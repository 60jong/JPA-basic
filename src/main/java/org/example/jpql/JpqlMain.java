package org.example.jpql;

import org.example.jpql.domain.User;
import org.example.jpql.domain.dto.UserDto;

import javax.persistence.*;
import java.util.List;

public class JpqlMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // code
        List<User> users = em.createQuery("select distinct u from User u join fetch u.club", User.class)
                .getResultList();

        for (User user : users) {
            System.out.println("User : " + user.getId());
            System.out.println("User : " + user.getAge());
            System.out.println("User-Club : " + user.getClub().getId());
            System.out.println("User-Club : " + user.getClub().getName());
        }
        tx.commit();
        em.close();
        emf.close();
    }
}
