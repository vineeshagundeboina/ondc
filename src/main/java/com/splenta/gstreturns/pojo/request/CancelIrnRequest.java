package com.splenta.gstreturns.pojo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CancelIrnRequest {
	// @JsonProperty("Irn")
	private String irn;
	// @JsonProperty("CnlRsn")
	private String cnlRsn;
	// @JsonProperty("CnlRem")
	private String cnlRem;

}
