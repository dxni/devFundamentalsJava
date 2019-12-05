package org.jalasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * BankAccountTest
 */
public class FreshBankAccountTests {

    int initialAmount = 2000;
    BankAccount bankAccount;

    @BeforeEach
    public void beforeEach() {
        bankAccount = new BankAccount(0, AccountOrigin.FOREIGN);
        bankAccount.deposit(initialAmount);
    }

    @ParameterizedTest
    @ValueSource(ints = {200, 300, 400, 10000, 20000})
    public void multipleDepositActionsToAccount(int amountToDeposit) {
        // Act
        bankAccount.deposit(amountToDeposit);
        // Assert
        assertEquals(amountToDeposit + initialAmount, bankAccount.getBalance());
    }


    @ParameterizedTest
    @ValueSource(ints = {-200, -300, -400, -10000, -20000})
    public void multipleInvalidDepositActionsToAccount(int amountToDeposit) {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(amountToDeposit));
    }

    @ParameterizedTest
    @ValueSource(ints = {200, 300, 400, 1000, 2000})
    public void multipleWithdrawActionsToAccount(int amountToDeposit) {
        // Act
        bankAccount.withdraw(amountToDeposit);
        // Assert
        assertEquals(initialAmount - amountToDeposit, bankAccount.getBalance());
    }

    @ParameterizedTest
    @ValueSource(ints = {-3000, -4000, -5000, -6000})
    public void multipleInvalidWithdrawActionsToAccount(int amountToDeposit) {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(amountToDeposit));
    }

    @ParameterizedTest
    @ValueSource(ints = {3000, 4000, 5000, 6000})
    public void multipleWithdrawActionsToAccountWithInsufficientBalance(int amountToDeposit) {
        // Act & Assert
        assertThrows(ArithmeticException.class, () -> bankAccount.withdraw(amountToDeposit));
    }


    @ParameterizedTest
    @ValueSource(ints = {2000, 4000, 1000, 100})
    public void hasEnoughCollateralIntoAccount(int loanAmount) {
        assertTrue(bankAccount.hasEnoughCollateral(loanAmount));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {5000, 6000, 7000, 8000, -100, -5000})
    public void doesNotHaveEnoughCollateralIntoAccount(int loanAmount) {
        assertFalse(bankAccount.hasEnoughCollateral(loanAmount));
    }
    
    @Test
    @Disabled
    public void depositAmountToAccount() {
        // Act
        bankAccount.deposit(100);

        // Assert
        assertEquals(100, bankAccount.getBalance());
    }


    @Test
    @Disabled
    public void fakeTest() {
        int numberOne = 100;
        int numberTwo = numberOne;

        assertEquals(100, numberOne);
        assertEquals(100, numberTwo);

        numberOne = 300;
        numberTwo = 200;

        assertEquals(300, numberOne);
        assertEquals(200, numberTwo);

    }

    @Test
    @Disabled
    public void fakeTestTwo() {
        BankAccount accountOne = new BankAccount(0, AccountOrigin.LOCAL);
        BankAccount accountTwo = accountOne;

        assertEquals(0, accountOne.getBalance());
        assertEquals(0, accountTwo.getBalance());

        accountOne.deposit(100);

        assertEquals(100, accountOne.getBalance());
        assertEquals(100, accountTwo.getBalance());
    }
}