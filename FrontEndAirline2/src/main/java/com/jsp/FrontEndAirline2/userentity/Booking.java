package com.jsp.FrontEndAirline2.userentity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	
	@Column(columnDefinition = "DATE")
	private LocalDate bookingDate;
	private String currentCity;
	private String destination;
	
	@Column(columnDefinition = "DATE")
	private LocalDate flightDate;
	
	@Column(columnDefinition = "Time")
	private LocalTime flightTime;
	private String flightNumber;
	private double amount;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "booking")
	private List<Passenger> passengers;

}
