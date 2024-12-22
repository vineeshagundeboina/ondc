package com.splenta.gstreturns.pojo.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class AuthenticateRequest {
	
	private String UserName;
	private String Password;
	private String AppKey;
	private boolean ForceRefreshAccessToken;
}
