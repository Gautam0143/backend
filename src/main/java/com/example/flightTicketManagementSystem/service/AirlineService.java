package com.example.flightTicketManagementSystem.service;

import com.example.flightTicketManagementSystem.entity.AirlineEntity;
import com.example.flightTicketManagementSystem.repo.AirlineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


    @Service
    public class AirlineService {
        @Autowired
        private AirlineRepo airlineRepo;
        public ResponseEntity<AirlineEntity> showAirlineDetails(int id) {
            try {
                AirlineEntity airlineEntity = airlineRepo.findById(id).get();
                return ResponseEntity.status(HttpStatus.OK).body(airlineEntity);
            } catch (Exception e) {

//           log.warn("gddddgdsg",e);
                throw e;
            }
        }
    }

