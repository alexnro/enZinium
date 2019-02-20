package org.lasencinas.tokenContract;

import org.lasencinas.address.Address;
import org.lasencinas.genSig.GenSig;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class TokenContract {

    private String name = null;
    private String symbol = null;
    private double TotalSupply = 0;
    private PublicKey owner = null;
    private Map<PublicKey, Double> ownerBalance = new HashMap<PublicKey, Double>();
    private double balance = 0;

    public TokenContract(Address address) {
        this.owner = address.getPK();
    }

    public String getName() {
        return this.name;
    }

    public String symbol() {
        return this.symbol;
    }

    public PublicKey getOwner() {
        return owner;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setTotalSupply(int totalSupply) {
        TotalSupply = totalSupply;
    }

    @Override
    public String toString() {
        String toString = "\nname = " + getName() +
                          "\nsymbol = " + symbol() +
                          "\ntotalSupply = " + totalSupply() +
                          "\nowner PK = " + getOwner().hashCode();
        return toString;
    }

    public void addOwner(PublicKey PK, double units) {
        if (units <= totalSupply())  {
            ownerBalance.put(PK, units);
        } else {
            ownerBalance.put(PK, totalSupply());
        }
    }

    public double totalSupply() {
        return this.TotalSupply;
    }

    public int numOwners() {
        int numOwners = 0;
        for (PublicKey key : ownerBalance.keySet()) {
            numOwners++;
        }
        return numOwners;
    }

    public double balanceOf(PublicKey owner) {
        double balanceOf = 0;
        for (Map.Entry<PublicKey, Double> ownerSupply : ownerBalance.entrySet()) {
            if (ownerSupply.getKey() == owner) {
                balanceOf = ownerSupply.getValue();
            }
        }
        return balanceOf;
    }
}
