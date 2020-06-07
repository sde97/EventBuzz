package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import project.model.User;
import project.model.UserData;
import project.orchestrator.UserOrchestrator;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
   
@Controller
public class UserController {


    @Autowired
    private UserOrchestrator userOrchestrator;
    
    @GetMapping("/home")
     public String home() {

      return "home.html";
}
    
    @PostMapping("/register")
    public ResponseEntity<UserData> newUser(@RequestBody UserData userData) {
     return ResponseEntity.ok(userOrchestrator.register(userData));
     
  }
    
    @GetMapping("/confirm-account")
    public String confirmUserAccount(@RequestParam("token") String confirmationToken){
        
        return userOrchestrator.confirmAccount(confirmationToken);
    }
    
     @GetMapping("/confirm-invitation")
    public String confirmInvitation(@RequestParam("token") String confirmationToken){
        
        return userOrchestrator.confirmInvitation(confirmationToken);
    }
    
    @PostMapping("/signin")
    public ResponseEntity<UserData> login(@RequestBody UserData userData){
        
       return ResponseEntity.ok(userOrchestrator.validateUser(userData));
    }

}
