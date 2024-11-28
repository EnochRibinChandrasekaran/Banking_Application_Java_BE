package com.bankingapplication.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * BankAccount model class
 * String accountHolderName         Account Holder Name
 * double balance                   Bank Balance
 * List<transaction> transactions   Account Transactions
 */
public class BankAccount implements Comparable<BankAccount> {
    public static final SortedSet<BankAccount> bankAccountsList = new TreeSet<>();
    private String accountHolderName;
    private double balance;
    private List<Transaction> transactions;

    /**
     * Constructors
     */
    public BankAccount() {
    }

    public BankAccount(String accountHolderName, double balance, List<Transaction> transactions) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactions = transactions;
    }

    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    /**
     * Getters and Setters for the fields
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    /**
     * Mock data
     * SortedSet interface is used so that its references can be changed in future
     *
     * @return SortedSet<BankAccount>
     */
    public static SortedSet<BankAccount> setInstances() {
        bankAccountsList.add(account1());
        bankAccountsList.add(account2());
        bankAccountsList.add(account3());
        bankAccountsList.add(account4());
        bankAccountsList.add(account5());
        return bankAccountsList;
    }

    /**
     * Mock data  - Hard coded
     *
     * @return BankAccount
     */
    private static BankAccount account1() {
        BankAccount account = new BankAccount("Enoch", 1000000.00);
        Transaction transaction1 = new Transaction(LocalDate.parse("11/11/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse("10:11:20"), "Mc Donald's", 0, 12);
        transaction1.setCurrentBalanceBasedOnTransaction(account.getBalance(), transaction1.getMoneyIn(), transaction1.getMoneyOut());
        account.setBalance(transaction1.getCurrentBalance());
        ArrayList<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        account.setTransactions(transactionList);
        return account;
    }

    /**
     * Mock data  - Hard coded
     *
     * @return BankAccount
     */
    private static BankAccount account2() {
        BankAccount account = new BankAccount("Roy", 1000000.00);
        Transaction transaction1 = new Transaction(LocalDate.parse("12/01/2002", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse("19:11:20"), "Marriott", 0, 120);
        Transaction transaction2 = new Transaction(LocalDate.parse("11/11/2012", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse("10:11:20"), "Mc Donald's", 0, 11);
        transaction1.setCurrentBalanceBasedOnTransaction(account.getBalance(), transaction1.getMoneyIn(), transaction1.getMoneyOut());
        account.setBalance(transaction1.getCurrentBalance());
        transaction2.setCurrentBalanceBasedOnTransaction(account.getBalance(), transaction2.getMoneyIn(), transaction2.getMoneyOut());
        account.setBalance(transaction2.getCurrentBalance());
        ArrayList<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        account.setTransactions(transactionList);
        return account;
    }

    /**
     * Mock data  - Hard coded
     *
     * @return BankAccount
     */
    private static BankAccount account3() {
        BankAccount account = new BankAccount("Ribin", 200000.00);
        Transaction transaction1 = new Transaction(LocalDate.parse("12/01/2002", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse("19:11:20"), "Marriott", 0, 120);
        Transaction transaction2 = new Transaction(LocalDate.parse("11/11/2012", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse("10:11:20"), "Mc Donald's", 0, 11);
        Transaction transaction3 = new Transaction(LocalDate.parse("01/11/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse("11:01:20"), "Enoch", 20, 0);
        transaction1.setCurrentBalanceBasedOnTransaction(account.getBalance(), transaction1.getMoneyIn(), transaction1.getMoneyOut());
        account.setBalance(transaction1.getCurrentBalance());
        transaction2.setCurrentBalanceBasedOnTransaction(account.getBalance(), transaction2.getMoneyIn(), transaction2.getMoneyOut());
        account.setBalance(transaction2.getCurrentBalance());
        transaction3.setCurrentBalanceBasedOnTransaction(account.getBalance(), transaction3.getMoneyIn(), transaction3.getMoneyOut());
        account.setBalance(transaction3.getCurrentBalance());
        ArrayList<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        account.setTransactions(transactionList);
        return account;
    }

    /**
     * Mock data  - Hard coded
     *
     * @return BankAccount
     */
    private static BankAccount account4() {
        BankAccount account = new BankAccount("Ram", 90000.00);
        Transaction transaction1 = new Transaction(LocalDate.parse("12/01/2002", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse("19:11:20"), "Marriott", 0, 120);
        Transaction transaction2 = new Transaction(LocalDate.parse("11/11/2012", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse("10:11:20"), "Mc Donald's", 0, 11);
        Transaction transaction3 = new Transaction(LocalDate.parse("01/11/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse("11:01:20"), "Enoch", 20, 0);
        transaction1.setCurrentBalanceBasedOnTransaction(account.getBalance(), transaction1.getMoneyIn(), transaction1.getMoneyOut());
        account.setBalance(transaction1.getCurrentBalance());
        transaction2.setCurrentBalanceBasedOnTransaction(account.getBalance(), transaction2.getMoneyIn(), transaction2.getMoneyOut());
        account.setBalance(transaction2.getCurrentBalance());
        transaction3.setCurrentBalanceBasedOnTransaction(account.getBalance(), transaction3.getMoneyIn(), transaction3.getMoneyOut());
        account.setBalance(transaction3.getCurrentBalance());
        ArrayList<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        account.setTransactions(transactionList);
        return account;
    }

    /**
     * Mock data  - Hard coded
     *
     * @return BankAccount
     */
    private static BankAccount account5() {
        BankAccount account = new BankAccount("Raj", 2000000.00);
        Transaction transaction1 = new Transaction(LocalDate.parse("12/01/2002", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse("19:11:20"), "Marriott", 0, 120);
        Transaction transaction2 = new Transaction(LocalDate.parse("11/11/2012", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse("10:11:20"), "Mc Donald's", 0, 11);
        Transaction transaction3 = new Transaction(LocalDate.parse("01/11/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse("11:01:20"), "Enoch", 20, 0);
        transaction1.setCurrentBalanceBasedOnTransaction(account.getBalance(), transaction1.getMoneyIn(), transaction1.getMoneyOut());
        account.setBalance(transaction1.getCurrentBalance());
        transaction2.setCurrentBalanceBasedOnTransaction(account.getBalance(), transaction2.getMoneyIn(), transaction2.getMoneyOut());
        account.setBalance(transaction2.getCurrentBalance());
        transaction3.setCurrentBalanceBasedOnTransaction(account.getBalance(), transaction3.getMoneyIn(), transaction3.getMoneyOut());
        account.setBalance(transaction3.getCurrentBalance());
        ArrayList<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        account.setTransactions(transactionList);
        return account;
    }

    /**
     * Override toString to change the string based on transaction field
     *
     * @return String BankAccount Object
     */
    @Override
    public String toString() {
        String withTransaction = "Account Holder Name : " + accountHolderName +
                " | Balance : £" + balance + "\n" +
                " | Transactions : " + transactions + "|" + "\n";
        String withoutTransaction = "Account Holder Name : " + accountHolderName +
                " | Balance : £" + balance + "\n" +
                " | Transactions : No Transactions made" + "|" + "\n";

        if (transactions == null) {
            return withoutTransaction + "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + "\n";
        }
        return
                withTransaction +
                        "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + "\n";
    }


    /**
     * override equals based accountHolderName is same or not
     *
     * @param o BankAccount object
     * @return true/false comparing accountHolderName
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountHolderName.equals(that.accountHolderName);
    }

    /**
     * override hashCode based on the accountHolderName
     *
     * @return int accountHolderName hashcode
     */
    @Override
    public int hashCode() {
        return accountHolderName.hashCode();
    }

    /**
     * override compareTo based on accountHolderName
     *
     * @param accountObject the object to be compared.
     * @return int comparing accountHolderName(-1,1,0)
     */
    @Override
    public int compareTo(BankAccount accountObject) {
        return accountHolderName.compareTo(accountObject.getAccountHolderName());
    }
}