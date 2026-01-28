package com.eventplateform.repository;

import com.eventplateform.entity.Booking;
import com.eventplateform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    //get all booking of a user
    List<Booking> findByUser(User user);
}
