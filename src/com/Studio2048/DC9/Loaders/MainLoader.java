package com.Studio2048.DC9.Loaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.Studio2048.DC9.App;
import com.Studio2048.DC9.Download;
import com.Studio2048.DC9.Objects;

public class MainLoader {
	@SuppressWarnings("unused")
	public static int Load() {
		Objects.setObject(4,
				"https://raw.githubusercontent.com/creeperlv/DC9/master/Today.lst");
		Objects.setObject(5, "./Data/Temp/Today.lst");
		if (Download.httpDownload((String) Objects.getObject(4),
				(String) Objects.getObject(5)) == false) {
//			return 0x03;
		}
		File f = new File("./Data/Temp/Today.lst");
		if (f.exists() == false) {
			App.lblMessage
					.setText("<html><body><p>Error: List file no found.</p><p><font size=3>Reason: </p>"
							+ "<p><font size=3>List file should be at \"./Data/Temp/Today.lst\"");
			App.showMessage();
			return 0x01;
		} else {
			BufferedReader reader = null;
			try {
				System.out
						.println("[Load][BY_LINE]File:" + f.getAbsolutePath());
				reader = new BufferedReader(new FileReader(f));
				String s = null;
				int line = 1;
				int Obj = 0;
				boolean isStarted = false;
				boolean b1 = false;
				boolean b2 = false;// Target List
				boolean b3 = false;// Target OBJ
				boolean b4 = false;// Target Name
				boolean b5 = false;// Target URL
				boolean b6 = false; // Target Icon
				// 一次读入一行，直到读入null为文件结束
				while ((s = reader.readLine()) != null) {
					// 显示行号
					if (s.equals("<DC>")) {
						isStarted = true;
					}
					if (isStarted == true) {
						if (s.equals("<Build>")) {
							b1 = true;
							continue;
						} else if (s.equals("<List>")) {
							b2 = true;
						}
						if (b1 == true) {
							if (s.equals("</Build>")) {
								b1 = false;
								continue;
							}
							if (Integer.parseInt(s) > (Integer) Objects
									.getObject(1)) {
								App.lblMessage
										.setText("<html><body>"
												+ "<p>Your Daily Class 9 is out of the date please update as soon as you can.</p>"
												+ "<p><font size=3>Reason: </p>"
												+ "<p><font size=3>The build of the downloaded file:"
												+ s
												+ "</p><p style=\"color:red\"><font size=3>Your build:"
												+ Objects.getObject(1)
												+ "</p><p style=\"color:blue\"><font size=4>Visit:www.github.com/creeperlv/DC9");
								App.showMessage();
							}
						}
						if (b2 == true) {
							if (s.equals("<OBJ>")) {
								b3 = true;
								
							}
							if (b3 == true) {
								if (s.equals("</OBJ>")) {
									App.panel_13.add(Objects.createLabel_Today(Obj));
									Obj++;
									b3 = false;
									continue;
								}
								if (b4 == true) {
									Debug("Dealing <Name>");
									if (s.equals("</Name>")) {
										b4 = false;
										continue;
									} else {
										Objects.setArrayObject_1(6, Obj, s);
										Debug("<Name>"+Objects.getArrayObject(6)[Obj]);
									}
								} else if (b5 == true) {
									Debug("Dealing <Url>");
									if (s.equals("</URL>")) {
										b5 = false;
										continue;
									} else {
										Objects.setArrayObject_1(7, Obj, s);
										Debug("["+Obj+"]<URL>"+Objects.getArrayObject(7)[Obj]);
									}

								} else if (b6 == true) {
									Debug("Dealing <Icon>");

									if (s.equals("</Icon>")) {
										b6 = false;
										continue;
									} else {
										Objects.setArrayObject_1(9, Obj, s);
										Debug("<Icon>"+Objects.getArrayObject(9)[Obj]);
									}
								} else if (s.equals("<Name>")) {
									b4 = true;
								} else if (s.equals("<URL>")) {
									b5 = true;
								} else if (s.equals("<Icon>")) {
									b6 = true;
								}

							}
						}
						// TODO The models...
					}
					// System.out.println("[Load]Line:" + line + ": " + s);
					line++;
				}
				reader.close();
			} catch (IOException e) {
				App.lblMessage
						.setText("<html><body><p>Load list file error</p><p><font size=3>Reason: </p><p><font size=3>"
								+ e);
				App.showMessage();
				e.printStackTrace();
				return 0x02;
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e1) {
					}
				}
			}
			App.contentPane.updateUI();
		}
		return 0x00;
	}
	public static void reLoad(){
		App.panel_13.removeAll();
		MainLoader.Load();
	}
	public static void Debug(String msg) {
		if ((Boolean) Objects.getObject(8) == true){
			System.out.println("[DEBUG]" + msg);
		}else return;
	}

}
