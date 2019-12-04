package org.jalasoft;

public class BankProgram {

    /**
     * this method excecued our banck client and man
     * @param argd
     */
    public static void main (String [] args){

        BankClient bankClient = new BankClient();
        bankClient.run();

    }

}