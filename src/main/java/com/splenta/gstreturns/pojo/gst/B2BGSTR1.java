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
public class B2BGSTR1 {
	
	private String ctin;
	
	private  List<InvB2BGSTR1> inv;
//	private String flag;
//	private String chksum;
//	private String inum;
//	private String idt;
//	private String val;
//	private String pos;
//	private String rchrg;
//	private String etin;
//	private String inv_typ;
//	private BigDecimal diff_percent;
//	
//	private List<ItmB2BGSTR1> items;

}
