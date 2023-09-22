package com.jsp.FrontEndAirline2.AdminDto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.jsp.FrontEndAirline2.adminentity.FareAmout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FlightTravelDto {

	private int flightId;
	private String currentLocation;
	private String destination;
	private String flightNumber;

	private LocalDate flightDate;
	private LocalTime flightTime;
	
	private int fareId;
	
	private int flightinfoId;
	
	private int inventoryId;
	
	

	private FareAmout fareamount;
//
//	private FlightDetailsDto flightdetails;
//
//	private InventoryDto inventory;
}
