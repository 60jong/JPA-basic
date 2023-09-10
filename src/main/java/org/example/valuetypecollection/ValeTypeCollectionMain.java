package org.example.valuetypecollection;

import org.example.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ValeTypeCollectionMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // code
        Member findMember = em.find(Member.class, 1L);
        findMember.getProfileImages().removeUrl("1A");
        System.out.println(findMember.getName());
        System.out.println(findMember.getProfileImages().getProfileImageUrls());

        tx.commit();
        em.close();
        emf.close();
    }
}
