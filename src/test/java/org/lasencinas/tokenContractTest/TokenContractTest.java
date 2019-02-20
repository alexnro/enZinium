package org.lasencinas.tokenContractTest;

import org.junit.Before;
import org.junit.Test;
import org.lasencinas.address.Address;
import org.lasencinas.tokenContract.TokenContract;

import static org.junit.Assert.*;

public class TokenContractTest {

    Address address = null;
    TokenContract token = null;

    @Before
    public void init() {
        address = new Address();
        address.generateKeyPair();
        token = new TokenContract(address);
    }

    @Test
    public void TokenContractTest() {

        assertNotNull(token.getOwner());
        assertEquals(token.getOwner(), address.getPK());
    }

    @Test
    public void gettersTest() {
        token.setName("Pepinillos");
        token.setSymbol("PNP");
        token.setTotalSupply(350);

        assertEquals("Pepinillos", token.getName());
        assertEquals("PNP", token.symbol());
        assertEquals(350, token.totalSupply(), 0);
    }

    @Test
    public void ownerTest() {
        Address pepe = new Address();
        pepe.generateKeyPair();
        token.addOwner(address.getPK(), token.totalSupply());
        token.addOwner(pepe.getPK(), 500d);

        assertEquals(token.getOwner(), address.getPK());
        assertNotEquals(token.totalSupply(), 500d);
        assertEquals(token.numOwners(), 1);
    }

//    @Test
//    public void payable_test() {
//
//        Address rick = new Address();
//        rick.generateKeyPair();
//        TokenContract ricknillos = new TokenContract(rick);
//        ricknillos.addOwner(rick.getPK(), 100d);
//        Address morty = new Address();
//        morty.generateKeyPair();
//
//        morty.addEZI(20d);
//
//        // verifico la transferencia de entradas
//        ricknillos.payable(morty.getPK(), morty.getBalance());
//        assertEquals(4d, ricknillos.balanceOf(morty.getPK()), 0d);
//
//        // verifico la trasnferencia de EZI
//        assertEquals(20d, ricknillos.owner().getBalance(), 0d);
//    }
}
