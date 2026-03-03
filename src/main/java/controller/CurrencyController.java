package controller;

import dao.CurrencyDao;
import entity.Currency;

import java.sql.SQLException;
import java.util.List;

public class CurrencyController {

    private CurrencyDao dao = new CurrencyDao();

    public List<Currency> getCurrencies() throws SQLException {
        return dao.getAllCurrencies();
    }

    public double convert(double amount, Currency from, Currency to) throws SQLException {
        double fromRate = dao.getRateByAbbreviation(from.getAbbreviation());
        double toRate = dao.getRateByAbbreviation(to.getAbbreviation());

        double inUsd = amount / fromRate;
        return inUsd * toRate;
    }

    public double convertSafe(String amountText, Currency from, Currency to)
            throws SQLException {

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

        return convert(amount, from, to);
    }
}