package com.splenta.gstreturns.service;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.splenta.gstreturns.pojo.request.AddlDocDtls;
import com.splenta.gstreturns.pojo.request.AttribDtls;
import com.splenta.gstreturns.pojo.request.CancelIrnRequest;
import com.splenta.gstreturns.pojo.request.ContrDtls;
import com.splenta.gstreturns.pojo.request.EwaybillByIrn;
import com.splenta.gstreturns.pojo.request.GenerateIRNRequest;
import com.splenta.gstreturns.pojo.request.ItemList;
import com.splenta.gstreturns.pojo.request.PrecDocDtls;
import com.splenta.gstreturns.pojo.response.DecryptSekResponse;

@Service
public class EwayInvoiceService {

	@Autowired
	private EncryptionDecryptionService encryptionDecryptionService;

	public String getDecryptedSek(String encryptedSek, byte[] appKey) {
		Key aesKey = new SecretKeySpec(appKey, "AES");
		String response = "";
		DecryptSekResponse decryptSekResponse = new DecryptSekResponse();
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			byte[] encryptedSekBytes = Base64.getDecoder().decode(encryptedSek);
			byte[] decryptedSekBytes = cipher.doFinal(encryptedSekBytes);
			String decryptedSek = Base64.getEncoder().encodeToString(decryptedSekBytes);
			response = decryptedSek;
			System.out.println("decryptedSek: " + decryptedSek);
			decryptSekResponse.setDecryptedSek(decryptedSek);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	private HttpHeaders getIrnHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		headers.set("Ocp-Apim-Subscription-Key", "AL1S2k5m3F9P2A7S0x");
		headers.set("Gstin", "07AGAPA5363L002");
		headers.set("user_name", "AL001");
		headers.set("AuthToken", "AMJIa5iWQX5OBUlyIcH5GuLlH");

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	public String generateIRN(GenerateIRNRequest generateIRNRequest, String sek) throws Exception {

		String encodedMessage = getEncodedJsonObjectForprocessIrnRequst(generateIRNRequest, sek);
		HttpHeaders headers = getIrnHeaders();
		String finalResponse = "";
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("Data", encodedMessage);

			System.out.println("\n\n\n:");
			System.out.println("final encrypted string    ---->" + requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://developers.eraahi.com/eInvoiceGateway/eicore/v1.03/Invoice", HttpMethod.POST, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
			System.out.println("responseInJson: " + responseInJson.toString(4));
			String decryptedData = encryptionDecryptionService.getDecryptedRek(responseInJson.get("Data").toString(),
					decodeBase64StringTOByte(sek));
			finalResponse = new String(Base64.getDecoder().decode(decryptedData));
			System.out.println("after data -->" + new String(Base64.getDecoder().decode(decryptedData)));

			int status = responseInJson.getInt("Status");

			if (status == 0) {
				throw new Exception("could not generate IRN");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return finalResponse;

	}

	private String getEncodedJsonObjectForprocessIrnRequst(GenerateIRNRequest generateIRNRequest, String sek)
			throws Exception {
		String encodedMessage = "";

		JSONObject mainObject = new JSONObject();
		JSONObject tranDtls = new JSONObject();
		JSONObject docDtls = new JSONObject();
		JSONObject sellerDtls = new JSONObject();
		JSONObject buyerDtls = new JSONObject();
		JSONObject dispDtls = new JSONObject();
		JSONObject shipDtls = new JSONObject();
		JSONObject bchDtls = new JSONObject();

		List<JSONObject> attribDtls = new ArrayList<JSONObject>();
		JSONObject attribDtl = new JSONObject();

		List<JSONObject> itemList = new ArrayList<JSONObject>();
		JSONObject item = new JSONObject();

		JSONObject valDtls = new JSONObject();
		JSONObject payDtls = new JSONObject();
		JSONObject refDtls = new JSONObject();

		List<JSONObject> precDocDtls = new ArrayList<JSONObject>();
		JSONObject precDocDtl = new JSONObject();

		List<JSONObject> contrDtls = new ArrayList<JSONObject>();
		JSONObject contrDtl = new JSONObject();

		List<JSONObject> addlDocDtls = new ArrayList<JSONObject>();
		JSONObject addlDocDtl = new JSONObject();

		JSONObject expDtls = new JSONObject();
		JSONObject ewbDtls = new JSONObject();

		JSONObject docperDetails = new JSONObject();

		try {

			try {
				Field changeMap = docperDetails.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(docperDetails, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = mainObject.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(mainObject, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = tranDtls.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(tranDtls, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = docDtls.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(docDtls, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = buyerDtls.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(buyerDtls, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = dispDtls.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(dispDtls, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = shipDtls.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(shipDtls, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

//			try {
//				Field changeMap = itemList.getClass().getDeclaredField("map");
//				changeMap.setAccessible(true);
//				changeMap.set(itemList, new LinkedHashMap<>());
//				changeMap.setAccessible(false);
//			} catch (IllegalAccessException | NoSuchFieldException e) {
//				e.printStackTrace();
//			}

			try {
				Field changeMap = item.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(item, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = bchDtls.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(bchDtls, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

//			try {
//				Field changeMap = attribDtls.getClass().getDeclaredField("map");
//				changeMap.setAccessible(true);
//				changeMap.set(attribDtls, new LinkedHashMap<>());
//				changeMap.setAccessible(false);
//			} catch (IllegalAccessException | NoSuchFieldException e) {
//				e.printStackTrace();
//			}

			try {
				Field changeMap = attribDtl.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(attribDtl, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = valDtls.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(valDtls, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = payDtls.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(payDtls, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = refDtls.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(refDtls, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

//			try {
//				Field changeMap = precDocDtls.getClass().getDeclaredField("map");
//				changeMap.setAccessible(true);
//				changeMap.set(precDocDtls, new LinkedHashMap<>());
//				changeMap.setAccessible(false);
//			} catch (IllegalAccessException | NoSuchFieldException e) {
//				e.printStackTrace();
//			}

			try {
				Field changeMap = precDocDtl.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(precDocDtl, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

//			try {
//				Field changeMap = contrDtls.getClass().getDeclaredField("map");
//				changeMap.setAccessible(true);
//				changeMap.set(contrDtls, new LinkedHashMap<>());
//				changeMap.setAccessible(false);
//			} catch (IllegalAccessException | NoSuchFieldException e) {
//				e.printStackTrace();
//			}

			try {
				Field changeMap = contrDtl.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(contrDtl, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

//			try {
//				Field changeMap = addlDocDtls.getClass().getDeclaredField("map");
//				changeMap.setAccessible(true);
//				changeMap.set(addlDocDtls, new LinkedHashMap<>());
//				changeMap.setAccessible(false);
//			} catch (IllegalAccessException | NoSuchFieldException e) {
//				e.printStackTrace();
//			}
//			

			try {
				Field changeMap = addlDocDtl.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(addlDocDtl, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = expDtls.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(expDtls, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = ewbDtls.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ewbDtls, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			// JSONObject ecmGstin=new JSONObject();
			// ecmGstin=null;
			Object ecmGstinValue = null;
			System.out.println("generateIRNRequest.getTranDtls()--> " + generateIRNRequest.getVersion());
			tranDtls.put("TaxSch", generateIRNRequest.getTranDtls().getTaxSch());
			tranDtls.put("SupTyp", generateIRNRequest.getTranDtls().getSupTyp());
			tranDtls.put("RegRev", generateIRNRequest.getTranDtls().getRegRev());
			tranDtls.put("EcmGstin", ecmGstinValue);

			tranDtls.put("IgstOnIntra", generateIRNRequest.getTranDtls().getIgstOnIntra());

			docDtls.put("Typ", generateIRNRequest.getDocDtls().getTyp());
			docDtls.put("No", generateIRNRequest.getDocDtls().getNo());
			docDtls.put("Dt", generateIRNRequest.getDocDtls().getDt());

			sellerDtls.put("Gstin", generateIRNRequest.getSellerDtls().getGstin());
			sellerDtls.put("LglNm", generateIRNRequest.getSellerDtls().getLglNm());
			sellerDtls.put("TrdNm", generateIRNRequest.getSellerDtls().getTrdNm());
			sellerDtls.put("Addr1", generateIRNRequest.getSellerDtls().getAddr1());
			sellerDtls.put("Addr2", generateIRNRequest.getSellerDtls().getAddr2());
			sellerDtls.put("Loc", generateIRNRequest.getSellerDtls().getLoc());
			sellerDtls.put("Pin", generateIRNRequest.getSellerDtls().getPin());
			sellerDtls.put("Stcd", generateIRNRequest.getSellerDtls().getStcd());
			sellerDtls.put("Ph", generateIRNRequest.getSellerDtls().getPh());
			sellerDtls.put("Em", generateIRNRequest.getSellerDtls().getEm());

			buyerDtls.put("Gstin", generateIRNRequest.getBuyerDtls().getGstin());
			buyerDtls.put("LglNm", generateIRNRequest.getBuyerDtls().getLglNm());
			buyerDtls.put("TrdNm", generateIRNRequest.getBuyerDtls().getTrdNm());
			buyerDtls.put("Pos", generateIRNRequest.getBuyerDtls().getPos());
			buyerDtls.put("Addr1", generateIRNRequest.getBuyerDtls().getAddr1());
			buyerDtls.put("Addr2", generateIRNRequest.getBuyerDtls().getAddr2());
			buyerDtls.put("Loc", generateIRNRequest.getBuyerDtls().getLoc());
			buyerDtls.put("Pin", generateIRNRequest.getBuyerDtls().getPin());
			buyerDtls.put("Stcd", generateIRNRequest.getBuyerDtls().getStcd());
			buyerDtls.put("Ph", generateIRNRequest.getBuyerDtls().getPh());
			buyerDtls.put("Em", generateIRNRequest.getBuyerDtls().getEm());

			dispDtls.put("Nm", generateIRNRequest.getDispDtls().getNm());
			dispDtls.put("Addr1", generateIRNRequest.getDispDtls().getAddr1());
			dispDtls.put("Addr2", generateIRNRequest.getDispDtls().getAddr2());
			dispDtls.put("Loc", generateIRNRequest.getDispDtls().getLoc());
			dispDtls.put("Pin", generateIRNRequest.getDispDtls().getPin());
			dispDtls.put("Stcd", generateIRNRequest.getDispDtls().getStcd());

			shipDtls.put("Gstin", generateIRNRequest.getShipDtls().getGstin());
			shipDtls.put("LglNm", generateIRNRequest.getShipDtls().getLglNm());
			shipDtls.put("TrdNm", generateIRNRequest.getShipDtls().getTrdNm());
			shipDtls.put("Addr1", generateIRNRequest.getShipDtls().getAddr1());
			shipDtls.put("Addr2", generateIRNRequest.getShipDtls().getAddr2());
			shipDtls.put("Loc", generateIRNRequest.getShipDtls().getLoc());
			shipDtls.put("Pin", generateIRNRequest.getShipDtls().getPin());
			shipDtls.put("Stcd", generateIRNRequest.getShipDtls().getStcd());

			valDtls.put("AssVal", generateIRNRequest.getValDtls().getAssVal());
			valDtls.put("CgstVal", generateIRNRequest.getValDtls().getCgstVal());
			valDtls.put("SgstVal", generateIRNRequest.getValDtls().getSgstVal());
			valDtls.put("IgstVal", generateIRNRequest.getValDtls().getIgstVal());
			valDtls.put("CesVal", generateIRNRequest.getValDtls().getCesVal());
			valDtls.put("StCesVal", generateIRNRequest.getValDtls().getStCesVal());
			valDtls.put("Discount", generateIRNRequest.getValDtls().getDiscount());
			valDtls.put("OthChrg", generateIRNRequest.getValDtls().getOthChrg());
			valDtls.put("RndOffAmt", generateIRNRequest.getValDtls().getRndOffAmt());
			valDtls.put("TotInvVal", generateIRNRequest.getValDtls().getTotInvVal());
			valDtls.put("TotInvValFc", generateIRNRequest.getValDtls().getTotInvValFc());

			payDtls.put("Nm", generateIRNRequest.getPayDtls().getNm());
			payDtls.put("AccDet", generateIRNRequest.getPayDtls().getAccDet());
			payDtls.put("Mode", generateIRNRequest.getPayDtls().getMode());
			payDtls.put("FinInsBr", generateIRNRequest.getPayDtls().getFinInsBr());
			payDtls.put("PayTerm", generateIRNRequest.getPayDtls().getPayTerm());
			payDtls.put("PayInstr", generateIRNRequest.getPayDtls().getPayInstr());
			payDtls.put("CrTrn", generateIRNRequest.getPayDtls().getCrTrn());
			payDtls.put("DirDr", generateIRNRequest.getPayDtls().getDirDr());
			payDtls.put("CrDay", generateIRNRequest.getPayDtls().getCrDay());
			payDtls.put("PaidAmt", generateIRNRequest.getPayDtls().getPaidAmt());
			payDtls.put("PaymtDue", generateIRNRequest.getPayDtls().getPaymtDue());

			// Object expDutyValue=null;
			expDtls.put("ShipBNo", generateIRNRequest.getExpDtls().getShipBNo());
			expDtls.put("ShipBDt", generateIRNRequest.getExpDtls().getShipBDt());
			expDtls.put("Port", generateIRNRequest.getExpDtls().getPort());
			expDtls.put("RefClm", generateIRNRequest.getExpDtls().getRefClm());
			expDtls.put("ForCur", generateIRNRequest.getExpDtls().getForCur());
			expDtls.put("CntCode", generateIRNRequest.getExpDtls().getCntCode());
			expDtls.put("ExpDuty", generateIRNRequest.getExpDtls().getExpDuty());

			ewbDtls.put("TransId", generateIRNRequest.getEwbDtls().getTransId());
			ewbDtls.put("TransName", generateIRNRequest.getEwbDtls().getTransName());
			ewbDtls.put("Distance", generateIRNRequest.getEwbDtls().getDistance());
			ewbDtls.put("TransDocNo", generateIRNRequest.getEwbDtls().getTransDocNo());
			ewbDtls.put("TransDocDt", generateIRNRequest.getEwbDtls().getTransDocDt());
			ewbDtls.put("VehNo", generateIRNRequest.getEwbDtls().getVehNo());
			ewbDtls.put("VehType", generateIRNRequest.getEwbDtls().getVehType());
			ewbDtls.put("TransMode", generateIRNRequest.getEwbDtls().getTransMode());

			for (ItemList obj : generateIRNRequest.getItemList()) {
				item = new JSONObject();
				item.put("SlNo", obj.getSlNo());
				item.put("PrdDesc", obj.getPrdDesc());
				item.put("IsServc", obj.getIsServc());
				item.put("HsnCd", obj.getHsnCd());
				item.put("Barcde", obj.getBarcde());
				item.put("Qty", obj.getQty());
				item.put("FreeQty", obj.getFreeQty());
				item.put("Unit", obj.getUnit());
				item.put("UnitPrice", obj.getUnitPrice());
				item.put("TotAmt", obj.getTotAmt());
				item.put("Discount", obj.getDiscount());
				item.put("PreTaxVal", obj.getPreTaxVal());
				item.put("AssAmt", obj.getAssAmt());
				item.put("GstRt", obj.getGstRt());
				item.put("IgstAmt", obj.getIgstAmt());
				item.put("CgstAmt", obj.getCgstAmt());
				item.put("SgstAmt", obj.getSgstAmt());
				item.put("CesRt", obj.getCesRt());
				item.put("CesAmt", obj.getCesAmt());
				item.put("CesNonAdvlAmt", obj.getCesNonAdvlAmt());
				item.put("StateCesRt", obj.getStateCesRt());
				item.put("StateCesAmt", obj.getStateCesAmt());
				item.put("StateCesNonAdvlAmt", obj.getStateCesNonAdvlAmt());
				item.put("OthChrg", obj.getOthChrg());
				item.put("TotItemVal", obj.getTotItemVal());
				item.put("OrdLineRef", obj.getOrdLineRef());
				item.put("OrgCntry", obj.getOrgCntry());
				item.put("PrdSlNo", obj.getPrdSlNo());
				bchDtls = new JSONObject();
				bchDtls.put("Nm", obj.getBchDtls().getNm());
				bchDtls.put("ExpDt", obj.getBchDtls().getExpDt());

				bchDtls.put("WrDt", obj.getBchDtls().getWrDt());

				item.put("BchDtls", bchDtls);
				// List<JSONObject> jsonattribDtls = new ArrayList<JSONObject>();
				for (AttribDtls attribDt : obj.getAttribDtls()) {
					attribDtl = new JSONObject();
					attribDtl.put("Nm", attribDt.getNm());
					attribDtl.put("Val", attribDt.getVal());
					attribDtls.add(attribDtl);

				}
				item.put("AttribDtls", attribDtls);
				itemList.add(item);
			}

			docperDetails.put("InvStDt", generateIRNRequest.getRefDtls().getDocPerdDtls().getInvStDt());
			docperDetails.put("InvEndDt", generateIRNRequest.getRefDtls().getDocPerdDtls().getInvEndDt());

			refDtls.put("InvRm", generateIRNRequest.getRefDtls().getInvRm());

			refDtls.put("DocPerdDtls", docperDetails);

			for (PrecDocDtls precDocDt : generateIRNRequest.getRefDtls().getPrecDocDtls()) {
				precDocDtl = new JSONObject();
				precDocDtl.put("InvNo", precDocDt.getInvNo());
				precDocDtl.put("InvDt", precDocDt.getInvDt());
				precDocDtl.put("OthRefNo", precDocDt.getOthRefNo());
				precDocDtls.add(precDocDtl);
			}
			refDtls.put("PrecDocDtls", precDocDtls);

			for (ContrDtls contrDt : generateIRNRequest.getRefDtls().getContrDtls()) {
				contrDtl = new JSONObject();
				contrDtl.put("RecAdvRefr", contrDt.getRecAdvRefr());
				contrDtl.put("RecAdvDt", contrDt.getRecAdvDt());

				contrDtl.put("TendRefr", contrDt.getTendRefr());

				contrDtl.put("ContrRefr", contrDt.getContrRefr());

				contrDtl.put("ExtRefr", contrDt.getExtRefr());
				contrDtl.put("ProjRefr", contrDt.getProjRefr());
				contrDtl.put("PORefr", contrDt.getPORefr());
				contrDtl.put("PORefDt", contrDt.getPORefDt());
				contrDtls.add(contrDtl);
			}
			refDtls.put("ContrDtls", contrDtls);

			for (AddlDocDtls addlDocDt : generateIRNRequest.getAddlDocDtls()) {
				addlDocDtl = new JSONObject();
				addlDocDtl.put("Url", addlDocDt.getUrl());
				addlDocDtl.put("Docs", addlDocDt.getDocs());
				addlDocDtl.put("Info", addlDocDt.getInfo());
				addlDocDtls.add(addlDocDtl);
			}

			mainObject.put("Version", generateIRNRequest.getVersion());
			mainObject.put("TranDtls", tranDtls);
			mainObject.put("DocDtls", docDtls);
			mainObject.put("SellerDtls", sellerDtls);
			mainObject.put("BuyerDtls", buyerDtls);
			mainObject.put("DispDtls", dispDtls);
			mainObject.put("ShipDtls", shipDtls);
			mainObject.put("ItemList", itemList);
			mainObject.put("ValDtls", valDtls);
			mainObject.put("PayDtls", payDtls);
			mainObject.put("RefDtls", refDtls);
			mainObject.put("AddlDocDtls", addlDocDtls);
			mainObject.put("ExpDtls", expDtls);
			mainObject.put("EwbDtls", ewbDtls);

			System.out.println("befofe payload-->\n: " + mainObject.toString(5));

//			String encString = encryptionDecryptionService.encryptEK(mainObject.toString().getBytes(),
//					encryptionDecryptionService.decodeBase64StringTOByte(sek));

			String encodedJson = encodeBase64String(mainObject.toString().getBytes());
			String encString = encryptBySymmetricKey(encodedJson, sek);

			System.out.println("encString: " + encString);

			System.out.println("/n/n/n/n");
			System.out.println("base64convertedcode     " + encodedJson);
			System.out.println("/n/n/n/n");

			// System.out.println("mainObject: " + mainObject.toString(4));
			// encodedMessage = encString;
			encodedMessage = encString;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("something went wrong");
		}
		return encodedMessage;
	}

	public String encodeBase64String(byte[] bytes) {
		return new String(java.util.Base64.getEncoder().encode(bytes));
	}

	final String CHARACTER_ENCODING = "UTF-8";

	byte[] decodeBase64StringTOByte(String stringData) throws Exception {
		return java.util.Base64.getDecoder().decode(stringData.getBytes(CHARACTER_ENCODING));
	}

	public String encryptBySymmetricKey(String jsondata, String decryptedsek) {
		try {
			byte[] dataToEncrypt = Base64.getDecoder().decode(jsondata);
			byte[] keyBytes = Base64.getDecoder().decode(decryptedsek);
			SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey); // No initialization vector (IV) in this example
			byte[] encryptedData = cipher.doFinal(dataToEncrypt);
			return Base64.getEncoder().encodeToString(encryptedData);
		} catch (Exception ex) {
			throw new RuntimeException("Encryption failed.", ex);
		}
	}

	
	
	
	
	
	
	
	public void getEinvoiceDetails(String sek, String IRN) {



		HttpHeaders headers = getIrnHeaders();
		try {
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			String url = "https://developers.eraahi.com/eInvoiceGateway/eicore/v1.03/Invoice/irn/" + IRN;
			System.out.println("url " + url);
			ResponseEntity<String> responses = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());

			System.out.println("responseInJson: " + responseInJson.toString(4));
			String decryptedData = encryptionDecryptionService.getDecryptedRek(responseInJson.get("Data").toString(),
					decodeBase64StringTOByte(sek));
			// finalResponse=new String(Base64.getDecoder().decode(decryptedData));
			System.out.println("after data -->" + new String(Base64.getDecoder().decode(decryptedData)));

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	
	
	
	public String ewaybillByIrn(EwaybillByIrn ewaybillByIrn,String sek) {
		String encodedMessage=getEncodedJsonObjectForprocessEwaybillIrnRequst(ewaybillByIrn,sek);
		HttpHeaders headers=getIrnHeaders();
		String finalResponse="";
		try {
			JSONObject requestPayload = new JSONObject();

			requestPayload.put("Data", encodedMessage);
			//requestPayload.put("Data", "otLD941XaryQHL45unNjLW39Cd/W4gaMHiVNp/QZ8PFyHp7vVEoomlO4B0JhSWfSgFDCBsUO2vNM1i6KRwU9m8Wq9LjGCuM3dJsvPnw7JNle56stmi6AkCnETa2biDbQjFZdCoK22hLMLXXGFcK/YMWt5JoXPqx5G2EPEBV56Ec=\r\n");

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://developers.eraahi.com/eInvoiceGateway/eiewb/v1.03/ewaybill", HttpMethod.POST, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());

			System.out.println("responseInJson: " + responseInJson.toString(4));
			
			String decryptedData = encryptionDecryptionService.getDecryptedRek(responseInJson.get("Data").toString(), decodeBase64StringTOByte(sek));
			finalResponse=new String(Base64.getDecoder().decode(decryptedData));
			System.out.println("after data -->" + new String(Base64.getDecoder().decode(decryptedData)));
//			String encryptedRek = responseInJson.getString("rek");
//			String encryptedData = responseInJson.getString("data");
//			System.out.println("before rek -->" + encryptedRek);
//			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
//			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
//			System.out.println("after rek -->" + decryptedRek);
//
//			System.out.println("before data -->" + encryptedData);
//			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
//			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
//			System.out.println("after data -->" + decryptedData);
			
//			int status=responseInJson.getInt("Status");
//			if(status==0) {
//				throw new Exception("unable to cancel IRN");
//			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		return finalResponse;

	}

//	public String generateBase64Code(String cancelIRN) {
//		// Encode to Base64
//
//		String encodedString = Base64.getEncoder().encodeToString(cancelIRN.getBytes());
//		System.out.println("Encoded string: " + encodedString);
//		return encodedString;
//
//	}
//	
	private String getEncodedJsonObjectForprocessEwaybillIrnRequst(EwaybillByIrn ewaybillByIrn, String sek) {
		String encodedMessage = "";
		JSONObject ewaybillMainObject = new JSONObject();
		
		try {
			Field changeMap = ewaybillMainObject.getClass().getDeclaredField("map");
			changeMap.setAccessible(true);
			changeMap.set(ewaybillMainObject, new LinkedHashMap<>());
			changeMap.setAccessible(false);
		} catch (IllegalAccessException | NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		
		ewaybillMainObject.put("Irn", ewaybillByIrn.getIrn());
		ewaybillMainObject.put("Distance", ewaybillByIrn.getDistance());
		ewaybillMainObject.put("TransMode", ewaybillByIrn.getTransMode());
		ewaybillMainObject.put("TransId", ewaybillByIrn.getTransId());
		ewaybillMainObject.put("TransName", ewaybillByIrn.getTransName());
		ewaybillMainObject.put("TrnDocDt", ewaybillByIrn.getTrnDocDt());
		ewaybillMainObject.put("TrnDocNo", ewaybillByIrn.getTrnDocNo());
		ewaybillMainObject.put("VehNo", ewaybillByIrn.getVehNo());
		ewaybillMainObject.put("VehType", ewaybillByIrn.getVehType());
		
		
		
		
		
		System.out.println("cancelMainObject    ------>      "+ewaybillMainObject.toString(4));
		
		
		
		
		try {

			String encodedJson = encodeBase64String(ewaybillMainObject.toString().getBytes());

			String encString = encryptBySymmetricKey(encodedJson, sek);
            
			System.out.println("encString: " + encString);

			System.out.println("/n/n/n/n");
			System.out.println("base64convertedcode     " + encodedJson);
			System.out.println("/n/n/n/n");

			
			encodedMessage = encString;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encodedMessage;

	}

//	private String encryptBySymmetricKey(String encodedString, String decryptedSek) throws Exception {
//		byte[] sekByte = null;
//		try {
//			sekByte = decodeBase64StringTOByte(decryptedSek);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.println("SEKBYTEJHHHHHHHHHHHHHHHHHHHDS     " + new String(sekByte));
//
//		Key aesKey = new SecretKeySpec(sekByte, "AES");
//		try {
//			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
//			byte[] encryptedjsonbytes = cipher.doFinal(encodedString.getBytes());
//			String encryptedJson = encodeBase64String(encryptedjsonbytes);
//			return encryptedJson;
//		} catch (Exception e) {
//			return "Exception " + e;
//		}
//	}
	
	
	
	
	
	
				
	}


