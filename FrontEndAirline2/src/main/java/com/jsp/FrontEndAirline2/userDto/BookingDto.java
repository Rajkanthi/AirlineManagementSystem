package com.jsp.FrontEndAirline2.userDto;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
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
public class BookingDto {

	private int bookingId;
	private LocalDate bookingDate;
	private String currentCity;
	private String destination;
	
	private LocalDate flightDate;
	private LocalTime flightTime;
	private String flightNumber;
	private double amount;
	
	
	private List<PassengerDto> passengerDto;
}
