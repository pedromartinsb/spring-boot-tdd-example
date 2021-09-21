package com.example.tdd.controller;

import com.example.tdd.model.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @GetMapping
    public String getAll() {
        return "Ok";
    }

    @PostMapping
    public ResponseEntity<Booking> save(@RequestBody Booking booking) {
        return ResponseEntity.ok(booking);
    }

}
