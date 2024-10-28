package com.example.population;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Book;
import com.example.entity.BorrowLength;
import com.example.entity.Genre;
import com.example.util.HibernateUtil;

public class Populator {
    public static void populate(){
        System.out.println("Enter Query");
        Session session = HibernateUtil.getSessionFactory().openSession();
        try (Scanner input = new Scanner(System.in)) {
            String searchTerm = input.nextLine();
            final String uri = "https://www.googleapis.com/books/v1/volumes?q=" + searchTerm;
            RestTemplate restTemplate = new RestTemplate();
            GoogleResult result = restTemplate.getForObject(uri,GoogleResult.class);
            System.out.println(result.getTotalItems());

            for(Item item:result.getItems()){
                BookInfo info = item.getVolumeInfo();
                if(info.getIndustryIdentifiers() == null){
                    continue;
                }
                Book book = new Book();
                book.setBlurb(info.getDescription());
                book.setTitle(info.getTitle());
                BorrowLength borrow = session.get(BorrowLength.class, 1);
                book.setBorrowLength(borrow);
                book.setCopies(5);
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
                int genreId = 1;
                if (info.getCategories() != null){
                    genreId = Genre.getOrCreateGenre(info.getCategories().get(0),session);
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