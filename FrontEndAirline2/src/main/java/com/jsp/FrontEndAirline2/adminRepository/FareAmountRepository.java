package com.jsp.FrontEndAirline2.adminRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsp.FrontEndAirline2.adminentity.FareAmout;



@Repository
public interface FareAmountRepository extends JpaRepository<FareAmout, Integer>{

	List<FareAmout> findByCurrency(@Param("currency") String currency);
}
