package project.service.impl;


import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import project.model.User;
import project.dao.UserDAO;
import project.dao.UserDetailsDAO;
import project.service.UserService;
import project.model.UserDetails;
import project.GlobalConstants;
import project.GlobalConstants.*;
import project.service.PasswordHelperService;

@Component
public class UserServiceImpl implements UserService{
    
@Autowired
private UserDAO userDAO;
    
@Autowired
private PasswordHelperService passwordHelperService; 
    
@Autowired
private UserDetailsDAO userDetailsDAO;
    public User validateUser(User user){
        
        String saltedPassword = GlobalConstants.SALT + user.getPassword();
		String hashedPassword = passwordHelperService.generateHash(saltedPassword);
        int countOfValidUsers = userDAO.validateUser(user.getEmail(),hashedPassword);
        
        if(countOfValidUsers == 1)
            return user;
        
        return new User();
    }
    
    public User findByEmail(String email){
        return userDAO.findByEmailIgnoreCase(email.trim());
    }
    
    public User saveUser(User user){
        return userDAO.save(user);
    }
    
    public UserDetails saveUserDetails(UserDetails userDetails){
        return userDetailsDAO.save(userDetails);
    }
    
    public UserDetails findUserDetailsByEmail(String email){
        return userDetailsDAO.findByEmailIgnoreCase(email.trim());
    }
}