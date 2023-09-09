package org.example.valuetypecollection;

import org.example.domain.Member;
import org.example.domain.ProfileImage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ValeTypeCollectionMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // code
        ProfileImage profileImage = new ProfileImage("urlA");

        Member member = new Member();
        member.setId(1L);
        member.setName("memberA");
        member.getProfileImages().add(profileImage);

        em.persist(member);

        tx.commit();
        em.close();
        emf.close();
    }
}
