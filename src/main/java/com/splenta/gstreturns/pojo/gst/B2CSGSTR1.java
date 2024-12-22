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
public class B2CSGSTR1 {
	private String pos;
	private String sply_ty;
	private String diff_percent;
	private int rt;
	private String typ;
	private String etin;
	private int txval;
	private int iamt;
	private int csamt;
}
