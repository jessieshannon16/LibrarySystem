package com.example.main;

import com.example.entity.Author;
import com.example.util.HibernateUtil;
import org.hibernate.Session;


public class ReadAuthor{
    public static Author readAuthor(int authorId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Author author = session.get(Author.class, authorId);
            if (author != null) {
                System.out.println("Author details: " + author.getFirstName() + " " + author.getLastName());
            } else {
                System.out.println("Author not found!");
            }
            return author;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}