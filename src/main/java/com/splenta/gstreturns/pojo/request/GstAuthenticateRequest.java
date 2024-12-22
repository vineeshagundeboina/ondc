package com.splenta.gstreturns.pojo.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class GstAuthenticateRequest {

	private String action;
	private String app_key;
	private String username;

}
