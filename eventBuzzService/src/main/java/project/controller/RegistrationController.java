package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import project.model.Registration;
import java.util.List;
import project.StripeClient;
import com.stripe.model.Charge;
import project.orchestrator.EventRegistrationOrchestrator;

@Controller
public class RegistrationController {
    
    @Autowired
    EventRegistrationOrchestrator eventRegistrationOrchestrator;
    
    @Autowired
    private StripeClient stripeClient;
    
    @PostMapping("/registerEvent")
    public ResponseEntity<List<Registration>> registerEvent(@RequestBody List<Registration> registration){
        return ResponseEntity.ok(eventRegistrationOrchestrator.saveRegistration(registration)); 
    }
    
    @GetMapping("/findByRegistrationId")
   public ResponseEntity<Registration> registerEvent(@RequestParam("registrationId") int regId){
        return ResponseEntity.ok(eventRegistrationOrchestrator.findByRegistrationId(regId)); 
    }
    
    
    @PostMapping("/checkout")
    public Charge chargeCard(@RequestParam("token") String token, @RequestParam("amount") String amount) throws Exception {
        return this.stripeClient.chargeCreditCard(token, Double.parseDouble(amount));
    }
}
