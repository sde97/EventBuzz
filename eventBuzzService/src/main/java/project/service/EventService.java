package project.service;

import org.springframework.stereotype.Service;
import project.model.Event;
import java.util.List;
import project.model.User;


@Service
public interface EventService{
    
    public Event getEventById(int eventId);
    public Event saveEventDetails(Event event);
    public List<Event> findAllEvents();
    public List<Event> findEventDetails(Event event);
    public List<Event> getOrganizedEvents(User user);
    public List<Event> getRegisteredEvents(User user);
}