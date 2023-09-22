package com.jsp.FrontEndAirline2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.FrontEndAirline2.AdminDto.AirInfoDto;
import com.jsp.FrontEndAirline2.AdminDto.CheckingDto;
import com.jsp.FrontEndAirline2.AdminDto.FareAmountDto;
import com.jsp.FrontEndAirline2.AdminDto.FlightDetailsDto;
import com.jsp.FrontEndAirline2.AdminDto.FlightTravelDto;
import com.jsp.FrontEndAirline2.AdminDto.InventoryDto;
import com.jsp.FrontEndAirline2.adminRepository.AirRepository;
import com.jsp.FrontEndAirline2.adminRepository.CheckingRepository;
import com.jsp.FrontEndAirline2.adminRepository.FareAmountRepository;
import com.jsp.FrontEndAirline2.adminRepository.FlightDetailsRepository;
import com.jsp.FrontEndAirline2.adminRepository.FlightTravelRepository;
import com.jsp.FrontEndAirline2.adminRepository.InventoryRepository;
import com.jsp.FrontEndAirline2.adminentity.AirInfo;
import com.jsp.FrontEndAirline2.adminentity.Checking;
import com.jsp.FrontEndAirline2.adminentity.FareAmout;
import com.jsp.FrontEndAirline2.adminentity.FlightDetails;
import com.jsp.FrontEndAirline2.adminentity.FlightTravel;
import com.jsp.FrontEndAirline2.adminentity.Inventory;
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
public class AdminServiceImplemetation implements AdminService {

	@Autowired
	private AirRepository airRepository;

	@Override
	public List<AirInfoDto> getAllDetailsAirinfo() {
		List<AirInfo> findAll = airRepository.findAll();

		List<AirInfoDto> listOfAir = findAll.stream().map(a-> AirInfoDto.builder()
				.airlineId(a.getAirlineId())
				.airlineName(a.getAirlineName()).build()).toList();
		return listOfAir;
	}

	@Override
	public void saveAirline(AirInfoDto airDto) {
		
		AirInfo airinfo = AirInfo.builder().airlineId(airDto.getAirlineId())
				.airlineName(airDto.getAirlineName()).build();
		 airRepository.save(airinfo);
	}

	@Override
	public AirInfoDto fetchByIdAir(int airlineId) {
		Optional<AirInfo> airInfoByid = airRepository.findById(airlineId);
		if(airInfoByid.isPresent()) {
			AirInfo airInfo = airInfoByid.get();
			
			AirInfoDto airDto = AirInfoDto.builder()
				.airlineId(airInfo.getAirlineId()).airlineName(airInfo.getAirlineName())
				.build();
			return airDto;
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteById(int airlineId) {
		airRepository.deleteById(airlineId);
	}

	/*
	 * -----------------check in implementation------------------------------
	 */

	@Autowired
	private CheckingRepository checkinRepository;

	@Override
	public List<CheckingDto> getAllDetailsChecking() {
		List<Checking> findAll = checkinRepository.findAll();

		List<CheckingDto> checkindtolist = findAll.stream().map(c-> CheckingDto.builder()
				.checkinId(c.getCheckinId())
				.gateNo(c.getGateNo()).seatNo(c.getSeatNo())
				.build()).toList();

		return checkindtolist;
	}



	@Override
	public CheckingDto fetchByIdCheckin(int checkinId) {
		Optional<Checking> checkingbyId = checkinRepository.findById(checkinId);
		
		if(checkingbyId.isPresent()) {
		
			Checking checking = checkingbyId.get();
			CheckingDto checkindtoList = CheckingDto.builder().checkinId(checking.getCheckinId())
					.gateNo(checking.getGateNo()).seatNo(checking.getSeatNo())
					.build();
			return checkindtoList;
		}
		else {
			return null;
		}
	}

	@Override
	public void saveCheckin(CheckingDto checkDto) {
		Checking checkin = Checking.builder().checkinId(checkDto.getCheckinId())
		.gateNo(checkDto.getGateNo()).seatNo(checkDto.getSeatNo())
		.build();
		
		checkinRepository.save(checkin);
	}

	@Override
	public void deleteCheckin(int checkinId) {
		checkinRepository.deleteById(checkinId);
	}
	
	/*
	 * -----------------passenger and booking list implementation----------------------------
	 */
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Override
	public List<PassengerDto> getAllDetailsPassenger() {
		List<Passenger> findAll = passengerRepo.findAll();
		
		List<PassengerDto> dtoList = findAll.stream().map(p -> PassengerDto.builder().passengerId(p.getPassengerId())
				.firstName(p.getFirstName()).lastName(p.getLastName()).mobileNo(p.getMobileNo())
				.emailId(p.getEmailId()).gender(p.getGender()).bookingDto(p.getBooking().getBookingId())
				.checkinDto(p.getCheckin().getCheckinId())
				.build()).toList();
		return dtoList;
	}

	@Autowired
	private BookingRepository bookingRepo;
	
	@Override
	public List<BookingDto> getAllDetailsBooking() {
		List<Booking> findAll = bookingRepo.findAll(); 
		
		List<BookingDto> dtoList = findAll.stream().map(b -> BookingDto.builder().bookingId(b.getBookingId())
				.flightDate(b.getFlightDate()).currentCity(b.getCurrentCity()).destination(b.getDestination())
				.flightTime(b.getFlightTime()).flightNumber(b.getFlightNumber()).amount(b.getAmount())
				.bookingDate(b.getBookingDate())
				.build()).toList();
		
		return dtoList;
	}
	
	/*
	 * --------------- fare amount implementation ------------------------
	 */
	@Autowired
	private FareAmountRepository fareRepository;
	
	@Override
	public List<FareAmountDto> getAllDetailsFareAmount() {
		List<FareAmout> findAll = fareRepository.findAll();
		
		List<FareAmountDto> dtolist = findAll.stream().map(f -> FareAmountDto.builder().fareId(f.getFareId())
				.amount(f.getAmount()).currency(f.getCurrency())
				.build()).toList();
		return dtolist;
	}

	@Override
	public void saveFareAmount(FareAmountDto fareDto) {
		FareAmout fare = FareAmout.builder().amount(fareDto.getAmount()).fareId(fareDto.getFareId())
				.currency(fareDto.getCurrency()).build();

		fareRepository.save(fare);
	}

	@Override
	public FareAmountDto fetchByIdFareAmount(int fareId) {
		Optional<FareAmout> fareAmount = fareRepository.findById(fareId);
		if(fareAmount.isPresent()) {
		
			FareAmout fareAmout = fareAmount.get();
			FareAmountDto fareDto = FareAmountDto.builder().fareId(fareAmout.getFareId())
					.amount(fareAmout.getAmount()).currency(fareAmout.getCurrency())
					.build();
			return fareDto;
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteFareAmount(int fareId) {
		fareRepository.deleteById(fareId);
	}
	
	/*
	 * ------------------ flight details implementation---------------------
	 */
	@Autowired
	private FlightDetailsRepository flightRepository;
	
	@Override
	public List<FlightDetailsDto> getAllDetailsFlight() {
		List<FlightDetails> findAll = flightRepository.findAll();
		
		List<FlightDetailsDto> dtolist = findAll.stream().map(f -> FlightDetailsDto.builder()
				.flightinfoId(f.getFlightinfoId()).flightNumber(f.getFlightNumber())
				.flightType(f.getFlightType()).airinfoId(f.getAirinfo().getAirlineId())
				.build()).toList();
		return dtolist;
	}

	@Override
	public void saveFlightDetails(FlightDetailsDto flightDto) {
		
		Optional<AirInfo> findById = airRepository.findById(flightDto.getAirinfoId());
		
		if(findById.isPresent()) {
			AirInfo airInfopresent = findById.get();
		FlightDetails details = FlightDetails.builder().flightinfoId(flightDto.getFlightinfoId())
				.flightNumber(flightDto.getFlightNumber()).flightType(flightDto.getFlightType())
				.airinfo(airInfopresent)
				.build();
		
		flightRepository.save(details);
		}
	}

	@Override
	public FlightDetailsDto fetchByIdFlight(int flightinfoId) {
		Optional<FlightDetails> flightDetails = flightRepository.findById(flightinfoId);
		
		if(flightDetails.isPresent()) {
			FlightDetails flight2 = flightDetails.get();
			
			FlightDetailsDto dtoflight = FlightDetailsDto.builder().flightinfoId(flight2.getFlightinfoId())
					.flightNumber(flight2.getFlightNumber()).flightType(flight2.getFlightType())
					.airinfoId(flight2.getAirinfo().getAirlineId())
					.build();
			
		return dtoflight;	
		}
		else {
			return null;
		}
		
	}
	
	@Override
	public void deleteFlightDetails(int flightId) {
		flightRepository.deleteById(flightId);
	}
	
	
	/*
	 * ------------------ flight travel implementation----------------------
	 */
	
	@Autowired
	private FlightTravelRepository travelRepo; 

	@Override
	public List<FlightTravelDto> getAllDetailsFlightTravel() {
		List<FlightTravel> findAll = travelRepo.findAll();
		
		List<FlightTravelDto> dtotravel = findAll.stream().map(t -> FlightTravelDto
				.builder().flightId(t.getFlightId()).currentLocation(t.getCurrentLocation()).destination(t.getDestination())
				.flightDate(t.getFlightDate()).flightNumber(t.getFlightNumber()).flightTime(t.getFlightTime())
				.fareId(t.getFareamount().getFareId())
				.flightinfoId(t.getFlightdetails().getFlightinfoId())
				.inventoryId(t.getInventory().getInventoryId())
				.build()).toList();
		return dtotravel;
	}

	@Override
	public void saveFlightTravel(FlightTravelDto travelDto) {
		
		Optional<FareAmout> findById = fareRepository.findById(travelDto.getFareId());
		
		Optional<FlightDetails> findById2 = flightRepository.findById(travelDto.getFlightinfoId());
		
		Optional<Inventory> findById3 = inventoryRepo.findById(travelDto.getInventoryId());
		
		if(findById.isPresent() && findById2.isPresent() && findById3.isPresent()) {
		
			FareAmout fareAmout = findById.get();
			
			FlightDetails flightDetails = findById2.get();
			
			Inventory inventory = findById3.get();
		
			FlightTravel travel = FlightTravel.builder().flightId(travelDto.getFlightId())
					.currentLocation(travelDto.getCurrentLocation())
					.destination(travelDto.getDestination()).flightDate(travelDto.getFlightDate())
					.flightNumber(travelDto.getFlightNumber()).flightTime(travelDto.getFlightTime())
					.fareamount(fareAmout)
					.flightdetails(flightDetails)
					.inventory(inventory)
					.build();
			
//				travel.setFareamount(fareAmout);
//				travel.setFlightdetails(flightDetails);
//				travel.setInventory(inventory);
			travelRepo.save(travel);
		}
		}

	@Override
	public FlightTravelDto fetchByIdTravel(int flightId) {
		Optional<FlightTravel> findById = travelRepo.findById(flightId);
		if(findById.isPresent()) {
			FlightTravel travel = findById.get();
			
			FlightTravelDto travelDto = FlightTravelDto.builder().flightId(travel.getFlightId()).currentLocation(travel.getCurrentLocation())
					.destination(travel.getDestination()).flightDate(travel.getFlightDate())
					.flightNumber(travel.getFlightNumber()).flightTime(travel.getFlightTime())
					.fareId(travel.getFareamount().getFareId())
					.flightinfoId(travel.getFlightdetails().getFlightinfoId())
					.inventoryId(travel.getInventory().getInventoryId())
					.build();
			return travelDto;
		}
		else {
			return null;
		}
	}
	
	@Override
	public void deleteFlightTravel(int flightId) {
		travelRepo.deleteById(flightId);
		
	}
	
	/*
	 * ----------------- inventory implementations ---------------------
	 */

	@Autowired
	private InventoryRepository inventoryRepo;

	@Override
	public List<InventoryDto> getAllDetailsInventory() {
		List<Inventory> findAll = inventoryRepo.findAll();
		
		List<InventoryDto> dtolist = findAll.stream().map(i -> InventoryDto.builder()
				.inventoryId(i.getInventoryId()).count(i.getCount())
				.build()).toList();
		return dtolist;
	}

	@Override
	public InventoryDto fetchByIdInventory(int inventoryId) {
		Optional<Inventory> findById = inventoryRepo.findById(inventoryId);
		
		if(findById.isPresent()) {
			Inventory i = findById.get();
			InventoryDto dto = InventoryDto.builder()
					.inventoryId(i.getInventoryId()).count(i.getCount())
					.build();
			return dto;
		}
		else {
			return null;
		}
		
	}

	@Override
	public void saveInventory(InventoryDto inventoryDto) {
		
		Inventory inventory = Inventory.builder().inventoryId(inventoryDto.getInventoryId())
				.count(inventoryDto.getCount()).build();
		inventoryRepo.save(inventory);
		
	}

	@Override
	public void deleteInventory(int inventoryId) {
		inventoryRepo.deleteById(inventoryId);
		
	}
	
	
	/*
	 * ---------------user login implementation-----------------
	 */
	
	
	
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void saveUser(UserDto userDto) {
		
		User user = User.builder().firstName(userDto.getFirstName()).lastName(userDto.getLastName())
				.userName(userDto.getUserName()).password(userDto.getPassword())
				.mobileNo(userDto.getMobileNo()).gender(userDto.getGender())
				.build();
		userRepo.save(user);
	}
	

	@Override
	public boolean authenticateUser(String userName, String password) {
		List<User> findByUserName = userRepo.findByUserName(userName);
		
		boolean result =false;
		for(User user : findByUserName) {
			if(user!=null && user.getPassword().equals(password)) {
				result = true;
				break;
			}
			
		}
		return result;
	
	}
	
	
	
	
	
	


}
