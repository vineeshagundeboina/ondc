package com.splenta.gstreturns.pojo.request;

import java.util.Date;

import lombok.Data;

@Data
public class EwaybillByIrn {
	
	private String irn;
    private int distance;
    private String transMode;
    private String transId;
    private String transName;
    private Date trnDocDt;  // You may need to handle date parsing and formatting
    private String trnDocNo;
    private String vehNo;
    private String vehType;
	
  
}
