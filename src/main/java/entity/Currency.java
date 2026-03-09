package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    public Currency(String abbreviation, String name, double conversionRateToUsd) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversionRateToUsd = conversionRateToUsd;
    }

    public int getId() {
        return id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public String toString() {
        return abbreviation + " (" + name + ")";
    }
}
