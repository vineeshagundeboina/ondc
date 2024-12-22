package com.splenta.hrms.pojo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponse {
	Boolean status = false;
	String message = "";
	Boolean isProfileExists = false;
	Boolean isMPINExists = false;

	// public SignupResponse() {
	// this.status = false;
	// this.message = "";
	// this.isProfileExists = false;
	// this.isMPINExists = false;
	// }

}
