package com.jsp.FrontEndAirline2.AdminDto;



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
public class FareAmountDto {
	private int fareId;
	private double amount;
	private String currency;


}
