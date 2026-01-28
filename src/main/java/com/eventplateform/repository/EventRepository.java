package com.eventplateform.repository;

import com.eventplateform.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {
    //find upcoming events
    List<Event> findByEventDateAfter(LocalDateTime dataTime
    );
    //find events by location
    List<Event> findByLocation(String location);
}

