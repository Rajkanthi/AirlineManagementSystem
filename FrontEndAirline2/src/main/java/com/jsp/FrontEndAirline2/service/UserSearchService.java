package com.jsp.FrontEndAirline2.service;

import java.time.LocalDate;
import java.util.List;

import com.jsp.FrontEndAirline2.AdminDto.FlightTravelDto;
import com.jsp.FrontEndAirline2.adminentity.Checking;
import com.jsp.FrontEndAirline2.adminentity.FlightTravel;
import com.jsp.FrontEndAirline2.userDto.PassengerDto;
import com.jsp.FrontEndAirline2.userDto.UserDto;
import com.jsp.FrontEndAirline2.userentity.Booking;
import com.jsp.FrontEndAirline2.userentity.User;

public interface UserSearchService {

	List<FlightTravelDto> fetchByDateTravel(LocalDate flightDate, String currentLocation, String destination);

	void savePassenger(PassengerDto passengerDto);

	

	void saveBooking(Booking booking);

	FlightTravel fetchByFlightId(int flightId);

	List<Checking> getAvailableCheckins();

	void saveUser(User user);

	Booking fetchByBookingId(int bookingId);

	List<Booking> fetchAllBookings();

	User fetchByUsernameAndMobileNo(String emailId, String mobileNo);

	

	
}
