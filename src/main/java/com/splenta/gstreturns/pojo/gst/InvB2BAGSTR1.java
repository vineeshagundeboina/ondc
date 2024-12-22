package com.splenta.gstreturns.pojo.gst;

import java.math.BigDecimal;
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
public class InvB2BAGSTR1 {

	private String oinum;
	private String oidt;
	private String inum;
	private String idt;
	private BigDecimal val;
	private String pos;
	private String rchrg;
	private String etin;
	private String inv_typ;
	private double diff_percent;
	private List<ItmB2BAGSTR1> itms;

}
