package org.jalasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    public void depositAmountToAccount(){
        //Arrange
        BankAccount bankAccount = new BankAccount(0, AccountOrigin.FOREIGN);
        
        
        
        ///Act
        bankAccount.deposit(100);


        //Assert
        assertEquals(100, bankAccount.getBalance());
     


    }




}