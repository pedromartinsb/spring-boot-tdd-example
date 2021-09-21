package com.example.tdd.service;

import com.example.tdd.model.Booking;
import com.example.tdd.repository.BookingRepository;
import com.example.tdd.service.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

@SpringBootTest
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;

    @MockBean
    private BookingRepository bookingRepository;

    @BeforeEach
    public void setup() {
        LocalDate checkIn = LocalDate.parse("2020-11-10");
        LocalDate checkOut = LocalDate.parse("2020-11-20");
        Booking booking = new Booking("1", "Pedro", checkIn, checkOut);

        Mockito.when(bookingRepository.findByReserveName(booking.getReserveName()))
                .thenReturn(java.util.Optional.of(booking));
    }

    @Test
    public void bookingTestServiceDaysCalculator() {
        String name = "Pedro";
        int days = bookingService.daysCalculatorWithDatabase(name);

        Assertions.assertEquals(days, 10);
    }


}
