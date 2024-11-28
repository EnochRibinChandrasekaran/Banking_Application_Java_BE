package com.bankingapplication.utility;

import com.bankingapplication.exception.BankingApplicationException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * BankingApplicationInputValidation
 * Utility class
 * all the input validation is done in this class
 */
public class BankingApplicationInputValidation {

    private static final Scanner scannerObj = new Scanner(System.in);

    /**
     * private constructor to avoid object creation
     * of the utility class
     *
     * @throws BankingApplicationException custom exception
     */
    private BankingApplicationInputValidation() throws BankingApplicationException {
        throw new BankingApplicationException("Utility Class - used only for validation.");
    }


    /**
     * Validate account holder name
     * ^[a-zA-Z\s]+ allows only alphabets and space
     *
     * @return accountHolderName
     */
    public static String getValidAccountHolderName() {
        while (true) {
            String name = scannerObj.nextLine();
            if (name.matches("^[a-zA-Z\\s]+")) {
                return name;
            } else {
                System.out.println("Enter valid Account Holder Name (Firstname LastName):");
            }
        }
    }

    /**
     * Validate decimal digits
     * allows only decimal digits
     *
     * @return double - amount
     */
    public static double getDoubleInput() {
        do {
            if (scannerObj.hasNextDouble()) {
                double amount = scannerObj.nextDouble();
                scannerObj.nextLine();
                return amount;
            } else {
                scannerObj.next();
                System.out.println("Enter valid amount : ");
            }

        } while (true);
    }

    /**
     * Date validation
     * dd/MM/yyyy - if the format is not matched it will prompt to enter valid date
     *
     * @return LocalDate date
     */
    public static LocalDate getDateValidation() {
        do {
            try {
                String localDateStr = scannerObj.next();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return LocalDate.parse(localDateStr, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid Date Input! Enter valid date :");
            }
        } while (true);
    }

    /**
     * Time validation
     * if the LocalTime format is not matched it will prompt to enter valid time
     *
     * @return LocalTime time
     */
    public static LocalTime getTimeValidation() {
        do {
            try {
                String localTimeStr = scannerObj.next();
                return LocalTime.parse(localTimeStr);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid Time Input! Enter valid time :");
            }
        } while (true);
    }

    /**
     * Integer validation
     *
     * @return int - used for options
     */
    public static int getIntegerInput() {
        do {
            if (scannerObj.hasNextInt()) {
                int number = scannerObj.nextInt();
                scannerObj.nextLine();
                return number;
            } else {
                scannerObj.next();
                System.out.println("Enter valid number : ");
            }
        } while (true);
    }
}
