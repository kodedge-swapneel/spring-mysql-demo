package com.example.springmysqldemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.sql.Date;

@Entity
@Table(name = "exchange-rate")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer transactionId;
    @NotNull
    private String sourceCurrency;
    @NotNull
    private String targetCurrency;
    @NotNull
    private double amount;
    @NotNull
    private Date lastUpdated;

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "transactionId=" + transactionId +
                ", sourceCurrency='" + sourceCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", amount=" + amount +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
