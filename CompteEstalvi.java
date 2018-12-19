package com.company;


import com.company.Exceptions.BankAccountException;
import com.company.Exceptions.BankClientException;
import com.company.Exceptions.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class CompteEstalvi {
    private String numCompte;
    private double saldo;
    private List<CompteEstalvi> compte_estalvis = new ArrayList<>(10);
    private List<Client> llista_usuaris = new ArrayList<>(10);

    public CompteEstalvi(String numCompte) {
        this.numCompte = String.format("%[0-9]{4}", numCompte);
        saldo = 0;
    }

    /**
     Afegeix un usuari d'aquest compte
     @param client
     @return quantitat d'usuaris que té el compte
     **/
    public int addUser(Client client) {
        llista_usuaris.add(client);
        return llista_usuaris.size();
    }

    /**
     Elimina un usuari d'aquest compte
     @param dni
     @return quantitat d'usuaris que té el compte
     @throws BankAccountException
     **/
    public int removeUser(String dni) throws BankAccountException {
        if (llista_usuaris == null) {
            llista_usuaris.removeIf(u -> dni.equals(u.getDNI()));

        }
        else throw new BankAccountException(ExceptionMessage.ACCOUNT_ZERO_USER);
        return llista_usuaris.size();
    }

    /**
     * Afegeix m diners al saldo
     * @param m
     */
    public void ingressar(double m) throws BankAccountException {
        if (m < 0) {
            throw new BankAccountException(ExceptionMessage.NEGATIVE_AMOUNT);
        } else {
            saldo += m;
        }
    }

    /**
     * Treu m diners del compte si n'hi han suficient
     * @param m
     * @throws BankAccountException
     */
    public void treure(double m) throws BankAccountException {
        if (saldo > m) {
            saldo -= m;
        } else throw new BankAccountException(ExceptionMessage.NOT_ENOUGH_MONEY);
    }

    public String getNumCompte() {
        return numCompte;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Client> getLlista_usuaris() {
        return llista_usuaris;
    }
}
