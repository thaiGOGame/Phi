package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LoginSignup extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	//private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginSignup frame = new LoginSignup();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		new LoginSignup().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public LoginSignup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		setUndecorated(true);
		getContentPane().setLayout(null);
		
		JPanel pnLogin = new JPanel();
		pnLogin.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		pnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		pnLogin.setBounds(0, 0, 1200, 620);
		getContentPane().add(pnLogin);
		pnLogin.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
		panel.setBounds(124, 86, 400, 350);
		pnLogin.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Đăng nhập");
		lblNewLabel_1.setBounds(169, 11, 58, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(30, 81, 46, 14);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(30, 106, 320, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mật khẩu");
		lblNewLabel_3.setBounds(30, 164, 46, 14);
		panel.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(30, 200, 320, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("trở về");
		lblNewLabel.setBounds(10, 11, 46, 14);
		pnLogin.add(lblNewLabel);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//setContentPane(contentPane);
	}
}
