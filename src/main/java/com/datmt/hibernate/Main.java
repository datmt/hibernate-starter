package com.datmt.hibernate;

import com.datmt.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    private static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private static final SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    public static void main(String[] args) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            User user = new User();
            user.setName("Jane");
            user.setAge(10000);

            session.persist(user);
            tx.commit();
        }
    }


}
