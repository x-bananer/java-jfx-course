package module_6_2;

import java.util.ArrayList;

public class CurrencyController {
    private ArrayList<Currency> currencies = new ArrayList<>();

    public CurrencyController() {
        currencies.add(new Currency("USD", "$", 1.0));
        currencies.add(new Currency("EUR", "€", 0.92));
        currencies.add(new Currency("SEK", "kr", 10.7));
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public double convert(double amount, Currency from, Currency to) {
        double inUsd = amount / from.getRateToUsd();
        return inUsd * to.getRateToUsd();
    }

    public double convertSafe(String amountText, Currency from, Currency to) {
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
