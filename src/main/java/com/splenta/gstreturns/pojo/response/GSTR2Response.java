package com.splenta.gstreturns.pojo.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.splenta.gstreturns.pojo.gst.B2BGSTR2;

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
public class GSTR2Response {

	@JsonProperty("b2b")
	ArrayList<B2BGSTR2> b2b;
	
}
