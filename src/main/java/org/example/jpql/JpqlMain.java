package org.example.jpql;

import org.example.jpql.domain.Club;
import org.example.jpql.domain.User;
import org.example.jpql.domain.dto.UserDto;

import javax.persistence.*;
import java.util.List;
import java.util.Random;

public class JpqlMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // code
//        List<User> users = em.createQuery("select u from User u join u.club", User.class)
//                .getResultList();
//
//        for (User user : users) {
//            System.out.println("User : " + user.getName());
//            System.out.println("User-Club : " + user.getClub().getName());
//        }

        List<Club> clubs = em.createQuery("select c from Club c join c.users", Club.class)
                .getResultList();

        System.out.println(clubs.size());
        for (Club club : clubs) {
            System.out.println(club.getUsers().size());
        }

        tx.commit();
        em.close();
        emf.close();
    }
}
