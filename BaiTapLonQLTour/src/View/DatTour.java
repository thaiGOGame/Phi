package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.awt.ScrollPane;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DatTour extends JFrame {

	private JPanel pnDatTour;
	private JTable table;
	private DefaultTableModel tableModel;
	private int soLuongHK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatTour frame = new DatTour();
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
	public DatTour() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(84, 99, 1200, 620);
		pnDatTour = new JPanel();
		pnDatTour.setBackground(new Color(255, 255, 255));
		pnDatTour.setBorder(null);

		setContentPane(pnDatTour);
		pnDatTour.setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		
		JLabel tenTour = new JLabel("Đà Lạt");
		tenTour.setForeground(new Color(65, 105, 225));
		tenTour.setFont(new Font("Arial", Font.PLAIN, 30));
		tenTour.setBounds(74, 43, 468, 49);
		pnDatTour.add(tenTour);
		
		JLabel h1 = new JLabel("Thông tin cơ bản:");
		h1.setFont(new Font("Arial", Font.PLAIN, 20));
		h1.setBounds(74, 124, 161, 21);
		pnDatTour.add(h1);
		
		JLabel maTour = new JLabel("Mã tour:");
		maTour.setBounds(114, 152, 46, 14);
		pnDatTour.add(maTour);
		
		JLabel ngayKhoiHanh = new JLabel("Khởi hành 11/04/2023");
		ngayKhoiHanh.setBounds(114, 172, 131, 14);
		pnDatTour.add(ngayKhoiHanh);
		
		JLabel gioDi = new JLabel("- Giờ đi: 17:50");
		gioDi.setBounds(250, 172, 110, 14);
		pnDatTour.add(gioDi);
		
		JLabel diemTapTrung = new JLabel("Tập trung 15:00 tại sân bay Tân Sơn Nhất ");
		diemTapTrung.setBounds(114, 192, 253, 14);
		pnDatTour.add(diemTapTrung);
		
		JLabel soNgay = new JLabel("Số ngày: 3");
		soNgay.setBounds(114, 212, 63, 14);
		pnDatTour.add(soNgay);
		
		JLabel noiKhoiHanh = new JLabel("Nơi khởi hành: TP Hồ Chí Minh");
		noiKhoiHanh.setBounds(114, 232, 196, 14);
		pnDatTour.add(noiKhoiHanh);
		
		JLabel soChoConNhan = new JLabel("Số chỗ còn nhận: 2");
		soChoConNhan.setBounds(114, 252, 131, 14);
		pnDatTour.add(soChoConNhan);
		
		JLabel h2 = new JLabel("Thông tin hướng dẫn viên:");
		h2.setFont(new Font("Arial", Font.PLAIN, 20));
		h2.setBounds(74, 274, 246, 24);
		pnDatTour.add(h2);
		
		JLabel tenHDV = new JLabel("Họ tên: Nguyễn Văn A");
		tenHDV.setBounds(114, 302, 196, 14);
		pnDatTour.add(tenHDV);
		
		JLabel sdtHDV = new JLabel("Số điện thoại: 0213232333");
		sdtHDV.setBounds(114, 322, 196, 14);
		pnDatTour.add(sdtHDV);
		
		JPanel btnDatNgay = new JPanel();
		btnDatNgay.setBackground(new Color(220, 20, 60));
		btnDatNgay.setToolTipText("");
		btnDatNgay.setBounds(732, 462, 287, 49);
		pnDatTour.add(btnDatNgay);
		btnDatNgay.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Đặt ngay");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(116, 11, 74, 29);
		btnDatNgay.add(lblNewLabel_10);
		
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(1,1,10,1));
		spinner.addChangeListener((ChangeListener) new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				soLuongHK = (int) spinner.getValue();
				showTable();
			}
        });
		spinner.setBounds(231, 347, 30, 28);
		pnDatTour.add(spinner);
		spinner.setValue((int)1);
		
		
		JLabel soLuongVe = new JLabel("Số lượng vé");
		soLuongVe.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		soLuongVe.setBounds(74, 347, 161, 28);
		pnDatTour.add(soLuongVe);
		
		JLabel hinhAnh = new JLabel("");
		hinhAnh.setIcon(new ImageIcon("T:\\java\\baitap\\TestGui\\images\\thanh-pho-da-lat.jpg"));
		hinhAnh.setBounds(593, 43, 560, 332);
		pnDatTour.add(hinhAnh);
		
		JLabel btnTroVe = new JLabel("Trở về");
		btnTroVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		btnTroVe.setIcon(new ImageIcon("C:\\Users\\nghoa\\Downloads\\back.png"));
		btnTroVe.setBounds(10, 11, 80, 21);
		pnDatTour.add(btnTroVe);
		
		JLabel giaTour = new JLabel("5.000.000đ");
		giaTour.setForeground(new Color(255, 0, 0));
		giaTour.setFont(new Font("Arial", Font.BOLD, 26));
		giaTour.setBounds(74, 86, 161, 28);
		pnDatTour.add(giaTour);
		
		String header[] = {"STT","Họ tên","Số điện thoại"};
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane(table = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int row, int col) {
				// TODO Auto-generated method stub
				if (col==0) return false;
				return true;
			}
		});
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		table.setBorder(null);
		scrollPane.setBounds(74, 410, 468, 166);
		pnDatTour.add(scrollPane);
		
		soLuongHK=1;
		showTable();
	}
	
	private void removeDataTable() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		table.setModel(dm);
	}
	private void updateDataTable() {
		removeDataTable();
		for (int i=0;i<soLuongHK;i++) {
			String []data = {i+1+"","",""};
			tableModel.addRow(data);
		}
	}
	private void showTable() {
		updateDataTable();
		table.setModel(tableModel);
	}
}
