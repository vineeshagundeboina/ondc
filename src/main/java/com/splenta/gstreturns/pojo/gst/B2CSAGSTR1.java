package com.splenta.gstreturns.pojo.gst;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
public class B2CSAGSTR1 {
	private String omon;
	private String sply_ty;
	private String diff_percent;
	private String typ;
	private String etin;
	private String pos;

	private List<ItmDetB2CSAGSTR1> itms;

}
