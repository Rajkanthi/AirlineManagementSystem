package com.jsp.FrontEndAirline2.adminRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsp.FrontEndAirline2.adminentity.AirInfo;



@Repository

public interface AirRepository extends JpaRepository<AirInfo, Integer> {

	List<AirInfo> findByAirlineName(@Param("airlineName") String airlineName);

//	@Modifying
//	@Query("DELETE FROM AirInfo b WHERE b.airlineName = :name")
//	int deleteBYAirlineName(@Param("name") String airlineName);
}
