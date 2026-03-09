package controller;

import dao.CurrencyDao;
import entity.Currency;

import java.util.List;

public class CurrencyController {
    private final CurrencyDao dao = new CurrencyDao();

    public List<Currency> getCurrencies() {
        return dao.getAllCurrencies();
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

        return convert(amount, from, to);
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
