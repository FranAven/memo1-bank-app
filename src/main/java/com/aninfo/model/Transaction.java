package com.aninfo.model;

import javax.persistence.*;

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long accountCbu;
    private Double income;

    public Transaction (Long accountCbu, Double amount){
        this.income = amount;
        this.accountCbu = accountCbu;
    }

    public Long getAccountCbu (){
        return this.accountCbu;
    }

    public Double getIncome() {
        return income;
    }

    public Long getId(){
        return this.id;
    }
}
