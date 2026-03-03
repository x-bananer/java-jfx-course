package entity;

public class Currency {

    private String abbreviation;
    private String name;
    private double conversionRateToUsd;

    public Currency(String abbreviation, String name, double conversionRateToUsd) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversionRateToUsd = conversionRateToUsd;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public double getConversionRateToUsd() {
        return conversionRateToUsd;
    }

    @Override
    public String toString() {
        return abbreviation + " (" + name + ")";
    }
}