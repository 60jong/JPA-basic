package org.example;

import org.example.domain.Member;
import org.example.domain.mapping.Customer;
import org.example.domain.mapping.Team;

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
        Team team = new Team();
        team.setId(4L);

        Customer customer = new Customer();
        customer.setId(4L);
        customer.setTeam(team);

        em.persist(team);
        em.persist(customer);

        tx.commit();
        em.close();
        emf.close();
    }
}