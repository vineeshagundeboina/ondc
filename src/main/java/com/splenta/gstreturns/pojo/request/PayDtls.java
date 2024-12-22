package com.splenta.gstreturns.pojo.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PayDtls {
	
	private String nm;
    private String accDet;
    private String mode;
    private String finInsBr;
    private String payTerm;
    private String payInstr;
    private String crTrn;
    private String dirDr;
    private int crDay;
    private double paidAmt;
    private double paymtDue;

}
