package com.eventplateform.controller;

import com.eventplateform.entity.Event;
import com.eventplateform.entity.User;
import com.eventplateform.service.EventService;
import com.eventplateform.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;
    private final UserService userService;

    public EventController(EventService eventService,UserService userService)
    {
        this.eventService=eventService;
        this.userService=userService;
    }

    //create event

    @PostMapping
    public Event createEvent(@RequestBody Event event, @RequestParam String organizerEmail)
    {
        User organizer=userService.getByEmail(organizerEmail);
        return eventService.createEvent(event,organizer);

    }
    //get all event
    @GetMapping
    public List<Event> getEvents()
    {
        return eventService.getAllEvents();
    }

    //get upcoming event
    @GetMapping("/upcoming")
    public List<Event> getUpcomingEvents()
    {
        return eventService.getUpcomingEvents();
    }

}
