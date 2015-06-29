package com.Studio2048.DC9;

import java.io.*;
import java.net.*;

public class Download {
	/**
	 * @author Creeper Lv
	 * @since build 2
	 * @version 1.0
	 * @param httpUrl
	 * @param saveFile
	 */
	public static boolean httpDownload(String httpUrl, String saveFile) {
		// ÏÂÔØÍøÂçÎÄ¼þ
		int bytesum = 0;
		int byteread = 0;

		URL url = null;
		try {
			url = new URL(httpUrl);
		} catch (MalformedURLException e1) {
			ShowError(1, e1);
			System.out.println("[DOWNLOAD]From:[" + httpUrl + "] To:["
					+ saveFile + "] failure! Code:" + e1);
			return false;
		}

		try {
			File f = new File(saveFile);
			if (f.exists() == false) {
				f.createNewFile();
			}
			URLConnection conn = url.openConnection();
			InputStream inStream = conn.getInputStream();
			FileOutputStream fs = new FileOutputStream(saveFile);
			byte[] buffer = new byte[1204];
			while ((byteread = inStream.read(buffer)) != -1) {
				bytesum += byteread;
				System.out.println(bytesum);
				fs.write(buffer, 0, byteread);
			}
			System.out.println("[DOWNLOAD]From:[" + httpUrl + "] To:["
					+ saveFile + "] complete!");
			return true;
		} catch (FileNotFoundException e) {
			ShowError(1, e);
			System.out.println("[DOWNLOAD]From:[" + httpUrl + "] To:["
					+ saveFile + "] failure! Code:" + e);
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			ShowError(1, e);
			System.out.println("[DOWNLOAD]From:[" + httpUrl + "] To:["
					+ saveFile + "] failure! Code:" + e);
			e.printStackTrace();
			return false;
		}
	}

	static void ShowError(int Code, Exception e) {
		switch (Code) {
		case 1:
			// Object[] options = { "OK", "CANCEL" };
			// JOptionPane.showConfirmDialog(null,
			// "Download File form remote server failure.","Error",
			// JOptionPane.ERROR_MESSAGE);
			App.lblMessage
					.setText("<html><body><p>Download File form remote server failure.</p><p><font size=3>Reason:</p><p><font size=3>"
							+ e);
			App.showMessage();
			// JOptionPane.showMessageDialog(null,
			// "Download File form remote server failure.\r\nReason:\r\n"+e,
			// "Error",
			// JOptionPane.ERROR_MESSAGE);
			break;
		case 2:
			// JOptionPane.showMessageDialog(null,
			// "Download File form remote server failure.\r\nReason:Unknown Host",
			// "Error",
			// JOptionPane.ERROR_MESSAGE);
			break;
		case 3:
			// JOptionPane.showMessageDialog(null,
			// "Download File form remote server failure.", "Error",
			// JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
