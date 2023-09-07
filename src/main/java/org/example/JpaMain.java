package org.example;

import org.example.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        // code
        Member findMember = em.find(Member.class, 5L);
        findMember.setName("ABCDE");
        Member newMEmber = new Member();
        newMEmber.setId(7L);
        newMEmber.setName("HelloJPA");
        em.persist(newMEmber);
        em.flush();
        System.out.println("=======");
        tx.commit();
        em.close();
        emf.close();
    }
}