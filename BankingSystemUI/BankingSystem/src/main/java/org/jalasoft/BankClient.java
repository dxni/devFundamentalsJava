package org.jalasoft;

import java.util.Scanner;

/**
 * BankClient
 */
public class BankClient {
    
    private Scanner scanner;
    private boolean done;
    private BankService bankServices;

    private int currentAccount;

    public BankClient() {
        done = false;
        currentAccount = 0;
    }

    /**
     * Ask the users the command they want to execute and execute that command 
     */
    public void run() {
        bankServices = new BankService();
        scanner = new Scanner(System.in);
        while (!done) {
            System.out.print("Enter command (0=quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest, 7=witdraw ): ");
            int commandNumber = scanner.nextInt();
            
            try {
                processCommand(commandNumber);
            } catch (IllegalArgumentException  | ArithmeticException exception ) {
                String fancyMessage = getFancyMessage(exception);
                System.out.println(fancyMessage);
            }
        }
        scanner.close();
    }

   

    /**
     * Decides what command will be executed based on the command number
     * 
     * @param commandNumber the command that will be executed
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
        else if (commandNumber == 7)
            withdraw();    
        else
            System.out.println("Illegal command");
    }

    private void quit() {
        done = true;
        System.out.println("Goodbye!");
    }

    private void newAccount() {
        System.out.println("Specify the origin of the account (Local, Rural, Foreign): ");
        String accountOriginAsString = scanner.next();        
        currentAccount = bankServices.newAccount(accountOriginAsString);
        System.out.println("Your new account number is: " + currentAccount);
    }

    private void select() {
        System.out.print("Enter account#: ");
        currentAccount = scanner.nextInt();
        int balance = bankServices.getBalance(currentAccount); //delegates the work to the appropriate class
        System.out.println("The balance of account " + currentAccount + " is " + balance);
    }

    private void deposit() {
        System.out.print("Enter deposit amount: ");
        int amount = scanner.nextInt();
        bankServices.deposit(currentAccount, amount); //delegates the work to the appropriate class
    }

    private void withdraw(){
        System.out.print("Enter deposit amount: ");
        int amount = scanner.nextInt();
        bankServices.withdraw(currentAccount, amount); //delegates the work to the appropriate class

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

    private String getFancyMessage(RuntimeException exception) {
        if(exception.getMessage().startsWith("No enum constant")){
            return "The value entered is not valid";
        }
        return exception.getMessage();
    }
    
   
}