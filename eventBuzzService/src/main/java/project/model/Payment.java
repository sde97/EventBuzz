package project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;

import ch.qos.logback.core.status.Status;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import project.model.Event;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import project.GlobalConstants.*;
import java.util.List;


public class Payment {
    
    private int amount;
    private String stripePublicKey;
    private String description;
    private Currency currency;
    private String stripeEmail;
    private String stripeToken;
    private String id;
    private String status;
    private String chargeId;
    private String balanceTransaction;
        
    

    public Payment(){}
    
    Payment(int amount, String stripePublicKey, String description, Currency currency, String stripeEmail, String stripeToken, String id, String status, String chargeId, String balanceTransaction){

        this.amount = amount;
        this.stripePublicKey = stripePublicKey;
        this.currency = currency;
        this.stripeEmail = stripeEmail;
        this.stripeToken = stripeToken;
        this.id = id;
        this.status = status;
        this.chargeId = chargeId;
        this.balanceTransaction = balanceTransaction;
    }

public int getAmount() {
    return amount;
}

public void setAmount(int amount) {
    this.amount = amount;
}

public String getStripePublicKey() {
    return stripePublicKey;
}

public void setStripePublicKey(String stripePublicKey) {
    this.stripePublicKey = stripePublicKey;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public Currency getCurrency() {
    return currency;
}

public void setCurrency(Currency currency) {
    this.currency = currency;
}

public String getStripeEmail() {
    return stripeEmail;
}

public void setStripeEmail(String stripeEmail) {
    this.stripeEmail = stripeEmail;
}

public String getStripeToken() {
    return stripeToken;
}

public void setStripeToken(String stripeToken) {
    this.stripeToken = stripeToken;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public String getChargeId() {
    return chargeId;
}

public void setChargeId(String chargeId) {
    this.chargeId = chargeId;
}

public String getBalanceTransaction() {
    return balanceTransaction;
}

public void setBalanceTransaction(String balanceTransaction) {
    this.balanceTransaction = balanceTransaction;
}

   
}
