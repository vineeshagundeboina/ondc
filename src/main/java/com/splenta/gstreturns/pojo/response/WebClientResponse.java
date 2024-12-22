package com.splenta.gstreturns.pojo.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@JsonIgnoreProperties
public class WebClientResponse {
	
	
	private AuthResponsePojo Data;
	private String ErrorDetails;
	private String status;
	private String InfoDtls;
	private String originalAppKey;
	private String decryptedSek;
}
