package com.jsp.FrontEndAirline2.userDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.FrontEndAirline2.userentity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

	List<Passenger> findByEmailId(String emailId);
}
