package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import custom_entity.ChonMau;
import custom_entity.CustomTable;
import custom_entity.RoundedCornerBorder;
import entities.Tour;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import bus.Tour_BUS;
import connectDB.ConnectDB;

import java.awt.Color;
import java.awt.Cursor;
import custom_entity.CustomButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import custom_entity.CustomComboxBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class NhanVienQuanLy extends JFrame {

	private JPanel pnNhanVienQuanLy;
	private CustomComboxBox cboDiemDen;
	private CustomComboxBox cboDiemDi;
	private CustomComboxBox cboThang;
	private ArrayList<Tour> ds,dsTimKiem;
	private Tour_BUS tourBus;
	private String sDDi, sDDen, sNgay;
	private JLabel lblNgy;
	private UtilDateModel model; 
	private JDatePanelImpl datePanel; 
	private JDatePickerImpl datePicker;
	private JTextField textField;
	private CustomComboxBox table;
	private DefaultTableModel modelKhachHang,modelTour,modelDonDat,modelHangKhach;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienQuanLy frame = new NhanVienQuanLy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhanVienQuanLy() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//
		//tour_BUS = new Tour_BUS();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		// setBounds(84, 99, 1200, 620);
		setBounds(84, 19, 1200, 700);
		tourBus = new Tour_BUS();
		ds = tourBus.getDS();
		
		pnNhanVienQuanLy = new JPanel();
		pnNhanVienQuanLy.setBackground(new Color(255, 255, 255));
		pnNhanVienQuanLy.setBorder(null);

		setContentPane(pnNhanVienQuanLy);
		pnNhanVienQuanLy.setLayout(null);

		JPanel pnHeader = new JPanel();
		pnHeader.setBorder(null);
		pnHeader.setBackground(new Color(65, 105, 225));
		pnHeader.setBounds(0, 0, 1200, 80);
		pnNhanVienQuanLy.add(pnHeader);
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
//		btnUser.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				login = new LoginSignup();
//				login.main(null);
//			}
//		});
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
		
		JLabel btnTroVe = new JLabel("Trở về");
		btnTroVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				// System.exit(0);
			}
		});
		btnTroVe.setIcon(new ImageIcon("C:\\Users\\nghoa\\Downloads\\back.png"));
		btnTroVe.setBounds(10, 90, 80, 21);
		pnNhanVienQuanLy.add(btnTroVe);
		
		String[] strDiemDi = updateCboBoxDiemDi();
		
		String[] strDiemDen = updateCboBoxDiemDen();
		
		model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		
		CustomButton cstmbtnThaigo = new CustomButton((String) null);
		cstmbtnThaigo.setColor_fogeground(ChonMau.blue_4B70F5);
		cstmbtnThaigo.setHightlight(Color.WHITE);
		cstmbtnThaigo.setForeground(ChonMau.blue_4B70F5);
		cstmbtnThaigo.setRadius(30);
		cstmbtnThaigo.setText("TOUR");
		cstmbtnThaigo.setBounds(20, 122, 130, 50);
		cstmbtnThaigo.setFont(new Font(null,ABORT,30));
		pnNhanVienQuanLy.add(cstmbtnThaigo);
		
		CustomButton cstmbtnKhchHng = new CustomButton((String) null);
		cstmbtnKhchHng.setText("KHÁCH HÀNG");
		cstmbtnKhchHng.setRadius(30);
		cstmbtnKhchHng.setHightlight(Color.WHITE);
		cstmbtnKhchHng.setForeground(new Color(75, 112, 245));
		cstmbtnKhchHng.setFont(new Font("Dialog", Font.PLAIN, 30));
		cstmbtnKhchHng.setColor_fogeground(new Color(75, 112, 245));
		cstmbtnKhchHng.setBounds(160, 122, 214, 50);
		pnNhanVienQuanLy.add(cstmbtnKhchHng);
		
		CustomButton cstmbtnKhchHng_1 = new CustomButton((String) null);
		cstmbtnKhchHng_1.setText("ĐƠN ĐẶT");
		cstmbtnKhchHng_1.setRadius(30);
		cstmbtnKhchHng_1.setHightlight(Color.WHITE);
		cstmbtnKhchHng_1.setForeground(new Color(75, 112, 245));
		cstmbtnKhchHng_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		cstmbtnKhchHng_1.setColor_fogeground(new Color(75, 112, 245));
		cstmbtnKhchHng_1.setBounds(383, 122, 168, 50);
		pnNhanVienQuanLy.add(cstmbtnKhchHng_1);
		
		CustomButton cstmbtnHngKhch = new CustomButton((String) null);
		cstmbtnHngKhch.setText("HÀNG KHÁCH");
		cstmbtnHngKhch.setRadius(30);
		cstmbtnHngKhch.setHightlight(Color.WHITE);
		cstmbtnHngKhch.setForeground(new Color(75, 112, 245));
		cstmbtnHngKhch.setFont(new Font("Dialog", Font.PLAIN, 30));
		cstmbtnHngKhch.setColor_fogeground(new Color(75, 112, 245));
		cstmbtnHngKhch.setBounds(561, 122, 230, 50);
		pnNhanVienQuanLy.add(cstmbtnHngKhch);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 183, 1170, 506);
		pnNhanVienQuanLy.add(panel);
		panel.setLayout(null);
		
		JPanel search = new JPanel();
		search.setBounds(0, 11, 771, 58);
		panel.add(search);
		search.setBackground(new Color(255, 255, 255));
		search.setLayout(null);
		search.setBorder(new RoundedCornerBorder());
		cboDiemDi = new CustomComboxBox(strDiemDi, ChonMau.blue_4B70F5, Color.white, Color.black, ChonMau.blue_4B70F5, 30, true);
		cboDiemDi.setSize(93, 31);
		cboDiemDi.setEditable(true);
		cboDiemDi.setLocation(63, 10);
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
		cboDiemDen = new CustomComboxBox(strDiemDen, ChonMau.blue_4B70F5, Color.white, Color.black, ChonMau.blue_4B70F5, 30, true);
		cboDiemDen.setSize(128, 37);
		cboDiemDen.setLocation(288, 10);
		search.add(cboDiemDen.getPanel(Color.white, 280, 5, 170, 45));
		sDDen = (String) cboDiemDen.getSelectedItem();
		
		lblNgy = new JLabel("Ngày:");
		lblNgy.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNgy.setBounds(450, 21, 36, 20);
		search.add(lblNgy);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		datePicker.setBackground(new Color(255, 255, 255));
		datePicker.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		datePicker.setBounds(490, 17, 180, 28);
		datePicker.getJDateInstantPanel().setShowYearButtons(true);
		//datePicker.getJFormattedTextField().setText("2023-01-01");
		//datePicker.getModel().setValue(Date("2023-01-01"));
		search.add(datePicker);
		
		CustomButton customButton = new CustomButton((String) null);
		customButton.setBounds(699, 25, 1, 1);
		search.add(customButton);
		
		CustomButton cstmbtnLc = new CustomButton((String) null);
		cstmbtnLc.setRadius(20);
		cstmbtnLc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cstmbtnLc.setForeground(ChonMau.blue_4B70F5);
		cstmbtnLc.setOver(true);
		cstmbtnLc.setText("LỌC");
		cstmbtnLc.setBounds(680, 18, 55, 26);
		search.add(cstmbtnLc);
		
		String header[] =  "Mã Tour, Tên Tour, TG KhHành, Số Ngày, Số Vé Còn,Giá,TG TTrung,Điểm Đi,Điểm Đến".split(",");
		modelTour = new DefaultTableModel(header,0);
		
		CustomButton customButton_1 = new CustomButton((String) null);
		customButton_1.setBounds(351, 488, 1, 1);
		panel.add(customButton_1);
		
		CustomTable customTable = new CustomTable(modelTour, ChonMau.blue_4B70F5, Color.white);
		customTable.setBounds(10, 90, 761, 387);
		
		JScrollPane scrollPane = new JScrollPane(customTable);
		scrollPane.setBounds(0, 77, 771, 397);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin Tour");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel_1.setBounds(869, 6, 217, 34);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(869, 51, 276, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên Tour");
		lblNewLabel_2.setBounds(815, 54, 62, 14);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(869, 83, 276, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên Tour");
		lblNewLabel_2_1.setBounds(815, 86, 62, 14);
		panel.add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(869, 114, 276, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tên Tour");
		lblNewLabel_2_2.setBounds(815, 117, 62, 14);
		panel.add(lblNewLabel_2_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(869, 145, 276, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Tên Tour");
		lblNewLabel_2_2_1.setBounds(815, 148, 62, 14);
		panel.add(lblNewLabel_2_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(869, 176, 276, 20);
		panel.add(textField_5);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Tên Tour");
		lblNewLabel_2_2_2.setBounds(815, 179, 62, 14);
		panel.add(lblNewLabel_2_2_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(869, 207, 276, 20);
		panel.add(textField_6);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Tên Tour");
		lblNewLabel_2_2_3.setBounds(815, 210, 62, 14);
		panel.add(lblNewLabel_2_2_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(869, 238, 276, 20);
		panel.add(textField_7);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("Tên Tour");
		lblNewLabel_2_2_4.setBounds(815, 241, 62, 14);
		panel.add(lblNewLabel_2_2_4);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(869, 269, 276, 20);
		panel.add(textField_8);
		
		JLabel lblNewLabel_2_2_5 = new JLabel("Tên Tour");
		lblNewLabel_2_2_5.setBounds(815, 272, 62, 14);
		panel.add(lblNewLabel_2_2_5);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(869, 300, 276, 20);
		panel.add(textField_9);
		
		JLabel lblNewLabel_2_2_6 = new JLabel("Tên Tour");
		lblNewLabel_2_2_6.setBounds(815, 303, 62, 14);
		panel.add(lblNewLabel_2_2_6);
		
		CustomButton cstmbtnThm = new CustomButton((String) null);
		cstmbtnThm.setText("Thêm");
		cstmbtnThm.setRadius(30);
		cstmbtnThm.setHightlight(Color.WHITE);
		cstmbtnThm.setForeground(new Color(75, 112, 245));
		cstmbtnThm.setFont(new Font("Dialog", Font.PLAIN, 30));
		cstmbtnThm.setColor_fogeground(new Color(75, 112, 245));
		cstmbtnThm.setBounds(815, 347, 101, 34);
		panel.add(cstmbtnThm);
		
		CustomButton cstmbtnXa = new CustomButton((String) null);
		cstmbtnXa.setText("Xóa");
		cstmbtnXa.setRadius(30);
		cstmbtnXa.setHightlight(Color.WHITE);
		cstmbtnXa.setForeground(new Color(75, 112, 245));
		cstmbtnXa.setFont(new Font("Dialog", Font.PLAIN, 30));
		cstmbtnXa.setColor_fogeground(new Color(75, 112, 245));
		cstmbtnXa.setBounds(926, 347, 101, 34);
		panel.add(cstmbtnXa);
		
		CustomButton cstmbtnSa = new CustomButton((String) null);
		cstmbtnSa.setText("Sửa");
		cstmbtnSa.setRadius(30);
		cstmbtnSa.setHightlight(Color.WHITE);
		cstmbtnSa.setForeground(new Color(75, 112, 245));
		cstmbtnSa.setFont(new Font("Dialog", Font.PLAIN, 30));
		cstmbtnSa.setColor_fogeground(new Color(75, 112, 245));
		cstmbtnSa.setBounds(1044, 347, 101, 34);
		panel.add(cstmbtnSa);
		
		JLabel lblNewLabel = new JLabel("Tìm theo mã hoặc tên:");
		lblNewLabel.setBounds(801, 148, 125, 14);
		pnNhanVienQuanLy.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(936, 145, 194, 20);
		pnNhanVienQuanLy.add(textField);
		textField.setColumns(10);
		
		CustomButton cstmbtnTm = new CustomButton((String) null);
		cstmbtnTm.setBounds(1140, 143, 50, 20);
		pnNhanVienQuanLy.add(cstmbtnTm);
		cstmbtnTm.setHightlight(Color.WHITE);
		cstmbtnTm.setForeground(new Color(75, 112, 245));
		cstmbtnTm.setFont(new Font("Dialog", Font.PLAIN, 15));
		cstmbtnTm.setColor_fogeground(new Color(75, 112, 245));
		cstmbtnTm.setText("TÌM");
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
