package org.lasencinas.address;

import org.lasencinas.genSig.GenSig;

import java.security.PublicKey;

public class Address {

    private PublicKey PK = null;
    private PublicKey SK = null;
    private double balance = 0;
    private String symbol = "EZI";

    public PublicKey getPK() {
        return this.PK;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setPK(PublicKey PK) {
        this.PK = PK;
    }

    public void setSK(PublicKey SK) {
        this.SK = SK;
    }

    public void generateKeyPair() {
        setPK(GenSig.generateKeyPair().getPublic());
        setSK(GenSig.generateKeyPair().getPublic());
    }

    @Override
    public String toString() {
        String toString = "\nPK = " + getPK().hashCode() +
                          "\nBalance = " + getBalance();
        return toString;
    }
}
