package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.entity.BookAuthorMapping;
import com.example.entity.BookReservationMapping;
import com.example.entity.BorrowLength;
import com.example.entity.ContributionLevel;
import com.example.entity.Genre;
import com.example.entity.Reservations;
import com.example.entity.Users;


public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration config = new Configuration().configure()
            .addAnnotatedClass(Author.class)
            .addAnnotatedClass(Book.class)
            .addAnnotatedClass(BookAuthorMapping.class)
            .addAnnotatedClass(BookReservationMapping.class)
            .addAnnotatedClass(BorrowLength.class)
            .addAnnotatedClass(ContributionLevel.class)
            .addAnnotatedClass(Genre.class)
            .addAnnotatedClass(Reservations.class)
            .addAnnotatedClass(Users.class)
            ;
            
            return config.buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}