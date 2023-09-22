package com.jsp.FrontEndAirline2.adminRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsp.FrontEndAirline2.adminentity.Checking;



@Repository
public interface CheckingRepository extends JpaRepository<Checking, Integer> {

	List<Checking> findByGateNo(@Param("gateNo") String gateNo);

	List<Checking> findBySeatNo(String seatNo);

//	@Modifying
//	@Query("DELETE FROM Checking c WHERE c.seatNo = :seatNo")
//	void deleteBySeatNo(@Param("seatNo") String seatNo);
//
}
