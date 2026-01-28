package com.eventplateform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numberOfTickets;
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    @ManyToOne
    private User user;
    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;
}
enum BookingStatus{
    CONFIRM,
    CANCELLED
}
