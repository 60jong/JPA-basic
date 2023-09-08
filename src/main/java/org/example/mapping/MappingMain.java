package org.example.mapping;

import org.example.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MappingMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // code
        Customer findCustomer = em.find(Customer.class, 1L);

        System.out.println(findCustomer.getTeam().getClass());

        tx.commit();
        em.close();
        emf.close();
    }
}