package com.example.flightTicketManagementSystem.repo;

import com.example.flightTicketManagementSystem.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<BookingEntity,Integer> {
}
