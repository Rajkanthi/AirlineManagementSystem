package com.jsp.FrontEndAirline2.userDto;

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
public class UserDto {
	
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String password;
	private String userName;
	private String gender;

}
