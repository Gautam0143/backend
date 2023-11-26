package com.example.flightTicketManagementSystem.service;

import com.example.flightTicketManagementSystem.entity.AirportEntity;
import com.example.flightTicketManagementSystem.repo.AirportRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AirportService {
    @Autowired
    private AirportRepo airportRepo;
    public ResponseEntity<AirportEntity> showAirportDetails(int id) {
        try {
            AirportEntity airportEntity = airportRepo.findById(id).get();
            return ResponseEntity.status(HttpStatus.OK).body(airportEntity);
        } catch (Exception e) {

//           log.warn("gddddgdsg",e);
            throw e;
        }
    }
}