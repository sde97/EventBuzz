package project.orchestrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.model.User;
import project.model.Registration;
import project.model.UserData;
import project.service.UserService;
import project.service.PasswordHelperService;
import project.service.EmailSenderService;
import project.dao.ConfirmationTokenRepository;
import project.model.ConfirmationToken;
import org.springframework.mail.SimpleMailMessage;
import project.service.RegistrationService;
import project.GlobalConstants;
import project.GlobalConstants.*;
import java.util.*;

@Component
public class UserOrchestrator{

        
    @Autowired
    private UserService userService;
    
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;
    
    @Autowired
    private PasswordHelperService passwordHelperService;
    
    @Autowired
    private RegistrationService registrationService;
    
    public UserData validateUser(UserData userData){
        User userValidated = userService.validateUser(userData.getUser());
        if(null != userValidated.getEmail()){
            userData.setUser(userService.findByEmail(userValidated.getEmail()));
            userData.setUserDetails(userService.findUserDetailsByEmail(userData.getUser().getEmail().trim()));
            userData.getUser().setPassword(null);
            userData.getUserDetails().setIdUrl(null);
            userData.setMessage("User Successfully Authenticated");
        }
        else{
            userData.setUser(null);
            userData.setMessage("Authentication failed");
        }
        return userData;
    }
    
    public UserData register(UserData userData){
        User existingUser = userService.findByEmail(userData.getUser().getEmail());
        if(existingUser != null)
        {
            userData.setMessage("User already present");
        }
        else
        {
            User localUser = userData.getUser();
            String saltedPassword = GlobalConstants.SALT + localUser.getPassword().trim();
		    String hashedPassword = passwordHelperService.generateHash(saltedPassword);
            localUser.setPassword(hashedPassword);        
            User user = userService.saveUser(localUser);
            userData.getUserDetails().setUser(user);
            userService.saveUserDetails(userData.getUserDetails());
            ConfirmationToken confirmationToken = new ConfirmationToken(userData.getUser());
            confirmationTokenRepository.save(confirmationToken);
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(userData.getUser().getEmail());
            mailMessage.setSubject("Verify your account!");
            mailMessage.setFrom("stackweb2019@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
            +"https://stackeventweb-nldsh.run-ap-south1.goorm.io/confirm-account?token="+
                                confirmationToken.getConfirmationToken());
            emailSenderService.sendEmail(mailMessage);
            userData.setMessage("Yayy! New User Created!");
        }
        userData.getUser().setPassword(null);
        userData.getUserDetails().setIdUrl(null);
     
      return userData;
    }
    
    public String confirmAccount(String confirmationToken){
        
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if(token != null){
            User user = userService.findByEmail(token.getUser().getEmail());
            user.setIsEnabled(true);
            userService.saveUser(user);
            return "Verified.html";
        }
        return "error.html";
    }
    
    public String confirmInvitation(String confirmationToken){
        
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if(token != null){
            Registration registration = registrationService.findById(token.getRegistration().getEventRegId());
            registration.setStatus(GlobalConstants.Status.Approved);
            System.out.println(registration);
            registrationService.saveRegistration(Arrays.asList(registration));
            return "Verified.html";
        }
        return "error.html";
    }
}