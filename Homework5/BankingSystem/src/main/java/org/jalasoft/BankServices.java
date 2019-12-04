package org.jalasoft;



public class BankServices {

    private Bank bank;

    public BankServices() {
        this.bank = new Bank();
    
    }



    /**
     * this method create a new accouny with balance
     * 
     * @return currentAccount number
     */
    public int newAccount() {
       
        int currentAccount = bank.newAccount();
        return currentAccount;
    }
    


     /**
     * Ask a given account to bank and then grabs the balance
     * 
     * @param accountNumber the account to check balance
     * @return the balance of the given account
     */

    public int getBalance(int accountNumber) {
        BankAccount bankAccount=bank.getBankAccount(accountNumber); 
        return bankAccount.getBalance();
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
        BankAccount bankAccount = bank.getBankAccount(accountNumber);
        return bankAccount.deposit(amount);
    
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

        BankAccount bankAccount = bank.getBankAccount(accountNumber);
        return bankAccount.hasEnoughCollateral(loanAmount);
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
        return bank.payInterest();

    }


    
    /**
     * 
     * @return the bank information with using the bank own format
     */
    public String getBankInformation(){
        return bank.toString();
    }


}