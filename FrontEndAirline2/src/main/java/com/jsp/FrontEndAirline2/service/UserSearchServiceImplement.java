package com.jsp.FrontEndAirline2.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.FrontEndAirline2.AdminDto.FlightTravelDto;
import com.jsp.FrontEndAirline2.adminRepository.CheckingRepository;
import com.jsp.FrontEndAirline2.adminRepository.FlightTravelRepository;
import com.jsp.FrontEndAirline2.adminentity.Checking;
import com.jsp.FrontEndAirline2.adminentity.FlightTravel;
import com.jsp.FrontEndAirline2.userDao.BookingRepository;
import com.jsp.FrontEndAirline2.userDao.PassengerRepository;
import com.jsp.FrontEndAirline2.userDao.UserRepository;
import com.jsp.FrontEndAirline2.userDto.BookingDto;
import com.jsp.FrontEndAirline2.userDto.PassengerDto;
import com.jsp.FrontEndAirline2.userDto.UserDto;
import com.jsp.FrontEndAirline2.userentity.Booking;
import com.jsp.FrontEndAirline2.userentity.Passenger;
import com.jsp.FrontEndAirline2.userentity.User;

@Service
public class UserSearchServiceImplement implements UserSearchService{
	
	@Autowired
	private FlightTravelRepository travelRepo;

	@Override
	public List<FlightTravelDto> fetchByDateTravel(LocalDate flightDate, String currentLocation, String destination) {
		List<FlightTravel> findByFlightDate = travelRepo.findByFlightDateAndCurrentLocationAndDestination(flightDate, currentLocation, destination);
		
		if(findByFlightDate.size()>0) { 
			
			List<FlightTravelDto> dtolist = findByFlightDate.stream().map(t -> FlightTravelDto.builder()
					.currentLocation(t.getCurrentLocation()).destination(t.getDestination())
					.flightDate(t.getFlightDate()).flightNumber(t.getFlightNumber()).flightTime(t.getFlightTime())
					.flightId(t.getFlightId())
					.build()).toList();
			return dtolist;
		}
		else {
			return null;
		}
	}

	
	//-----------------------------------
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private CheckingRepository checkRepo;
	

	@Autowired
	private BookingRepository bookingRepo;

	@Override
	public void savePassenger(PassengerDto passengerDto) {
		
		
		Passenger passenger = Passenger.builder().firstName(passengerDto.getFirstName())
				.lastName(passengerDto.getLastName())
				.emailId(passengerDto.getEmailId()).mobileNo(passengerDto.getMobileNo())
				.gender(passengerDto.getGender())
				.build();
		
		
		List<Checking> findAllCheckins = checkRepo.findAll();
		
		if(!findAllCheckins.isEmpty()) {
			Random random = new Random();
			int randomIndex = random.nextInt(findAllCheckins.size());
			passenger.setCheckin(findAllCheckins.get(randomIndex));
		}
		
		List<Booking> findAllbookings = bookingRepo.findAll();
		if(!findAllbookings.isEmpty()) {
			passenger.setBooking(findAllbookings.get(findAllbookings.size()-1));
		}
		
		
		passengerRepo.save(passenger);
		

	}

	
	
	
	@Override
	public List<Checking> getAvailableCheckins() {
		
			return checkRepo.findAll();
	}

	@Override
	public FlightTravel fetchByFlightId(int flightId) {
		FlightTravel findById = travelRepo.findById(flightId).get();
		
		return findById;		
	}
	
	

	
	@Override
	public void saveBooking(Booking booking) {
		bookingRepo.save(booking);
	}


	@Autowired
	private UserRepository userRepo;

	@Override
	public void saveUser(User user) {
		userRepo.save(user);
	}




	@Override
	public Booking fetchByBookingId(int bookingId) {
		Optional<Booking> findById = bookingRepo.findById(bookingId);
			if(findById.isPresent()) {
				return null;
			}
			else {
				Booking booking = findById.get();
				return booking;
			}
			
	}




	@Override
	public List<Booking> fetchAllBookings() {
		return bookingRepo.findAll();
		
	}




	@Override
	public User fetchByUsernameAndMobileNo(String emailId, String mobileNo) {
		return userRepo.findByUserNameAndMobileNo(emailId, mobileNo);
	}

	

}
	
	
	
	
	
	
	
	

//	@Override
//	public void saveBooking(FlightTravel travelflight) {
//		FlightTravel travel = travelRepo.findById(travelflight.getFlightId()).get();
//		
//		Booking booking = new Booking();
//		booking.setCurrentCity(travel.getCurrentLocation());
//		booking.setDestination(travel.getDestination());
//		booking.setFlightDate(travel.getFlightDate());
//		booking.setFlightTime(travel.getFlightTime());
//		booking.setFlightNumber(travel.getFlightNumber());
//		
////		Booking booking = Booking.builder().currentCity(travelDto.getCurrentLocation())
////				.destination(travelDto.getDestination()).flightDate(travelDto.getFlightDate())
////				.flightTime(travelDto.getFlightTime()).flightNumber(travelDto.getFlightNumber())
////	//			.amount(travelDto.getFareamount().getAmount())
////				.build();
//		
//		bookingRepo.save(booking);
//	}


	
	
//	List<Checking> availableCheckins = userSearch.getAvailableCheckins();
	
//	if(!availableCheckins.isEmpty()) {
//		Checking randomCheckin = SelectRandom(availableCheckins);
//		
//		bookDto.set
//	}
//	private Checking SelectRandom(List<Checking> availableCheckins) {
//	
//	Random random = new Random();
//	int randomIndex = random.nextInt(availableCheckins.size());
//	
//	return availableCheckins.get(randomIndex);
//}
	

