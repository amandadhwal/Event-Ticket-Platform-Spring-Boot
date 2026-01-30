package com.eventplateform.controller;

import com.eventplateform.entity.Booking;
import com.eventplateform.entity.User;
import com.eventplateform.service.BookingService;
import com.eventplateform.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final UserService userService;

    public BookingController(BookingService bookingService,UserService userService)
    {
        this.bookingService=bookingService;
        this.userService=userService;
    }
    //book tickets
    @PostMapping
    public Booking bookTickets(
            @RequestParam String email,
            @RequestParam Long eventId,
            @RequestParam int tickets
    )
    {
        User user=userService.getByEmail(email);
        return bookingService.bookTickets(user,eventId,tickets);
    }

}
