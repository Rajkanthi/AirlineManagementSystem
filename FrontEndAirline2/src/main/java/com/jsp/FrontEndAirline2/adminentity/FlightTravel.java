package com.jsp.FrontEndAirline2.adminentity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class FlightTravel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightId;
	private String currentLocation;
	private String destination;
	private String flightNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fare_id")
	private FareAmout fareamount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="flightinfo_id")
	private FlightDetails flightdetails;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="inventory_id")
	private Inventory inventory;

	@Column(columnDefinition = "DATE")
	private LocalDate flightDate;

	@Column(columnDefinition = "TIME")
	private LocalTime flightTime;



}
