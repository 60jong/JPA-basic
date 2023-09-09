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
        List<Member> profileImages = em.createQuery("select m from Member m join fetch m.profileImages", Member.class)
                .getResultList();

        profileImages.stream()
                .map(Member::getProfileImages)
                .forEach(images -> images.stream()
                        .forEach(image -> {
                            System.out.println(image.getUrl());
                        })
                );

        tx.commit();
        em.close();
        emf.close();
    }
}
