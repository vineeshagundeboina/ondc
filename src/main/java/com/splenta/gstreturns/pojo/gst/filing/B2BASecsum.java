package com.splenta.gstreturns.pojo.gst.filing;

import java.math.BigDecimal;

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
public class B2BASecsum {
	public String sec_nm;
	public String chksum;
	public BigDecimal ttl_rec;
	public BigDecimal ttl_tax;
	public BigDecimal ttl_igst;
	public BigDecimal ttl_sgst;
	public BigDecimal ttl_cgst;
	public BigDecimal ttl_val;
	public BigDecimal ttl_cess;
	public BigDecimal act_tax;
	public BigDecimal act_igst;
	public BigDecimal act_sgst;
	public BigDecimal act_cgst;
	public BigDecimal act_val;
	public BigDecimal act_cess;

}