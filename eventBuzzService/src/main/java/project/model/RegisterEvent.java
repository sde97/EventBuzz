package project.model;

import java.util.List;
import project.model.Event;
import project.model.RegisterEvent;

public class RegisterEvent{
    
    private Event event;
    private List<Registration> registration;
    public RegisterEvent(){}

    public RegisterEvent(Event event, List<Registration> registration) {
        this.event = event;
        this.registration = registration;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Registration> getRegistration() {
        return registration;
    }

    public void setRegistration(List<Registration> registration) {
        this.registration = registration;
    }
}