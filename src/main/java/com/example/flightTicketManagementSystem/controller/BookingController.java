package com.example.flightTicketManagementSystem.controller;

import com.example.flightTicketManagementSystem.dto.BookingAndPassengerDTO;
import com.example.flightTicketManagementSystem.entity.BookingEntity;
import com.example.flightTicketManagementSystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/saveBooking")
    ResponseEntity<BookingEntity> saveBooking(@RequestBody BookingEntity b){
        bookingService.saveBooking(b);
        return ResponseEntity.status(HttpStatus.OK).body(b);
    }

    @GetMapping("/showBookingDetails/{id}")
    ResponseEntity<BookingAndPassengerDTO> showBookingDetails(@PathVariable int id){
        ResponseEntity<BookingAndPassengerDTO> bookingAndPassengerDTO= bookingService.showBookingDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookingAndPassengerDTO.getBody());
    }
}
