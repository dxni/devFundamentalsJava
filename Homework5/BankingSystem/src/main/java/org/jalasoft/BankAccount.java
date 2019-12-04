package org.jalasoft;

public class BankAccount{


    private int accountNumber;
    private int balance;
    private AccountOrigin accountOrigin;
    /**
     *@param accountNumber the unique identifier for a bank account
     *@param AccountOrigin represent where the account was created 
     */

    public BankAccount(int accountNumber, AccountOrigin AccountOrigin) {
        this.accountNumber = accountNumber;
        this.accountOrigin = accountOrigin;
        this.balance = 0;
    }
    /**
     * 
     * 
     * @return the unique identifier of the account 
     */
    public int getAccountNumber(){
        return accountNumber;
    }
    /**
     * 
     * @return total amount of balance of the account
     */
    public int getBalance(){
        return balance;

    }    

    /**
     * 
     * @return the origin where the account was created
     */
    public AccountOrigin getAccountOrigin() {
        return accountOrigin;
    }

/**
 * this increase  the ammount of the balance applying the following restrucctions:
 * 
 * 
 * @param amount the amount thata will be increased
 * @return
 */
    public boolean deposit(int amount){

        if (amount <= 0) {
            throw new IllegalArgumentException("The deposit amount must be greater than 0.");
        }
        balance += amount;
        return true;
    }


/**
 * this decrease  the ammount of the balance applying the following restrucctions:
 * - the amoint cannot ge greater than the currrent balance
 * 
 * 
 * @param amount the amount thata will be decreased
 * @return
 */
    public boolean withdraw (int amount){
       balance -= amount;
       return true;
    }



    /**
     * will check if the amount cam be supported by the current balance+
     * 
     * <<explain how the check will be performed>>
     * 
     * @param amount the amount tio check
     * @return wether amount is supported or not
     */
    public boolean hasEnoughCollateral(int amount){
        return balance >= amount / 2;
    }


    /**
     * change the account origin app`lying the following action
     * - change the limit for withdraw
     * - change the restriction for loan 
     * - etc
     * @param accountOrigin the new account origin to change, it will decide how the restriction or facilities will change
     * @return
     * 
     * DO NOT IMPLEMENT IT: Still in design
     */
    public boolean changeAccount(AccountOrigin AccountOrigin) {
        return false;
    }

}