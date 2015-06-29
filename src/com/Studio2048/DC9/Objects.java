package com.Studio2048.DC9;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import com.Studio2048.DC9.Loaders.MainLoader;

/**
 * 
 * @author CreeperLv
 * 
 */
public class Objects {
	static int build = 9;
	static String Version = "0.0.9";
	static String status = "Alpha Preview";
	static String URL = "127.0.0.1";
	static String Location = "./";
	static String[] Names = new String[1000];
	static String[] Icons_Location = new String[1000];
	static String[] URLs = new String[1000];
	static boolean Debug = false;

	/**
	 * @author CreeperLv
	 * @since Build 2
	 * @version 0.1
	 * @param ID
	 * @return The object you want to get
	 */
	public static Object getObject(int ID) {
		switch (ID) {
		case 1:
			return build;
		case 2:
			return Version;
		case 3:
			return status;
		case 4:
			return URL;
		case 5:
			return Location;
		case 6:
			return Names;
		case 7:
			return URLs;
		case 8:
			return Debug;
		case 9:
			return Icons_Location;
		}
		return null;
	}

	/**
	 * @author CreeperLv
	 * @since Build 2
	 * @version 0.1
	 * @param ID
	 * @param obj
	 */
	public static void setObject(int ID, Object obj) {
		switch (ID) {
		case 4:
			URL = (String) obj;
			break;
		case 5:
			Location = (String) obj;
			break;
		case 8:
			Debug = (Boolean) obj;
			break;
		}
	}

	/**
	 * @author CreeperLv
	 * @param ID
	 * @param ID2
	 * @param obj
	 * @since Build 3
	 * @version 0.1
	 */
	public static void setArrayObject_1(int ID, int ID2, Object obj) {
		switch (ID) {
		case 6:
			Names[ID2] = (String) obj;
			break;
		case 7:
			URLs[ID2] = (String) obj;
			break;
		case 9:
			Icons_Location[ID2] = (String) obj;
			break;
		}
	}

	public static Object[] getArrayObject(int ID) {
		switch (ID) {
		case 6:
			return Names;
		case 7:
			return URLs;
		case 9:
			return Icons_Location;
		}
		return null;
	}

	public static JLabel createLabel_Today(final int ID) {
		JLabel l = new JLabel("<HTML><BODY>"
				+ "<P><font face=\"Microsoft YaHei UI\" size=5>"+(ID+1)+"<font size=6>"
				+ getArrayObject(6)[ID] + "");
//		if(ID%2==1){
//			l.setText("<HTML><body><div STYLE=\"background:gray;background-size: 500px,30px\">"
//					+ "<P><font face=\"Microsoft YaHei UI\" size=5>"+(ID+1)+"<font size=6>"
//					+ getArrayObject(6)[ID] + "");
//		}
		l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				com.Studio2048.DC9.Activities.Navigation.Deal((String) Objects.getArrayObject(7)[ID]);
				MainLoader.Debug("["+ID+"]URL to:"+(String) Objects.getArrayObject(7)[ID]);
				App.lblTitle.setText((String)getArrayObject(6)[ID]);
				App.contentPane.updateUI();
			}
		});
		return l;
	}
}
