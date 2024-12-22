package com.splenta.gstreturns.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.splenta.gstreturns.pojo.gst.GSTR1ProccedFile;
import com.splenta.gstreturns.pojo.gst.GSTR1Summary;
import com.splenta.gstreturns.pojo.gst.filing.FileGstr1B2B;
import com.splenta.gstreturns.pojo.gst.filing.FileGstr1B2BA;
import com.splenta.gstreturns.pojo.gst.save.SaveGstr1B2B;
import com.splenta.gstreturns.pojo.gst.save.SaveGstr1B2BA;
import com.splenta.gstreturns.pojo.gst.save.SaveGstr1B2CL;
import com.splenta.gstreturns.pojo.gst.save.SaveGstr1B2CLA;
import com.splenta.gstreturns.pojo.gst.save.SaveGstr1B2CS;
import com.splenta.gstreturns.pojo.gst.save.SaveGstr1B2CSA;
import com.splenta.gstreturns.pojo.gst.submit.SubmitGSTR1;

@Service
public class GstService {

	@Autowired
	private EncryptionDecryptionService encryptionDecryptionService;

	private String getEncodedJsonObjectForprocessGSTR1B2BSave(SaveGstr1B2B saveGstr1B2B, String sek) {
		String encodedMessage = "";

		JSONObject ssaveGstr1B2B = new JSONObject();

		JSONObject B2BGSTR1 = new JSONObject();

		List<JSONObject> B2BGSTR1List = new ArrayList<JSONObject>();
		List<JSONObject> InvGSTR1List = new ArrayList<JSONObject>();
		List<JSONObject> ItmGSTR1List = new ArrayList<JSONObject>();

		JSONObject InvGSTR1 = new JSONObject();
		JSONObject ItmGSTR1 = new JSONObject();
		JSONObject ItmDetGSTR1 = new JSONObject();

		try {

			try {
				Field changeMap = ssaveGstr1B2B.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ssaveGstr1B2B, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = B2BGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(B2BGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = InvGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(InvGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = ItmGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = ItmDetGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmDetGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			ItmDetGSTR1.put("rt", saveGstr1B2B.getB2b().get(0).getInv().get(0).getItms().get(0).getItm_det().getRt());
			ItmDetGSTR1.put("txval",
					saveGstr1B2B.getB2b().get(0).getInv().get(0).getItms().get(0).getItm_det().getTxval());
			ItmDetGSTR1.put("iamt",
					saveGstr1B2B.getB2b().get(0).getInv().get(0).getItms().get(0).getItm_det().getIamt());
			ItmDetGSTR1.put("csamt",
					saveGstr1B2B.getB2b().get(0).getInv().get(0).getItms().get(0).getItm_det().getCsamt());

			ItmGSTR1.put("num", saveGstr1B2B.getB2b().get(0).getInv().get(0).getItms().get(0).getNum());
			ItmGSTR1.put("itm_det", ItmDetGSTR1);
			ItmGSTR1List.add(ItmGSTR1);

			InvGSTR1.put("inum", saveGstr1B2B.getB2b().get(0).getInv().get(0).getInum());
			InvGSTR1.put("idt", saveGstr1B2B.getB2b().get(0).getInv().get(0).getIdt());
			InvGSTR1.put("val", saveGstr1B2B.getB2b().get(0).getInv().get(0).getVal());
			InvGSTR1.put("pos", saveGstr1B2B.getB2b().get(0).getInv().get(0).getPos());
			InvGSTR1.put("rchrg", saveGstr1B2B.getB2b().get(0).getInv().get(0).getRchrg());
			InvGSTR1.put("etin", saveGstr1B2B.getB2b().get(0).getInv().get(0).getEtin());
			InvGSTR1.put("inv_typ", saveGstr1B2B.getB2b().get(0).getInv().get(0).getInv_typ());
			InvGSTR1.put("diff_percent", saveGstr1B2B.getB2b().get(0).getInv().get(0).getDiff_percent());
			InvGSTR1.put("itms", ItmGSTR1List);
			InvGSTR1List.add(InvGSTR1);

			B2BGSTR1.put("ctin", saveGstr1B2B.getB2b().get(0).getCtin());
			B2BGSTR1.put("inv", InvGSTR1List);

			B2BGSTR1List.add(B2BGSTR1);

			ssaveGstr1B2B.put("gstin", saveGstr1B2B.getGstin());
			ssaveGstr1B2B.put("fp", saveGstr1B2B.getFp());
			ssaveGstr1B2B.put("gt", saveGstr1B2B.getGt());
			ssaveGstr1B2B.put("cur_gt", saveGstr1B2B.getCur_gt());
			ssaveGstr1B2B.put("b2b", B2BGSTR1List);

			String encString = encryptionDecryptionService.encryptEK(ssaveGstr1B2B.toString().getBytes(),
					encryptionDecryptionService.decodeBase64StringTOByte(sek));
			// System.out.println("encString: " + encString);

			System.out.println("SaveGstr1B2B:   " + ssaveGstr1B2B.toString(4));
			// encodedMessage = encString;
			encodedMessage = encString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedMessage;
	}

	private String getEncodedJsonObjectForprocessGSTR1B2BASave(SaveGstr1B2BA saveGstr1B2B, String sek) {
		String encodedMessage = "";

		JSONObject ssaveGstr1B2B = new JSONObject();

		JSONObject B2BGSTR1 = new JSONObject();

		List<JSONObject> B2BGSTR1List = new ArrayList<JSONObject>();
		List<JSONObject> InvGSTR1List = new ArrayList<JSONObject>();
		List<JSONObject> ItmGSTR1List = new ArrayList<JSONObject>();

		JSONObject InvGSTR1 = new JSONObject();
		JSONObject ItmGSTR1 = new JSONObject();
		JSONObject ItmDetGSTR1 = new JSONObject();

		try {

			try {
				Field changeMap = ssaveGstr1B2B.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ssaveGstr1B2B, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = B2BGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(B2BGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = InvGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(InvGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = ItmGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = ItmDetGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmDetGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			ItmDetGSTR1.put("rt", saveGstr1B2B.getB2ba().get(0).getInv().get(0).getItms().get(0).getItm_det().getRt());
			ItmDetGSTR1.put("txval",
					saveGstr1B2B.getB2ba().get(0).getInv().get(0).getItms().get(0).getItm_det().getTxval());
			ItmDetGSTR1.put("iamt",
					saveGstr1B2B.getB2ba().get(0).getInv().get(0).getItms().get(0).getItm_det().getIamt());
			ItmDetGSTR1.put("camt",
					saveGstr1B2B.getB2ba().get(0).getInv().get(0).getItms().get(0).getItm_det().getCamt());
			ItmDetGSTR1.put("samt",
					saveGstr1B2B.getB2ba().get(0).getInv().get(0).getItms().get(0).getItm_det().getSamt());
			ItmDetGSTR1.put("csamt",
					saveGstr1B2B.getB2ba().get(0).getInv().get(0).getItms().get(0).getItm_det().getCsamt());

			ItmGSTR1.put("num", saveGstr1B2B.getB2ba().get(0).getInv().get(0).getItms().get(0).getNum());
			ItmGSTR1.put("itm_det", ItmDetGSTR1);
			ItmGSTR1List.add(ItmGSTR1);

			InvGSTR1.put("oinum", saveGstr1B2B.getB2ba().get(0).getInv().get(0).getOinum());
			InvGSTR1.put("oidt", saveGstr1B2B.getB2ba().get(0).getInv().get(0).getOidt());
			InvGSTR1.put("inum", saveGstr1B2B.getB2ba().get(0).getInv().get(0).getInum());
			InvGSTR1.put("idt", saveGstr1B2B.getB2ba().get(0).getInv().get(0).getIdt());
			InvGSTR1.put("val", saveGstr1B2B.getB2ba().get(0).getInv().get(0).getVal());
			InvGSTR1.put("pos", saveGstr1B2B.getB2ba().get(0).getInv().get(0).getPos());
			InvGSTR1.put("rchrg", saveGstr1B2B.getB2ba().get(0).getInv().get(0).getRchrg());
			InvGSTR1.put("etin", saveGstr1B2B.getB2ba().get(0).getInv().get(0).getEtin());
			InvGSTR1.put("inv_typ", saveGstr1B2B.getB2ba().get(0).getInv().get(0).getInv_typ());
			InvGSTR1.put("diff_percent", saveGstr1B2B.getB2ba().get(0).getInv().get(0).getDiff_percent());
			InvGSTR1.put("itms", ItmGSTR1List);
			InvGSTR1List.add(InvGSTR1);

			B2BGSTR1.put("ctin", saveGstr1B2B.getB2ba().get(0).getCtin());
			B2BGSTR1.put("inv", InvGSTR1List);

			B2BGSTR1List.add(B2BGSTR1);

			ssaveGstr1B2B.put("gstin", saveGstr1B2B.getGstin());
			ssaveGstr1B2B.put("fp", saveGstr1B2B.getFp());
			ssaveGstr1B2B.put("gt", saveGstr1B2B.getGt());
			ssaveGstr1B2B.put("cur_gt", saveGstr1B2B.getCur_gt());
			ssaveGstr1B2B.put("b2ba", B2BGSTR1List);

			String encString = encryptionDecryptionService.encryptEK(ssaveGstr1B2B.toString().getBytes(),
					encryptionDecryptionService.decodeBase64StringTOByte(sek));
			// System.out.println("encString: " + encString);

			System.out.println("SaveGstr1B2B:   " + ssaveGstr1B2B.toString(4));
			// encodedMessage = encString;
			encodedMessage = encString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedMessage;
	}

	private String getEncodedJsonObjectForprocessGSTR1B2CLSave(SaveGstr1B2CL saveGstr1B2CL, String sek) {
		String encodedMessage = "";

		JSONObject ssaveGstr1B2B = new JSONObject();

		JSONObject B2BGSTR1 = new JSONObject();

		List<JSONObject> B2BGSTR1List = new ArrayList<JSONObject>();
		List<JSONObject> InvGSTR1List = new ArrayList<JSONObject>();
		List<JSONObject> ItmGSTR1List = new ArrayList<JSONObject>();

		JSONObject InvGSTR1 = new JSONObject();
		JSONObject ItmGSTR1 = new JSONObject();
		JSONObject ItmDetGSTR1 = new JSONObject();

		try {

			try {
				Field changeMap = ssaveGstr1B2B.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ssaveGstr1B2B, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = B2BGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(B2BGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = InvGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(InvGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = ItmGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = ItmDetGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmDetGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			ItmDetGSTR1.put("rt", saveGstr1B2CL.getB2cl().get(0).getInv().get(0).getItms().get(0).getItm_det().getRt());
			ItmDetGSTR1.put("txval",
					saveGstr1B2CL.getB2cl().get(0).getInv().get(0).getItms().get(0).getItm_det().getTxval());
			ItmDetGSTR1.put("iamt",
					saveGstr1B2CL.getB2cl().get(0).getInv().get(0).getItms().get(0).getItm_det().getIamt());
			ItmDetGSTR1.put("csamt",
					saveGstr1B2CL.getB2cl().get(0).getInv().get(0).getItms().get(0).getItm_det().getCsamt());

			ItmGSTR1.put("num", saveGstr1B2CL.getB2cl().get(0).getInv().get(0).getItms().get(0).getNum());
			ItmGSTR1.put("itm_det", ItmDetGSTR1);
			ItmGSTR1List.add(ItmGSTR1);

			InvGSTR1.put("inum", saveGstr1B2CL.getB2cl().get(0).getInv().get(0).getInum());
			InvGSTR1.put("idt", saveGstr1B2CL.getB2cl().get(0).getInv().get(0).getIdt());
			InvGSTR1.put("val", saveGstr1B2CL.getB2cl().get(0).getInv().get(0).getVal());
			InvGSTR1.put("etin", saveGstr1B2CL.getB2cl().get(0).getInv().get(0).getEtin());
			InvGSTR1.put("diff_percent", saveGstr1B2CL.getB2cl().get(0).getInv().get(0).getDiff_percent());
			InvGSTR1.put("itms", ItmGSTR1List);
			InvGSTR1List.add(InvGSTR1);

			B2BGSTR1.put("pos", saveGstr1B2CL.getB2cl().get(0).getPos());
			B2BGSTR1.put("inv", InvGSTR1List);

			B2BGSTR1List.add(B2BGSTR1);

			ssaveGstr1B2B.put("gstin", saveGstr1B2CL.getGstin());
			ssaveGstr1B2B.put("fp", saveGstr1B2CL.getFp());
			ssaveGstr1B2B.put("gt", saveGstr1B2CL.getGt());
			ssaveGstr1B2B.put("cur_gt", saveGstr1B2CL.getCur_gt());
			ssaveGstr1B2B.put("b2cl", B2BGSTR1List);

			String encString = encryptionDecryptionService.encryptEK(ssaveGstr1B2B.toString().getBytes(),
					encryptionDecryptionService.decodeBase64StringTOByte(sek));
			// System.out.println("encString: " + encString);

			System.out.println("SaveGstr1B2B:   " + ssaveGstr1B2B.toString(4));
			// encodedMessage = encString;
			encodedMessage = encString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedMessage;
	}

	private String getEncodedJsonObjectForprocessGSTR1B2CLASave(SaveGstr1B2CLA saveGstr1B2CLA, String sek) {
		String encodedMessage = "";

		JSONObject ssaveGstr1B2B = new JSONObject();

		JSONObject B2BGSTR1 = new JSONObject();

		List<JSONObject> B2BGSTR1List = new ArrayList<JSONObject>();
		List<JSONObject> InvGSTR1List = new ArrayList<JSONObject>();
		List<JSONObject> ItmGSTR1List = new ArrayList<JSONObject>();

		JSONObject InvGSTR1 = new JSONObject();
		JSONObject ItmGSTR1 = new JSONObject();
		JSONObject ItmDetGSTR1 = new JSONObject();

		try {

			try {
				Field changeMap = ssaveGstr1B2B.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ssaveGstr1B2B, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = B2BGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(B2BGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = InvGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(InvGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = ItmGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = ItmDetGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmDetGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			ItmDetGSTR1.put("rt",
					saveGstr1B2CLA.getB2cla().get(0).getInv().get(0).getItms().get(0).getItm_det().getRt());
			ItmDetGSTR1.put("txval",
					saveGstr1B2CLA.getB2cla().get(0).getInv().get(0).getItms().get(0).getItm_det().getTxval());
			ItmDetGSTR1.put("iamt",
					saveGstr1B2CLA.getB2cla().get(0).getInv().get(0).getItms().get(0).getItm_det().getIamt());

			ItmGSTR1.put("num", saveGstr1B2CLA.getB2cla().get(0).getInv().get(0).getItms().get(0).getNum());
			ItmGSTR1.put("itm_det", ItmDetGSTR1);
			ItmGSTR1List.add(ItmGSTR1);

			InvGSTR1.put("oinum", saveGstr1B2CLA.getB2cla().get(0).getInv().get(0).getOinum());
			InvGSTR1.put("oidt", saveGstr1B2CLA.getB2cla().get(0).getInv().get(0).getOidt());
			InvGSTR1.put("diff_percent", saveGstr1B2CLA.getB2cla().get(0).getInv().get(0).getDiff_percent());
			InvGSTR1.put("inum", saveGstr1B2CLA.getB2cla().get(0).getInv().get(0).getInum());
			InvGSTR1.put("idt", saveGstr1B2CLA.getB2cla().get(0).getInv().get(0).getIdt());
			InvGSTR1.put("val", saveGstr1B2CLA.getB2cla().get(0).getInv().get(0).getVal());
			InvGSTR1.put("etin", saveGstr1B2CLA.getB2cla().get(0).getInv().get(0).getEtin());
			InvGSTR1.put("itms", ItmGSTR1List);
			InvGSTR1List.add(InvGSTR1);

			B2BGSTR1.put("pos", saveGstr1B2CLA.getB2cla().get(0).getPos());
			B2BGSTR1.put("inv", InvGSTR1List);

			B2BGSTR1List.add(B2BGSTR1);

			ssaveGstr1B2B.put("gstin", saveGstr1B2CLA.getGstin());
			ssaveGstr1B2B.put("fp", saveGstr1B2CLA.getFp());
			ssaveGstr1B2B.put("gt", saveGstr1B2CLA.getGt());
			ssaveGstr1B2B.put("cur_gt", saveGstr1B2CLA.getCur_gt());
			ssaveGstr1B2B.put("b2cl", B2BGSTR1List);

			String encString = encryptionDecryptionService.encryptEK(ssaveGstr1B2B.toString().getBytes(),
					encryptionDecryptionService.decodeBase64StringTOByte(sek));
			// System.out.println("encString: " + encString);

			System.out.println("SaveGstr1B2B:   " + ssaveGstr1B2B.toString(4));
			// encodedMessage = encString;
			encodedMessage = encString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedMessage;
	}

	private String getEncodedJsonObjectForprocessGSTR1B2CSSave(SaveGstr1B2CS saveGstr1B2CS, String sek) {
		String encodedMessage = "";

		JSONObject ssaveGstr1B2B = new JSONObject();

		JSONObject B2BGSTR1 = new JSONObject();

		List<JSONObject> B2BGSTR1List = new ArrayList<JSONObject>();
		List<JSONObject> InvGSTR1List = new ArrayList<JSONObject>();
		List<JSONObject> ItmGSTR1List = new ArrayList<JSONObject>();

		JSONObject InvGSTR1 = new JSONObject();
		JSONObject ItmGSTR1 = new JSONObject();
		JSONObject ItmDetGSTR1 = new JSONObject();
		JSONObject ItmDetGSTR2 = new JSONObject();

		try {

			try {
				Field changeMap = ssaveGstr1B2B.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ssaveGstr1B2B, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = B2BGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(B2BGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = InvGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(InvGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = ItmGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = ItmDetGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmDetGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}
			try {
				Field changeMap = ItmDetGSTR2.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmDetGSTR2, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}
			ItmDetGSTR1.put("sply_ty", saveGstr1B2CS.getB2cs().get(0).getSply_ty());
			ItmDetGSTR1.put("diff_percent", saveGstr1B2CS.getB2cs().get(0).getDiff_percent());
			ItmDetGSTR1.put("rt", saveGstr1B2CS.getB2cs().get(0).getRt());
			ItmDetGSTR1.put("typ", saveGstr1B2CS.getB2cs().get(0).getTyp());
			ItmDetGSTR1.put("etin", saveGstr1B2CS.getB2cs().get(0).getEtin());
			ItmDetGSTR1.put("pos", saveGstr1B2CS.getB2cs().get(0).getPos());
			ItmDetGSTR1.put("txval", saveGstr1B2CS.getB2cs().get(0).getTxval());
			ItmDetGSTR1.put("iamt", saveGstr1B2CS.getB2cs().get(0).getIamt());
			ItmDetGSTR1.put("csamt", saveGstr1B2CS.getB2cs().get(0).getCsamt());

			ItmDetGSTR2.put("sply_ty", saveGstr1B2CS.getB2cs().get(1).getSply_ty());
			ItmDetGSTR2.put("diff_percent", saveGstr1B2CS.getB2cs().get(1).getDiff_percent());
			ItmDetGSTR2.put("rt", saveGstr1B2CS.getB2cs().get(1).getRt());
			ItmDetGSTR2.put("typ", saveGstr1B2CS.getB2cs().get(1).getTyp());
			ItmDetGSTR2.put("etin", saveGstr1B2CS.getB2cs().get(1).getEtin());
			ItmDetGSTR2.put("pos", saveGstr1B2CS.getB2cs().get(1).getPos());
			ItmDetGSTR2.put("txval", saveGstr1B2CS.getB2cs().get(1).getTxval());
			ItmDetGSTR2.put("iamt", saveGstr1B2CS.getB2cs().get(1).getIamt());
			ItmDetGSTR2.put("csamt", saveGstr1B2CS.getB2cs().get(1).getCsamt());

			// ItmGSTR1.put("itm_det", ItmDetGSTR1);
			ItmGSTR1List.add(ItmDetGSTR1);
			ItmGSTR1List.add(ItmDetGSTR2);

			ssaveGstr1B2B.put("gstin", saveGstr1B2CS.getGstin());
			ssaveGstr1B2B.put("fp", saveGstr1B2CS.getFp());
			ssaveGstr1B2B.put("gt", saveGstr1B2CS.getGt());
			ssaveGstr1B2B.put("cur_gt", saveGstr1B2CS.getCur_gt());
			ssaveGstr1B2B.put("b2cs", ItmGSTR1List);

			String encString = encryptionDecryptionService.encryptEK(ssaveGstr1B2B.toString().getBytes(),
					encryptionDecryptionService.decodeBase64StringTOByte(sek));
			// System.out.println("encString: " + encString);

			System.out.println("SaveGstr1B2B:   " + ssaveGstr1B2B.toString(4));
			// encodedMessage = encString;
			encodedMessage = encString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedMessage;
	}

	private String getEncodedJsonObjectForprocessGSTR1B2CSASave(SaveGstr1B2CSA saveGstr1B2CSA, String sek) {
		String encodedMessage = "";

		JSONObject ssaveGstr1B2B = new JSONObject();

		JSONObject B2BGSTR1 = new JSONObject();

		List<JSONObject> B2BGSTR1List = new ArrayList<JSONObject>();
		List<JSONObject> InvGSTR1List = new ArrayList<JSONObject>();
		List<JSONObject> ItmGSTR1List = new ArrayList<JSONObject>();

		JSONObject InvGSTR1 = new JSONObject();
		JSONObject ItmGSTR1 = new JSONObject();
		JSONObject ItmDetGSTR1 = new JSONObject();
		JSONObject ItmDetGSTR2 = new JSONObject();

		try {

			try {
				Field changeMap = ssaveGstr1B2B.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ssaveGstr1B2B, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = B2BGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(B2BGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = InvGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(InvGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = ItmGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = ItmDetGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmDetGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}
			try {
				Field changeMap = ItmDetGSTR2.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ItmDetGSTR2, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}
			ItmDetGSTR1.put("rt", saveGstr1B2CSA.getB2csa().get(0).getItms().get(0).getRt());
			ItmDetGSTR1.put("txval", saveGstr1B2CSA.getB2csa().get(0).getItms().get(0).getTxval());
			ItmDetGSTR1.put("iamt", saveGstr1B2CSA.getB2csa().get(0).getItms().get(0).getIamt());
			ItmDetGSTR1.put("camt", saveGstr1B2CSA.getB2csa().get(0).getItms().get(0).getCamt());
			ItmDetGSTR1.put("samt", saveGstr1B2CSA.getB2csa().get(0).getItms().get(0).getSamt());
			ItmDetGSTR1.put("csamt", saveGstr1B2CSA.getB2csa().get(0).getItms().get(0).getCsamt());

			ItmDetGSTR2.put("rt", saveGstr1B2CSA.getB2csa().get(0).getItms().get(1).getRt());
			ItmDetGSTR2.put("txval", saveGstr1B2CSA.getB2csa().get(0).getItms().get(1).getTxval());
			ItmDetGSTR2.put("iamt", saveGstr1B2CSA.getB2csa().get(0).getItms().get(1).getIamt());
			ItmDetGSTR2.put("camt", saveGstr1B2CSA.getB2csa().get(0).getItms().get(1).getCamt());
			ItmDetGSTR2.put("samt", saveGstr1B2CSA.getB2csa().get(0).getItms().get(1).getSamt());
			ItmDetGSTR2.put("csamt", saveGstr1B2CSA.getB2csa().get(0).getItms().get(1).getCsamt());

			// ItmGSTR1.put("itm_det", ItmDetGSTR1);
			ItmGSTR1List.add(ItmDetGSTR1);
			ItmGSTR1List.add(ItmDetGSTR2);

			B2BGSTR1.put("omon", saveGstr1B2CSA.getB2csa().get(0).getOmon());
			B2BGSTR1.put("sply_ty", saveGstr1B2CSA.getB2csa().get(0).getSply_ty());
			B2BGSTR1.put("diff_percent", saveGstr1B2CSA.getB2csa().get(0).getDiff_percent());
			B2BGSTR1.put("typ", saveGstr1B2CSA.getB2csa().get(0).getTyp());
			B2BGSTR1.put("etin", saveGstr1B2CSA.getB2csa().get(0).getEtin());
			B2BGSTR1.put("pos", saveGstr1B2CSA.getB2csa().get(0).getPos());
			B2BGSTR1.put("itms", ItmGSTR1List);
			B2BGSTR1List.add(B2BGSTR1);

			ssaveGstr1B2B.put("gstin", saveGstr1B2CSA.getGstin());
			ssaveGstr1B2B.put("fp", saveGstr1B2CSA.getFp());
			ssaveGstr1B2B.put("gt", saveGstr1B2CSA.getGt());
			ssaveGstr1B2B.put("cur_gt", saveGstr1B2CSA.getCur_gt());
			ssaveGstr1B2B.put("b2csa", B2BGSTR1List);

			String encString = encryptionDecryptionService.encryptEK(ssaveGstr1B2B.toString().getBytes(),
					encryptionDecryptionService.decodeBase64StringTOByte(sek));
			// System.out.println("encString: " + encString);

			System.out.println("SaveGstr1B2B:   " + ssaveGstr1B2B.toString(4));
			// encodedMessage = encString;
			encodedMessage = encString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedMessage;
	}

	private String getEncodedJsonObjectForprocessGSTR1B2BFiling(FileGstr1B2B fileGstr1B2B, String sek) {
		String encodedMessage = "";

		JSONObject ssaveGstr1B2B = new JSONObject();

		JSONObject B2BGSTR1 = new JSONObject();

		List<JSONObject> B2BGSTR1List = new ArrayList<JSONObject>();

		try {

			try {
				Field changeMap = ssaveGstr1B2B.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ssaveGstr1B2B, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = B2BGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(B2BGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			B2BGSTR1.put("sec_nm", fileGstr1B2B.getSec_sum().get(0).getSec_nm());
			B2BGSTR1.put("chksum", fileGstr1B2B.getSec_sum().get(0).getChksum());
			B2BGSTR1.put("ttl_rec", fileGstr1B2B.getSec_sum().get(0).getTtl_rec());
			B2BGSTR1.put("ttl_tax", fileGstr1B2B.getSec_sum().get(0).getTtl_tax());
			B2BGSTR1.put("ttl_igst", fileGstr1B2B.getSec_sum().get(0).getTtl_igst());
			B2BGSTR1.put("ttl_sgst", fileGstr1B2B.getSec_sum().get(0).getTtl_sgst());
			B2BGSTR1.put("ttl_cgst", fileGstr1B2B.getSec_sum().get(0).getTtl_cgst());
			B2BGSTR1.put("ttl_cess", fileGstr1B2B.getSec_sum().get(0).getTtl_cess());
			B2BGSTR1.put("ttl_val", fileGstr1B2B.getSec_sum().get(0).getTtl_val());
			B2BGSTR1List.add(B2BGSTR1);

			ssaveGstr1B2B.put("gstin", fileGstr1B2B.getGstin());
			ssaveGstr1B2B.put("ret_period", fileGstr1B2B.getRet_period());
			ssaveGstr1B2B.put("chksum", fileGstr1B2B.getChksum());
			ssaveGstr1B2B.put("newSumFlag", fileGstr1B2B.getNewSumFlag());
			ssaveGstr1B2B.put("sec_sum", B2BGSTR1List);

			String encString = encryptionDecryptionService.encryptEK(ssaveGstr1B2B.toString().getBytes(),
					encryptionDecryptionService.decodeBase64StringTOByte(sek));
			// System.out.println("encString: " + encString);

			System.out.println("SaveGstr1B2B:   " + ssaveGstr1B2B.toString(4));
			// encodedMessage = encString;
			encodedMessage = encString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedMessage;
	}

	private String getEncodedJsonObjectForprocessGSTR1B2BAFiling(FileGstr1B2BA fileGstr1B2BA, String sek) {
		String encodedMessage = "";

		JSONObject ssaveGstr1B2B = new JSONObject();

		JSONObject B2BGSTR1 = new JSONObject();

		List<JSONObject> B2BGSTR1List = new ArrayList<JSONObject>();

		try {

			try {
				Field changeMap = ssaveGstr1B2B.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ssaveGstr1B2B, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			try {
				Field changeMap = B2BGSTR1.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(B2BGSTR1, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			B2BGSTR1.put("sec_nm", fileGstr1B2BA.getSec_sum().get(0).getSec_nm());
			B2BGSTR1.put("chksum", fileGstr1B2BA.getSec_sum().get(0).getChksum());
			B2BGSTR1.put("ttl_rec", fileGstr1B2BA.getSec_sum().get(0).getTtl_rec());
			B2BGSTR1.put("ttl_tax", fileGstr1B2BA.getSec_sum().get(0).getTtl_tax());
			B2BGSTR1.put("ttl_igst", fileGstr1B2BA.getSec_sum().get(0).getTtl_igst());
			B2BGSTR1.put("ttl_sgst", fileGstr1B2BA.getSec_sum().get(0).getTtl_sgst());
			B2BGSTR1.put("ttl_cgst", fileGstr1B2BA.getSec_sum().get(0).getTtl_cgst());
			B2BGSTR1.put("ttl_val", fileGstr1B2BA.getSec_sum().get(0).getTtl_val());
			B2BGSTR1.put("ttl_cess", fileGstr1B2BA.getSec_sum().get(0).getTtl_cess());
			B2BGSTR1.put("act_tax", fileGstr1B2BA.getSec_sum().get(0).getTtl_rec());
			B2BGSTR1.put("act_igst", fileGstr1B2BA.getSec_sum().get(0).getTtl_tax());
			B2BGSTR1.put("act_sgst", fileGstr1B2BA.getSec_sum().get(0).getTtl_igst());
			B2BGSTR1.put("act_cgst", fileGstr1B2BA.getSec_sum().get(0).getTtl_sgst());
			B2BGSTR1.put("act_val", fileGstr1B2BA.getSec_sum().get(0).getTtl_cgst());
			B2BGSTR1.put("act_cess", fileGstr1B2BA.getSec_sum().get(0).getTtl_val());

			B2BGSTR1List.add(B2BGSTR1);

			ssaveGstr1B2B.put("gstin", fileGstr1B2BA.getGstin());
			ssaveGstr1B2B.put("ret_period", fileGstr1B2BA.getRet_period());
			ssaveGstr1B2B.put("chksum", fileGstr1B2BA.getChksum());
			ssaveGstr1B2B.put("newSumFlag", fileGstr1B2BA.getNewSumFlag());
			ssaveGstr1B2B.put("sec_sum", B2BGSTR1List);

			String encString = encryptionDecryptionService.encryptEK(ssaveGstr1B2B.toString().getBytes(),
					encryptionDecryptionService.decodeBase64StringTOByte(sek));
			// System.out.println("encString: " + encString);

			System.out.println("SaveGstr1B2B:   " + ssaveGstr1B2B.toString(4));
			// encodedMessage = encString;
			encodedMessage = encString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedMessage;
	}

	private String getEncodedJsonObjectForprocessGSTR1Submit(SubmitGSTR1 submitGSTR1, String sek) {

		String encodedMessage = "";

		JSONObject ssaveGstr1B2B = new JSONObject();
		try {

			try {
				Field changeMap = ssaveGstr1B2B.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ssaveGstr1B2B, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			ssaveGstr1B2B.put("gstin", submitGSTR1.getGstin());
			ssaveGstr1B2B.put("ret_period", submitGSTR1.getRet_period());
			ssaveGstr1B2B.put("generate_summary", submitGSTR1.getGenerate_summary());

			String encString = encryptionDecryptionService.encryptEK(ssaveGstr1B2B.toString().getBytes(),
					encryptionDecryptionService.decodeBase64StringTOByte(sek));

			System.out.println("SaveGstr1B2B:   " + ssaveGstr1B2B.toString(4));
			encodedMessage = encString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedMessage;

	}

	private String getEncodedJsonObjectForproccedFileGSTR1(GSTR1ProccedFile gSTR1ProccedFile, String sek) {
		String encodedMessage = "";

		JSONObject ssaveGstr1B2B = new JSONObject();
		try {

			try {
				Field changeMap = ssaveGstr1B2B.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ssaveGstr1B2B, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

			ssaveGstr1B2B.put("gstin", gSTR1ProccedFile.getGstin());
			ssaveGstr1B2B.put("ret_period", gSTR1ProccedFile.getRet_period());
			ssaveGstr1B2B.put("isnil", gSTR1ProccedFile.getIsnil());
			String encString = encryptionDecryptionService.encryptEK(ssaveGstr1B2B.toString().getBytes(),
					encryptionDecryptionService.decodeBase64StringTOByte(sek));
			// System.out.println("encString: " + encString);

			System.out.println("SaveGstr1B2B:   " + ssaveGstr1B2B.toString(4));
			encodedMessage = encString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedMessage;
	}

	private String getEncodedJsonObjectForGSTR1Summary(GSTR1Summary gSTR1Summary, String sek) {
		String encodedMessage = "";

		JSONObject ssaveGstr1B2B = new JSONObject();
		try {

			try {
				Field changeMap = ssaveGstr1B2B.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(ssaveGstr1B2B, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}

//			ssaveGstr1B2B.put("gstin", gSTR1Summary.getGstin());
//			ssaveGstr1B2B.put("ret_period", gSTR1Summary.getRet_period());
//			ssaveGstr1B2B.put("isnil", gSTR1Summary.getIsnil());
			String encString = encryptionDecryptionService.encryptEK(ssaveGstr1B2B.toString().getBytes(),
					encryptionDecryptionService.decodeBase64StringTOByte(sek));
			// System.out.println("encString: " + encString);

			System.out.println("SaveGstr1B2B:   " + ssaveGstr1B2B.toString(4));
			encodedMessage = encString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedMessage;
	}

	public String saveGSTR1B2B(SaveGstr1B2B saveGstr1B2B, String sek) {
		String encodedMessage = getEncodedJsonObjectForprocessGSTR1B2BSave(saveGstr1B2B, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		String response = "";
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETSAVE");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v3.0/returns/gstr1", HttpMethod.PUT, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());

			String encryptedRek = responseInJson.getString("rek");
			String encryptedData = responseInJson.getString("data");
			System.out.println("before rek -->" + encryptedRek);
			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
			System.out.println("after rek -->" + decryptedRek);
			System.out.println("before data -->" + encryptedData);
			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;
	}

	public String saveGSTR1B2BA(SaveGstr1B2BA saveGstr1B2BA, String sek) {
		String encodedMessage = getEncodedJsonObjectForprocessGSTR1B2BASave(saveGstr1B2BA, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		String response = "";
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETSAVE");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v3.0/returns/gstr1", HttpMethod.PUT, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
			String encryptedRek = responseInJson.getString("rek");
			String encryptedData = responseInJson.getString("data");
			System.out.println("before rek -->" + encryptedRek);
			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
			System.out.println("after rek -->" + decryptedRek);
			System.out.println("before data -->" + encryptedData);
			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;
	}

	public String saveGSTR1B2CL(SaveGstr1B2CL saveGstr1B2CL, String sek) {
		String encodedMessage = getEncodedJsonObjectForprocessGSTR1B2CLSave(saveGstr1B2CL, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		String response = "";
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETSAVE");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v3.0/returns/gstr1", HttpMethod.PUT, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
			String encryptedRek = responseInJson.getString("rek");
			String encryptedData = responseInJson.getString("data");
			System.out.println("before rek -->" + encryptedRek);
			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
			System.out.println("after rek -->" + decryptedRek);
			System.out.println("before data -->" + encryptedData);
			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;
	}

	public String saveGSTR1B2CLA(SaveGstr1B2CLA saveGstr1B2CLA, String sek) {
		String encodedMessage = getEncodedJsonObjectForprocessGSTR1B2CLASave(saveGstr1B2CLA, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		String response = "";
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETSAVE");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v3.0/returns/gstr1", HttpMethod.PUT, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
			String encryptedRek = responseInJson.getString("rek");
			String encryptedData = responseInJson.getString("data");
			System.out.println("before rek -->" + encryptedRek);
			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
			System.out.println("after rek -->" + decryptedRek);
			System.out.println("before data -->" + encryptedData);
			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}

		return response;
	}

	public String saveGSTR1B2CSA(SaveGstr1B2CSA saveGstr1B2CSA, String sek) {
		String encodedMessage = getEncodedJsonObjectForprocessGSTR1B2CSASave(saveGstr1B2CSA, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		String response = "";
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETSAVE");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v3.0/returns/gstr1", HttpMethod.PUT, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
			String encryptedRek = responseInJson.getString("rek");
			String encryptedData = responseInJson.getString("data");
			System.out.println("before rek -->" + encryptedRek);
			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
			System.out.println("after rek -->" + decryptedRek);
			System.out.println("before data -->" + encryptedData);
			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}

		return response;
	}

	public String saveGSTR1B2CS(SaveGstr1B2CS saveGstr1B2CS, String sek) {
		String encodedMessage = getEncodedJsonObjectForprocessGSTR1B2CSSave(saveGstr1B2CS, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		String response = "";
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETSAVE");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v3.0/returns/gstr1", HttpMethod.PUT, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
			String encryptedRek = responseInJson.getString("rek");
			String encryptedData = responseInJson.getString("data");
			System.out.println("before rek -->" + encryptedRek);
			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
			System.out.println("after rek -->" + decryptedRek);
			System.out.println("before data -->" + encryptedData);
			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;
	}

	public String fileGSTR1B2B(FileGstr1B2B fileGstr1B2B, String sek) {
		String response = "";
		String encodedMessage = getEncodedJsonObjectForprocessGSTR1B2BFiling(fileGstr1B2B, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETFILE");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v4.0/returns/gstr1", HttpMethod.PUT, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
//			String encryptedRek = responseInJson.getString("rek");
//			String encryptedData = responseInJson.getString("data");
//			System.out.println("before rek -->" + encryptedRek);
//			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
//			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
//			System.out.println("after rek -->" + decryptedRek);
//			System.out.println("before data -->" + encryptedData);
//			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
//			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
//			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
//			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
//
//			System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;
	}

	public String fileGSTR1B2BA(FileGstr1B2BA fileGstr1B2BA, String sek) {
		String response = "";
		String encodedMessage = getEncodedJsonObjectForprocessGSTR1B2BAFiling(fileGstr1B2BA, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETFILE");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v4.0/returns/gstr1", HttpMethod.PUT, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
			String encryptedRek = responseInJson.getString("rek");
			String encryptedData = responseInJson.getString("data");
			System.out.println("before rek -->" + encryptedRek);
			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
			System.out.println("after rek -->" + decryptedRek);
			System.out.println("before data -->" + encryptedData);
			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;
	}

	public String fileGSTR1B2CL(FileGstr1B2B fileGstr1B2B, String sek) {
		String response = "";
		String encodedMessage = getEncodedJsonObjectForprocessGSTR1B2BFiling(fileGstr1B2B, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETFILE");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v4.0/returns/gstr1", HttpMethod.PUT, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
			String encryptedRek = responseInJson.getString("rek");
			String encryptedData = responseInJson.getString("data");
			System.out.println("before rek -->" + encryptedRek);
			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
			System.out.println("after rek -->" + decryptedRek);
			System.out.println("before data -->" + encryptedData);
			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;
	}

	public String fileGSTR1B2CS(FileGstr1B2B fileGstr1B2B, String sek) {
		String response = "";
		String encodedMessage = getEncodedJsonObjectForprocessGSTR1B2BFiling(fileGstr1B2B, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETFILE");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v4.0/returns/gstr1", HttpMethod.PUT, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
			String encryptedRek = responseInJson.getString("rek");
			String encryptedData = responseInJson.getString("data");
			System.out.println("before rek -->" + encryptedRek);
			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
			System.out.println("after rek -->" + decryptedRek);
			System.out.println("before data -->" + encryptedData);
			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;
	}

	public String fileGSTR1B2CSA(FileGstr1B2BA fileGstr1B2BA, String sek) {
		String response = "";
		String encodedMessage = getEncodedJsonObjectForprocessGSTR1B2BAFiling(fileGstr1B2BA, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETFILE");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v4.0/returns/gstr1", HttpMethod.PUT, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
			String encryptedRek = responseInJson.getString("rek");
			String encryptedData = responseInJson.getString("data");
			System.out.println("before rek -->" + encryptedRek);
			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
			System.out.println("after rek -->" + decryptedRek);
			System.out.println("before data -->" + encryptedData);
			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;
	}

	public String fileGSTR1HSN(FileGstr1B2B fileGstr1B2B, String sek) {
		String response = "";
		String encodedMessage = getEncodedJsonObjectForprocessGSTR1B2BFiling(fileGstr1B2B, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETFILE");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v4.0/returns/gstr1", HttpMethod.PUT, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
			String encryptedRek = responseInJson.getString("rek");
			String encryptedData = responseInJson.getString("data");
			System.out.println("before rek -->" + encryptedRek);
			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
			System.out.println("after rek -->" + decryptedRek);
			System.out.println("before data -->" + encryptedData);
			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	public String submitGSTR1(SubmitGSTR1 submitGSTR1, String sek) {
		String response = "";
		String encodedMessage = getEncodedJsonObjectForprocessGSTR1Submit(submitGSTR1, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETSUBMIT");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v4.0/returns/gstr1", HttpMethod.PUT, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
			String encryptedRek = responseInJson.getString("rek");
			String encryptedData = responseInJson.getString("data");
			System.out.println("before rek -->" + encryptedRek);
			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
			System.out.println("after rek -->" + decryptedRek);
			System.out.println("before data -->" + encryptedData);
			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;
	}

	public String getGSTR1Summary(String gstin, String ret_period, String refid, String sek) {

		String response = "";
		// String encodedMessage =
		// getEncodedJsonObjectForprocessGSTR1B2BFiling(fileGstr1B2B, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
//			JSONObject requestPayload = new JSONObject();
//			requestPayload.put("action", "RETFILE");
//			requestPayload.put("data", encodedMessage);
//			requestPayload.put("hmac",
//					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));
//
//			System.out.println("\n\n\n:");
//			System.out.println(requestPayload);
//			System.out.println("\n\n\n:");
//			https://uatapi.alankitgst.com/taxpayerapi/v0.3/returns?gstin=27AAICN6997Q3Z4&ret_period=072017&ref_id=0a0cd3f6-148d-41e0-ac1d-f03af957d666&action=RETSTATUS

			// String
			// url="https://uatapi.alankitgst.com/taxpayerapi/v0.3/returns?gstin=27AAICN6997Q3Z4&ret_period=072017&ref_id=8bcf4185-3f1f-41f5-b9f0-bf281927a24e&action=RETSTATUS";
			String url = "https://uatapi.alankitgst.com/taxpayerapi/v0.3/returns?gstin=" + gstin + "&ret_period="
					+ ret_period + "&ref_id=" + refid + "&action=RETSTATUS";
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
			String encryptedRek = responseInJson.getString("rek");
			String encryptedData = responseInJson.getString("data");
			System.out.println("before rek -->" + encryptedRek);
			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
			System.out.println("after rek -->" + decryptedRek);
			System.out.println("before data -->" + encryptedData);
			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			System.out.println("after data -->" + response);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;
	}

	public String proccedToFileGSTR1(GSTR1ProccedFile gSTR1ProccedFile, String sek) {

		String response = "";
		String encodedMessage = getEncodedJsonObjectForproccedFileGSTR1(gSTR1ProccedFile, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		try {

			JSONObject hdrValues = new JSONObject();
			hdrValues.put("clientid", "l7xxda1af7c62c6c40449602e5a9f448f2ef");
			hdrValues.put("username", "MH_NT2.2664");
			hdrValues.put("state-cd", "27");
			hdrValues.put("ip-usr", "10.20.3.11");
			hdrValues.put("txn", "LAPN24235325555");
			hdrValues.put("gstin", "27AAICN6997Q3Z4");
			hdrValues.put("auth-token", "501fa6e1148d4a27aac7d23e0f7c528c");
			hdrValues.put("ret_period", "072017");
			hdrValues.put("Api version", "");
			hdrValues.put("rtn_typ", "");
			hdrValues.put("User Role", "");
			hdrValues.put("Client id", "");

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "RETNEWPTF");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			requestPayload.put("hdr", hdrValues);

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v1.0/returns/gstrptf", HttpMethod.POST, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
//			String encryptedRek = responseInJson.getString("rek");
//			String encryptedData = responseInJson.getString("data");
//			System.out.println("before rek -->" + encryptedRek);
//			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
//			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
//			System.out.println("after rek -->" + decryptedRek);
//			System.out.println("before data -->" + encryptedData);
//			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
//			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
//			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
//			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			// System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	public String generateSummaryGSTR1(GSTR1Summary gSTR1Summary, String sek) {

		String response = "";
		String encodedMessage = getEncodedJsonObjectForGSTR1Summary(gSTR1Summary, sek);
		HttpHeaders headers = encryptionDecryptionService.getHeaders();
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();
			requestPayload.put("action", "GENSUM");
			requestPayload.put("data", encodedMessage);
			requestPayload.put("hmac",
					encryptionDecryptionService.HMAC_Encrypt(encodedMessage.getBytes(), sek.getBytes()));

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://uatapi.alankitgst.com/taxpayerapi/v1.0/returns/gstr1", HttpMethod.POST, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());
//			String encryptedRek = responseInJson.getString("rek");
//			String encryptedData = responseInJson.getString("data");
//			System.out.println("before rek -->" + encryptedRek);
//			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
//			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
//			System.out.println("after rek -->" + decryptedRek);
//			System.out.println("before data -->" + encryptedData);
//			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
//			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
//			decryptedData = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));
//			response = new String(encryptionDecryptionService.decodeBase64StringTOByte(decryptedData));

			// System.out.println("after data -->" + encryptedData);
			System.out.println("responseInJson: " + responseInJson.toString(4));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

}
