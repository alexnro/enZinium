package org.lasencinas.tokenContract;

import org.lasencinas.address.Address;
import org.lasencinas.genSig.GenSig;

import java.security.PublicKey;

public class TokenContract {

    private String name = null;
    private String symbol = null;
    private int TotalSupply = 0;
    private PublicKey owner = null;

    public TokenContract(Address address) {
        this.owner = address.getPK();
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getTotalSupply() {
        return this.TotalSupply;
    }

    public PublicKey getOwner() {
        return owner;
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
                          "\nsymbol = " + getSymbol() +
                          "\ntotalSupply = " + getTotalSupply() +
                          "\nowner PK = " + getOwner().hashCode();
        return toString;
    }
}
