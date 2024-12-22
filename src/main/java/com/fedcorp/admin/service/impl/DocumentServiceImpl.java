package com.fedcorp.admin.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fedcorp.admin.entities.Documents;
import com.fedcorp.admin.file.FileNetUpload;
import com.fedcorp.admin.repositories.DocumentsRepository;

@Service
public class DocumentServiceImpl {

	private String filepathloc;
	private String userName;
	private String password;
	private String stanza;
	private String uri;
	private String obStore;
	private String foldername;
	long document_store = 0L;
	boolean exception = false;
	String filenetkey = "";

	@Autowired
	private DocumentsRepository documentsRepository;

	public String fileUploadfolder(MultipartFile filePart, String uploadPath, String docname) throws IOException {
		
		String PDFFileName = docname;
		FileOutputStream outputStream = null;
		InputStream fileContent = null;
		try {
			outputStream = new FileOutputStream(new File(String.valueOf(uploadPath) + File.separator + PDFFileName));
			fileContent = filePart.getInputStream();
			int readBytes = 0;
			byte[] readArray = new byte[1024];
			while ((readBytes = fileContent.read(readArray)) != -1)
				outputStream.write(readArray, 0, readBytes);
		} catch (Exception ex) {

		} finally {
			if (outputStream != null) {
				outputStream.close();	
			}
			if (fileContent != null) {
				fileContent.close();
				
			}
		}
		System.out.println("upload file  into folder ....");
		return PDFFileName;

	}

	public String filenetupdate(Long document_id, String filenetkey) {
		String finalappstatus = "Failed";
		try {
			Documents documents = documentsRepository.findById(document_id).get();
			documents.setUpdatedAt(new java.util.Date());
			documents.setFilenetId(filenetkey);
			documentsRepository.save(documents);
			finalappstatus = "Success";
			System.out.println("update filenetid  into documents table....");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalappstatus;
	}

	public String filenetupdateToBlank(Long document_id, String filenetkey, Long appform_id) {
		String finalappstatus = "Failed";
		try {
			Documents documents = documentsRepository.findById(document_id).get();
			documents.setUpdatedAt(new java.util.Date());
			documents.setFilenetId(filenetkey + "  " + appform_id);
			documents.setApplicationFormId(0l);
			Documents updatedDocuments = documentsRepository.save(documents);
			if (updatedDocuments != null) {
				finalappstatus = "Success";
				System.out.println(" update filent id when error in filenet    into documents table ....");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalappstatus;

	}

	public Long documentform(Long appform_id, String documentname, String document_type) {
		String updocname = "";
		Long documentsId = null;
		Documents documents = new Documents();
		try {
			
			documents.setApplicationFormId(appform_id);
			documents.setDocument(documentname);
			documents.setCreatedAt(new java.util.Date());
			documents.setUpdatedAt(new java.util.Date());
			Documents newDocument = documentsRepository.save(documents);
			if (newDocument != null) {
				documentsId = newDocument.getId();
				
				updocname = String.valueOf(documentsId) + "_file.pdf";
				Documents getDocument = documentsRepository.findById(documentsId).get();
				getDocument.setUpdatedAt(new java.util.Date());
				getDocument.setDocumentType(document_type);
				getDocument.setDocument(updocname);
				documentsRepository.save(getDocument);
				System.out.println("update data  into documents table....");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error during documents update :"+e.getMessage());
		}
		return documentsId;
	}

	public LinkedHashMap<String, String> fileNetUpload(Long appform_id, String filepdfname) {
		
	
		LinkedHashMap<String, String> lstDocNo = new LinkedHashMap<>();
		FileNetUpload fnu = new FileNetUpload(this.userName, this.password, this.stanza, this.uri, this.obStore,this.foldername);
//		lstDocNo = fnu.doUpload(new File(String.valueOf(uploadPath) + File.separator + filepdfname), "file", null);
		System.out.println("----" + lstDocNo.keySet().size());
		return lstDocNo;
	}

	public String uploadPath(Long appform_id) {

		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
			this.filepathloc = System.getenv("fileuploadloc");
			this.userName = System.getenv("filenet_uname");
			this.password = System.getenv("filenet_pwd");
			this.stanza = System.getenv("filenet_stanza");
			this.uri = System.getenv("filenet_url");
			this.obStore = System.getenv("filenet_obStore");
			this.foldername = System.getenv("filenet_foldername");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String uploadPath = String.valueOf(this.filepathloc) + File.separator + appform_id;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		System.out.println("function return upload path : "+uploadPath);
		return uploadPath;

	}

}
