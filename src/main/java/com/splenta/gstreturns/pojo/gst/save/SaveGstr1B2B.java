package com.splenta.gstreturns.pojo.gst.save;

import java.math.BigDecimal;
import java.util.List;

import com.splenta.gstreturns.pojo.gst.B2BGSTR1;

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
public class SaveGstr1B2B {
	
	private String gstin;
	private String fp;
	private BigDecimal gt;
	private BigDecimal cur_gt;
	 private List<B2BGSTR1> b2b;
}
