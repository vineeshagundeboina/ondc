package com.splenta.gstreturns.pojo.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BuyerDtls {
	
	private String gstin;
    private String lglNm;
    private String trdNm;
    private String pos;
    private String addr1;
    private String addr2;
    private String loc;
    private int pin;
    private String stcd;
    private String ph;
    private String em;

}
