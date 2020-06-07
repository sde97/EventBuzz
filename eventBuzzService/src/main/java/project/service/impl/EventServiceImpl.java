package project.service.impl;


import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import project.model.Event;
import project.model.User;
import project.model.Registration;
import project.dao.EventDAO;
import project.dao.RegistrationDAO;
import project.service.EventService;
import java.util.*;

@Component
public class EventServiceImpl implements EventService{
    
@Autowired
private EventDAO eventDAO;
    
@Autowired
private RegistrationDAO registrationDAO;
 

    public Event getEventById(int eventId){
        return eventDAO.findByEventId(eventId);
    }
    
    public Event saveEventDetails(Event event){
      
          return eventDAO.save(event);
    }
    
    public List<Event> findAllEvents(){
        return Lists.newArrayList(eventDAO.findAll());
    }
    
    public List<Event> findEventDetails(Event event){
        if(null != event.getEventCategory() && null != event.getEventFromDate() && null != event.getEventToDate())
            return eventDAO.findEventDetails(event.getEventCategory(), event.getEventFromDate(), event.getEventToDate());
        return Arrays.asList(new Event());
    }
    
    public List<Event> getOrganizedEvents(User user){
        return eventDAO.findByUser(user);
    }
    
    public List<Event> getRegisteredEvents(User user){
        if(StringUtils.isNotEmpty(user.getEmail())){
            List<Registration> regList= registrationDAO.findByEmail(user.getEmail());
            return eventDAO.findByRegistration(regList);
        }
        return Arrays.asList(new Event());
    }
}