package com.example.EventManagement.controller;

import com.example.EventManagement.model.Event;
import com.example.EventManagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventService eventService;


    //get all events
    @GetMapping("events")
    public Iterable<Event> getAllEvents(){
        return eventService.getAllEvents();
    }



    //add event
    @PostMapping("event")
    public String addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }



    //delete event by id
    @DeleteMapping("event/{eventId}")
    public String deleteEventById(@PathVariable Integer eventId){
        return eventService.deleteEventById(eventId);
    }



    //Update Event name and location by id
    @PutMapping("event/{eventId}/{eventName}/{eventLocation}")
    public String updateEventById(@PathVariable Integer eventId,@PathVariable String eventName,@PathVariable String eventLocation){
        return eventService.updateEventById(eventId,eventName,eventLocation);
    }


}
