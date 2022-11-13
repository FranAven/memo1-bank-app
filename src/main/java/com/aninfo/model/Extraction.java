package com.aninfo.model;

public class Extraction extends Transaction {

    private Double amount;

    public Extraction(Long accountCbu, Double amount){
        this.amount = amount;
        this.accountCbu = accountCbu;
    }

    public Double getAmount() {
        return amount;
    }
}
