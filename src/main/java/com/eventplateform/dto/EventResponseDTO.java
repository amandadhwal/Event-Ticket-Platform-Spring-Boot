package com.eventplateform.dto;

import java.time.LocalDateTime;

public class EventResponseDTO {
    public Long id;
    public String title;
    public String location;
    public LocalDateTime eventDate;
    public int availableTickets;
    public double price;
}
