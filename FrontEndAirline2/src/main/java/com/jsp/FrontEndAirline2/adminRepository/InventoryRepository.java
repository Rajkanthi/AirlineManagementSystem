package com.jsp.FrontEndAirline2.adminRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsp.FrontEndAirline2.adminentity.Inventory;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	List<Inventory> findByCount(int count);


	@Modifying
	@Query(value = "DELETE FROM Inventory WHERE count = :count", nativeQuery = true)
	int deleteByCount(@Param("count") int count);
}
