package project.service;
import project.model.Registration;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {
    
    public List<Registration> saveRegistration(List<Registration> registration);
    public Registration findById(int id);
}
