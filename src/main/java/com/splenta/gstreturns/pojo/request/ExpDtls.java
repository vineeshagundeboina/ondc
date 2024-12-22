package com.splenta.gstreturns.pojo.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ExpDtls {
	private String shipBNo;
    private String shipBDt;
    private String port;
    private String refClm;
    private String forCur;
    private String cntCode;
    private String expDuty;

}
