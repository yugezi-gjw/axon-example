package com.varian.ois.sample.exploringaxon.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

/**
 * Created by gbt1220 on 9/27/2016.
 */
@Entity
public class AccountEntity {
    @Id
    @javax.persistence.Id
    private String identifier;
    private String accountNo;
    private Double balance;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
