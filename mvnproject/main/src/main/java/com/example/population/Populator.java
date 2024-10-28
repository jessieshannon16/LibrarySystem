package com.example.population;

import java.util.Random;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Book;
import com.example.entity.BorrowLength;
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

            for(Item item:result.getItems()){
                BookInfo info = item.getVolumeInfo();
                if(info.getIndustryIdentifiers() == null){
                    continue;
                }
                Book book = new Book();

                String desc = info.getDescription();
                if(desc == null){
                    continue;
                }

                if(desc.length() > 255){
                    desc = desc.substring(0,255);
                }
                book.setBlurb(desc);
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
                
                
                
            }
            session.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
	}
}