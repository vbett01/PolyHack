package com.example.vincentbett.inventoryapp.dataobjects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransactionTest {

    private Transaction transaction;

    @Before
    public void setUp() {
        transaction = new Transaction("s01D");
    }

    @After
    public void tearDown() {
        transaction = null;
    }

    // Tests
    @Test
    public void transaction_id_test() {
        assertEquals(transaction.get_transaction_id(), "s01D");
    }

    @Test
    public void product_id_test() {
        transaction.set_product_id("b73a4");
        assertEquals(transaction.get_product_id(), "b73a4");
    }

}
