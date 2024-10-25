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
                
                Transaction t;
                Genre bookGenre;
                int genreId = 1;
                if (info.getCategories() != null){
                    String genre = info.getCategories().get(0);

                    Query query = session.createQuery("select GenreId from Genre where Name = '" + genre + "'", int.class);
                    List list = query.list();

                    

                    if (list.size() > 0){
                        genreId = (int) query.uniqueResult();
                    }
                    else{
                        t = session.beginTransaction();
                        try{
                        
                        Query queryInsert = session.createNativeQuery("insert into Genre(Name) values (?1)");
                        queryInsert.setParameter(1, genre);
                        int rowsCopied = queryInsert.executeUpdate();
                        t.commit();
                        Query queryId = session.createQuery("select GenreId from Genre where Name = '" + genre + "'", int.class);
                        genreId = (int) queryId.uniqueResult();
                        System.out.println(genreId);
                        }
                    
                        catch(Exception e){
                            t.rollback();
                        }
                    }
                    
                }
                
                bookGenre = session.get(Genre.class, genreId);
                book.setGenre(bookGenre);
                System.out.println("test");
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