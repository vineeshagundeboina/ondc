package com.splenta.gstreturns.pojo.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DispDtls {
	
	private String nm;
    private String addr1;
    private String addr2;
    private String loc;
    private int pin;
    private String stcd;

}
