package com.jsp.FrontEndAirline2.AdminDto;


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
public class FlightDetailsDto {

	private int flightinfoId;
	private String flightNumber;
	private String flightType;

	private int airinfoId;

//	private FlightTravelDto travelDto;

}
