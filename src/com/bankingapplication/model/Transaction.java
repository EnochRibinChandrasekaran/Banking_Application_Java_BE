package com.bankingapplication.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Transaction model class
 * LocalDate transactionDate         transaction date
 * LocalTime transactionTime         transaction time
 * double moneyIn                   money credited
 * double moneyOut                  money debited
 * double currentBalance            available balance
 */
public class Transaction implements Comparable<Object> {
    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private String description;
    private double moneyIn;
    private double moneyOut;
    private double currentBalance;

    /**
     * Constructors
     */
    public Transaction() {
    }

    public Transaction(LocalDate transactionDate, LocalTime transactionTime, String description, double moneyIn, double moneyOut) {
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.description = description;
        this.moneyIn = moneyIn;
        this.moneyOut = moneyOut;
    }

    public Transaction(LocalDate transactionDate, LocalTime transactionTime, String description, double moneyIn, double moneyOut, double currentBalance) {
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.description = description;
        this.moneyIn = moneyIn;
        this.moneyOut = moneyOut;
        this.currentBalance = currentBalance;
    }

    /**
     * Getters and Setters
     */

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMoneyIn() {
        return moneyIn;
    }

    public void setMoneyIn(double moneyIn) {
        this.moneyIn = moneyIn;
    }

    public double getMoneyOut() {
        return moneyOut;
    }

    public void setMoneyOut(double moneyOut) {
        this.moneyOut = moneyOut;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * Current balance calculated based on the money credited and debited
     *
     * @param balance  account balance
     * @param moneyIn  money credited
     * @param moneyOut money debited
     */
    public void setCurrentBalanceBasedOnTransaction(double balance, double moneyIn, double moneyOut) {
        if (moneyIn == 0)
            this.currentBalance = balance - moneyOut;
        else
            this.currentBalance = balance + moneyIn;
    }

    @Override
    public String toString() {
        return
                "\n" + " Transaction Date : " + transactionDate +
                        " | Transaction Time : " + transactionTime +
                        " | Description : " + description +
                        " | MoneyIn : £" + moneyIn +
                        " | MoneyOut : £" + moneyOut +
                        " | Current Balance : £" + currentBalance + "|";
    }

    /**
     * Override equals based on transactionDate
     *
     * @param o transaction class object
     * @return true/false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transactionDate.equals(that.transactionDate);
    }

    @Override
    public int hashCode() {
        return transactionDate.hashCode();
    }

    /**
     * compare object based on transaction date
     *
     * @param o the object to be compared.
     * @return int (1,0,-1)
     */
    @Override
    public int compareTo(Object o) {
        Transaction transaction = (Transaction) o;
        return transactionDate.compareTo(transaction.getTransactionDate());
    }
}
