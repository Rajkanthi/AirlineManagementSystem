package com.jsp.FrontEndAirline2.AdminDto;



import com.jsp.FrontEndAirline2.userDto.PassengerDto;

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
public class CheckingDto {

	private int checkinId;
	private String gateNo;
	private String seatNo;

	private PassengerDto passengerDto;
}
