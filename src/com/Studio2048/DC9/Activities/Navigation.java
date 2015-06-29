package com.Studio2048.DC9.Activities;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.Studio2048.DC9.App;
import com.Studio2048.DC9.Download;
import com.Studio2048.DC9.Loaders.MainLoader;

public class Navigation {
	public static void Deal(String URL) {
		if (URL.startsWith("DC9://")) {
			if (URL.startsWith("DC9://Search")) {
				App.lblSearch_1.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 20));
				App.lblToday_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
				App.cl1.show(App.panel_12, "Search");
				App.lblTitle.setText("Search");
				MainLoader.Debug("DC9://Search");
			} else if (URL.startsWith("DC9://Today")) {
				App.lblSearch_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
				App.lblToday_1.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 20));
				App.cl1.show(App.panel_12, "Today");
				MainLoader.Debug("DC9://Today");
				App.lblTitle.setText("Today");
			}
		} else {
			App.lblSearch_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
			App.lblToday_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
			App.cl1.show(App.panel_12, "Browser");
			boolean a = Download.httpDownload(URL, "./Data/Temp/0x01.html");
			if (a == false) {
				BufferedWriter bufferedWriter = null;
				try {
					bufferedWriter = new BufferedWriter(new FileWriter(
							"./Data/Temp/0x01.html"));
					bufferedWriter
							.write("<html>\r\n" +
									"<body>\r\n" +
									"<h1>No content loaded!</h1>\r\n" +
									"<h2>You can try:</h2>\r\n" +
									"<li>Back to Today and do it again.</li>\r\n" +
									"<li>Check your Network");
					// bufferedWriter.newLine();
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				} finally {
					// Close the BufferedWriter
					try {
						if (bufferedWriter != null) {
							bufferedWriter.flush();
							bufferedWriter.close();
						}
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
			String s = null;
			try {
				s = new File("./Data/Temp/0x01.html").getCanonicalPath();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			s = "file:///" + s;
			MainLoader.Debug("" + s);
			s.replace('\\', '/');
			MainLoader.Debug("" + s);
			try {
				App.Browser.setPage(s);
			} catch (IOException e) {

				e.printStackTrace();
			}
			MainLoader.Debug("" + URL);
			App.lblTitle.setText("Reading");
		}
	}
}
