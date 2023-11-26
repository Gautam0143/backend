package com.example.flightTicketManagementSystem.controller;

import com.example.flightTicketManagementSystem.entity.AirportEntity;
import com.example.flightTicketManagementSystem.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class AirportController {
    @Autowired
    private AirportService airportService;
    @GetMapping("/showAirportDetails/{id}")
    ResponseEntity<AirportEntity> showAirportDetails(@PathVariable int id)
    {
        AirportEntity airportEntity=airportService.showAirportDetails(id).getBody();
        return ResponseEntity.status(HttpStatus.OK).body(airportEntity);

    }
}