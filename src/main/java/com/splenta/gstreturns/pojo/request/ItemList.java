package com.splenta.gstreturns.pojo.request;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class ItemList {
	
	private String slNo;
    private String prdDesc;
    private String isServc;
    private String hsnCd;
    private String barcde;
    private double qty;
    private int freeQty;
    private String unit;
    private double unitPrice;
    private double totAmt;
    private int discount;
    private double preTaxVal;
    private double assAmt;
    private double gstRt;
    private double igstAmt;
    private double cgstAmt;
    private double sgstAmt;
    private double cesRt;
    private double cesAmt;
    private int cesNonAdvlAmt;
    private double stateCesRt;
    private double stateCesAmt;
    private double stateCesNonAdvlAmt;
    private double othChrg;
    private double totItemVal;
    private String ordLineRef;
    private String orgCntry;
    private String prdSlNo;
    private BchDtls bchDtls;
    private List<AttribDtls> attribDtls;

}
