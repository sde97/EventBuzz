package project.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.model.UserDetails;

@Repository
public interface UserDetailsDAO extends CrudRepository<UserDetails,Long>{
    
    UserDetails findByEmailIgnoreCase(String email);
}