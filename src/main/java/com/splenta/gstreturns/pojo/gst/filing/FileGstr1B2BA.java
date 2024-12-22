package com.splenta.gstreturns.pojo.gst.filing;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileGstr1B2BA {

	public String gstin;
	public String ret_period;
	public String chksum;
	public String newSumFlag;
	public List<B2BASecsum> sec_sum;

	
	 

}


