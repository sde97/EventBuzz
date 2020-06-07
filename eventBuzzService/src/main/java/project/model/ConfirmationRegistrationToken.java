package project.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ConfirmationRegistrationToken {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="token_id")
    private long tokenid;

    @Column(name="confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = Registration.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "regId")
    private Registration registration;
    

    
    protected ConfirmationRegistrationToken(){}
        
    public ConfirmationRegistrationToken(Registration registration) {
        this.registration = registration;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }
    
    public long getTokenid() {
        return tokenid;
    }

    public void setTokenid(long tokenid) {
        this.tokenid = tokenid;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Registration getRegistration() {
        return registration;
    }
    
     public void setRegistration(Registration registration) {
        this.registration = registration;
    }
    
}

