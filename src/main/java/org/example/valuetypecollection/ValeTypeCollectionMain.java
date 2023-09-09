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
        List<Member> findMembers = em.createQuery("select distinct m from Member m join fetch m.profileImages.profileImages", Member.class)
                .getResultList();

        findMembers.stream()
                .map(Member::getProfileImages)
                .forEach(pi -> {
                            System.out.println(pi.getProfileImageUrls());
                        }
                );


        tx.commit();
        em.close();
        emf.close();
    }
}
