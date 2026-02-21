package module_6_2;

public class Currency {
    private String abbreviation;
    private String name;
    private double conversionRateToUsd;

    public Currency(String abbreviation, String name, double conversionRateToUsd) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversionRateToUsd = conversionRateToUsd;
    }

    public double getRateToUsd() {
        return conversionRateToUsd;
    }

    @Override
    public String toString() {
        return abbreviation + " (" + name + ")";
    }
}
