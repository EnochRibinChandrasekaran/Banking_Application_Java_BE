package com.bankingapplication.service;

import com.bankingapplication.exception.BankingApplicationException;
import com.bankingapplication.model.BankAccount;
import com.bankingapplication.model.Transaction;
import com.bankingapplication.serviceimpl.BankingServiceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * BankingService implements BankingServiceImpl
 * all the implementation details are in this class
 */
public class BankingService implements BankingServiceImpl {

    /**
     * All the bank accounts are displayed in ascending order based on name
     *
     * @return TreeSet<BankAccount>
     */
    @Override
    public TreeSet<BankAccount> viewAllBankAccountsAscending() {
        return (TreeSet<BankAccount>) BankAccount.bankAccountsList;
    }

    /**
     * All the bank accounts are displayed in descending order based on name
     *
     * @return TreeSet<BankAccount>
     */
    @Override
    public TreeSet<BankAccount> viewAllBankAccountsDescending() {
        TreeSet<BankAccount> bankAccountsList = (TreeSet<BankAccount>) BankAccount.bankAccountsList;
        return (TreeSet<BankAccount>) bankAccountsList.descendingSet();
    }

    /**
     * All the bank accounts are displayed in descending order based on balance
     * used custom Comparator
     *
     * @return TreeSet<BankAccount>
     */
    @Override
    public TreeSet<BankAccount> viewAllBankAccountsByBalanceDescending() {
        TreeSet<BankAccount> accountsByBalanceDescending = new TreeSet<>(new AccountBalanceComparator().reversed());
        accountsByBalanceDescending.addAll(BankAccount.bankAccountsList);
        return accountsByBalanceDescending;
    }

    /**
     * All the bank accounts are displayed in ascending order based on balance
     * used custom Comparator
     *
     * @return TreeSet<BankAccount>
     */
    @Override
    public TreeSet<BankAccount> viewAllBankAccountsByBalanceAscending() {
        TreeSet<BankAccount> accountsByBalanceAscending = new TreeSet<>(new AccountBalanceComparator());
        accountsByBalanceAscending.addAll(BankAccount.bankAccountsList);
        return accountsByBalanceAscending;
    }

    /**
     * Get individual account details
     *
     * @param accountHolderName find based on accountHolderName
     * @return bankAccount object if found
     * @throws BankingApplicationException thrown if account is not found
     */
    @Override
    public BankAccount viewIndividualAccount(String accountHolderName) throws BankingApplicationException {
        TreeSet<BankAccount> bankAccountsList = (TreeSet<BankAccount>) BankAccount.bankAccountsList;
        for (BankAccount bankAccount :
                bankAccountsList) {
            if (bankAccount.getAccountHolderName().equals(accountHolderName)) {
                return bankAccount;
            }
        }
        throw new BankingApplicationException("Account Not Found");
    }

    /**
     * add new transaction based on the bankAccount object
     * the balance is set on transaction object based on money in and money out
     * the balance in bankAccount object based on transaction
     *
     * @param bankAccountDetails bankAccount Object if the user exist
     * @param transactionDetails transaction Object with all fields updated except transaction.currentBalance
     */
    @Override
    public void addNewTransaction(BankAccount bankAccountDetails, Transaction transactionDetails) {
        transactionDetails.setCurrentBalanceBasedOnTransaction(bankAccountDetails.getBalance(), transactionDetails.getMoneyIn(), transactionDetails.getMoneyOut());
        bankAccountDetails.setBalance(transactionDetails.getCurrentBalance());
        ArrayList<Transaction> transactions;
        if (bankAccountDetails.getTransactions() == null) {
            transactions = new ArrayList<>();
        } else {
            transactions = new ArrayList<>(bankAccountDetails.getTransactions());
        }
        transactions.add(transactionDetails);
        bankAccountDetails.setTransactions(transactions);

    }

    /**
     * Remove bank account from the Set based on the BankAccount object
     *
     * @param bankAccountDetails bankAccount object if present
     */
    @Override
    public void removeBankAccount(BankAccount bankAccountDetails) {
        TreeSet<BankAccount> bankAccountsList = (TreeSet<BankAccount>) BankAccount.bankAccountsList;
        bankAccountsList.remove(bankAccountDetails);
    }

    /**
     * Add bank account to the Set
     *
     * @param bankAccountDetails bankAccount object with all the fields filled except transaction
     */
    @Override
    public void addNewBankAccount(BankAccount bankAccountDetails) {
        TreeSet<BankAccount> bankAccountsList = (TreeSet<BankAccount>) BankAccount.bankAccountsList;
        bankAccountsList.add(bankAccountDetails);
    }

    /**
     * Initialise dummy data
     */
    public void initialiseBankAccounts() {
        BankAccount.setInstances();
    }
}

/**
 * User defined comparator
 * to compare Bank Balance
 */
class AccountBalanceComparator implements Comparator<BankAccount> {
    /**
     * Compare BankAccount.balance
     *
     * @param account1 the first object to be compared.
     * @param account2 the second object to be compared.
     * @return double (1,0,-1)
     */
    public int compare(BankAccount account1, BankAccount account2) {
        return Double.compare(account1.getBalance(), account2.getBalance());
    }
}

