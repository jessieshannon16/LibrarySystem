package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.*;
import java.lang.*;
import com.example.entity.Author;
import com.example.entity.Book;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import jakarta.persistence.criteria.*;
import java.util.*;

@SpringBootApplication
@RestController
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	private static <T> List<T> loadAllData(Class<T> type, Session session) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(type);
		criteria.from(type);
		List<T> data = session.createQuery(criteria).getResultList();
		return data;
  }

	@GetMapping("/author")
	public String author(@RequestParam(name="id") String id){
		Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Author author = session.get(Author.class, id);
            if (author != null) {
                System.out.println("Author details: " + author.getFirstName() + " " + author.getLastName());
				return "Author details: " + author.getFirstName() + " " + author.getLastName();
            } else {
                System.out.println("Author not found!");
				return "Error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        } finally {
            session.close();
        }
	}

	@GetMapping("/book")
	public String book(){
		System.out.println("Hit3");
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Hit");

		try {
            List<Book> books = loadAllData(Book.class,session);
			System.out.println("Hit2");
			if(books != null){
				System.out.println("Books found");
				
				String result = "";
				for(Book book:books){
					result += book.toString();
				}
				return result;
			}
			else{
				return "Error";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return "Error";
		}
		finally {
            session.close();
        }
	}
}
