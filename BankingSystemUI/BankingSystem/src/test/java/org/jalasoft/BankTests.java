package org.jalasoft;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * BankTests
 */
public class BankTests {

    @Test
    public void createNewAccount() {
        //Arrange
        Bank bank = new Bank();
        
        //Act
        int accountZero = bank.newAccount();
        int accountOne = bank.newAccount();
        int accountTwo = bank.newAccount();
        int accountThree = bank.newAccount();
        
        //Assert
        assertEquals(0, accountZero);
        assertEquals(1, accountOne);
        assertEquals(2, accountTwo);
        assertEquals(3, accountThree);
    }

    @Test
    public void createDefaultNewAccount() {
        //Arrange
        Bank bank = new Bank();
        
        //Act
        int accountZero = bank.newAccount();
        BankAccount accountOne = bank.getBankAccount(accountZero);
        
        //Assert
        assertEquals(AccountOrigin.LOCAL, accountOne.getAccountOrigin());
    }

    @Test
    public void getAccountGivenTheAccountNumber() {
        //Arrange
        Bank bank = new Bank();
        int accountZero = bank.newAccount();
        
        //Act
        BankAccount accountOne = bank.getBankAccount(accountZero);
        
        //Assert
        assertEquals(accountZero, accountOne.getAccountNumber());
    }

    @Test
    public void payInterestToAllAccounts() {
        //Arrange
        int accountOneInitialAmount = 2000;
        int accountTwoInitialAmount = 1000;

        Bank bank = new Bank();
        int accountNumberOne = bank.newAccount();
        int accountNumberTwo = bank.newAccount();

        BankAccount accountOne = bank.getBankAccount(accountNumberOne);
        accountOne.deposit(accountOneInitialAmount);
        BankAccount accountTwo = bank.getBankAccount(accountNumberTwo);
        accountTwo.deposit(accountTwoInitialAmount);

        //Act
        bank.payInterest();


        //Assert
        assertEquals(accountOneInitialAmount + (accountOneInitialAmount * bank.getInterestRate()), accountOne.getBalance());
        assertEquals(accountTwoInitialAmount + (accountTwoInitialAmount * bank.getInterestRate()), accountTwo.getBalance());
    }

    @Test
    public void payInterestToAccountsWithZeroBalance() {
        //Arrange

        Bank bank = new Bank();
        bank.newAccount();
        
        //Act & Assert
        assertDoesNotThrow(() -> bank.payInterest());
    }
}