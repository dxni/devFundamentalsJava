package org.jalasoft;

import java.util.HashMap;
import java.util.Set;

/**
 * Bank
 */
public class Bank {

    private HashMap<Integer, BankAccount> accounts;
    private int nextAccount;
    private double interestRate;

    public Bank() {
        accounts = new HashMap<>();
        nextAccount = 0;
        interestRate = 0.01;
    }

    /**
     * Create a new account and assign it an account number and sets the balance to 0
     * 
     * @return The account number
     */
    public int newAccount() {
        return newAccount(AccountOrigin.LOCAL);
    }

    /**
     * Create a new account with a given origin and assign it an account number and sets the balance to 0
     * 
     * @param origin the origin of the account
     * @return The account number
     */
    public int newAccount(AccountOrigin origin) {
        BankAccount newBankAccount = new BankAccount(nextAccount++, origin);
        accounts.put(newBankAccount.getAccountNumber(), newBankAccount);    
        return newBankAccount.getAccountNumber();
    }

    /**
     * Given an account number it will search for the BankAccount instance
     *  - If the accountNumber does not exist it wil return 'null' 
     * 
     * TODO: Analyse NullObjectPattern to avoid nulls
     * 
     * @param accountNumber the account number to find the BankAccountInstance
     * @return a instance of BankAccount
     */
    public BankAccount getBankAccount(int accountNumber)  {    
        return accounts.get(accountNumber);
    }

    /**
     * This method deposit a certain amount of money to all accounts based on a
     * interest rate
     */
    public void payInterest() {
        for(BankAccount bankAccount : accounts.values()) {
            int interestToPay = (int) (bankAccount.getBalance() * interestRate);
            if (interestToPay > 0) {
                bankAccount.deposit(interestToPay);
            }
        }
    }

    /**
     * @return the interestRate which will help to calculate the interest to pay
     */
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Set<Integer> accountNumbers = accounts.keySet();
        builder.append("The bank has ").append(accountNumbers.size()).append(" accounts.");
        for (int accountNumber : accountNumbers) {
            builder
                .append(System.lineSeparator())
                .append("\tAccount ").append(accountNumber)
                .append(": balance = ").append(accounts.get(accountNumber).getBalance());
        }

        return builder.toString();
    }  
}