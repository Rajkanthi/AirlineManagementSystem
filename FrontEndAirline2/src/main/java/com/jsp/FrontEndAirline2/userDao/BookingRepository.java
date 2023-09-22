package com.jsp.FrontEndAirline2.userDao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsp.FrontEndAirline2.userDto.PassengerDto;
import com.jsp.FrontEndAirline2.userentity.Booking;

import jakarta.transaction.Transactional;

@Repository
@EnableJpaRepositories
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByBookingDate(LocalDate bookingDate);
	
	List<Booking> findByFlightTime(LocalTime flightTime);
	
	
//	@Query("DELETE FROM Booking b WHERE b.bookingDate= :bookingDate")
//	void deleteByBookingDate(@Param("bookingDate") LocalDate bookingDate);
	
//	@Transactional
//	@Modifying
//	@Query("UPDATE Booking b SET b.flightTime = :flightTime WHERE b.flightNumber = :fightNumber")
//	void updateByFlightTime(@Param("flightTime") LocalTime flightTime,@Param("flightNumber") String flightNumber);

	
}
