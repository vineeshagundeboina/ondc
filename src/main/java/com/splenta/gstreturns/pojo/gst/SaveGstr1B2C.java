package com.splenta.gstreturns.pojo.gst;

import java.math.BigDecimal;
import java.util.ArrayList;

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
public class SaveGstr1B2C {

	private String gstin;
	private String fp;
	private BigDecimal gt;
	private BigDecimal cur_gt;
	private ArrayList<B2CGSTR1> b2cs;
}
