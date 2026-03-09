package dao;

import datasource.MariaDbJpaConnection;
import entity.Currency;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CurrencyDao {

    public List<Currency> getAllCurrencies() {
        EntityManager entityManager = MariaDbJpaConnection.getInstance();
        return entityManager.createQuery(
                "select c from Currency c order by c.abbreviation",
                Currency.class
        ).getResultList();
    }

    public double getRateByAbbreviation(String abbreviation) {
        EntityManager entityManager = MariaDbJpaConnection.getInstance();
        return entityManager.createQuery("select c.conversionRateToUsd from Currency c where c.abbreviation = :abbreviation", Double.class)
                .setParameter("abbreviation", abbreviation)
                .getSingleResult();
    }

    public void persist(Currency currency) {
        EntityManager entityManager = MariaDbJpaConnection.getInstance();
        entityManager.getTransaction().begin();
        entityManager.persist(currency);
        entityManager.getTransaction().commit();
    }
}
