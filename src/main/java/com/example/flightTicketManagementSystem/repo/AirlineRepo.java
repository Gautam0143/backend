package com.example.flightTicketManagementSystem.repo;

import com.example.flightTicketManagementSystem.entity.AirlineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepo extends JpaRepository<AirlineEntity,Integer> {
}
