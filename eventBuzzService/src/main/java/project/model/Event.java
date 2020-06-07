package project.model;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import project.GlobalConstants.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Entity
@Table(name = "event")
public class Event{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int eventId;
    
    @Temporal(TemporalType.DATE)
    private Date eventCreatedDate;

    private String eventName;
    private String eventDescription;
    private String eventImageUrl;
    private String eventLocation;
    
    @Temporal(TemporalType.DATE)
    private Date eventFromDate;
    @Temporal(TemporalType.DATE)
    private Date eventToDate;
    
    @Enumerated(EnumType.STRING)
    private OrganizedType organizedType;
    
    private String organizerName;
    private String organizerPhone;
    private String organizerEmail;
    
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    
    @Enumerated(EnumType.STRING)
    private HeadCount eventHeadCount;
    private String ticketQuantity;
    private String ticketPrice;
    
    @Enumerated(EnumType.STRING)
    private EventCategory eventCategory;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy = "event")
    private List<Registration> registration;
    
    public Event(){}
    
    public Event(int eventId, Date eventCreatedDate, String eventName,String eventDescription, String eventImageUrl, String eventLocation, Date eventFromDate, Date eventToDate,  OrganizedType organizedType, String organizerName, String organizerPhone, String organizerEmail, EventType eventType, HeadCount eventHeadCount, String ticketQuantity, String ticketPrice, EventCategory eventCategory, User user,List<Registration> registration){
        
        this.eventId = eventId;
        this.eventCreatedDate = eventCreatedDate;
        this.eventName=eventName;
        this.eventDescription=eventDescription;
        this.eventImageUrl = eventImageUrl;
        this.eventLocation=eventLocation;
        this.eventFromDate = eventFromDate;
        this.eventToDate = eventToDate;
        this.organizedType = organizedType;
        this.organizerName = organizerName;
        this.organizerPhone = organizerPhone;
        this.organizerEmail = organizerEmail;
        this.eventType = eventType;
        this.eventHeadCount = eventHeadCount;
        this.ticketQuantity = ticketQuantity;
        this.ticketPrice = ticketPrice;
        this.eventCategory = eventCategory;
        this.user = user;
        this.registration=registration;
        
    }
    
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    
    
    public Date getEventCreatedDate(){
        return eventCreatedDate;
    }
    
    public void setEventDate(Date eventCreatedDate){
        this.eventCreatedDate = eventCreatedDate;
    }
    
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
    
    public String getEventImageUrl() {
        return eventImageUrl;
    }

    public void setEventImageUrl(String eventImageUrl) {
        this.eventImageUrl = eventImageUrl;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Date getEventFromDate(){
        return eventFromDate;
    }
    
    public void setEventFromDate(Date eventFromDate){
        this.eventFromDate = eventFromDate;
    }
    
    public Date getEventToDate(){
        return eventToDate;
    }
    
    public void setEventToDate(Date eventToDate){
        this.eventToDate = eventToDate;
    }
    
    public OrganizedType getOrganizedType(){
        return organizedType;
    }
    
    public void setOrganizedType(OrganizedType organizedType){
        this.organizedType = organizedType;
    }
    
    public String getOrganizerName(){
        return organizerName;
    }
    
    public void setOrganizerName(String organizerName){
        this.organizerName = organizerName;
    }
    
    public String getOrganizerPhone(){
        return organizerPhone;
    }
    
    public void setOrganizerPhone(String organizerPhone){
        this.organizerPhone = organizerPhone;
    }
    
    public String getOrganizerEmail(){
        return organizerEmail;
    }
    
    public void setOrganizerEmail(String organizerEmail){
        this.organizerEmail = organizerEmail;
    }
    
    public EventType getEventType(){
        return eventType;
    }
    
    public void setEventType(EventType eventType){
        this.eventType = eventType;
    }
    
    public HeadCount getEventHeadCount(){
        return eventHeadCount;
    }
    
    public void setEventHeadCount(HeadCount eventHeadCount){
        this.eventHeadCount = eventHeadCount;
    }
    
    public String getTicketQuantity(){
        return ticketQuantity;
    }
    
    public void setTicketQuantity(String ticketQuantity){
        this.ticketQuantity = ticketQuantity;
    }
    
    public String getTicketPrice(){
        return ticketPrice;
    }
    
    public void setTicketPrice(String ticketPrice){
        this.ticketPrice = ticketPrice;
    }
    
    public EventCategory getEventCategory(){
        return eventCategory;
    }
    
    public void setEventCateogry(EventCategory eventCategory){
        this.eventCategory = eventCategory;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    public void setRegistration(List<Registration> registration){
        this.registration = registration;
    }


}
