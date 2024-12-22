package com.splenta.gstreturns.pojo.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthResponsePojo {

	private String UserName;
	private String TokenExpiry;
	private String Sek;

	private String ClientId;
	private String AuthToken;

}
