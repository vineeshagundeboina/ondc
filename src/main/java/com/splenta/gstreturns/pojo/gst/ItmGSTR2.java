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
public class ItmGSTR2 {
	@JsonProperty("num")
	int num;
	  @JsonProperty("itm_det") 
	  ItmDetGSTR2 itm_det;
}
