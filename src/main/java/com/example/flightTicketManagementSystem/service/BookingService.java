package com.example.flightTicketManagementSystem.service;

import com.example.flightTicketManagementSystem.dto.BookingAndPassengerDTO;
import com.example.flightTicketManagementSystem.entity.BookingEntity;
import com.example.flightTicketManagementSystem.entity.FlightEntity;
import com.example.flightTicketManagementSystem.entity.PassengerEntity;
import com.example.flightTicketManagementSystem.repo.BookingRepo;
import com.example.flightTicketManagementSystem.repo.FlightRepo;
import com.example.flightTicketManagementSystem.repo.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private PassengerRepo passengerRepo;

    @Autowired
    private FlightRepo flightRepo;



    public ResponseEntity<BookingEntity> saveBooking(BookingEntity b){
        b.setBookingStatus("Confirmed");
        bookingRepo.save(b);
        FlightEntity f=flightRepo.getReferenceById(b.getFlightReferenceId());
        f.setAvailableSeats(f.getAvailableSeats()-1);
        flightRepo.save(f);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    public ResponseEntity<BookingAndPassengerDTO> showBookingDetails(int id) {
        BookingAndPassengerDTO bookingAndPassengerDTO=new BookingAndPassengerDTO();
        Optional<BookingEntity> bookingEntityOptional= bookingRepo.findById(id);
        BookingEntity bookingEntity = bookingEntityOptional.get();
        bookingAndPassengerDTO.setBookingId(bookingEntity.getBookingId());
        bookingAndPassengerDTO.setBookingStatus(bookingEntity.getBookingStatus());
        bookingAndPassengerDTO.setBookingDateTime(bookingEntity.getBookingDateTime());
        bookingAndPassengerDTO.setPassengerReferenceId(bookingEntity.getPassengerReferenceId());
        int id1= bookingEntity.getPassengerReferenceId();

        PassengerEntity passengerEntity=passengerRepo.findById(id1).get();
        bookingAndPassengerDTO.setPassengerEntity(passengerEntity);
        return ResponseEntity.status(HttpStatus.OK).body(bookingAndPassengerDTO);
    }
}

