package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

import javax.accessibility.Accessible;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JWindow;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.Choice;

public class Home extends JFrame {

	private JPanel pnHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
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
				Login login = new Login();
				login.main(null);
			}
		});
		btnUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUser.setForeground(new Color(255, 255, 255));
		btnUser.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\user.png"));
		btnUser.setBounds(1050, 11, 51, 52);
		pnHeader.add(btnUser);
		
		JPanel radius = new JPanel() {
		     @Override
		     protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        Dimension arcs = new Dimension(50,50);
		        int width = getWidth();
		        int height = getHeight();
		        Graphics2D graphics = (Graphics2D) g;
		        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


		        //Draws the rounded opaque panel with borders.
		        graphics.setColor(getBackground());
		        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
		        graphics.setColor(getForeground());
		        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
		     }
		  };
		radius.setOpaque(false);
		radius.setBackground(new Color(255, 255, 255));
		radius.setBounds(247, 11, 700, 58);
		pnHeader.add(radius);
		radius.setLayout(null);
		
		JLabel lblLogo = new JLabel("ViGo");
		lblLogo.setFont(new Font("Arial", Font.BOLD, 35));
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\beach_118051 (1).png"));
		lblLogo.setBounds(10, 3, 339, 72);
		pnHeader.add(lblLogo);
		
		JLabel btnCart = new JLabel("");
		btnCart.setBounds(1104, 11, 51, 52);
		pnHeader.add(btnCart);
		btnCart.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\cart.png"));
		
		JLabel titleContent = new JLabel("Tour đặc biệt dành cho bạn");
		titleContent.setFont(new Font("Arial", Font.BOLD, 20));
		titleContent.setBounds(10, 107, 266, 31);
		pnHome.add(titleContent);
		
		JPanel listTour = new JPanel();
		listTour.setBackground(Color.WHITE);
		listTour.setBounds(100, 149, 1000, 540);
		pnHome.add(listTour);
		listTour.setLayout(null);
		
		JPanel item1 = new JPanel();
		item1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lg = new Login();
				lg.main(null);
			}
		});
		item1.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		item1.setBackground(Color.WHITE);
		item1.setBounds(0, 0, 320, 260);
		listTour.add(item1);
		item1.setLayout(null);
		
		JLabel tourPicture1 = new JLabel("");
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
		
		JLabel tourName1 = new JLabel("Đà Lạt");
		tourName1.setFont(new Font("Arial", Font.BOLD, 15));
		tourName1.setBounds(10, 196, 300, 20);
		item1.add(tourName1);
		
		JLabel tourPrice1 = new JLabel("5.000.000Đ");
		tourPrice1.setHorizontalAlignment(SwingConstants.RIGHT);
		tourPrice1.setFont(new Font("Arial", Font.BOLD, 18));
		tourPrice1.setForeground(Color.RED);
		tourPrice1.setBounds(130, 234, 180, 15);
		item1.add(tourPrice1);
		
		JLabel tourTime1 = new JLabel("11/04/2023 - 3 ngày");
		tourTime1.setFont(new Font("Arial", Font.PLAIN, 10));
		tourTime1.setBounds(10, 182, 300, 14);
		item1.add(tourTime1);
		
		JLabel tourID1 = new JLabel("Mã tour: DL001");
		tourID1.setFont(new Font("Arial", Font.PLAIN, 10));
		tourID1.setBounds(10, 214, 300, 14);
		item1.add(tourID1);
		
		JLabel tourBtn1 = new JLabel("Xem chi tiết");
		tourBtn1.setForeground(new Color(186, 85, 211));
		tourBtn1.setHorizontalAlignment(SwingConstants.CENTER);
		tourBtn1.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		tourBtn1.setBounds(10, 235, 88, 16);
		item1.add(tourBtn1);
		
		JPanel item2 = new JPanel();
		item2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item2.setLayout(null);
		item2.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		item2.setBackground(Color.WHITE);
		item2.setBounds(341, 0, 320, 260);
		listTour.add(item2);
		
		JLabel tourPicture2 = new JLabel("");
		tourPicture2.setVerticalTextPosition(SwingConstants.BOTTOM);
		tourPicture2.setVerticalAlignment(SwingConstants.TOP);
		tourPicture2.setIgnoreRepaint(true);
		tourPicture2.setHorizontalTextPosition(SwingConstants.CENTER);
		tourPicture2.setHorizontalAlignment(SwingConstants.CENTER);
		tourPicture2.setFocusTraversalPolicyProvider(true);
		tourPicture2.setFocusTraversalKeysEnabled(false);
		tourPicture2.setBounds(10, 11, 300, 165);
		item2.add(tourPicture2);
		
		JLabel tourName2 = new JLabel("Đà Lạt");
		tourName2.setFont(new Font("Arial", Font.BOLD, 15));
		tourName2.setBounds(10, 196, 300, 20);
		item2.add(tourName2);
		
		JLabel tourPrice2 = new JLabel("5.000.000Đ");
		tourPrice2.setHorizontalAlignment(SwingConstants.RIGHT);
		tourPrice2.setForeground(Color.RED);
		tourPrice2.setFont(new Font("Arial", Font.BOLD, 18));
		tourPrice2.setBounds(130, 234, 180, 15);
		item2.add(tourPrice2);
		
		JLabel tourTime2 = new JLabel("11/04/2023 - 3 ngày");
		tourTime2.setFont(new Font("Arial", Font.PLAIN, 10));
		tourTime2.setBounds(10, 182, 300, 14);
		item2.add(tourTime2);
		
		JLabel tourID2 = new JLabel("Mã tour: DL001");
		tourID2.setFont(new Font("Arial", Font.PLAIN, 10));
		tourID2.setBounds(10, 214, 300, 14);
		item2.add(tourID2);
		
		JLabel tourBtn2 = new JLabel("Xem chi tiết");
		tourBtn2.setHorizontalAlignment(SwingConstants.CENTER);
		tourBtn2.setForeground(new Color(186, 85, 211));
		tourBtn2.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		tourBtn2.setBounds(10, 235, 88, 16);
		item2.add(tourBtn2);
		
		JPanel item3 = new JPanel();
		item3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item3.setLayout(null);
		item3.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		item3.setBackground(Color.WHITE);
		item3.setBounds(680, 0, 320, 260);
		listTour.add(item3);
		
		JLabel tourPicture3 = new JLabel("");
		tourPicture3.setVerticalTextPosition(SwingConstants.BOTTOM);
		tourPicture3.setVerticalAlignment(SwingConstants.TOP);
		tourPicture3.setIgnoreRepaint(true);
		tourPicture3.setHorizontalTextPosition(SwingConstants.CENTER);
		tourPicture3.setHorizontalAlignment(SwingConstants.CENTER);
		tourPicture3.setFocusTraversalPolicyProvider(true);
		tourPicture3.setFocusTraversalKeysEnabled(false);
		tourPicture3.setBounds(10, 11, 300, 165);
		item3.add(tourPicture3);
		
		JLabel tourName3 = new JLabel("Đà Lạt");
		tourName3.setFont(new Font("Arial", Font.BOLD, 15));
		tourName3.setBounds(10, 196, 300, 20);
		item3.add(tourName3);
		
		JLabel tourPrice3 = new JLabel("5.000.000Đ");
		tourPrice3.setHorizontalAlignment(SwingConstants.RIGHT);
		tourPrice3.setForeground(Color.RED);
		tourPrice3.setFont(new Font("Arial", Font.BOLD, 18));
		tourPrice3.setBounds(130, 234, 180, 15);
		item3.add(tourPrice3);
		
		JLabel tourTime3 = new JLabel("11/04/2023 - 3 ngày");
		tourTime3.setFont(new Font("Arial", Font.PLAIN, 10));
		tourTime3.setBounds(10, 182, 300, 14);
		item3.add(tourTime3);
		
		JLabel tourID3 = new JLabel("Mã tour: DL001");
		tourID3.setFont(new Font("Arial", Font.PLAIN, 10));
		tourID3.setBounds(10, 214, 300, 14);
		item3.add(tourID3);
		
		JLabel tourBtn3 = new JLabel("Xem chi tiết");
		tourBtn3.setHorizontalAlignment(SwingConstants.CENTER);
		tourBtn3.setForeground(new Color(186, 85, 211));
		tourBtn3.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		tourBtn3.setBounds(10, 235, 88, 16);
		item3.add(tourBtn3);
		
		JPanel item4 = new JPanel();
		item4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item4.setLayout(null);
		item4.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		item4.setBackground(Color.WHITE);
		item4.setBounds(0, 280, 320, 260);
		listTour.add(item4);
		
		JLabel tourPicture4 = new JLabel("");
		tourPicture4.setVerticalTextPosition(SwingConstants.BOTTOM);
		tourPicture4.setVerticalAlignment(SwingConstants.TOP);
		tourPicture4.setIgnoreRepaint(true);
		tourPicture4.setHorizontalTextPosition(SwingConstants.CENTER);
		tourPicture4.setHorizontalAlignment(SwingConstants.CENTER);
		tourPicture4.setFocusTraversalPolicyProvider(true);
		tourPicture4.setFocusTraversalKeysEnabled(false);
		tourPicture4.setBounds(10, 11, 300, 165);
		item4.add(tourPicture4);
		
		JLabel tourName4 = new JLabel("Đà Lạt");
		tourName4.setFont(new Font("Arial", Font.BOLD, 15));
		tourName4.setBounds(10, 196, 300, 20);
		item4.add(tourName4);
		
		JLabel tourPrice4 = new JLabel("5.000.000Đ");
		tourPrice4.setHorizontalAlignment(SwingConstants.RIGHT);
		tourPrice4.setForeground(Color.RED);
		tourPrice4.setFont(new Font("Arial", Font.BOLD, 18));
		tourPrice4.setBounds(130, 234, 180, 15);
		item4.add(tourPrice4);
		
		JLabel tourTime4 = new JLabel("11/04/2023 - 3 ngày");
		tourTime4.setFont(new Font("Arial", Font.PLAIN, 10));
		tourTime4.setBounds(10, 182, 300, 14);
		item4.add(tourTime4);
		
		JLabel tourID4 = new JLabel("Mã tour: DL001");
		tourID4.setFont(new Font("Arial", Font.PLAIN, 10));
		tourID4.setBounds(10, 214, 300, 14);
		item4.add(tourID4);
		
		JLabel tourBtn4 = new JLabel("Xem chi tiết");
		tourBtn4.setHorizontalAlignment(SwingConstants.CENTER);
		tourBtn4.setForeground(new Color(186, 85, 211));
		tourBtn4.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		tourBtn4.setBounds(10, 235, 88, 16);
		item4.add(tourBtn4);
		
		JPanel item5 = new JPanel();
		item5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item5.setLayout(null);
		item5.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		item5.setBackground(Color.WHITE);
		item5.setBounds(341, 280, 320, 260);
		listTour.add(item5);
		
		JLabel tourPicture5 = new JLabel("");
		tourPicture5.setVerticalTextPosition(SwingConstants.BOTTOM);
		tourPicture5.setVerticalAlignment(SwingConstants.TOP);
		tourPicture5.setIgnoreRepaint(true);
		tourPicture5.setHorizontalTextPosition(SwingConstants.CENTER);
		tourPicture5.setHorizontalAlignment(SwingConstants.CENTER);
		tourPicture5.setFocusTraversalPolicyProvider(true);
		tourPicture5.setFocusTraversalKeysEnabled(false);
		tourPicture5.setBounds(10, 11, 300, 165);
		item5.add(tourPicture5);
		
		JLabel tourName5 = new JLabel("Đà Lạt");
		tourName5.setFont(new Font("Arial", Font.BOLD, 15));
		tourName5.setBounds(10, 196, 300, 20);
		item5.add(tourName5);
		
		JLabel tourPrice5 = new JLabel("5.000.000Đ");
		tourPrice5.setHorizontalAlignment(SwingConstants.RIGHT);
		tourPrice5.setForeground(Color.RED);
		tourPrice5.setFont(new Font("Arial", Font.BOLD, 18));
		tourPrice5.setBounds(130, 234, 180, 15);
		item5.add(tourPrice5);
		
		JLabel tourTime5 = new JLabel("11/04/2023 - 3 ngày");
		tourTime5.setFont(new Font("Arial", Font.PLAIN, 10));
		tourTime5.setBounds(10, 182, 300, 14);
		item5.add(tourTime5);
		
		JLabel tourID5 = new JLabel("Mã tour: DL001");
		tourID5.setFont(new Font("Arial", Font.PLAIN, 10));
		tourID5.setBounds(10, 214, 300, 14);
		item5.add(tourID5);
		
		JLabel tourBtn5 = new JLabel("Xem chi tiết");
		tourBtn5.setHorizontalAlignment(SwingConstants.CENTER);
		tourBtn5.setForeground(new Color(186, 85, 211));
		tourBtn5.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		tourBtn5.setBounds(10, 235, 88, 16);
		item5.add(tourBtn5);
		
		JPanel item6 = new JPanel();
		item6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item6.setLayout(null);
		item6.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		item6.setBackground(Color.WHITE);
		item6.setBounds(680, 280, 320, 260);
		listTour.add(item6);
		
		JLabel tourPicture6 = new JLabel("");
		tourPicture6.setVerticalTextPosition(SwingConstants.BOTTOM);
		tourPicture6.setVerticalAlignment(SwingConstants.TOP);
		tourPicture6.setIgnoreRepaint(true);
		tourPicture6.setHorizontalTextPosition(SwingConstants.CENTER);
		tourPicture6.setHorizontalAlignment(SwingConstants.CENTER);
		tourPicture6.setFocusTraversalPolicyProvider(true);
		tourPicture6.setFocusTraversalKeysEnabled(false);
		tourPicture6.setBounds(10, 11, 300, 165);
		item6.add(tourPicture6);
		
		JLabel tourName6 = new JLabel("Đà Lạt");
		tourName6.setFont(new Font("Arial", Font.BOLD, 15));
		tourName6.setBounds(10, 196, 300, 20);
		item6.add(tourName6);
		
		JLabel tourPrice6 = new JLabel("5.000.000Đ");
		tourPrice6.setHorizontalAlignment(SwingConstants.RIGHT);
		tourPrice6.setForeground(Color.RED);
		tourPrice6.setFont(new Font("Arial", Font.BOLD, 18));
		tourPrice6.setBounds(130, 234, 180, 15);
		item6.add(tourPrice6);
		
		JLabel tourTime6 = new JLabel("11/04/2023 - 3 ngày");
		tourTime6.setFont(new Font("Arial", Font.PLAIN, 10));
		tourTime6.setBounds(10, 182, 300, 14);
		item6.add(tourTime6);
		
		JLabel tourID6 = new JLabel("Mã tour: DL001");
		tourID6.setFont(new Font("Arial", Font.PLAIN, 10));
		tourID6.setBounds(10, 214, 300, 14);
		item6.add(tourID6);
		
		JLabel tourBtn6 = new JLabel("Xem chi tiết");
		tourBtn6.setHorizontalAlignment(SwingConstants.CENTER);
		tourBtn6.setForeground(new Color(186, 85, 211));
		tourBtn6.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		tourBtn6.setBounds(10, 235, 88, 16);
		item6.add(tourBtn6);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\left-arrow.png"));
		lblNewLabel_3.setBounds(25, 383, 48, 37);
		pnHome.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\right-arrow.png"));
		lblNewLabel_3_3.setBounds(1122, 383, 48, 37);
		pnHome.add(lblNewLabel_3_3);
		
		
	}
}
