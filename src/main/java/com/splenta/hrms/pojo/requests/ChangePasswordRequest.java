package com.splenta.hrms.pojo.requests;

import com.splenta.hrms.models.auth.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ChangePasswordRequest {
	
	private String newPassword;
	
	private User user;

}
