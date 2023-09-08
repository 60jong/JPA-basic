package org.example.loading;

import org.example.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class LoadingMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // code
        // 즉시 로딩 시에는 1 + N 문제 발생 (JPQL에서)
        // 따라서 모든 연관관계를 Lazy Loading -> jpql 사용시엔 fetch join 사용
        List<Customer> customers = em.createQuery("select c from Customer c", Customer.class)
                .getResultList();

        System.out.println(customers);

        tx.commit();
        em.close();
        emf.close();
    }
}
