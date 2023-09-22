package com.jsp.FrontEndAirline2.userDto;


import com.jsp.FrontEndAirline2.AdminDto.CheckingDto;

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
public class PassengerDto {
	
	private int passengerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNo;
	private String gender;
	
	private int bookingDto;	
	private int checkinDto;
	
	
//	private Booking booking;	
//	private Checking checkin;
}
