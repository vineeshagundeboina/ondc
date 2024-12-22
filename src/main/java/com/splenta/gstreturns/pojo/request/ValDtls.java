package com.splenta.gstreturns.pojo.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ValDtls {
	
	private double assVal;
    private double cgstVal;
    private double sgstVal;
    private double igstVal;
    private double cesVal;
    private double stCesVal;
    private int discount;
    private int othChrg;
    private double rndOffAmt;
    private int totInvVal;
    private double totInvValFc;

}
