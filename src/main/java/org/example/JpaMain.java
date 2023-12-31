package org.example;

import org.example.domain.Member;
import org.example.domain.item.Movie;

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
        Movie movie = new Movie();
        movie.setId(2L);
        movie.setName("Avengers");
        movie.setDirector("YKJ");

        em.persist(movie);

        tx.commit();

        em.close();
        emf.close();
    }
}