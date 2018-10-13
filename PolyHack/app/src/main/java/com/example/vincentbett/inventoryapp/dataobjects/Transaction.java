package com.example.vincentbett.inventoryapp.dataobjects;
enum TransactionType {
    BUY, SELL, RETURN_TO_CUSTOMER, RETURN_TO_SUPPLIER
}

public class Transaction {

    private String transaction_id;
    private String product_id;
    private double transaction_amount;
    private TransactionType transaction_type;
    private int created_tsecs;
    private int updated_tsecs;


    private Transaction() {
        // DISABLED DEFAULT CONSTRUCTOR
    }

    Transaction(String trans_id){
        this.transaction_id = trans_id;
    }

    Transaction(String trans_id, String prod_id){
        this.transaction_id = trans_id;
        this.product_id = prod_id;
    }

    Transaction(String trans_id, String prod_id, double trans_amt){
        this.transaction_id = trans_id;
        this.product_id = prod_id;
        this.transaction_amount = trans_amt;
    }

    Transaction(String trans_id, String prod_id, double trans_amt, TransactionType trans_type){
        this.transaction_id = trans_id;
        this.product_id = prod_id;
        this.transaction_amount = trans_amt;
        this.transaction_type = trans_type;
    }

    Transaction(String trans_id, String prod_id, double trans_amt, TransactionType trans_type,
                int created_time, int updated_time){
        this.transaction_id = trans_id;
        this.product_id = prod_id;
        this.transaction_amount = trans_amt;
        this.transaction_type = trans_type;
        this.created_tsecs = created_time;
        this.updated_tsecs = updated_time;
    }

    public String get_transaction_id() {
        return transaction_id;
    }

    public String get_product_id() {
        return product_id;
    }

    public void set_product_id(String product_id) {
        this.product_id = product_id;
    }

    public double get_transaction_amount() {
        return transaction_amount;
    }

    public void set_transaction_amount(double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public TransactionType get_transaction_type() {
        return transaction_type;
    }

    public void set_transaction_type(TransactionType transaction_type) {
        this.transaction_type = transaction_type;
    }

    public int get_created_tsecs() {
        return created_tsecs;
    }

    public void set_created_tsecs(int created_tsecs) {
        this.created_tsecs = created_tsecs;
    }

    public int get_updated_tsecs() {
        return updated_tsecs;
    }

    public void set_updated_tsecs(int updated_tsecs) {
        this.updated_tsecs = updated_tsecs;
    }
}
