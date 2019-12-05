package org.jalasoft;

import java.util.Scanner;

public class BankClient {
    private Scanner scanner;
    private boolean done;
    private BankServices bankServices;
    private int currentAccount;

    public BankClient() {
        done = false;
        currentAccount =0;

    }

    /**
     * Ask the users the command they want to execute and execute that command
     */

    public void run() {
        bankServices = new BankServices();
        scanner = new Scanner(System.in);
        while (!done) {
            System.out.print("Enter command (0=quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest): ");
            int commandNumber = scanner.nextInt();
            try {
                processCommand(commandNumber);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        scanner.close();

    }

    /**
     * decides what command will be excuted based on the command number
     * 
     * @param commandNumber
     */
    private void processCommand(int commandNumber) {
        if (commandNumber == 0)
            quit();
        else if (commandNumber == 1)
            newAccount();
        else if (commandNumber == 2)
            select();
        else if (commandNumber == 3)
            deposit();
        else if (commandNumber == 4)
            authorizeLoan();
        else if (commandNumber == 5)
            showAll();
        else if (commandNumber == 6)
            addInterest();
        else
            System.out.println("illegal command");
    }

    private void quit() {
        done = true;
        System.out.println("Goodbye!");
    }

    private void newAccount() {

        int accountNumber = bankServices.newAccount();// delegates the work to the appropriate class
        // own logic
        currentAccount = accountNumber;
        System.out.println("Your new account number is: " + currentAccount);
    }

    private void select() {
        System.out.print("Enter account#: ");
        currentAccount = scanner.nextInt();
        int balance = bankServices.getBalance(currentAccount);// delegates the work to the appropriate class
        // own logic
        System.out.println("The balance of account " + currentAccount + " is " + balance);
    }

    private void deposit() {

        System.out.print("Enter deposit amount: ");
        int amount = scanner.nextInt();
        bankServices.deposit(currentAccount, amount);
    }

    private void authorizeLoan() {
        System.out.print("Enter loan amount: ");
        int loanAmount = scanner.nextInt();
        if (bankServices.authorizeLoan(currentAccount, loanAmount))
            System.out.println("Your loan is approved");
        else
            System.out.println("Your loan is denied");
    }

    private void showAll() {
        System.out.println(bankServices.getBankInformation());
    }

    private void addInterest() {
        bankServices.payInterest();
    }
}
