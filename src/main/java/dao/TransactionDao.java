package dao;

import datasource.MariaDbJpaConnection;
import entity.Transaction;
import jakarta.persistence.EntityManager;

public class TransactionDao {

    public void persist(Transaction transaction) {
        EntityManager entityManager = MariaDbJpaConnection.getInstance();
        entityManager.getTransaction().begin();
        entityManager.persist(transaction);
        entityManager.getTransaction().commit();
    }
}
