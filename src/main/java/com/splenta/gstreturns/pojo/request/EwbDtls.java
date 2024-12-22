package com.splenta.gstreturns.pojo.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EwbDtls {
	
	 private String transId;
	    private String transName;
	    private int distance;
	    private String transDocNo;
	    private String transDocDt;
	    private String vehNo;
	    private String vehType;
	    private String transMode;


}
