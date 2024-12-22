package com.splenta.gstreturns.pojo.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class GstAuthenticateRequestForToken {

	private String action;
	private String username;
	private String originalAppKey;
	private String encryptedAppKey;
	private String otp;

}
