package project.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.model.User;

@Repository
public interface UserDAO extends CrudRepository<User,Long>{
    User findByEmailIgnoreCase(String email);
    
    @Query("SELECT COUNT(u) FROM User u WHERE u.email=:email and u.password=:password")
    Integer validateUser(@Param("email") String email, @Param("password") String password);
    
    User findByUserId(Long id);
}