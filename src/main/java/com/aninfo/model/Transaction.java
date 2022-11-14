package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long accountCbu;
    private Double amount;
    private String transactionType;

    public Transaction(Long accountCbu, Double amount, String transactionType){
        this.amount = amount;
        this.accountCbu = accountCbu;
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public Long getAccountCbu(){
        return this.accountCbu;
    }

    public Long getId(){
        return this.id;
    }
}
