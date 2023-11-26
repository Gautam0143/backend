package com.example.flightTicketManagementSystem.controller;

import com.example.flightTicketManagementSystem.entity.AirlineEntity;
import com.example.flightTicketManagementSystem.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class AirlineController {
    @Autowired
    private AirlineService airlineService;

    @GetMapping("/showAirlineDetails/{id}")
    ResponseEntity<AirlineEntity> showAirlineDetails(@PathVariable int id) {
        AirlineEntity airlineEntity = airlineService.showAirlineDetails(id).getBody();
        return ResponseEntity.status(HttpStatus.OK).body(airlineEntity);
    }
}