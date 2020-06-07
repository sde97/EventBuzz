package project.service.impl;
import project.model.Registration;
import project.dao.RegistrationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;
import project.service.RegistrationService;
import project.GlobalConstants;
import project.service.EmailSenderService;
import project.model.UserData;
import project.service.UserService;
import project.service.PasswordHelperService;
import project.dao.ConfirmationTokenRepository;
import project.model.ConfirmationToken;
import org.springframework.mail.SimpleMailMessage;
import project.dao.ConfirmationTokenRepository;

import project.GlobalConstants.*;

@Component
public class RegistrationServiceImpl implements RegistrationService{
    
    @Autowired
    private RegistrationDAO registrationDAO;
    
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
        
    @Autowired
    private EmailSenderService emailSenderService;
    
    public List<Registration> saveRegistration(List<Registration> registrations){
        List<Registration> regList = new ArrayList<Registration>();
        for(Registration reg : registrations){
           regList.add(registrationDAO.save(reg));
            String inviteeEmail = reg.getEmail();
            String inviteeName = reg.getName();
             if(reg.getStatus() != GlobalConstants.Status.Approved){
                 ConfirmationToken confirmationToken = new ConfirmationToken(reg);
                 confirmationTokenRepository.save(confirmationToken);
                 SimpleMailMessage mailMessage = new SimpleMailMessage();
                 mailMessage.setTo(inviteeEmail);
                 mailMessage.setSubject("You have been Invited!");
                 mailMessage.setFrom("stackweb2019@gmail.com");
                 mailMessage.setText("Hi " + inviteeName + " ," + "\n" + "To confirm your invitation, please click here : "
                 +"https://stackeventweb-nldsh.run-ap-south1.goorm.io/confirm-invitation?token="+
                                     confirmationToken.getConfirmationToken());
                 emailSenderService.sendEmail(mailMessage);
                 
            }
            else {
                 SimpleMailMessage mailMessage = new SimpleMailMessage();
                 mailMessage.setTo(inviteeEmail);
                 mailMessage.setSubject("Your Invitation is Approved!");
                 mailMessage.setFrom("stackweb2019@gmail.com");
                 mailMessage.setText("Hi " + inviteeName + " ," + "\n" + "Your invitation has been approved!!! Come join us. We will be waiting !!!!" );
                 emailSenderService.sendEmail(mailMessage);
                
            }
                 
                 
        }
        
        return regList;
    }
    public Registration findById(int id){
        return registrationDAO.findByEventRegId(id);
    }
}
