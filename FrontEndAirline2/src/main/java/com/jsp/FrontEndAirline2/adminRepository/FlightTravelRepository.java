package com.jsp.FrontEndAirline2.adminRepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.FrontEndAirline2.adminentity.FlightTravel;


@Repository
public interface FlightTravelRepository extends JpaRepository<FlightTravel, Integer> {

	List<FlightTravel> findByFlightDateAndCurrentLocationAndDestination(LocalDate flightDate, String currentLocation, String destination);
}
