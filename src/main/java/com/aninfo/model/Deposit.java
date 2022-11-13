package com.aninfo.model;

public class Deposit extends Transaction {

    private Double amount;

    public Deposit(Long accountCbu, Double amount){
        this.amount = amount;
        this.accountCbu = accountCbu;
    }

    public Double getAmount() {
        return amount;
    }
}