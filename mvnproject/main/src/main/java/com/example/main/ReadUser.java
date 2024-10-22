package com.example.main;

import com.example.entity.Users;
import com.example.util.HibernateUtil;
import org.hibernate.Session;


public class ReadUser{
    public static Users readUser(int userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Users user = session.get(Users.class, userId);
            if (user != null) {
                System.out.println("User details: " + user.getUserName() + ", " + user.getEmail());
            } else {
                System.out.println("User not found!");
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}