import com.bankingapplication.exception.BankingApplicationException;
import com.bankingapplication.model.BankAccount;
import com.bankingapplication.model.Transaction;
import com.bankingapplication.service.BankingService;
import com.bankingapplication.utility.BankingApplicationInputValidation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public class BankingApplication {
    //set the below fields to final so that it can't be set to f
    /**
     * set the below field to final so that it
     * can't be set to null in any part of the program
     */
    public static final BankingService bankingService = new BankingService();

    public static void main(String[] args) {
        System.out.println("---------------------------Welcome to Cardiff Bank £---------------------------");


        bankingService.initialiseBankAccounts();
        boolean runApplication = true;
        while (runApplication) {
            bankingMenu();
            int option = BankingApplicationInputValidation.getIntegerInput();
            switch (option) {
                case 1 -> viewAllBankAccounts();
                case 2 -> viewIndividualAccount();
                case 3 -> addNewTransaction();
                case 4 -> removeBankAccount();
                case 5 -> addBankAccount();
                case 6 -> runApplication = isRunApplication();
                default -> {
                    System.out.println("Invalid Option! Please choose a valid option.");
                    System.out.println("------------------------------------------------------------------------------");
                }
            }

        }
    }

    /**
     * Method to display banking Options
     */
    private static void bankingMenu() {
        System.out.println("Choose the below operation to perform :");
        System.out.println("1.View All Bank Accounts");
        System.out.println("2.View Individual Account");
        System.out.println("3.Add New Transaction to an Account");
        System.out.println("4.Remove Bank Account");
        System.out.println("5.Add New Bank Account");
        System.out.println("6.Exit Banking System");
        System.out.println("------------------------------------------------------------------------------");
    }

    /**
     * Method to stop the application from execution
     *
     * @return false
     */
    private static boolean isRunApplication() {
        System.out.println("Thank you for banking with us!");
        System.out.println("------------------------------------------------------------------------------");
        return false;
    }

    /**
     * Method to add Bank account
     * all the input validation is done
     */
    private static void addBankAccount() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Enter the New Bank Account Details Below:");
        System.out.println("Account Holder Name :");
        String newAccountName = BankingApplicationInputValidation.getValidAccountHolderName();
        System.out.println("Account Holder Initial Deposit :");
        double newAccountDeposit = BankingApplicationInputValidation.getDoubleInput();
        bankingService.addNewBankAccount(new BankAccount(newAccountName, newAccountDeposit));
        System.out.println(newAccountName + "'s account added to the Bank. ");
        System.out.println("------------------------------------------------------------------------------");
    }

    /**
     * Method to remove bank account
     * the account is chosen using the accountHolderName
     */
    private static void removeBankAccount() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Enter the account holder name to be removed :");
        String name = BankingApplicationInputValidation.getValidAccountHolderName();
        try {
            BankAccount bankAccount = bankingService.viewIndividualAccount(name);
            bankingService.removeBankAccount(bankAccount);
        } catch (BankingApplicationException e) {
            System.out.println("Invalid Account Name - Account does not exist");
        }
        System.out.println(name + "'s account removed from the Bank. ");
        System.out.println("------------------------------------------------------------------------------");
    }

    /**
     * Method used to add new transaction to the user
     * all the input validations is done
     */
    private static void addNewTransaction() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Enter the account name :");
        String accountName = BankingApplicationInputValidation.getValidAccountHolderName();
        try {
            BankAccount account = bankingService.viewIndividualAccount(accountName);
            System.out.print("Enter the transaction date (dd/mm/yyyy): ");
            LocalDate localDate = BankingApplicationInputValidation.getDateValidation();
            System.out.print("Enter the transaction time (hh:mm:ss): ");
            LocalTime localTime = BankingApplicationInputValidation.getTimeValidation();
            System.out.println("Enter the description: ");
            String description = scannerObj.nextLine();
            System.out.println("Enter the amount of money credited :");
            double moneyIn = BankingApplicationInputValidation.getDoubleInput();
            double moneyOut = 0;
            if (moneyIn == 0) {
                System.out.println("Enter the amount of money debited :");
                moneyOut = BankingApplicationInputValidation.getDoubleInput();
            }
            bankingService.addNewTransaction(account, new Transaction(localDate, localTime, description, moneyIn, moneyOut));
        } catch (BankingApplicationException e) {
            System.out.println("Invalid Account Name - Account does not exist");
        }
        System.out.println(" Transaction added to the account. ");
        System.out.println("------------------------------------------------------------------------------");
    }

    /**
     * Method used to view individual account
     * Name validation is done
     */
    private static void viewIndividualAccount() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Enter the account holder name :");
        String accountHolderName = BankingApplicationInputValidation.getValidAccountHolderName();
        try {
            System.out.println(bankingService.viewIndividualAccount(accountHolderName));
        } catch (BankingApplicationException e) {
            System.out.println("Invalid Account Name - Account does not exist");
        }
    }

    /**
     * Method to display all bank accounts available
     * 1. Ascending order based on names
     * 2. Descending order based on names
     * 3. Ascending order based on Bank Balance
     * 4. Descending order based on Bank Balance
     */
    private static void viewAllBankAccounts() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Sort Bank Account based on:");
        System.out.println("1. View Accounts in Ascending Order of Names");
        System.out.println("2. View Accounts in Descending Order of Names");
        System.out.println("3. View Accounts in Ascending Order of Account Balance");
        System.out.println("4. View Accounts in Descending Order of Account Balance");
        System.out.println("------------------------------------------------------------------------------");
        int sortOption = BankingApplicationInputValidation.getIntegerInput();
        switch (sortOption) {
            case 1 -> System.out.println(bankingService.viewAllBankAccountsAscending());
            case 2 -> System.out.println(bankingService.viewAllBankAccountsDescending());
            case 3 -> System.out.println(bankingService.viewAllBankAccountsByBalanceAscending());
            case 4 -> System.out.println(bankingService.viewAllBankAccountsByBalanceDescending());
            default -> {
                System.out.println("Invalid option, displaying accounts based on account name ascending order :");
                System.out.println(bankingService.viewAllBankAccountsAscending());
            }
        }
    }


}