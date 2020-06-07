package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import project.model.Event;
import project.model.User;
import project.model.RegisterEvent;
import project.orchestrator.EventOrchestrator;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
   
@Controller
public class EventController {

    @Autowired
    private EventOrchestrator eventOrchestrator;

    @GetMapping("/getEventById")
    public ResponseEntity<List<Event>> getEventById(@RequestParam("eventId") String eventId){
        return ResponseEntity.ok(eventOrchestrator.getEvent(eventId));
    }
    
    @GetMapping("/getAllEvents")
    public ResponseEntity<List<Event>> getAllEvent(){
        return ResponseEntity.ok(eventOrchestrator.getEvent(null));
    }
    
    @PostMapping("/getEventsByFilter")
    public ResponseEntity<List<Event>> getEventByFilter(@RequestBody Event event){
        return ResponseEntity.ok(eventOrchestrator.getEventByFilter(event));
    }
    
    @PostMapping("/getOrganizedEvents")
    public ResponseEntity<List<Event>> getOrganizedEvents(@RequestBody User user){
        return ResponseEntity.ok(eventOrchestrator.getOrganizedEvents(user));
    }
    
    @PostMapping("/getRegisteredEvents")
    public ResponseEntity<List<Event>> getRegisteredEvents(@RequestBody User user){
        return ResponseEntity.ok(eventOrchestrator.getOrganizedEvents(user));
    }
    
    @PostMapping("/saveEventDetails")
    public ResponseEntity<RegisterEvent> saveEvent(@RequestBody RegisterEvent event){
        return ResponseEntity.ok(eventOrchestrator.saveEventDetails(event));
    }
}
