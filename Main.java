package com.company;

import com.company.Exceptions.BankAccountException;
import com.company.Exceptions.BankClientException;

public class Main {

    public static void main(String[] args) throws BankClientException{

        Client client = new Client("nom", "cognoms", "54178407K");
        try {
            client = new Client("Javi", "Ruiz", "54178407K");
        } catch (BankClientException e) {
            e.printStackTrace();
        }

        CompteEstalvi compteEstalvi = new CompteEstalvi("0001");

        try {
            compteEstalvi.ingressar(50);
        } catch (BankAccountException e) {
            e.printStackTrace();
        }

        try {
            compteEstalvi.treure(20);
        } catch (BankAccountException e) {
            e.printStackTrace();
        }

        compteEstalvi.addUser(client);

        try {
            compteEstalvi.removeUser("54178407K");
        } catch (BankAccountException e) {
            e.printStackTrace();
        }
    }

}
