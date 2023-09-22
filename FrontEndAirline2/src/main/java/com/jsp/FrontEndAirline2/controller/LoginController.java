  package com.jsp.FrontEndAirline2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.FrontEndAirline2.AdminDto.AirInfoDto;
import com.jsp.FrontEndAirline2.AdminDto.CheckingDto;
import com.jsp.FrontEndAirline2.AdminDto.FareAmountDto;
import com.jsp.FrontEndAirline2.AdminDto.FlightDetailsDto;
import com.jsp.FrontEndAirline2.AdminDto.FlightTravelDto;
import com.jsp.FrontEndAirline2.AdminDto.InventoryDto;
import com.jsp.FrontEndAirline2.service.AdminService;
import com.jsp.FrontEndAirline2.userDto.BookingDto;
import com.jsp.FrontEndAirline2.userDto.PassengerDto;
import com.jsp.FrontEndAirline2.userDto.UserDto;
import com.jsp.FrontEndAirline2.userentity.User;

import ch.qos.logback.core.model.Model;

@Controller
public class LoginController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/AirlineSystem")
	public String Home() {
		return "Index";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "HomePage";
	}
	
	@GetMapping("/user")
	public String user() {
		return "HomePage2";
	}

	@GetMapping("/htmlAdminPageaction")
	public String adminPageJsp(@RequestParam String adminname, @RequestParam String password) {
		if(adminname.equals("admin") && password.equals("123452")) {
			return "AdminPage";
		}
		else {
			return "HomePage";
		}
		
	}
	
	@GetMapping("/backhtmlAdminPageaction")
	public String backToAdminPage() {
		return "AdminPage";
	}

	@GetMapping("/htmlAirlineInfolink")
	public ModelAndView AirlineInfo() {
		ModelAndView mav = new ModelAndView("AirlineInfoPage");
		List<AirInfoDto> allDetailsAirinfo = adminService.getAllDetailsAirinfo();
		System.out.println(allDetailsAirinfo);
		mav.addObject("listOfAirinfo", allDetailsAirinfo);
		return mav;
	}


	@GetMapping("/addAirline")
	public ModelAndView addAirLine() {
		ModelAndView mav = new ModelAndView("AddAirlinePage");
		AirInfoDto newDto = new AirInfoDto();
		System.out.println(newDto);
		mav.addObject("airline", newDto); //same for update
		return mav;
	}


	@PostMapping("/htmlSaveAirlineaction")
	public String saveAirlineInfo(@ModelAttribute AirInfoDto airDto) {
//		System.out.println(adminService.saveAirline(airDto));
		adminService.saveAirline(airDto);
		return "redirect:/htmlAirlineInfolink";
	}

	@GetMapping("/htmlUpdateAirlineButton")
	public ModelAndView updateAirLine(@RequestParam int airlineId) {
		ModelAndView mav = new ModelAndView("AddAirlinePage");
		AirInfoDto fetchById = adminService.fetchByIdAir(airlineId);
		mav.addObject("airline", fetchById);
		return mav;
	}
	


	@GetMapping("/htmlDeleteAirlineButton")
	public String deleteAirline(@RequestParam int airlineId) {
		adminService.deleteById(airlineId);
		return "redirect:/htmlAirlineInfolink";
	}
/*
 * ----------------------------Checking managing----------------------------------
 */

	@GetMapping("/htmlCheckinglink")
	public ModelAndView showCheckingDetails() {
		ModelAndView mav = new ModelAndView("CheckingDetailsPage");
		List<CheckingDto> allDetailsChecking = adminService.getAllDetailsChecking();
		mav.addObject("checkin", allDetailsChecking);
		return mav;
	}
	
	@GetMapping("/addCheckin")
	public ModelAndView addCheckin() {
		ModelAndView mav = new ModelAndView("AddCheckinPage");
		CheckingDto dto = new CheckingDto();
		mav.addObject("checkin", dto); //same for update
		return mav;
	}
	
	@PostMapping("/htmlSaveCheckinaction")
	public String saveCheckinDetails(@ModelAttribute CheckingDto checkDto) {
		adminService.saveCheckin(checkDto);
		return "redirect:/htmlCheckinglink";
	}
	
	@GetMapping("/htmlUpdatelinkButton")
	public ModelAndView updateCheckin(@RequestParam int checkinId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("AddCheckinPage");
		CheckingDto fetchByIdCheckin = adminService.fetchByIdCheckin(checkinId);
		mav.addObject("checkin", fetchByIdCheckin);
		return mav;
	}
	
	@GetMapping("/htmlDeletelinkButton")
	public String deleteCheckinDetails(@RequestParam int checkinId) {
		adminService.deleteCheckin(checkinId);
		return "redirect:/htmlCheckinglink";
	}
	
	/*
	 * --------------------fare amount managing-----------------
	 */
	
	@GetMapping("/htmlFareAmountlink")
	public ModelAndView showFareAmount() {
		ModelAndView mav = new ModelAndView("FareAmountPage");
		List<FareAmountDto> fareDto = adminService.getAllDetailsFareAmount();
		mav.addObject("farelist", fareDto);
		return mav;
	}
	
	@GetMapping("/addFareAmount")
	public ModelAndView AddFareAmount() {
		ModelAndView mav = new ModelAndView("AddFareAmountPage");
		FareAmountDto newdto = new FareAmountDto();
		mav.addObject("fareamount", newdto);  //same for update
		return mav;
	}
	
	@PostMapping("/htmlSaveFareaction")
	public String SaveFareAmount(@ModelAttribute FareAmountDto fareDto) {
		adminService.saveFareAmount(fareDto);
		return "redirect:/htmlFareAmountlink";
	}
	
	@GetMapping("/htmlUpdateFarelinkButton")
	public ModelAndView updateFareAmount(@RequestParam int fareId) {
		ModelAndView mav = new ModelAndView("AddFareAmountPage");
		FareAmountDto fetchByIdFareAmount = adminService.fetchByIdFareAmount(fareId);
		mav.addObject("fareamount", fetchByIdFareAmount);
		return mav;
	}
	
	@GetMapping("/htmlDeleteFarelinkButton")
	public String deleteFareDetails(@RequestParam int fareId) {
		adminService.deleteFareAmount(fareId);
		return "redirect:/htmlFareAmountlink";
	}
	
	
	/*
	 * ----------------------flight details managing-----------------------
	 */
	
	@GetMapping("/htmlFlightDetailslink")
	public ModelAndView showFlightDetails() {
		ModelAndView mav = new ModelAndView("FlightDetailsPage");
		List<FlightDetailsDto> flightDetails = adminService.getAllDetailsFlight();
		mav.addObject("flightlist", flightDetails);
		return mav;
	}
	
	@GetMapping("/addFlightDetails")
	public ModelAndView addFlightDetails() {
		ModelAndView mav = new ModelAndView("AddFlightDetailsPage");
		FlightDetailsDto dtoflight = new FlightDetailsDto();
		mav.addObject("flight", dtoflight);
		return mav;
	}
	
	@PostMapping("/htmlSaveFlightDetailsaction")
	public String saveFlightDetails(@ModelAttribute FlightDetailsDto flightDto) {
		adminService.saveFlightDetails(flightDto);
		return "redirect:/htmlFlightDetailslink";
	}

	@GetMapping("/htmlUpdateFlightlinkButton")
	public ModelAndView updateFlightDetails(@RequestParam int flightId) {
		ModelAndView mav = new ModelAndView("AddFlightDetailsPage");
		FlightDetailsDto flightdto = adminService.fetchByIdFlight(flightId);
		mav.addObject("flight", flightdto);
		return mav;
	}
	
	@GetMapping("/htmlDeleteFlightlinkButton")
	public String DeleteFlightDetails(@RequestParam int flightId) {
		adminService.deleteFlightDetails(flightId);
		return "redirect:/htmlFlightDetailslink";
	}
	
	
	/*
	 * --------------------- flight travel managing----------------
	 */
	
	@GetMapping("/htmlFlightTravellink")
	public ModelAndView showFlightTravelDetails() {
		ModelAndView mav = new ModelAndView("TravelDetailsPage");
		List<FlightTravelDto> flightTravel = adminService.getAllDetailsFlightTravel();
		mav.addObject("flightlist", flightTravel);
		return mav;
	}
	
	@GetMapping("/addFlightTravel")
	public ModelAndView addFlightTravel() {
		ModelAndView mav = new ModelAndView("AddFlightTravelPage");
		FlightTravelDto dtotravel = new FlightTravelDto();
		mav.addObject("flight", dtotravel);		//same for update
		return mav;
	}
	
	@PostMapping("/htmlSaveFlightTravelaction")
	public String saveFlightTravel(@ModelAttribute FlightTravelDto travelDto) {
		adminService.saveFlightTravel(travelDto);
		return "redirect:/htmlFlightTravellink";
	}

	@GetMapping("/htmlUpdateTravellinkButton")
	public ModelAndView updateFlightTravel(@RequestParam int flightId) {
		ModelAndView mav = new ModelAndView("AddFlightTravelPage");
		FlightTravelDto traveldto = adminService.fetchByIdTravel(flightId);
		mav.addObject("flight", traveldto);
		return mav;
	}
	
	@GetMapping("/htmlDeleteTravellinkButton")
	public String DeleteFlightTravel(@RequestParam int flightId) {
		adminService.deleteFlightTravel(flightId);
		return "redirect:/htmlFlightTravellink";
	}
	
	/*
	 * -------------------------inventory managing----------------------------
	 */
	
	@GetMapping("/htmlInventorylink")
	public ModelAndView showInventory() {
		ModelAndView mav = new ModelAndView("InventoryPage");
		List<InventoryDto> allDetailsInventory = adminService.getAllDetailsInventory();
		mav.addObject("inventorylist", allDetailsInventory);
		return mav;
	}
	
	@GetMapping("/addInventory")
	public ModelAndView addInventory() {
		ModelAndView mav = new ModelAndView("AddInventoryPage");
		InventoryDto dto = new InventoryDto();
		mav.addObject("inventory", dto);
		return mav;
	}
	
	@PostMapping("/htmlSaveInventoryaction")
	public String saveInventory(@ModelAttribute InventoryDto inventoryDto) {
		adminService.saveInventory(inventoryDto);
		return "redirect:/htmlInventorylink";
	}
	
	@GetMapping("/htmlUpdateInventoryButton")
	public ModelAndView updateInventory(@RequestParam int inventoryId) {
		ModelAndView mav = new ModelAndView("AddInventoryPage");
		InventoryDto fetchByIdInventory = adminService.fetchByIdInventory(inventoryId);
		mav.addObject("inventory", fetchByIdInventory);
		return mav;
	}
	@GetMapping("/htmlDeleteInventoryButton")
	public String saveInventory(@RequestParam int inventoryId) {
		adminService.deleteInventory(inventoryId);
		return "redirect:/htmlInventorylink";
	}
	
	
	/*
	 * ---------------------passenger and booking list-------------------------
	 */
	
	@GetMapping("/htmlPassengerListlink")
	public ModelAndView showPassenger() {
		ModelAndView mav = new ModelAndView("PassengerListPage");
		List<PassengerDto> dto = adminService.getAllDetailsPassenger();
		mav.addObject("passengerlist",dto);
		return mav;
	}
	
	
	@GetMapping("/htmlBookingListlink")
	public ModelAndView showBookings() {
		ModelAndView mav = new ModelAndView("BookingListPage");
		List<BookingDto> dto = adminService.getAllDetailsBooking();
		mav.addObject("bookinglist", dto);
		return mav;
	}



/*
 * ----------------user login -----------
 */

	@GetMapping("/htmlUserRegistration")
	public ModelAndView userRegistration() {
		ModelAndView mav = new ModelAndView("UserRegisterPage");
		UserDto userdto = new UserDto();
		mav.addObject("user", userdto);
		return mav;
	}
	
	@PostMapping("/userRegister")
	public String saveUser(@ModelAttribute UserDto userDto) {
		adminService.saveUser(userDto);
		return "Successful";
	}
	
	@GetMapping("/loginUseraction")
	public ModelAndView userLogin(@RequestParam String userName, @RequestParam String password) {
		ModelAndView mav = new ModelAndView("HomePage2");
		boolean authenticateUser = adminService.authenticateUser(userName,password);
		if(authenticateUser) {
			mav.setViewName("Searchpage");
		}
		else {
			mav.addObject("alertmessage", "enter the valid username and password");
			mav.setViewName("Homepage2");
		}
		return mav;
	}
	




//	@ResponseBody
//	@GetMapping("/welcome")
//	public String welcome() {
//		return "Welcome";
//	}

//	@ResponseBody
//	@PostMapping("/htmladminlogin")
//	public String loginPage() {
//
//		return "login sucessfull";
//	}
}
