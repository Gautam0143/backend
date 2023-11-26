package com.example.flightTicketManagementSystem.repo;

import com.example.flightTicketManagementSystem.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepo extends JpaRepository<AirportEntity,Integer> {
}
