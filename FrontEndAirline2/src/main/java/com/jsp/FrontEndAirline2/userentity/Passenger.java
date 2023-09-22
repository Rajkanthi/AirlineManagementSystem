package com.jsp.FrontEndAirline2.userentity;


import com.jsp.FrontEndAirline2.adminentity.Checking;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int passengerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNo;
	private String gender;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private Booking booking;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="checkin_id")
	private Checking checkin;
}
