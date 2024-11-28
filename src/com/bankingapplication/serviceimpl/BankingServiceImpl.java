package com.bankingapplication.serviceimpl;

import com.bankingapplication.exception.BankingApplicationException;
import com.bankingapplication.model.BankAccount;
import com.bankingapplication.model.Transaction;

import java.util.TreeSet;

/**
 * BankingServiceImpl interface used in BankingService
 * Created for decoupling the implementation so that
 * it can be altered later without the whole application getting broken
 */
public interface BankingServiceImpl {
    TreeSet<BankAccount> viewAllBankAccountsAscending();

    TreeSet<BankAccount> viewAllBankAccountsDescending();

    TreeSet<BankAccount> viewAllBankAccountsByBalanceAscending();

    TreeSet<BankAccount> viewAllBankAccountsByBalanceDescending();

    BankAccount viewIndividualAccount(String accountHolderName) throws BankingApplicationException;

    void addNewTransaction(BankAccount bankAccountDetails, Transaction transactionDetails);

    void removeBankAccount(BankAccount bankAccountDetails);

    void addNewBankAccount(BankAccount bankAccountDetails);


}
