package com.jsp.FrontEndAirline2.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.FrontEndAirline2.AdminDto.FlightTravelDto;
import com.jsp.FrontEndAirline2.adminentity.Checking;
import com.jsp.FrontEndAirline2.adminentity.FlightTravel;
import com.jsp.FrontEndAirline2.service.UserSearchService;
import com.jsp.FrontEndAirline2.userDto.BookingDto;
import com.jsp.FrontEndAirline2.userDto.PassengerDto;
import com.jsp.FrontEndAirline2.userDto.UserDto;
import com.jsp.FrontEndAirline2.userentity.Booking;
import com.jsp.FrontEndAirline2.userentity.User;

@Controller
public class SearchController {
	
	@Autowired 
	private UserSearchService userSearch;
	
	@GetMapping("/searchflight")
	public String SearchHomePage() {
		return "SearchPage";
	}
	
	@PostMapping("/showSearchDetails")
	public ModelAndView showFlightByDate(@RequestParam LocalDate flightDate,@RequestParam String currentLocation, @RequestParam String destination)
	{
		ModelAndView mav = new ModelAndView("sFlightListPage");
		 List<FlightTravelDto> fetchByDateTravel = userSearch.fetchByDateTravel(flightDate,currentLocation,destination);
		 if(fetchByDateTravel!=null) {
			 mav.addObject("flightlist", fetchByDateTravel);
			 return mav;
		 }
		 else {
			 mav.setViewName("SearchPage");
			 mav.addObject("message", "No Records Found, Search the correct Destination and Location");
			 return mav;
		 }
		 
	}
	
	@GetMapping("/bookBtn")
	 public ModelAndView BookFlight(@RequestParam int flightId) {
		FlightTravel fetchByFlightId = userSearch.fetchByFlightId(flightId);
		
		ModelAndView mav = new ModelAndView("BookPassengerForm");
		PassengerDto dto = new PassengerDto();
		mav.addObject("passenger", dto);
		mav.addObject("flightDetails", fetchByFlightId);
		 return mav;
	 }
	
	@PostMapping("/htmlConfirmaction")
	public ModelAndView ConfirmPassengerDetails( @ModelAttribute PassengerDto passengerDto,@RequestParam int flightId, @RequestParam int passengerCount) {
		FlightTravel fetchByFlightId = userSearch.fetchByFlightId(flightId);
		
		Booking bookDto = new Booking();
		bookDto.setCurrentCity(fetchByFlightId.getCurrentLocation());
		bookDto.setDestination(fetchByFlightId.getDestination());
		bookDto.setFlightDate(fetchByFlightId.getFlightDate());
		bookDto.setFlightTime(fetchByFlightId.getFlightTime());
		bookDto.setFlightNumber(fetchByFlightId.getFlightNumber());
		
		LocalDate bookingDate = LocalDate.now();
		bookDto.setBookingDate(bookingDate);
		bookDto.setAmount(fetchByFlightId.getFareamount().getAmount());
		
		

		userSearch.saveBooking(bookDto);
		
		for(int i=0; i<passengerCount; i++) {
			
		userSearch.savePassenger(passengerDto);
		
		
		User user = new User();
		user.setFirstName(passengerDto.getFirstName());
		user.setLastName(passengerDto.getLastName());
		user.setUserName(passengerDto.getEmailId());
		user.setMobileNo(passengerDto.getMobileNo());
		user.setGender(passengerDto.getGender());
		
		Random random = new Random();
		int password = random.nextInt(1000000);
		String pwd = Integer.toString(password);
		user.setPassword(pwd);
		
		
		User existingUser = userSearch.fetchByUsernameAndMobileNo(passengerDto.getEmailId(),passengerDto.getMobileNo());
		
		if( user != null && existingUser==null) {
			userSearch.saveUser(user);
		}
		}
		
		ModelAndView mav = new ModelAndView("PaymentPage");
		mav.addObject("bookingAmount", bookDto);
		
		
		return mav;
	}

	@GetMapping("/sucessfull")
	public ModelAndView madePayment() {
		ModelAndView mav = new ModelAndView("PaymentSucess");
		mav.addObject("message", "payment sucessfull");
		return mav;
	}
	
	
	
}
