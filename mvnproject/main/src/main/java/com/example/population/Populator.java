package com.example.population;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.entity.BookAuthorMapping;
import com.example.entity.BorrowLength;
import com.example.entity.ContributionLevel;
import com.example.entity.Genre;
import com.example.util.HibernateUtil;

public class Populator {
    public static void populate(){
        Random random = new Random();

        System.out.println("Enter Query");
        Session session = HibernateUtil.getSessionFactory().openSession();
        try (Scanner input = new Scanner(System.in)) {
            String searchTerm = input.nextLine();
            final String uri = "https://www.googleapis.com/books/v1/volumes?q=" + searchTerm;
            RestTemplate restTemplate = new RestTemplate();
            GoogleResult result = restTemplate.getForObject(uri,GoogleResult.class);
            System.out.println(result.getTotalItems());

            BorrowLength.createDefaultBorrowLengths(session);
            ContributionLevel.createDefaults(session);

            for(Item item:result.getItems()){
                BookInfo info = item.getVolumeInfo();
                if(info.getIndustryIdentifiers() == null){
                    continue;
                }

                List<String> authors = info.getAuthors();
                if(authors == null || authors.isEmpty()){
                    continue;
                }
                String author = info.getAuthors().get(0);
                String[] authorWords = author.split(" ");
                if(authorWords.length !=2 ){
                    continue;
                }

                int authorId = Author.getOrCreateAuthor(authorWords[0], authorWords[1], session);
                if (authorId == -1){continue;}

                Author authorObj = session.get(Author.class, authorId);

                Book book = new Book();

                String desc = info.getDescription();
                if(desc == null){
                    continue;
                }

                if(desc.length() > 2000){
                    desc = desc.substring(0,2000);
                }
                book.setBlurb(desc);
                Images imgs = info.getImageLinks();
                if(imgs == null){continue;}
                book.setImg(imgs.getThumbnail());
                book.setTitle(info.getTitle());
                BorrowLength borrow = session.get(BorrowLength.class, BorrowLength.getRandomId(session));
                book.setBorrowLength(borrow);
                book.setCopies(random.nextInt(9) + 1);
                for(Isbn isbn:info.getIndustryIdentifiers()){
                    if(isbn.getType().equals("ISBN_13")){
                        book.setBookIsbn(isbn.getIdentifier());
                        break;
                    }
                }

                if(book.getBookIsbn() == null){
                    continue;
                }
                
                Transaction t;
                Genre bookGenre;
                int genreId = -1;
                if (info.getCategories() != null && !info.getCategories().isEmpty()) {
                    genreId = Genre.getOrCreateGenre(info.getCategories().get(0),session);
                }
                if(genreId == -1){
                    continue;
                }
                
                bookGenre = session.get(Genre.class, genreId);
                book.setGenre(bookGenre);

                t = session.beginTransaction();
                try{
                    session.persist(book);
                    t.commit();
                }
                catch(Exception e){
                    t.rollback();
                }

                ContributionLevel cl = session.get(ContributionLevel.class, 1);
                
                BookAuthorMapping bam = new BookAuthorMapping();
                bam.setAuthor(authorObj);
                bam.setBook(book);
                bam.setContributionLevel(cl);

                t = session.beginTransaction();
                try{
                    session.persist(bam);
                    t.commit();
                }
                catch(Exception e){
                    t.rollback();
                }

            }
            session.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
	}
}