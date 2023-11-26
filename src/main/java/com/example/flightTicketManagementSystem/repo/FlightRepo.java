package com.example.flightTicketManagementSystem.repo;

import com.example.flightTicketManagementSystem.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<FlightEntity,Integer> {
    @Query("Select u from FlightEntity u where u.departureAirportId = :departure and u.arrivalAirportId = :arrival and u.departureDate = :departureDate")
    List<FlightEntity> findByDepartureAndArrivalAndDepartureDate(int departure, int arrival, Date departureDate);

}