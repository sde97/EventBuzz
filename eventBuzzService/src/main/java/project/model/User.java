package project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import project.model.Event;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import java.util.List;

@Entity
@Table(name="User")

public class User {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    private String userPhotoUrl;
    
    private Boolean isEnabled;
        
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private UserDetails userDetails;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Event> events;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Registration> registrations;

    public User(){}
    
    User(String email, String password, UserDetails userDetails, Boolean isEnabled, List<Event> events,List<Registration> registrations, String userPhotoUrl){

        this.email = email;
        this.password = password;
        this.userDetails = userDetails;
        this.isEnabled = isEnabled;
        this.events = events;
        this.registrations = registrations;
        this.userPhotoUrl = userPhotoUrl;
    }
    
    public Long getUserId(){
        return userId;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setIsEnabled(Boolean isEnabled){
        this.isEnabled=isEnabled;
    }
    public Boolean getIsEnabled(){
        return this.isEnabled;
    }
    
    public void setUserDetails(UserDetails userDetails){
        this.userDetails = userDetails;
    }
   
    public void setEvent(List<Event> events){
        this.events = events;
    }
    
     public void setRegistration(List<Registration> registrations){
        this.registrations = registrations;
    }
    
    public String getUserPhotourl(){
        return this.userPhotoUrl;
    }
    public void setUserPhotoUrl(String userPhotoUrl){
        this.userPhotoUrl = userPhotoUrl;
    }
   
}
