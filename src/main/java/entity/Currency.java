package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String abbreviation;
    private String name;
    @Column(name = "conversion_rate_to_usd")
    private double conversionRateToUsd;

    public Currency() {
    }

    public Currency(String abbreviation, String name, double conversionRateToUsd) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversionRateToUsd = conversionRateToUsd;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConversionRateToUsd(double conversionRateToUsd) {
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