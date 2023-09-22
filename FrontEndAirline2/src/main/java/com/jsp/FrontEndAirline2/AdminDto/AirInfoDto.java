package com.jsp.FrontEndAirline2.AdminDto;

import java.util.List;

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
public class AirInfoDto {
	private int airlineId;
	private String airlineName;

	List<FlightDetailsDto> flights;

}
