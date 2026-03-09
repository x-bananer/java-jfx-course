package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "currency_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;

    @ManyToOne
    private Currency source;

    @ManyToOne
    private Currency destination;

    public Transaction() {
    }

    public Transaction(double amount, Currency source, Currency destination) {
        this.amount = amount;
        this.source = source;
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getSource() {
        return source;
    }

    public void setSource(Currency source) {
        this.source = source;
    }

    public Currency getDestination() {
        return destination;
    }

    public void setDestination(Currency destination) {
        this.destination = destination;
    }
}
