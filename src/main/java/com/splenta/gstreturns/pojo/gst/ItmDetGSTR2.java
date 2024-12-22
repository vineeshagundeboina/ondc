package com.splenta.gstreturns.pojo.gst;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItmDetGSTR2 {
	@JsonProperty("rt")

	int rt;

	@JsonProperty("txval")

	double txval;

	@JsonProperty("iamt")

	int iamt;

	@JsonProperty("camt")
	double camt;

	@JsonProperty("samt")
	double samt;

	@JsonProperty("csamt")
	double csamt;
}
