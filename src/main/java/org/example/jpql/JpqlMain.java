package org.example.jpql;

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
        List<Long> ids = em.createQuery("select c.id from User u join u.club c", Long.class)
                .getResultList();

        System.out.println(ids);
        tx.commit();
        em.close();
        emf.close();
    }
}
