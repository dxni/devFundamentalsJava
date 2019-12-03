package org.jalasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BankProgramOldTest{

    @Test

    public void createNewAccount(){
        BankProgramOld  bankProgramOld = new BankProgramOld();
        //Arrange
       
        
        ///Act
        int accountZero = bankProgramOld.newAccount();
        int accountOne = bankProgramOld.newAccount();
        int accountTwo = bankProgramOld.newAccount();
        int accountThree = bankProgramOld.newAccount();


        //Assert
        assertEquals(0, accountZero);
        assertEquals(1, accountOne);
        assertEquals(2, accountTwo);
        assertEquals(3, accountThree);


    }
    @Test
    public void depositAmountToAccount(){
        //Arrange
       // BankProgramOld  bankProgramOld = new BankProgramOld();
        //int accountZero= bankProgramOld.newAccount();


        //non-faceable to test
        

    }


}