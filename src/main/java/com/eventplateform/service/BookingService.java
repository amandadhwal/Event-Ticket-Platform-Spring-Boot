package com.eventplateform.service;

import com.eventplateform.entity.Booking;
import com.eventplateform.entity.BookingStatus;
import com.eventplateform.entity.Event;
import com.eventplateform.entity.User;
import com.eventplateform.repository.BookingRepository;
import com.eventplateform.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private  final BookingRepository bookingRepository;
    private final EventRepository eventRepository;

    public BookingService(BookingRepository bookingRepository, EventRepository eventRepository)
    {
        this.bookingRepository=bookingRepository;
        this.eventRepository=eventRepository;
    }
    @Transactional
    public Booking bookTickets(User user, Long eventId, int tickets)
    {
        Event event=eventRepository.findById(eventId)
                .orElseThrow(()->new RuntimeException("event not found"));


        //check availablity
        if(event.getAvailableTickets()<tickets)
        {
            throw new RuntimeException("not enough tickts avaliable");
        }
        //reduce available ticktes

        event.setAvailableTickets(event.getAvailableTickets()-tickets);

        //create booking

        Booking booking =new Booking();
        booking.setUser(user);
        booking.setEvent(event);
        booking.setNumberOfTickets(tickets);
        booking.setTotalPrice(event.getPrice()*tickets);
        booking.setStatus(BookingStatus.CONFIRM);

        eventRepository.save(event);
        return bookingRepository.save(booking);
    }

}
