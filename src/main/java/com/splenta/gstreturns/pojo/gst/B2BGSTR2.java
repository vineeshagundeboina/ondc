package com.splenta.gstreturns.pojo.gst;

import java.util.ArrayList;

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
public class B2BGSTR2 {

	@JsonProperty("ctin")

	String ctin;
	@JsonProperty("cfs")

	String cfs;
	@JsonProperty("dtcancel")

	String dtcancel;
	@JsonProperty("cfs3b")

	String cfs3b;
	@JsonProperty("fldtr1")

	String fldtr1;
	@JsonProperty("flprdr1")

	String flprdr1;
	@JsonProperty("inv")

	ArrayList<InvGSTR2> inv;

}
