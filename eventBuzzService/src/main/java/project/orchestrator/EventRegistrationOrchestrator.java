package project.orchestrator;

import project.model.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import project.service.RegistrationService;

@Component
public class EventRegistrationOrchestrator {
    
    @Autowired
    RegistrationService regService;
    
    public List<Registration> saveRegistration(List<Registration> registration){
        return regService.saveRegistration(registration);
    }
    
    public Registration findByRegistrationId(int regId){
        return regService.findById(regId);
    }

}
