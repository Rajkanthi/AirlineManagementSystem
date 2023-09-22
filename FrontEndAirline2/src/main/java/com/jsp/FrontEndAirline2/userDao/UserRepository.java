package com.jsp.FrontEndAirline2.userDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsp.FrontEndAirline2.userentity.User;

import jakarta.transaction.Transactional;

@Repository

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByUserName(String userName);
	
	
	List<User> findByMobileNo(String mobileNo);
	
	List<User> findByGender(String gender);
	
	
	User findByUserNameAndMobileNo(String userName, String mobileNo);

	
//	@Query("DELETE FROM User u WHERE u.mobileNo = :mobileNo")
//	 void deleteByMobileNo(@Param("mobileNo") String mobileNo);
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.password = :password WHERE u.mobileNo = :mobileNo")
	 void updateMoblieNo(@Param("mobileNo") String mobileNo, @Param("password") String password);	
}
