package com.splenta.gstreturns.pojo.gst;

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
public class GSTR1ProccedFile {

	private String gstin;
	private String ret_period;
	private String isnil;

}
