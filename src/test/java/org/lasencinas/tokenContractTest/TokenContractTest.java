package org.lasencinas.tokenContractTest;

import org.junit.Test;
import org.lasencinas.address.Address;
import org.lasencinas.tokenContract.TokenContract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TokenContractTest {

    @Test
    public void TokenContractTest() {
        Address address = new Address();
        address.generateKeyPair();
        TokenContract token = new TokenContract(address);

        assertNotNull(token.getOwner());
        assertEquals(token.getOwner(), address.getPK());
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
