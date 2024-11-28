package com.bankingapplication.exception;

/**
 * BankingApplicationException is used for exception wrapping and funneling
 */
public class BankingApplicationException extends Exception {
    public BankingApplicationException() {
    }

    public BankingApplicationException(String message) {
        super(message);
    }

    public BankingApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankingApplicationException(Throwable cause) {
        super(cause);
    }

    public BankingApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
