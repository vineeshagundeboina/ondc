package com.splenta.gstreturns.pojo.request;

import java.util.List;

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
public class GenerateIRNRequest {

	private String version;
	private TranDtls tranDtls;
	private DocDtls docDtls;
	private SellerDtls sellerDtls;
	private BuyerDtls buyerDtls;
	private DispDtls dispDtls;
	private ShipDtls shipDtls;
	private List<ItemList> itemList;
	private ValDtls valDtls;
	private PayDtls payDtls;
	private RefDtls refDtls;
	private List<AddlDocDtls> addlDocDtls;
	private ExpDtls expDtls;
	private EwbDtls ewbDtls;

}
