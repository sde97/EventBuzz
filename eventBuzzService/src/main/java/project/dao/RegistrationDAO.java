package project.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.model.Registration;
import project.GlobalConstants.EventCategory;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RegistrationDAO extends CrudRepository<Registration,Integer> {
    
    Registration findByEventRegId(int id);
    
    List<Registration> findByEmail(String email);
    
}
