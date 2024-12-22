package com.fedcorp.admin.file;

import java.io.File;
import java.io.FileInputStream;
import java.util.TreeMap;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

public class GetMimeType {
	private String temp = "";
	private TreeMap<String, String> tm;

	public GetMimeType() {
		tm = new TreeMap<String, String>();
	}

	public TreeMap<String, String> listFilesForFolder(final File folder) {

		// System.out.println(mimeTypes);
		System.out.println(" Inside Filenet Jar" + folder.isFile() + " ***** " + folder.getAbsolutePath());
		if (folder.isFile()) {
			try {
				ContentHandler contenthandler = new BodyContentHandler();
				Metadata metadata = new Metadata();
				metadata.set(metadata.RESOURCE_NAME_KEY, folder.getName());

				FileInputStream is = new FileInputStream(folder.getAbsoluteFile());
				Parser parser = new AutoDetectParser();
				// OOXMLParser parser = new OOXMLParser();
				try {
					System.out.println("contenthandler: " + contenthandler);
					System.out.println("metadata: " + metadata);
					parser.parse(is, contenthandler, metadata);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.toString());
				}

				System.out.println(" Inside Filenet Jar" + "Mime: " + metadata.get(Metadata.CONTENT_TYPE));
				tm.put((folder.getAbsolutePath()), metadata.get(Metadata.CONTENT_TYPE).toString());

//			  MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");//MimeUtils
//			  Collection<?> mimeTypes = MimeUtil.getMimeTypes(folder.getAbsoluteFile());
//			   tm.put((folder.getAbsolutePath()),mimeTypes.toString());

//			  FileNameMap fileNameMap = URLConnection.getFileNameMap();					//java.net
//		      String type = fileNameMap.getContentTypeFor(folder.getAbsolutePath());
//			  tm.put((folder.getAbsolutePath()),type);
				// System.out.println("File= " + folder.getAbsolutePath()+"
				// **MimeType:"+Files.probeContentType(Paths.get(folder.getAbsolutePath())));
				// tm.put((folder.getAbsolutePath()),Files.probeContentType(Paths.get(folder.getAbsolutePath())));
				// //java.nio.file
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {

			for (final File fileEntry : folder.listFiles()) {
				if (fileEntry.isDirectory()) {
					System.out.println(" Inside Filenet Jar: file only Folder part:  checking: "
							+ "Reading files under the folder " + folder.getAbsolutePath());
					listFilesForFolder(fileEntry);
				} else {
					if (fileEntry.isFile()) {
						temp = fileEntry.getName();
						// if ((strFormat.equals(null)||strFormat==null) &&
						// (temp.substring(temp.lastIndexOf('.') + 1,
						// temp.length()).toLowerCase()).equals(strFormat)){
						// Path source = Paths.get(folder.getAbsolutePath()+ "\\" +
						// fileEntry.getName());
						try {
							ContentHandler contenthandler = new BodyContentHandler();
							Metadata metadata = new Metadata();
							metadata.set(Metadata.RESOURCE_NAME_KEY, folder.getName());
							FileInputStream is = new FileInputStream(folder.getAbsoluteFile());
							Parser parser = new AutoDetectParser();
							// OOXMLParser parser = new OOXMLParser();
							parser.parse(is, contenthandler, metadata);
							System.out.println(" Inside Filenet Jar: file only folder part: fileOnly:  checking: "
									+ "Mime: " + metadata.get(Metadata.CONTENT_TYPE));
							tm.put((folder.getAbsolutePath()), metadata.get(Metadata.CONTENT_TYPE).toString());

//        	   MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
// 			  Collection<?> mimeTypes = MimeUtil.getMimeTypes(folder.getAbsoluteFile());
// 			   tm.put((folder.getAbsolutePath()),mimeTypes.toString());

//        	   FileNameMap fileNameMap = URLConnection.getFileNameMap();
//        	      String type = fileNameMap.getContentTypeFor(folder.getAbsolutePath());
//        	      tm.put((folder.getAbsolutePath()),type);

							// System.out.println("File= " + folder.getAbsolutePath()+ "\\" +
							// fileEntry.getName()+"
							// **MimeType:"+Files.probeContentType(Paths.get(folder.getAbsolutePath()+ "\\"
							// + fileEntry.getName())));
							// tm.put((folder.getAbsolutePath()),Files.probeContentType(Paths.get(folder.getAbsolutePath()+
							// "\\" + fileEntry.getName())));
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				}

			}
		}
		return tm;
	}

	public TreeMap<String, String> listFilesForFolder(final File folder, String strFormat) {

		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				System.out.println("Reading files under the folder " + folder.getAbsolutePath());
				listFilesForFolder(fileEntry, strFormat);
			} else {
				if (fileEntry.isFile()) {
					temp = fileEntry.getName();
					if (strFormat != null && (temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase())
							.equals(strFormat)) {
						// Path source = Paths.get(folder.getAbsolutePath()+ "\\" +
						// fileEntry.getName());
						try {
							tm.putAll(listFilesForFolder(fileEntry));
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					} else if (strFormat == null || strFormat.equals(null)) {
						System.out.println("inside FileNEt jar: strFormat==null " + fileEntry.getAbsolutePath());
						try {
							tm.putAll(listFilesForFolder(fileEntry));
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				}

			}
		}
		return tm;

	}

}