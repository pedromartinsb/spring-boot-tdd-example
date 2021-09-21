package com.example.tdd.service;

import com.example.tdd.model.Booking;
import com.example.tdd.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public int daysCalculatorWithDatabase(String name) {
        Optional<Booking> bookingOptional = bookingRepository.findByReserveName(name);
        return Period.between(bookingOptional.get().getCheckIn(), bookingOptional.get().getCheckOut()).getDays();
    }
}
