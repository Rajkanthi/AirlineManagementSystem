package com.jsp.FrontEndAirline2.adminentity;



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
public class FlightDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightinfoId;
	private String flightNumber;
	private String flightType;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="airinfo_id")
	private AirInfo airinfo;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "flightdetails")
	private FlightTravel flighttravel;
}
