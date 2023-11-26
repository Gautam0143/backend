package com.example.flightTicketManagementSystem.repo;

import com.example.flightTicketManagementSystem.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepo extends JpaRepository<PassengerEntity,Integer>{
    PassengerEntity findByPassengerUsernameAndPassengerPassword(String username, String password);
}
