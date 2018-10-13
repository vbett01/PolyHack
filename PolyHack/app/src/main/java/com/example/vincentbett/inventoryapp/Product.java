package com.example.vincentbett.inventoryapp;

public class Product {

    private String name;
    private String productID;
    private double price;

    private Product() {
        // DISABLED DEFAULT CONSTRUCTOR
    }

    Product(String id){
        this.productID = id;
    }

    Product(String id, double new_price){
        this.productID = id;
        this.price = new_price;

    }

    Product(String id, double new_price, String new_name){
        this.productID = id;
        this.price = new_price;
        this.name = new_name;
    }


    public String get_id(){
        return productID;
    }
    /*
     * Name getter
     * Returns: name based on product ID
     */
    public String get_name(){
        return name;
    }


    /*
     * Price getter
     * Returns: price based on product ID
     */
    public double get_price(){
        return price;
    }

    /*
     * Name setter
     */
    public void set_name(String new_name){
        this.name = new_name;
    }

    /*
     * Price setter
     */
    public void set_price(double new_price) {
        this.price = new_price;
    }
}
