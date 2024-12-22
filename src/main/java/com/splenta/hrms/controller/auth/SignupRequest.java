package com.splenta.hrms.controller.auth;

import java.util.UUID;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class SignupRequest {
	private String employeeName;
	private String employeeId;
	private String mobileNumber;
	private String email;
	private String password;
	private String type;
	
}
