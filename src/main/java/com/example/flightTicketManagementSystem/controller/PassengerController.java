package com.example.flightTicketManagementSystem.controller;

import com.example.flightTicketManagementSystem.entity.PassengerEntity;
import com.example.flightTicketManagementSystem.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;
    @PostMapping("/savePassenger")
    ResponseEntity<PassengerEntity> savePassenger(@RequestBody PassengerEntity p)
    {
        passengerService.savePassenger(p);
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }
    @GetMapping("/showPassengerDetails/{id}")
    ResponseEntity<PassengerEntity> showPassengerDetails(@PathVariable int id)
    {
        PassengerEntity passengerEntity= passengerService.showPassengerDetails(id).getBody();
        return ResponseEntity.status(HttpStatus.OK).body(passengerEntity);
    }
    @GetMapping("/findByPassengerUsernameAndPassengerPassword")
    ResponseEntity<PassengerEntity> findByPassengerUsernameAndPassengerPassword(@RequestParam String username, @RequestParam String password){
        PassengerEntity passengerEntity=passengerService.findByPassengerUsernameAndPassengerPassword(username, password).getBody();
        return ResponseEntity.status(HttpStatus.OK).body(passengerEntity);
    }
}
