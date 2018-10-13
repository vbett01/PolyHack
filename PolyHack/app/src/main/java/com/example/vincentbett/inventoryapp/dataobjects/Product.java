package com.example.vincentbett.inventoryapp.dataobjects;

public class Product {

    private String name;
    private String product_id;
    private double price;

    private Product() {
        // DISABLED DEFAULT CONSTRUCTOR
    }

    Product(String id){
        this.product_id = id;
    }

    Product(String id, double new_price){
        this.product_id = id;
        this.price = new_price;

    }

    Product(String id, double new_price, String new_name){
        this.product_id = id;
        this.price = new_price;
        this.name = new_name;
    }


    public String get_id(){
        return product_id;
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
