package project.model;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.Column;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import project.GlobalConstants.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int eventRegId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;
    
    @Column
    private String name;
    @Column
    private String email;
    
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Column
    private Long transactionId;

    public Registration(){}
    
    public Registration(User user, Event event, String name, String email, TicketType ticketType, Status status, Long transactionId) {
        
        this.user = user;
        this.event = event;
        this.name = name;
        this.email = email;
        this.ticketType = ticketType;
        this.status = status;
        this.transactionId = transactionId;
    }

    public int getEventRegId() {
        return eventRegId;
    }
      
    public void setUser(User user) {
        this.user = user;
    }

    // public Event getEvent() {
    //     return event;
    // }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long gettransactionId() {
        return transactionId;
    }

    public void settransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
