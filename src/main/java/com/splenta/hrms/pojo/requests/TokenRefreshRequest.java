package com.splenta.hrms.pojo.requests;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TokenRefreshRequest {
	
	@NotBlank
	private String refreshToken;
	
}
