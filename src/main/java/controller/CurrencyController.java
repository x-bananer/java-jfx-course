package controller;

import dao.CurrencyDao;
import dao.TransactionDao;
import entity.Currency;
import entity.Transaction;

import java.util.List;

public class CurrencyController {
    private final CurrencyDao dao = new CurrencyDao();
    private final TransactionDao transactionDao = new TransactionDao();

    public List<Currency> getCurrencies() {
        return dao.getAllCurrencies();
    }

    public void createCurrencies() {
        dao.persist(new Currency("USD", "US Dollar", 1.0000));
        dao.persist(new Currency("EUR", "Euro", 1.1814));
        dao.persist(new Currency("GBP", "British Pound Sterling", 1.3486));
        dao.persist(new Currency("JPY", "Japanese Yen", 0.0064));
        dao.persist(new Currency("CHF", "Swiss Franc", 1.3007));
        dao.persist(new Currency("CAD", "Canadian Dollar", 0.7329));
        dao.persist(new Currency("AUD", "Australian Dollar", 0.7116));
        dao.persist(new Currency("RUB", "Russian Ruble", 0.01294));
    }

    public double convert(double amount, Currency from, Currency to) {
        double fromRate = dao.getRateByAbbreviation(from.getAbbreviation());
        double toRate = dao.getRateByAbbreviation(to.getAbbreviation());

        double inUsd = amount / fromRate;
        return inUsd * toRate;
    }

    public double convertAmount(String amountText, Currency from, Currency to) {
        if (amountText == null || amountText.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter amount");
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText.replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number");
        }

        if (from == null || to == null) {
            throw new IllegalArgumentException("Select both currencies");
        }

        double result = convert(amount, from, to);
        transactionDao.persist(new Transaction(amount, from, to));
        return result;
    }

    public void addCurrency(String abbreviation, String name, String rateText) {
        if (abbreviation == null || abbreviation.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter abbreviation");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter currency name");
        }
        if (rateText == null || rateText.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter conversion rate");
        }

        double conversionRate;
        try {
            conversionRate = Double.parseDouble(rateText.replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid conversion rate");
        }

        Currency currency = new Currency(abbreviation.trim().toUpperCase(), name.trim(), conversionRate);
        dao.persist(currency);
    }
}
