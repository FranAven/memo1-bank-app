package com.aninfo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected Long accountCbu;

    public Long getAccountCbu(){
        return this.accountCbu;
    }

    public Long getId(){
        return this.id;
    }
}
