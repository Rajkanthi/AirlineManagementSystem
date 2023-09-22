package com.jsp.FrontEndAirline2.service;

import java.util.List;

import com.jsp.FrontEndAirline2.AdminDto.AirInfoDto;
import com.jsp.FrontEndAirline2.AdminDto.CheckingDto;
import com.jsp.FrontEndAirline2.AdminDto.FareAmountDto;
import com.jsp.FrontEndAirline2.AdminDto.FlightDetailsDto;
import com.jsp.FrontEndAirline2.AdminDto.FlightTravelDto;
import com.jsp.FrontEndAirline2.AdminDto.InventoryDto;
import com.jsp.FrontEndAirline2.userDto.BookingDto;
import com.jsp.FrontEndAirline2.userDto.PassengerDto;
import com.jsp.FrontEndAirline2.userDto.UserDto;

public interface AdminService {

	//---------------air info methods---------------------

	List<AirInfoDto> getAllDetailsAirinfo();

	void saveAirline(AirInfoDto airDto);

	AirInfoDto fetchByIdAir(int airlineId);

	void deleteById(int airlineId);
	
	/*
	 * ----------   check in methods---
	 */


	List<CheckingDto> getAllDetailsChecking();

	CheckingDto fetchByIdCheckin(int checkinId);

	void saveCheckin(CheckingDto checkDto);

	void deleteCheckin(int checkinId);

	
	List<PassengerDto> getAllDetailsPassenger();

	List<BookingDto> getAllDetailsBooking();
	
	/*
	 * --------- fare amount methods--------------
	 */

	List<FareAmountDto> getAllDetailsFareAmount();

	void saveFareAmount(FareAmountDto fareDto);

	FareAmountDto fetchByIdFareAmount(int fareId);

	void deleteFareAmount(int fareId);
	
	/*
	 * -----------------flight details methods-----------------
	 */

	List<FlightDetailsDto> getAllDetailsFlight();

	void saveFlightDetails(FlightDetailsDto flightDto);

	FlightDetailsDto fetchByIdFlight(int flightinfoId);

	void deleteFlightDetails(int flightId);
	/*
	 * ------------------flight travel methods-----------------------
	 */

	List<FlightTravelDto> getAllDetailsFlightTravel();

	void saveFlightTravel(FlightTravelDto travelDto);

	FlightTravelDto fetchByIdTravel(int flightId);

	void deleteFlightTravel(int flightId);
	/*
	 * ------------inventory methods-------------------
	 */

	List<InventoryDto> getAllDetailsInventory();

	InventoryDto fetchByIdInventory(int inventoryId);

	void saveInventory(InventoryDto inventoryDto);

	void deleteInventory(int inventoryId);
	
	
	/*
	 * --------------- user login methods---------------
	 */

	void saveUser(UserDto userDto);

	boolean authenticateUser(String userName, String password);



}
