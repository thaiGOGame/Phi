package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import bus.Tour_BUS;
import connectDB.ConnectDB;
import custom_entity.ChonMau;
import custom_entity.CustomComboxBox;
import custom_entity.RoundedCornerBorder;
import entities.Tour;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JButton;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Home extends JFrame {

	private JPanel pnHome;
	private LoginSignup login;
	private DatTour datTour;
	//
	private JPanel item1,item2,item3,item4,item5,item6;
	private CustomComboxBox cboDiemDi,cboDiemDen;
	//
	private JLabel tourPicture1,tourName1,tourPrice1,tourTime1,tourID1;
	private JLabel tourPicture2,tourName2,tourPrice2,tourTime2,tourID2;
	private JLabel tourPicture3,tourName3,tourPrice3,tourTime3,tourID3;
	private JLabel tourPicture4,tourName4,tourPrice4,tourTime4,tourID4;
	private JLabel tourPicture5,tourName5,tourPrice5,tourTime5,tourID5;
	private JLabel tourPicture6,tourName6,tourPrice6,tourTime6,tourID6;
	//
	private Tour_BUS tourBus;
	private ArrayList<Tour> ds,dsTimKiem;
	//
	private int iTour,lItem;
	private JLabel lblNgy;
	
	private UtilDateModel model; 
	private JDatePanelImpl datePanel; 
	private JDatePickerImpl datePicker;
	
	private String sDDi, sDDen, sNgay;
	private JTextField txtMess;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Home().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		//
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//
		tourBus = new Tour_BUS();
		ds = tourBus.getDS();
		
		//datTour = new DatTour("");
		setSize(1200,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		this.setLocationRelativeTo(null);
		pnHome = new JPanel();
		pnHome.setBackground(Color.WHITE);
		pnHome.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));

		setContentPane(pnHome);
		pnHome.setLayout(null);
		
		JPanel pnHeader = new JPanel();
		pnHeader.setBorder(null);
		pnHeader.setBackground(new Color(65, 105, 225));
		pnHeader.setBounds(0, 0, 1200, 80);
		pnHome.add(pnHeader);
		pnHeader.setLayout(null);
		
		JLabel btnExit = new JLabel("x");
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("Arial", Font.PLAIN, 30));
		btnExit.setBounds(1177, 0, 23, 31);
		pnHeader.add(btnExit);
		
		JLabel btnUser = new JLabel("");
		btnUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login = new LoginSignup();
				login.main(null);
			}
		});
		btnUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUser.setForeground(new Color(255, 255, 255));
		btnUser.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\user.png"));
		btnUser.setBounds(1050, 11, 51, 52);
		pnHeader.add(btnUser);
		
		JLabel lblLogo = new JLabel("ViGo");
		lblLogo.setFont(new Font("Arial", Font.BOLD, 35));
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\beach_118051 (1).png"));
		lblLogo.setBounds(10, 3, 211, 72);
		pnHeader.add(lblLogo);
		
		JLabel btnCart = new JLabel("");
		btnCart.setBounds(1104, 11, 51, 52);
		pnHeader.add(btnCart);
		btnCart.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\cart.png"));
		
		JPanel search = new JPanel();
		search.setBackground(new Color(255, 255, 255));
		search.setBounds(215, 11, 790, 58);
		search.setLayout(null);
		search.setBorder(new RoundedCornerBorder());
		pnHeader.add(search);
		
		JLabel titleContent = new JLabel("Tour đặc biệt dành cho bạn");
		titleContent.setFont(new Font("Arial", Font.BOLD, 20));
		titleContent.setBounds(10, 101, 266, 31);
		pnHome.add(titleContent);
		
		JPanel listTour = new JPanel();
		listTour.setBackground(Color.WHITE);
		listTour.setBounds(100, 149, 1000, 540);
		pnHome.add(listTour);
		listTour.setLayout(null);
		//
		String[] strDiemDi = updateCboBoxDiemDi();
		cboDiemDi = new CustomComboxBox(strDiemDi, ChonMau.blue_4B70F5, Color.white, Color.black, ChonMau.blue_4B70F5, 30, true);
		cboDiemDi.setLocation(40, 5);
		search.add(cboDiemDi.getPanel(Color.white, 55, 5, 170, 45));
		sDDi = (String) cboDiemDi.getSelectedItem();
		
		JLabel sDiemDi = new JLabel("Điểm đi:");
		sDiemDi.setFont(new Font("Arial", Font.PLAIN, 12));
		sDiemDi.setBounds(10, 21, 50, 20);
		search.add(sDiemDi);
		
		JLabel sDiemDen = new JLabel("Điểm đến:");
		sDiemDen.setFont(new Font("Arial", Font.PLAIN, 12));
		sDiemDen.setBounds(230, 21, 66, 20);
		search.add(sDiemDen);
		
		String[] strDiemDen = updateCboBoxDiemDen();
		cboDiemDen = new CustomComboxBox(strDiemDen, ChonMau.blue_4B70F5, Color.white, Color.black, ChonMau.blue_4B70F5, 30, true);
		cboDiemDen.setLocation(40, 5);
		search.add(cboDiemDen.getPanel(Color.white, 280, 5, 170, 45));
		sDDen = (String) cboDiemDen.getSelectedItem();
		
		lblNgy = new JLabel("Ngày:");
		lblNgy.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNgy.setBounds(450, 21, 36, 20);
		search.add(lblNgy);
		
		model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		datePicker.setBackground(new Color(255, 255, 255));
		datePicker.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		datePicker.setBounds(490, 17, 180, 28);
		datePicker.getJDateInstantPanel().setShowYearButtons(true);
		//datePicker.getJFormattedTextField().setText("2023-01-01");
		//datePicker.getModel().setValue(Date("2023-01-01"));
		search.add(datePicker);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dsTimKiem.removeAll(dsTimKiem);
				Date date= (Date) datePicker.getModel().getValue();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sNgay=sdf.format(date);
				dsTimKiem=tourBus.timKiem(sDDi, sDDen, sNgay);
				if (dsTimKiem.size()>0) {
					txtMess.setText(sNgay);
					iTour=0;
					ds=dsTimKiem;
					lItem=ds.size();
					showList(iTour);
				}
				else txtMess.setText("không tìm thấy kết quả!"+sNgay);
				System.out.println(sNgay);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(720, 20, 60, 23);
		search.add(btnNewButton);
		//cbo1.setBounds(320, 110, 180, 30);
		//
		
		//
		item1 = new JPanel();
		item1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item1.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		item1.setBackground(Color.WHITE);
		item1.setBounds(0, 0, 320, 260);
		listTour.add(item1);
		item1.setLayout(null);
		item1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				datTour = new DatTour(tourID1.getText().substring(9));
				datTour.setVisible(true);
				
			}
		});
		
		tourPicture1 = new JLabel("");
		tourPicture1.setFocusTraversalKeysEnabled(false);
		tourPicture1.setFocusTraversalPolicyProvider(true);
		tourPicture1.setHorizontalTextPosition(SwingConstants.CENTER);
		tourPicture1.setHorizontalAlignment(SwingConstants.CENTER);
		tourPicture1.setVerticalAlignment(SwingConstants.TOP);
		tourPicture1.setVerticalTextPosition(SwingConstants.BOTTOM);
		tourPicture1.setIgnoreRepaint(true);
		tourPicture1.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\thanh-pho-da-lat.jpg"));
		tourPicture1.setBounds(10, 11, 300, 165);
		item1.add(tourPicture1);
		
		tourName1 = new JLabel("Đà Lạt");
		tourName1.setFont(new Font("Arial", Font.BOLD, 15));
		tourName1.setBounds(10, 196, 300, 20);
		item1.add(tourName1);
		
		tourPrice1 = new JLabel("5.000.000Đ");
		tourPrice1.setHorizontalAlignment(SwingConstants.RIGHT);
		tourPrice1.setFont(new Font("Arial", Font.BOLD, 18));
		tourPrice1.setForeground(Color.RED);
		tourPrice1.setBounds(130, 234, 180, 15);
		item1.add(tourPrice1);
		
		tourTime1 = new JLabel("11/04/2023 - 3 ngày");
		tourTime1.setFont(new Font("Arial", Font.PLAIN, 10));
		tourTime1.setBounds(10, 182, 300, 14);
		item1.add(tourTime1);
		
		tourID1 = new JLabel("Mã tour: DL001");
		tourID1.setFont(new Font("Arial", Font.PLAIN, 10));
		tourID1.setBounds(10, 214, 300, 14);
		item1.add(tourID1);
		
		JLabel tourBtn1 = new JLabel("Xem chi tiết");
		tourBtn1.setForeground(new Color(186, 85, 211));
		tourBtn1.setHorizontalAlignment(SwingConstants.CENTER);
		tourBtn1.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		tourBtn1.setBounds(10, 235, 88, 16);
		item1.add(tourBtn1);
		
		
		item2 = new JPanel();
		item2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item2.setLayout(null);
		item2.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		item2.setBackground(Color.WHITE);
		item2.setBounds(341, 0, 320, 260);
		listTour.add(item2);
		item2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				datTour = new DatTour(tourID2.getText().substring(9));
				datTour.setVisible(true);
			}
		});
		
		tourPicture2 = new JLabel("");
		tourPicture2.setVerticalTextPosition(SwingConstants.BOTTOM);
		tourPicture2.setVerticalAlignment(SwingConstants.TOP);
		tourPicture2.setIgnoreRepaint(true);
		tourPicture2.setHorizontalTextPosition(SwingConstants.CENTER);
		tourPicture2.setHorizontalAlignment(SwingConstants.CENTER);
		tourPicture2.setFocusTraversalPolicyProvider(true);
		tourPicture2.setFocusTraversalKeysEnabled(false);
		tourPicture2.setBounds(10, 11, 300, 165);
		item2.add(tourPicture2);
		
		tourName2 = new JLabel("Đà Lạt");
		tourName2.setFont(new Font("Arial", Font.BOLD, 15));
		tourName2.setBounds(10, 196, 300, 20);
		item2.add(tourName2);
		
		tourPrice2 = new JLabel("5.000.000Đ");
		tourPrice2.setHorizontalAlignment(SwingConstants.RIGHT);
		tourPrice2.setForeground(Color.RED);
		tourPrice2.setFont(new Font("Arial", Font.BOLD, 18));
		tourPrice2.setBounds(130, 234, 180, 15);
		item2.add(tourPrice2);
		
		tourTime2 = new JLabel("11/04/2023 - 3 ngày");
		tourTime2.setFont(new Font("Arial", Font.PLAIN, 10));
		tourTime2.setBounds(10, 182, 300, 14);
		item2.add(tourTime2);
		
		tourID2 = new JLabel("Mã tour: DL001");
		tourID2.setFont(new Font("Arial", Font.PLAIN, 10));
		tourID2.setBounds(10, 214, 300, 14);
		item2.add(tourID2);
		
		JLabel tourBtn2 = new JLabel("Xem chi tiết");
		tourBtn2.setHorizontalAlignment(SwingConstants.CENTER);
		tourBtn2.setForeground(new Color(186, 85, 211));
		tourBtn2.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		tourBtn2.setBounds(10, 235, 88, 16);
		item2.add(tourBtn2);
		
		item3 = new JPanel();
		item3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item3.setLayout(null);
		item3.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		item3.setBackground(Color.WHITE);
		item3.setBounds(680, 0, 320, 260);
		listTour.add(item3);
		item3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				datTour = new DatTour(tourID3.getText().substring(9));
				datTour.setVisible(true);
			}
		});
		
		tourPicture3 = new JLabel("");
		tourPicture3.setVerticalTextPosition(SwingConstants.BOTTOM);
		tourPicture3.setVerticalAlignment(SwingConstants.TOP);
		tourPicture3.setIgnoreRepaint(true);
		tourPicture3.setHorizontalTextPosition(SwingConstants.CENTER);
		tourPicture3.setHorizontalAlignment(SwingConstants.CENTER);
		tourPicture3.setFocusTraversalPolicyProvider(true);
		tourPicture3.setFocusTraversalKeysEnabled(false);
		tourPicture3.setBounds(10, 11, 300, 165);
		item3.add(tourPicture3);
		
		tourName3 = new JLabel("Đà Lạt");
		tourName3.setFont(new Font("Arial", Font.BOLD, 15));
		tourName3.setBounds(10, 196, 300, 20);
		item3.add(tourName3);
		
		tourPrice3 = new JLabel("5.000.000Đ");
		tourPrice3.setHorizontalAlignment(SwingConstants.RIGHT);
		tourPrice3.setForeground(Color.RED);
		tourPrice3.setFont(new Font("Arial", Font.BOLD, 18));
		tourPrice3.setBounds(130, 234, 180, 15);
		item3.add(tourPrice3);
		
		tourTime3 = new JLabel("11/04/2023 - 3 ngày");
		tourTime3.setFont(new Font("Arial", Font.PLAIN, 10));
		tourTime3.setBounds(10, 182, 300, 14);
		item3.add(tourTime3);
		
		tourID3 = new JLabel("Mã tour: DL001");
		tourID3.setFont(new Font("Arial", Font.PLAIN, 10));
		tourID3.setBounds(10, 214, 300, 14);
		item3.add(tourID3);
		
		JLabel tourBtn3 = new JLabel("Xem chi tiết");
		tourBtn3.setHorizontalAlignment(SwingConstants.CENTER);
		tourBtn3.setForeground(new Color(186, 85, 211));
		tourBtn3.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		tourBtn3.setBounds(10, 235, 88, 16);
		item3.add(tourBtn3);
		
		item4 = new JPanel();
		item4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item4.setLayout(null);
		item4.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		item4.setBackground(Color.WHITE);
		item4.setBounds(0, 280, 320, 260);
		listTour.add(item4);
		item4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				datTour = new DatTour(tourID4.getText().substring(9));
				datTour.setVisible(true);
			}
		});
		
		tourPicture4 = new JLabel("");
		tourPicture4.setVerticalTextPosition(SwingConstants.BOTTOM);
		tourPicture4.setVerticalAlignment(SwingConstants.TOP);
		tourPicture4.setIgnoreRepaint(true);
		tourPicture4.setHorizontalTextPosition(SwingConstants.CENTER);
		tourPicture4.setHorizontalAlignment(SwingConstants.CENTER);
		tourPicture4.setFocusTraversalPolicyProvider(true);
		tourPicture4.setFocusTraversalKeysEnabled(false);
		tourPicture4.setBounds(10, 11, 300, 165);
		item4.add(tourPicture4);
		
		tourName4 = new JLabel("Đà Lạt");
		tourName4.setFont(new Font("Arial", Font.BOLD, 15));
		tourName4.setBounds(10, 196, 300, 20);
		item4.add(tourName4);
		
		tourPrice4 = new JLabel("5.000.000Đ");
		tourPrice4.setHorizontalAlignment(SwingConstants.RIGHT);
		tourPrice4.setForeground(Color.RED);
		tourPrice4.setFont(new Font("Arial", Font.BOLD, 18));
		tourPrice4.setBounds(130, 234, 180, 15);
		item4.add(tourPrice4);
		
		tourTime4 = new JLabel("11/04/2023 - 3 ngày");
		tourTime4.setFont(new Font("Arial", Font.PLAIN, 10));
		tourTime4.setBounds(10, 182, 300, 14);
		item4.add(tourTime4);
		
		tourID4 = new JLabel("Mã tour: DL001");
		tourID4.setFont(new Font("Arial", Font.PLAIN, 10));
		tourID4.setBounds(10, 214, 300, 14);
		item4.add(tourID4);
		
		JLabel tourBtn4 = new JLabel("Xem chi tiết");
		tourBtn4.setHorizontalAlignment(SwingConstants.CENTER);
		tourBtn4.setForeground(new Color(186, 85, 211));
		tourBtn4.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		tourBtn4.setBounds(10, 235, 88, 16);
		item4.add(tourBtn4);
		
		item5 = new JPanel();
		item5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item5.setLayout(null);
		item5.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		item5.setBackground(Color.WHITE);
		item5.setBounds(341, 280, 320, 260);
		listTour.add(item5);
		item5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				datTour = new DatTour(tourID5.getText().substring(9));
				datTour.setVisible(true);
			}
		});
		
		tourPicture5 = new JLabel("");
		tourPicture5.setVerticalTextPosition(SwingConstants.BOTTOM);
		tourPicture5.setVerticalAlignment(SwingConstants.TOP);
		tourPicture5.setIgnoreRepaint(true);
		tourPicture5.setHorizontalTextPosition(SwingConstants.CENTER);
		tourPicture5.setHorizontalAlignment(SwingConstants.CENTER);
		tourPicture5.setFocusTraversalPolicyProvider(true);
		tourPicture5.setFocusTraversalKeysEnabled(false);
		tourPicture5.setBounds(10, 11, 300, 165);
		item5.add(tourPicture5);
		
		tourName5 = new JLabel("Đà Lạt");
		tourName5.setFont(new Font("Arial", Font.BOLD, 15));
		tourName5.setBounds(10, 196, 300, 20);
		item5.add(tourName5);
		
		tourPrice5 = new JLabel("5.000.000Đ");
		tourPrice5.setHorizontalAlignment(SwingConstants.RIGHT);
		tourPrice5.setForeground(Color.RED);
		tourPrice5.setFont(new Font("Arial", Font.BOLD, 18));
		tourPrice5.setBounds(130, 234, 180, 15);
		item5.add(tourPrice5);
		
		tourTime5 = new JLabel("11/04/2023 - 3 ngày");
		tourTime5.setFont(new Font("Arial", Font.PLAIN, 10));
		tourTime5.setBounds(10, 182, 300, 14);
		item5.add(tourTime5);
		
		tourID5 = new JLabel("Mã tour: DL001");
		tourID5.setFont(new Font("Arial", Font.PLAIN, 10));
		tourID5.setBounds(10, 214, 300, 14);
		item5.add(tourID5);
		
		JLabel tourBtn5 = new JLabel("Xem chi tiết");
		tourBtn5.setHorizontalAlignment(SwingConstants.CENTER);
		tourBtn5.setForeground(new Color(186, 85, 211));
		tourBtn5.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		tourBtn5.setBounds(10, 235, 88, 16);
		item5.add(tourBtn5);
		
		item6 = new JPanel();
		item6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item6.setLayout(null);
		item6.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		item6.setBackground(Color.WHITE);
		item6.setBounds(680, 280, 320, 260);
		listTour.add(item6);
		item6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				datTour = new DatTour(tourID6.getText().substring(9));
				datTour.setVisible(true);
			}
		});
		
		tourPicture6 = new JLabel("");
		tourPicture6.setVerticalTextPosition(SwingConstants.BOTTOM);
		tourPicture6.setVerticalAlignment(SwingConstants.TOP);
		tourPicture6.setIgnoreRepaint(true);
		tourPicture6.setHorizontalTextPosition(SwingConstants.CENTER);
		tourPicture6.setHorizontalAlignment(SwingConstants.CENTER);
		tourPicture6.setFocusTraversalPolicyProvider(true);
		tourPicture6.setFocusTraversalKeysEnabled(false);
		tourPicture6.setBounds(10, 11, 300, 165);
		item6.add(tourPicture6);
		
		tourName6 = new JLabel("Đà Lạt");
		tourName6.setFont(new Font("Arial", Font.BOLD, 15));
		tourName6.setBounds(10, 196, 300, 20);
		item6.add(tourName6);
		
		tourPrice6 = new JLabel("5.000.000Đ");
		tourPrice6.setHorizontalAlignment(SwingConstants.RIGHT);
		tourPrice6.setForeground(Color.RED);
		tourPrice6.setFont(new Font("Arial", Font.BOLD, 18));
		tourPrice6.setBounds(130, 234, 180, 15);
		item6.add(tourPrice6);
		
		tourTime6 = new JLabel("11/04/2023 - 3 ngày");
		tourTime6.setFont(new Font("Arial", Font.PLAIN, 10));
		tourTime6.setBounds(10, 182, 300, 14);
		item6.add(tourTime6);
		
		tourID6 = new JLabel("Mã tour: DL001");
		tourID6.setFont(new Font("Arial", Font.PLAIN, 10));
		tourID6.setBounds(10, 214, 300, 14);
		item6.add(tourID6);
		
		JLabel tourBtn6 = new JLabel("Xem chi tiết");
		tourBtn6.setHorizontalAlignment(SwingConstants.CENTER);
		tourBtn6.setForeground(new Color(186, 85, 211));
		tourBtn6.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		tourBtn6.setBounds(10, 235, 88, 16);
		item6.add(tourBtn6);
		
		JLabel btnUndo = new JLabel("");
		btnUndo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUndo.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\left-arrow.png"));
		btnUndo.setBounds(25, 383, 48, 37);
		pnHome.add(btnUndo);
		
		JLabel btnRedu = new JLabel("");
		btnRedu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRedu.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\right-arrow.png"));
		btnRedu.setBounds(1122, 383, 48, 37);
		pnHome.add(btnRedu);
		
		txtMess = new JTextField();
		txtMess.setBorder(null);
		txtMess.setHorizontalAlignment(SwingConstants.CENTER);
		txtMess.setForeground(new Color(255, 0, 0));
		txtMess.setBounds(487, 109, 227, 20);
		pnHome.add(txtMess);
		txtMess.setColumns(10);
		
		JTextPane btnReset = new JTextPane();
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ds=tourBus.getDS();
				iTour=0;
				lItem=ds.size();
				showList(iTour);
				dsTimKiem.removeAll(dsTimKiem);
			}
		});
		btnReset.setText("reset");
		btnReset.setBounds(291, 101, 26, 31);
		pnHome.add(btnReset);
		ds = tourBus.getDS();
		iTour=0;
		lItem=ds.size();
		showList(iTour);
		if (iTour<7) btnUndo.setVisible(false);
		if (lItem-iTour<6) btnRedu.setVisible(false);
		btnUndo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iTour-=6;
				showList(iTour);
				if (iTour<6) btnUndo.setVisible(false);
				else btnUndo.setVisible(true);
				if (lItem-iTour<7) btnRedu.setVisible(false);
				else btnRedu.setVisible(true);
			}
		});
		btnRedu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iTour+=6;
				showList(iTour);
				if (iTour<6) btnUndo.setVisible(false);
				else btnUndo.setVisible(true);
				if (lItem-iTour<7) btnRedu.setVisible(false);
				else btnRedu.setVisible(true);
			}
		});
	}
	
	private void showList(int i) {
		//ds= tourBus.getDS();
		if (lItem-iTour==5) {
			updateDataItem1(i);
			i++;
			updateDataItem2(i);
			i++;
			updateDataItem3(i);
			i++;
			updateDataItem4(i);
			i++;
			updateDataItem5(i);
			item6.setVisible(false);
		}
		else
		if (lItem-iTour==4) {
			updateDataItem1(i);
			i++;
			updateDataItem2(i);
			i++;
			updateDataItem3(i);
			i++;
			updateDataItem4(i);
			item5.setVisible(false);
			item6.setVisible(false);
		}else
		if (lItem-iTour==3) {
			updateDataItem1(i);
			i++;
			updateDataItem2(i);
			i++;
			updateDataItem3(i);
			item4.setVisible(false);
			item5.setVisible(false);
			item6.setVisible(false);
		}else
		if (lItem-iTour==2) {
			updateDataItem1(i);
			i++;
			updateDataItem2(i);
			item3.setVisible(false);
			item4.setVisible(false);
			item5.setVisible(false);
			item6.setVisible(false);
		}else
		if (lItem-iTour==1) {
			updateDataItem1(i);
			item2.setVisible(false);
			item3.setVisible(false);
			item4.setVisible(false);
			item5.setVisible(false);
			item6.setVisible(false);
		}else
		if (lItem-iTour<1) {
			txtMess.setText("Không có tour!");
			item1.setVisible(false);
			item2.setVisible(false);
			item3.setVisible(false);
			item4.setVisible(false);
			item5.setVisible(false);
			item6.setVisible(false);
		}
		else
		if (lItem>5) {
			item1.setVisible(true);
			item2.setVisible(true);
			item3.setVisible(true);
			item4.setVisible(true);
			item5.setVisible(true);
			item6.setVisible(true);
			updateDataItem1(i);
			i++;
			updateDataItem2(i);
			i++;
			updateDataItem3(i);
			i++;
			updateDataItem4(i);
			i++;
			updateDataItem5(i);
			i++;
			updateDataItem6(i);
			i++;
		}
	}
	
	private void updateDataItem1(int i) {
		tourPicture1.setIcon(new ImageIcon(scaledImage(ds.get(i).getHinhAnh(),tourPicture1.getWidth(),tourPicture1.getHeight())));
		tourName1.setText(ds.get(i).getTenTour());
		DecimalFormat df = new DecimalFormat("#,###Đ");
		tourPrice1.setText(df.format(ds.get(i).getGia()));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		tourTime1.setText(dtf.format(ds.get(i).getNgayKhoiHanh())+" - "+ds.get(i).getSoNgay()+" ngày");
		System.out.println(ds.get(i).getNgayKhoiHanh());
		tourID1.setText("Mã tour: "+ds.get(i).getMaTour());
	}
	
	private void updateDataItem2(int i) {
		tourPicture2.setIcon(new ImageIcon(scaledImage(ds.get(i).getHinhAnh(),tourPicture2.getWidth(),tourPicture2.getHeight())));
		tourName2.setText(ds.get(i).getTenTour());
		DecimalFormat df = new DecimalFormat("#,###Đ");
		tourPrice2.setText(df.format(ds.get(i).getGia()));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		tourTime2.setText(dtf.format(ds.get(i).getNgayKhoiHanh())+" - "+ds.get(i).getSoNgay()+" ngày");
		tourID2.setText("Mã tour: "+ds.get(i).getMaTour());
	}
	
	private void updateDataItem3(int i) {
		tourPicture3.setIcon(new ImageIcon(scaledImage(ds.get(i).getHinhAnh(),tourPicture3.getWidth(),tourPicture3.getHeight())));
		tourName3.setText(ds.get(i).getTenTour());
		DecimalFormat df = new DecimalFormat("#,###Đ");
		tourPrice3.setText(df.format(ds.get(i).getGia()));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		tourTime3.setText(dtf.format(ds.get(i).getNgayKhoiHanh())+" - "+ds.get(i).getSoNgay()+" ngày");
		tourID3.setText("Mã tour: "+ds.get(i).getMaTour());
	}
	
	private void updateDataItem4(int i) {
		tourPicture4.setIcon(new ImageIcon(scaledImage(ds.get(i).getHinhAnh(),tourPicture4.getWidth(),tourPicture4.getHeight())));
		tourName4.setText(ds.get(i).getTenTour());
		DecimalFormat df = new DecimalFormat("#,###Đ");
		tourPrice4.setText(df.format(ds.get(i).getGia()));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		tourTime4.setText(dtf.format(ds.get(i).getNgayKhoiHanh())+" - "+ds.get(i).getSoNgay()+" ngày");
		tourID4.setText("Mã tour: "+ds.get(i).getMaTour());
	}
	private void updateDataItem5(int i) {
		tourPicture5.setIcon(new ImageIcon(scaledImage(ds.get(i).getHinhAnh(),tourPicture5.getWidth(),tourPicture5.getHeight())));
		tourName5.setText(ds.get(i).getTenTour());
		DecimalFormat df = new DecimalFormat("#,###Đ");
		tourPrice5.setText(df.format(ds.get(i).getGia()));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		tourTime5.setText(dtf.format(ds.get(i).getNgayKhoiHanh())+" - "+ds.get(i).getSoNgay()+" ngày");
		tourID5.setText("Mã tour: "+ds.get(i).getMaTour());
	}
	private void updateDataItem6(int i) {
		tourPicture6.setIcon(new ImageIcon(scaledImage(ds.get(i).getHinhAnh(),tourPicture6.getWidth(),tourPicture6.getHeight())));
		tourName6.setText(ds.get(i).getTenTour());
		DecimalFormat df = new DecimalFormat("#,###Đ");
		tourPrice6.setText(df.format(ds.get(i).getGia()));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		tourTime6.setText(dtf.format(ds.get(i).getNgayKhoiHanh())+" - "+ds.get(i).getSoNgay()+" ngày");
		tourID6.setText("Mã tour: "+ds.get(i).getMaTour());
	}
	private BufferedImage scaledImage(BufferedImage img, int w, int h) {
		BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resizedImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, w, h,null);
		g2.dispose();
		return resizedImage;
	}
	

	private String[] updateCboBoxDiemDi() {
		String[] s = {};
		List<String> list = new ArrayList<>(Arrays.asList(s));
		for (Tour t : tourBus.getDS()) {
				if (!list.contains(t.getDiemDi())) list.add(t.getDiemDi());
		}
		s=list.toArray(new String[0]);
		return s;
	}
	private String[] updateCboBoxDiemDen() {
		String[] s = {};
		List<String> list = new ArrayList<>(Arrays.asList(s));
		for (Tour t : tourBus.getDS()) {
				if (!list.contains(t.getDiemDen())) list.add(t.getDiemDen());
			
		}
		s=list.toArray(new String[0]);
		return s;
	}
}
