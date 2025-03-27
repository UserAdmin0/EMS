package com.example.EventManagement.service;

import com.example.EventManagement.model.Event;
import com.example.EventManagement.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    IEventRepo iEventRepo;

    public Iterable<Event> getAllEvents() {
        return iEventRepo.findAll();
    }



    public String addEvent(Event event) {
        iEventRepo.save(event);
        return "added event";
    }




    public String deleteEventById(Integer eventId) {
        iEventRepo.deleteById(eventId);
        return "deleted";
    }

    public String updateEventById(Integer eventId, String eventName, String eventLocation) {
        Optional<Event> event = iEventRepo.findById(eventId);
        Event event1;
        if(event.isPresent())
        {
            event1 = event.get();
        }
        else {
            return "Id not Found!!!";
        }
        event1.setEventName(eventName);
        event1.setLocationOfEvent(eventLocation);

        iEventRepo.save(event1);
        return "event  updated";

    }



}
