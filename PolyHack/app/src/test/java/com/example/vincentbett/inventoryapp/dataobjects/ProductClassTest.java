package com.example.vincentbett.inventoryapp.dataobjects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ProductClassTest {

    private Product sample_product;

    @Before
    public void setUp() {
        sample_product = new Product("br3a4");
    }

    @After
    public void tearDown() {
        sample_product = null;
    }

    // Tests
    @Test
    public void setIdTest() {
        assertEquals(sample_product.get_id(), "br3a4");
    }

    @Test
    public void setNameTest() {
        sample_product.set_name("Ashish");
        assertEquals(sample_product.get_name(), "Ashish");
    }

    @Test
    public void setPriceTest() {

        sample_product.set_price(19.99);
        assertTrue(Math.abs(sample_product.get_price() - 19.99) < 0.001);
    }

}
