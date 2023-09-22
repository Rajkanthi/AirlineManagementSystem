package com.jsp.FrontEndAirline2.adminRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.FrontEndAirline2.adminentity.FlightDetails;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Integer>{

	List<FlightDetails> findByFlightType(String flightType);
}
