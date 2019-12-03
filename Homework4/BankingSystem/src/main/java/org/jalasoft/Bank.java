package org.jalasoft;

import java.util.HashMap;
import java.util.Set;

public class Bank {

    /** <AccountNumber, balance> */
    private HashMap<Integer, Integer> accounts;
    private double interestRate;
    private int nextAccount;

    /**
     * Create a new account and assign it an account number and sets the balance to
     * 0
     * 
     * @return the account number
     */

    public Bank() {
        /**
         * para iniciar valores
         * 
         *
         */
        accounts = new HashMap<>();
        interestRate = 0.10;
        nextAccount = 0;

    }

    /**
     * this method create a new accouny with balance
     * 
     * @return currentAccount number
     */
    public int newAccount() {
        /*
         * current = nextAccount++; accounts.put(current, 0);
         * System.out.println("Your new account number is " + current);
         * 
         */
        int currentAccount = nextAccount++;
        accounts.put(currentAccount, 0);
        return currentAccount;
    }

    /**
     * return the current Balance of a given account
     * 
     * @param accountNumber the account wher the balance will be checked
     * @return the balance of the given account
     */

    public int getBalance(int accountNumber) {

        return accounts.get(accountNumber);
    }

    /**
     * this increment tha ammount of balance in a given account
     * 
     * @param accountNumber the account where the amount will be deposit
     * @param amount        the amount of money that will increase the balance
     * 
     * @return if the transaction was executed successfully
     */
    public boolean deposit(int accountNumber, int amount) {
        /*
         * System.out.print("Enter deposit amount: "); int amount = scanner.nextInt();
         * int balance = accounts.get(current); accounts.put(current, balance + amount);
         */
        int currentBalance = accounts.get(accountNumber);
        accounts.put(accountNumber, currentBalance + amount);
        return true;
    }

    /**
     * Verify if the amount requested can be assigned to this accountbased on their
     * current balance
     *
     * @param accountNumber account ID that we will vwerify on
     * @param loanamount    the request amoun to be verified
     * @return whether the amount was approved or not
     * 
     * 
     */

    public boolean authorizeLoan(int accountNumber, int loanAmount) {

        /**
         * System.out.print("Enter loan amount: "); int loanAmmount = scanner.nextInt();
         * int balance = accounts.get(current); if (balance >= loanAmmount / 2)
         * System.out.println("Your loan is approved"); else
         * System.out.println("Yourloan is denied");
         * 
         */
        int balance = accounts.get(accountNumber);

        if (balance >= loanAmount / 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * this method deposit a certain amount of money tpo all accounts based on aq
     * interest balance
     * 
     * @return if the transaction was executed successfully
     * 
     *         TODO : Implementation is very unefficient
     */
    public boolean payInterest() {
        /**
         * Set<Integer> accountIndetifiers = accounts.keySet(); for (int indetifier :
         * accountIndetifiers) { int balance = accounts.get(indetifier); int newbalance
         * = (int) (balance * (1 + interestRate)); accounts.put(indetifier, newbalance);
         * }
         */

        Set<Integer> accountNumbers = accounts.keySet();
        for (int accountNumber : accountNumbers) {
            int currentBalance = accounts.get(accountNumber);
            int newBalance = (int) (currentBalance * (1 + interestRate));
            accounts.put(accountNumber, newBalance);
        }
        return true;

    }

    @Override
    public String toString() {
        /*
         * Set<Integer> accountIndetifiers = accounts.keySet();
         * System.out.println("The bank has " + accountIndetifiers.size() +
         * " accounts."); for (int indentifier : accountIndetifiers)
         * System.out.println("\tAccount " + indentifier + ": balance=" +
         * accounts.get(indentifier));
         */
        StringBuilder builder = new StringBuilder();
        Set<Integer> accountIndetifiers = accounts.keySet();
        builder.append("The bank has " + accountIndetifiers.size() + " accounts.");
        for (int identifier : accountIndetifiers) {
            builder.append(System.lineSeparator()).append("\tAccount ").append(identifier).append(": balance=")
                    .append(accounts.get(identifier));

        }

        return builder.toString();
    }

}