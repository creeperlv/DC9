package com.Studio2048.DC9;

import java.awt.BorderLayout;

import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.CardLayout;

import com.Studio2048.DC9.Activities.Navigation;
import com.Studio2048.DC9.Loaders.MainLoader;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.border.MatteBorder;
import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Toolkit;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class App extends JFrame implements Runnable {

	static App frame;
	public static JPanel contentPane;
	static JPanel panel = new JPanel();
	JLabel lblTitle_S = new JLabel("Settings");
	CardLayout cl = new CardLayout(0, 0);
	JPanel panel_9 = new JPanel();
	static int AniSpeed = 1;
	public static String URL = "";
	public static String SaveTo = "";
	public static JLabel lblMessage = new JLabel("Message");
	static JPanel panel_14 = new JPanel();
	static JPanel panel_Chram = new JPanel();
	static boolean isSetting = false;
	public static JPanel panel_13 = new JPanel();// List
	static JLabel label_5 = new JLabel("");
	private JTextField txtEnterSomething;
	public static CardLayout cl1 = null;
	public static JPanel panel_12 = new JPanel();
	public static JLabel lblSearch_1 = new JLabel("Search");
	public static JLabel lblToday_1 = new JLabel("Today");
	public static JLabel lblTitle = new JLabel("Today");
	public static JEditorPane Browser = new JEditorPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Objects.setObject(8, true);
		frame = new App();
		frame.setVisible(true);
		int a = MainLoader.Load();
		if (a == 0x00) {

		}
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public App() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				App.class.getResource("/com/Studio2048/DC9/RES/icon_64.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// File f=
				new File("./Data/Temp/Today.lst").delete();
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// File f=
				new File("./Data/Temp/Today.lst").delete();
			}
		});
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		setTitle("DailyClass9");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 651);
		// setBounds(100, 100, 870, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel.setBounds(-187, 0, 885, 621);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_Chram.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Chram.setBackground(new Color(0, 153, 255));
		panel_Chram.setBounds(649, 0, 235, 621);
		panel.add(panel_Chram);
		panel_Chram.setLayout(new CardLayout(0, 0));

		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_Chram.add(panel_7, "name_5530024633595");
		panel_7.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_8.setBackground(Color.WHITE);
		panel_7.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new BorderLayout(0, 0));
		lblTitle_S.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Settings.png")));

		lblTitle_S.setForeground(Color.WHITE);
		lblTitle_S.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		panel_8.add(lblTitle_S, BorderLayout.CENTER);

		final JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Thread t = new M4();
				t.start();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label_2.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/BackB.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_2.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/Back.png")));
			}
		});
		label_2.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Back.png")));
		panel_8.add(label_2, BorderLayout.EAST);
		panel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});

		panel_9.setOpaque(false);
		panel_7.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(cl);

		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_9.add(panel_11, "Settings");
		panel_11.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));

		JLabel lblAS = new JLabel("Multiple of the animation");
		lblAS.setForeground(Color.WHITE);
		lblAS.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 17));
		panel_11.add(lblAS);

		final JSpinner spinner = new JSpinner();
		spinner.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				// TODO
				AniSpeed = (Integer) spinner.getValue();
			}
		});
		spinner.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		spinner.setBackground(new Color(0, 153, 255));
		spinner.setForeground(Color.WHITE);
		spinner.setModel(new SpinnerNumberModel(1, 0, 1000, 1));
		panel_11.add(spinner);

		// JLabel lblTip = new JLabel("More Settings are on the way!");
		// lblTip.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		// panel_11.add(lblTip);

		final JLabel lblServer = new JLabel("Server");
		lblServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblServer.setIcon(new ImageIcon(
						App.class
								.getResource("/com/Studio2048/DC9/RES/Buttons/Button1L.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblServer.setIcon(new ImageIcon(
						App.class
								.getResource("/com/Studio2048/DC9/RES/Buttons/Button1.png")));
			}
		});
		lblServer.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Buttons/Button1.png")));
		lblServer.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblServer.setVerticalAlignment(SwingConstants.TOP);
		lblServer.setIconTextGap(-28);
		lblServer.setHorizontalTextPosition(SwingConstants.CENTER);
		lblServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblServer.setForeground(Color.WHITE);
		lblServer.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		panel_11.add(lblServer);

		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_10.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_10.setOpaque(false);
		panel_9.add(panel_10, "About");
		JLabel lblVersion = new JLabel(
				"<html><body style=\"color:white\"><p><font size=6>Daily Class 9</p><p>Maker: 2048Studio</p><p>Version:"
						+ Objects.getObject(2)
						+ " "
						+ Objects.getObject(3)
						+ "</p><p>Build:" + Objects.getObject(1));
		lblVersion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblMessage.setText("<html><body><p><font size=6><center>"
						+ Objects.getObject(3)
						+ "</p><p>This version is very experimal, it may have a lot of problems.");
				showMessage();
			}
		});
		lblVersion.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		panel_10.add(lblVersion);

		label_5.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
			}
		});
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Thread t = new M4();
				t.start();
			}
		});
		label_5.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Dark_35_50.png")));
		label_5.setBounds(188, 0, 470, 650);
		panel.add(label_5);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 188, 621);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panel_3.setBackground(Color.WHITE);
		panel_1.add(panel_3, BorderLayout.NORTH);

		final JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Thread t = new M1();
				t.start();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/BackB.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/Back.png")));
			}
		});
		label.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Back.png")));
		panel_3.add(label);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_1.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(15, 1, 0, 0));
		lblToday_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Navigation.Deal("DC9://Today");
			}
		});

		lblToday_1.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 20));
		panel_5.add(lblToday_1);
		lblSearch_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Navigation.Deal("DC9://Search");
			}
		});

		lblSearch_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		panel_5.add(lblSearch_1);

		JLabel lblDownload = new JLabel("Download");
		lblDownload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Navigation.Deal("DC9://Download");
			}
		});
		lblDownload.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		panel_5.add(lblDownload);

		JLabel lblSettings = new JLabel("Settings");
		lblSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTitle_S.setText("Settings");
				lblTitle_S.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/Settings.png")));
				cl.show(panel_9, "Settings");
				Thread t = new M3();
				t.start();
			}
		});

		JLabel lblAbout = new JLabel("About");
		lblAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTitle_S.setText("About");
				lblTitle_S.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/Information.png")));
				cl.show(panel_9, "About");
				Thread t = new M3();
				t.start();
			}
		});
		lblAbout.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		panel_5.add(lblAbout);
		lblSettings.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		panel_5.add(lblSettings);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(187, 0, 462, 621);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 153, 255));
		panel_2.add(panel_4, BorderLayout.NORTH);

		final JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Thread t = new M2();
				t.start();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/MenuL.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/Menu.png")));
			}
		});
		panel_4.setLayout(new BorderLayout(5, 5));
		label_1.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Menu.png")));
		panel_4.add(label_1, BorderLayout.WEST);

		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		panel_4.add(lblTitle);

		final JLabel lbl_Re = new JLabel("");
		lbl_Re.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lbl_Re.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/ReL.png")));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				lbl_Re.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/Re.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			       Thread t= new Thread(frame);
			       t.start();
			}
		});
		lbl_Re.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Re.png")));
		panel_4.add(lbl_Re, BorderLayout.EAST);

		panel_12.setBackground(Color.WHITE);
		panel_12.setOpaque(false);
		panel_2.add(panel_12, BorderLayout.CENTER);
		cl1 = new CardLayout(0, 0);
		panel_12.setLayout(cl1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		panel_12.add(scrollPane, "Today");

		panel_13.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel_13);
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_17 = new JPanel();
		panel_12.add(panel_17, "Search");
		panel_17.setLayout(new BorderLayout(40, 40));

		JLabel lblSearchbeta = new JLabel(
				"<html><body><p><br/>Search <font size=3>Beta");
		lblSearchbeta.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 42));
		lblSearchbeta.setHorizontalAlignment(SwingConstants.CENTER);
		panel_17.add(lblSearchbeta, BorderLayout.NORTH);

		JPanel panel_18 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_18.getLayout();
		flowLayout_2.setHgap(0);
		flowLayout_2.setVgap(20);
		panel_17.add(panel_18, BorderLayout.CENTER);

		final JLabel lblBack = new JLabel("");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Navigation.Deal("DC9://Today");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblBack.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/BackB.png")));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				lblBack.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/Back.png")));
			}
		});
		panel_18.add(lblBack);
		lblBack.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Back.png")));

		txtEnterSomething = new JTextField();
		txtEnterSomething.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		txtEnterSomething.setText("Enter something...");
		panel_18.add(txtEnterSomething);
		txtEnterSomething.setColumns(20);

		final JLabel lblSearch = new JLabel("");
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblSearch.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/SearchL.png")));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				lblSearch.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/Search.png")));
			}
		});
		lblSearch.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Search.png")));
		panel_18.add(lblSearch);

		JPanel panel_19 = new JPanel();
		panel_12.add(panel_19, "Browser");
		panel_19.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_19.add(scrollPane_1);

		Browser.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		Browser.setContentType("text/html");
		Browser.setEditable(false);
		scrollPane_1.setViewportView(Browser);
		Browser.setText("<html>\r\n<body>\r\n<h1>No content loaded!</h1>\r\n<h2>You can try:</h2>\r\n<li>Back to Today and do it again.</li><li>Check your Network");

		JPanel panel_20 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_20.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_19.add(panel_20, BorderLayout.SOUTH);

		final JLabel lblBack_1 = new JLabel("");
		lblBack_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Navigation.Deal("DC9://Today");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblBack_1.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/BackB.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblBack_1.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/Back.png")));
			}
		});
		lblBack_1.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Back.png")));
		panel_20.add(lblBack_1);

		panel_14.setOpaque(false);
		this.setGlassPane(panel_14);
		panel_14.setLayout(null);

		JPanel panel_15 = new JPanel();
		panel_15.setOpaque(false);
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(85, 135, 300, 200);
		panel_14.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));

		final JLabel lblOk = new JLabel("O K");
		lblOk.setForeground(Color.DARK_GRAY);
		lblOk.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Button.png")));
		lblOk.setHorizontalAlignment(SwingConstants.CENTER);
		lblOk.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		lblOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// lblOk.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
				lblOk.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/ButtonL.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// lblOk.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 21));
				lblOk.setIcon(new ImageIcon(App.class
						.getResource("/com/Studio2048/DC9/RES/Button.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panel_14.hide();
				contentPane.updateUI();
			}
		});
		lblOk.setVerticalAlignment(SwingConstants.TOP);
		lblOk.setHorizontalAlignment(SwingConstants.CENTER);
		// lblOpen.setHorizontalAlignment(SwingConstants.CENTER);
		lblOk.setHorizontalTextPosition(0);
		lblOk.setVerticalTextPosition(JLabel.BOTTOM);
		lblOk.setIconTextGap(-28);
		panel_15.add(lblOk, BorderLayout.SOUTH);

		JLabel label_4 = new JLabel(" ");
		label_4.setForeground(Color.WHITE);
		label_4.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Title.png")));
		panel_15.add(label_4, BorderLayout.NORTH);

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.LIGHT_GRAY);
		panel_16.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204,
				204, 204)));
		panel_15.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new BorderLayout(0, 0));
		panel_16.add(lblMessage);
		lblMessage.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		lblMessage.setVerticalAlignment(SwingConstants.TOP);

		JLabel lblDark = new JLabel("");
		lblDark.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lblDark.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Dark_35_50.png")));
		lblDark.setBounds(0, 0, 470, 650);
		panel_14.add(lblDark);
		panel_14.hide();
		// panel_14.show();
		App.label_5.hide();
	}

	@SuppressWarnings("deprecation")
	public static void showMessage() {
		panel_14.show();
	}

	@Override
	public void run() {
		MainLoader.reLoad();
		
	}
}

class M1 extends Thread {
	public void run() {
		for (int i = 0; i <= 90; i++) {
			App.panel.setLocation(0 - 7 - i * 2, 0);
			try {
				sleep(App.AniSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class M2 extends Thread {
	public void run() {
		if (App.isSetting == true) {
			Thread t = new M4();
			t.run();
			App.isSetting = false;
		}
		for (int i = 90; i >= 0; i--) {
			App.panel.setLocation(0 - i * 2, 0);
			try {
				sleep(App.AniSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class M3 extends Thread {
	@SuppressWarnings("deprecation")
	public void run() {
		App.isSetting = true;
		for (int i = 0; i <= 90; i++) {
			App.panel.setLocation(0 - 7 - i * 2, 0);
			try {
				sleep(App.AniSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i <= 80; i++) {
			App.panel_Chram.setLocation(649 - i * 2, 0);
			try {
				sleep(App.AniSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i <= 35; i++) {
			App.panel_Chram.setLocation(649 - 160 - i, 0);
			try {
				sleep((long) (App.AniSpeed));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i <= 35; i++) {
			App.panel_Chram.setLocation(649 - 195 - i, 0);
			try {
				sleep((long) (App.AniSpeed * 2));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		App.label_5.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Dark_35_50.png")));
		App.label_5.show();
	}
}

class M4 extends Thread {
	@SuppressWarnings("deprecation")
	public void run() {
		// for (int i = 0; i <= 32; i++) {
		// App.panel.setLocation(0 - 15 * 30 + i * 7 + 39, 0);
		// try {
		// sleep(5 * App.AniSpeed);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		for (int i = 0; i <= 115; i++) {
			App.panel_Chram.setLocation(649 - 230 + i * 1, 0);
			try {
				sleep(App.AniSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		App.label_5.setIcon(new ImageIcon(App.class
				.getResource("/com/Studio2048/DC9/RES/Dark_15_35.png")));
		App.contentPane.updateUI();
		for (int i = 0; i <= 115; i++) {
			App.panel_Chram.setLocation(649 - 230 + 115 + i * 1, 0);
			try {
				sleep(App.AniSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		App.isSetting = false;
		App.label_5.hide();
		App.contentPane.updateUI();
	}
}

class DownloadT extends Thread {
	public void run() {
		Download.httpDownload((String) Objects.getObject(4),
				(String) Objects.getObject(5));
	}

}
