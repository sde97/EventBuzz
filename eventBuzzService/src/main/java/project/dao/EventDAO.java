package project.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.GlobalConstants.EventCategory;
import project.model.Event;
import project.model.User;
import project.model.Registration;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface EventDAO extends CrudRepository<Event,Long>{
    Event findByEventId(int evntId);
    
    @Query("SELECT e FROM Event e WHERE e.eventCategory=:eventCategory and e.eventFromDate >=:eventFromDate and e.eventToDate<=:eventToDate")
    List<Event> findEventDetails(@Param("eventCategory") EventCategory eventCategory, @Param("eventFromDate") Date eventFromDate, @Param("eventToDate") Date eventToDate);
    
        
    List<Event> findByUser(User user);
    
    @Query("SELECT e FROM Event e WHERE e.registration =:registration")
    List<Event> findByRegistration(List<Registration> registration);
    
}