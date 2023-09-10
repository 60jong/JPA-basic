package org.example.jpql;

import org.example.jpql.domain.dto.UserDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpqlMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // code
        List<UserDto> userDtos = em.createQuery("select new org.example.jpql.domain.dto.UserDto(u.name, u.age) from User u", UserDto.class)
                .getResultList();

        System.out.println(userDtos);
        tx.commit();
        em.close();
        emf.close();
    }
}
