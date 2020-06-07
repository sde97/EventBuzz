package project.orchestrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import project.service.EventService;
import project.model.User;
import project.service.RegistrationService;
import project.model.RegisterEvent;
import project.model.Event;
import project.model.Registration;
import project.GlobalConstants;
import java.util.*;

@Component
public class EventOrchestrator{
    
    @Autowired
    private EventService eventService;
    
    @Autowired
    private RegistrationService registrationService;
    
    public List<Event> getEvent(String eventId){
        if(StringUtils.isNotEmpty(eventId))
            return Arrays.asList(eventService.getEventById(Integer.parseInt(eventId)));
        else
            return eventService.findAllEvents();
    }
    
    public RegisterEvent saveEventDetails(RegisterEvent regEvent){
        Event eventDetails = eventService.saveEventDetails(regEvent.getEvent());
        regEvent.setEvent(eventDetails);
        if(regEvent.getRegistration().size() > 0){
            for(Registration reg : regEvent.getRegistration()){
                reg.setEvent(eventDetails);
            }
            regEvent.setRegistration(registrationService.saveRegistration(regEvent.getRegistration()));
        }
        return regEvent;
    }
    
    public List<Event> getEventByFilter(Event event){
        return eventService.findEventDetails(event);
    }
    
     public List<Event> getOrganizedEvents(User user){
        return eventService.getOrganizedEvents(user);
    }
    
     public List<Event> getRegisteredEvents(User user){
        return eventService.getRegisteredEvents(user);
    }
}