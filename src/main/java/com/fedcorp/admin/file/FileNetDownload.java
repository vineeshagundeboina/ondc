package com.fedcorp.admin.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import com.filenet.api.collection.ContentElementList;
import com.filenet.api.core.Connection;
import com.filenet.api.core.ContentTransfer;
import com.filenet.api.core.Document;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.property.Properties;
import com.filenet.api.util.Id;
import com.filenet.api.util.UserContext;

public class FileNetDownload {
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

	public FileNetDownload(String userName, String password, String stanza, String uri, String obStore,
			String folderName) {
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

	public static Double writeContent(InputStream s, String filename) throws IOException {
		// Open a buffered output stream to write the content to
		// a file named the same as the retrieval name
		BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(filename));
		Double size = new Double(0);
		int bufferSize;
		byte[] buffer = new byte[1024];
		// Loop through the content and write it to the system
		while ((bufferSize = s.read(buffer)) != -1) {
			size += bufferSize;
			writer.write(buffer, 0, bufferSize);
		}
		writer.close();
		s.close();
		return size;
	}

	public File doDownload(String strFileId) {

		ObjectStore os = null;
		Document doc1 = null;
		File file = null;
		File fileTo = null;
		try {
			ceConnection.establishConnection(strUserName, strPassword, strStanza, strUri);
			// stanza means to which module your are trying to get connected.

			// Get the connection
			Connection conn = Factory.Connection.getConnection(strUri);

			// Get the user context
			UserContext uc = UserContext.get();
			// Build the subject using the FileNetP8WSI stanza
			// Use the FileNetP8WSI stanza for CEWS
			uc.pushSubject(UserContext.createSubject(conn, strUserName, strPassword, strStanza));
			try {
				// Get the default domain
				Domain domain = Factory.Domain.getInstance(conn, null);
				// Get an object store
				os = Factory.ObjectStore.fetchInstance(domain, strObjStore, null);
				System.out.println("********ObjectStore Retrieved");
			} finally {
				uc.popSubject();
			}
			// Get the particular document using strFileId
			doc1 = Factory.Document.fetchInstance(os, new Id(strFileId), null);
			// Get the content elements
			ContentElementList elements = doc1.get_ContentElements();
			// Grab the first content element
			ContentTransfer element = (ContentTransfer) elements.get(0);
			String filename = element.get_RetrievalName();
			InputStream stream = element.accessContentStream();

			Double size = writeContent(stream, filename);
			Double expected = element.get_ContentSize();
			if (size != expected)
				System.err.println("Invalid content size retrieved : " + elements.size());
			for (Iterator<?> i = elements.iterator(); i.hasNext();) {

				element = (ContentTransfer) i.next();
				writeContent(element.accessContentStream(), "element" + element.get_ElementSequenceNumber());
				System.out.println("element : " + elements.toString());
			}
			file = new File("element" + element.get_ElementSequenceNumber());
			fileTo = new File("" + filename);
			System.out.println(file.getName() + " reached here: " + fileTo.getName());
		} catch (Exception e) {
			System.out.println("**** Error in getting file from file net server  ****");
			e.printStackTrace();
			return null;
		}
		return fileTo;
	}

}
