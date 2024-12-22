package com.fedcorp.admin.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import com.filenet.api.collection.ContentElementList;
import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.ContentTransfer;
import com.filenet.api.core.Factory.ContentElement;
import com.filenet.api.core.Factory.Document;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.core.ReferentialContainmentRelationship;
import com.filenet.api.property.Properties;


public class FileNetUpload {
	CEConnection ceConnection;
	private ObjectStore objStore;
	private ContentElementList contentList;
	private ContentTransfer contentTransfer;
	private FileInputStream fileInputStream;
	private Properties properties;
	private Folder myFolder;
	private TreeMap<String, String> mimeTypes;

	private String strUserName;
	private String strPassword;
	private String strStanza;
	private String strUri;
	private String strObjStore;
	private String strFolderName;
	private LinkedHashMap<String, String> lstDocId;

	public static final String FILE = "file";
	public static final String FOLDER = "folder";

	public FileNetUpload(String userName, String password, String stanza, String uri, String obStore,String folderName) {
		
		ceConnection = new CEConnection();
		mimeTypes = new TreeMap<String, String>();

		lstDocId = new LinkedHashMap<String, String>();
		strUserName = userName;
		strPassword = password;
		strStanza = stanza;
		strUri = uri;
		strObjStore = obStore;
		strFolderName = folderName;
		
	}

	@SuppressWarnings("unchecked")
	public LinkedHashMap<String, String> doUpload(File folder, String strFolderType, String strFormat) {

		try {
			ceConnection.establishConnection(strUserName, strPassword, strStanza, strUri);
			objStore = ceConnection.fetchOS(strObjStore);
		} catch (Exception e) {
			System.out.println("********Connection Not  Established please check....... ");
			e.printStackTrace();
			lstDocId.put(null, "Error in FileNet Connection");
			return lstDocId;
		}
		try {
		File f = new File(folder.getAbsolutePath());
		
//			System.out.println("********File Created");

			if (strFolderType.equals(FILE)) {
				mimeTypes = new GetMimeType().listFilesForFolder(f);
			} else if (strFolderType.equals(FOLDER)) {
				
				mimeTypes = new GetMimeType().listFilesForFolder(f, strFormat);
			}
			String strFileName = "";

			for (Map.Entry m : mimeTypes.entrySet()) {
//				System.out.println(" Inside Filenet Jar: " + m.getKey() + " :Key *** Value: " + m.getValue());
				com.filenet.api.core.Document doc1 = Document.createInstance(objStore, "FederalBankDocuments");
				contentList = ContentElement.createList();
//				System.out.println("******** ContentElementList Created");
				contentTransfer = com.filenet.api.core.Factory.ContentTransfer.createInstance(objStore);
				fileInputStream = new FileInputStream(new File(m.getKey().toString()));
				strFileName = m.getKey().toString().substring(m.getKey().toString().lastIndexOf("\\") + 1);
				contentTransfer.setCaptureSource(fileInputStream);
				contentTransfer.set_ContentType(m.getValue().toString());
				contentTransfer.set_RetrievalName(strFileName);
				contentList.add(contentTransfer);
//				System.out.println("********ContentList Added");
				doc1.set_ContentElements(contentList);
				properties = doc1.getProperties();
//				System.out.println(" ******Properties: " + properties.toString());
				properties.putValue("DocumentTitle", strFileName);

				doc1.set_MimeType(m.getValue().toString());
				doc1.save(RefreshMode.REFRESH);
				lstDocId.put(strFileName, doc1.get_Id().toString());
//				System.out.println("Doc ID: " + doc1.get_Id().toString());

				myFolder = com.filenet.api.core.Factory.Folder.fetchInstance(objStore, "/" + strFolderName, null);
//				System.out.println("******** Folder Created + " + myFolder.get_Id().toString());

				ReferentialContainmentRelationship rcr = myFolder.file(doc1, AutoUniqueName.AUTO_UNIQUE, null, DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
				System.out.println("******** File Added");
				rcr.save(RefreshMode.REFRESH);
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {                              
			System.out.println("FileNotFoundException filepath not getting.");
			e.printStackTrace();
			lstDocId.put(null, "Error in FileNet Uploading");
			return lstDocId;
		} finally {
			
		}

		return lstDocId;
	}

}
