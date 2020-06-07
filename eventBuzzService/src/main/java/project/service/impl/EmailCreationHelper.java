// package project.service.impl;
// import project.service.EmailSenderService;
// import project.dao.ConfirmationTokenRepository;
// import project.model.ConfirmationToken;
// import org.springframework.mail.SimpleMailMessage;


// public class EmailCreationHelper {
    
//     public void createEmail(){
        
//          ConfirmationToken confirmationToken = new ConfirmationToken(userData.getUser());
//          confirmationTokenRepository.save(confirmationToken);
//          SimpleMailMessage mailMessage = new SimpleMailMessage();
//          mailMessage.setTo(userData.getUser().getEmail());
//          mailMessage.setSubject("Verify your account!");
//          mailMessage.setFrom("stackweb2019@gmail.com");
//          mailMessage.setText("To confirm your account, please click here : "
//          +"https://stackeventweb-nldsh.run-ap-south1.goorm.io/confirm-account?token="+
//                              confirmationToken.getConfirmationToken());
//          emailSenderService.sendEmail(mailMessage);
//          userData.setMessage("Yayy! New User Created!");
        
//     }
   
// }
