package com.splenta.gstreturns.pojo.gst.submit;

import java.math.BigDecimal;
import java.util.List;

import com.splenta.gstreturns.pojo.gst.B2CSAGSTR1;
import com.splenta.gstreturns.pojo.gst.save.SaveGstr1B2CSA;

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
public class SubmitGSTR1 {

	private String gstin;
	private String ret_period;
	private String generate_summary;
}
