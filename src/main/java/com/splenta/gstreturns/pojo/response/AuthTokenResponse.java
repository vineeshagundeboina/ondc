package com.splenta.gstreturns.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenResponse {

	private String status_cd;
	private String sek;
	private String expiry;
	private String auth_token;

}
