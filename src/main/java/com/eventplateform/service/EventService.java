package com.eventplateform.service;

import com.eventplateform.entity.Event;
import com.eventplateform.entity.User;
import com.eventplateform.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@Transactional
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository)
    {
        this.eventRepository=eventRepository;
    }

    //create event
    public Event createEvent(Event event, User organizer)
    {
        event.setOrganizer(organizer);
        event.setAvailableTickets(event.getTotalTickets());
        return eventRepository.save(event);
    }
    //get All events
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    //get upcoming events
    public List<Event> getUpcomingEvents(){
        return eventRepository.findByEventDateAfter(LocalDateTime.now());

    }

    //get event by id
    public Event getEventById(Long id)
    {
        return eventRepository.findById(id).orElseThrow(()->new RuntimeException("Event not found"));
    }



}
