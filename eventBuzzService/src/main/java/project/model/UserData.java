package project.model;

public class UserData{
    
    private User user;
    private UserDetails userDetails;
    private String message;
    
    UserData(User user, UserDetails userDetails, String message){
        this.user = user;
        this.userDetails = userDetails;
        this.message = message;
    }
 
    public User getUser(){
        return this.user;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public UserDetails getUserDetails(){
        return this.userDetails;
    }
    
    public void setUserDetails(UserDetails userDetails){
        this.userDetails = userDetails;
    }
     public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}