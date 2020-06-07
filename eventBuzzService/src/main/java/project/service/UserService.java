package project.service;

import org.springframework.stereotype.Service;
import project.model.User;
import project.model.UserDetails;



@Service
public interface UserService{
    
    public User validateUser(User user);
    public User findByEmail(String email);
    public User saveUser(User user);
    
    public UserDetails saveUserDetails(UserDetails userDetails);
    public UserDetails findUserDetailsByEmail(String email);
}