package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Controller.QLCBController;
import DAO.DAODangNhap;
import Model.DangNhapDangKy;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ViewDangNhap extends JFrame {

	private DangNhapDangKy dangKy;
	private DAODangNhap daoDangNhap;
	private JPanel contentPane;
	private JTextField textField_taikhoan;
	private JTextField textField_doitaikhoan;
	private JRadioButton RadioButton_admin;
	private JTextField textField_tendangnhap;
	private JPasswordField passwordField_matkhau;
	private JPasswordField jPasswordField_xacnhanmk;
	private JPasswordField jPasswordField_nhapmatkhau;
	private JPasswordField jPasswordField_matkhaucu;
	private JPasswordField jPasswordField_matkhaumoi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDangNhap frame = new ViewDangNhap();
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
	public ViewDangNhap() {
		this.dangKy = new DangNhapDangKy();
		this.daoDangNhap = new DAODangNhap();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 375);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		QLCBController controller = new QLCBController(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel_taikhoan = new Panel();
		panel_taikhoan.setBounds(18, 11, 472, 316);
		panel_taikhoan.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tài Khoản");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(64, 118, 107, 36);
		panel_taikhoan.add(lblNewLabel);

		JLabel lblMtKhu = new JLabel("Mật Khẩu");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMtKhu.setBounds(64, 181, 107, 36);
		panel_taikhoan.add(lblMtKhu);

		textField_taikhoan = new JTextField();
		textField_taikhoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_taikhoan.setBounds(262, 119, 193, 36);
		panel_taikhoan.add(textField_taikhoan);
		textField_taikhoan.setColumns(10);

		passwordField_matkhau = new JPasswordField();
		passwordField_matkhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField_matkhau.setColumns(10);
		passwordField_matkhau.setBounds(262, 181, 193, 36);
		panel_taikhoan.add(passwordField_matkhau);

		JButton btnNewButton = new JButton("Đăng Nhập");
		btnNewButton.addActionListener(controller);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(93, 275, 133, 36);
		panel_taikhoan.add(btnNewButton);

		JButton btnngK = new JButton("Đăng Ký");
		btnngK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnngK.setBounds(299, 275, 133, 36);
		panel_taikhoan.add(btnngK);

		JLabel lblNewLabel_1 = new JLabel("Đăng Nhập Tài Khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(82, 11, 326, 74);
		panel_taikhoan.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Đổi Mật Khẩu");
		btnNewButton_1.addActionListener(controller);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(262, 235, 193, 36);
		panel_taikhoan.add(btnNewButton_1);
		btnNewButton_1.addActionListener(controller);

		JPanel jPanel_dangky = new JPanel();
		jPanel_dangky.setBounds(18, 11, 472, 316);
		jPanel_dangky.setLayout(null);

		JPanel panel_doimatkhau = new JPanel();
		panel_doimatkhau.setBounds(18, 11, 472, 316);
		panel_doimatkhau.setLayout(null);

		JButton btnNewButton_2 = new JButton("<");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(0, 0, 47, 36);
		panel_doimatkhau.add(btnNewButton_2);

		JLabel lblNewLabel_2 = new JLabel("Đổi Mật Khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(122, 36, 205, 44);
		panel_doimatkhau.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tài Khoản");
		lblNewLabel_3.setBounds(44, 105, 118, 44);
		panel_doimatkhau.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblMtKhuC = new JLabel("Mật Khẩu Cũ");
		lblMtKhuC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMtKhuC.setBounds(44, 167, 118, 36);
		panel_doimatkhau.add(lblMtKhuC);

		JLabel lblMtKhuMi = new JLabel("Mật Khẩu Mới");
		lblMtKhuMi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMtKhuMi.setBounds(44, 232, 131, 36);
		panel_doimatkhau.add(lblMtKhuMi);

		textField_doitaikhoan = new JTextField();
		textField_doitaikhoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_doitaikhoan.setColumns(10);
		textField_doitaikhoan.setBounds(242, 113, 193, 36);
		panel_doimatkhau.add(textField_doitaikhoan);

		jPasswordField_matkhaucu = new JPasswordField(30);
		jPasswordField_matkhaucu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jPasswordField_matkhaucu.setColumns(10);
		jPasswordField_matkhaucu.setBounds(242, 167, 193, 36);
		panel_doimatkhau.add(jPasswordField_matkhaucu);

		jPasswordField_matkhaumoi = new JPasswordField(30);
		jPasswordField_matkhaumoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jPasswordField_matkhaumoi.setColumns(10);
		jPasswordField_matkhaumoi.setBounds(242, 232, 193, 36);
		panel_doimatkhau.add(jPasswordField_matkhaumoi);

		JButton btnXcNhni = new JButton("Xác Nhận Đổi");
		btnXcNhni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXcNhni.setBounds(136, 269, 171, 36);
		panel_doimatkhau.add(btnXcNhni);
		btnXcNhni.addActionListener(controller);

		RadioButton_admin = new JRadioButton("ADMIN");
		RadioButton_admin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		RadioButton_admin.setBounds(60, 235, 111, 34);
		panel_taikhoan.add(RadioButton_admin);

		CardLayout cardLayout = new CardLayout();
		JPanel panel_card = new JPanel(cardLayout);
		panel_card.add(panel_taikhoan, "panel_taikhoan");
		panel_card.add(jPanel_dangky, "jPanel_dangky");

		JLabel lblNewLabel_1_1 = new JLabel("Đăng Ký Tài Khoản");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(87, 11, 270, 74);
		jPanel_dangky.add(lblNewLabel_1_1);

		JLabel lblNewLabel_4 = new JLabel("Tên Đăng Nhập");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(28, 96, 150, 34);
		jPanel_dangky.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("Nhập Mật Khẩu");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1.setBounds(28, 141, 150, 34);
		jPanel_dangky.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("Xác Nhận Mật Khẩu");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_2.setBounds(28, 186, 187, 34);
		jPanel_dangky.add(lblNewLabel_4_2);

		jPasswordField_xacnhanmk = new JPasswordField(30);
		jPasswordField_xacnhanmk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jPasswordField_xacnhanmk.setBounds(225, 186, 187, 34);
		jPanel_dangky.add(jPasswordField_xacnhanmk);
		jPasswordField_xacnhanmk.setColumns(10);

		jPasswordField_nhapmatkhau = new JPasswordField(30);
		jPasswordField_nhapmatkhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jPasswordField_nhapmatkhau.setColumns(10);
		jPasswordField_nhapmatkhau.setBounds(225, 141, 187, 34);
		jPanel_dangky.add(jPasswordField_nhapmatkhau);

		textField_tendangnhap = new JTextField();
		textField_tendangnhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_tendangnhap.setColumns(10);
		textField_tendangnhap.setBounds(225, 96, 187, 34);
		jPanel_dangky.add(textField_tendangnhap);

		JButton btnNewButton_3 = new JButton("Đăng Ký");
		btnNewButton_3.addActionListener(controller);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(136, 242, 169, 34);
		jPanel_dangky.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("<");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setBounds(0, 0, 47, 34);
		jPanel_dangky.add(btnNewButton_4);
		panel_card.add(panel_doimatkhau, "panel_doimatkhau");
		panel_card.setBounds(18, 11, 472, 316);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel_card, "panel_taikhoan");
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel_card, "panel_doimatkhau");
			}
		});
		btnngK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel_card, "jPanel_dangky");
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel_card, "panel_taikhoan");
			}
		});
		contentPane.add(panel_card);

		setVisible(true);
	}

	public void thuchiendangky() {
		String taikhoan = textField_tendangnhap.getText();
		String matkhau = jPasswordField_nhapmatkhau.getText();
		if (matkhau.equals(jPasswordField_xacnhanmk.getText())) {
			DangNhapDangKy nk = new DangNhapDangKy(taikhoan, matkhau);
			this.daoDangNhap.insert(nk);
			textField_tendangnhap.setText("");
			jPasswordField_nhapmatkhau.setText("");
			jPasswordField_xacnhanmk.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "Mật khẩu nhập không trùng");
		}
	}

	public void thuchiendoimatkhau() {
		String taikhoan = textField_doitaikhoan.getText();
		String matkhaucu = jPasswordField_matkhaucu.getText();
		String matkhaumoi = jPasswordField_matkhaumoi.getText();
		boolean kiemtrataikhoan = this.daoDangNhap.kiemtramatkhau(taikhoan, matkhaucu);
		if (kiemtrataikhoan) {
			DangNhapDangKy nk = new DangNhapDangKy(taikhoan, matkhaumoi);
			this.daoDangNhap.update(nk);
			textField_doitaikhoan.setText("");
			jPasswordField_matkhaumoi.setText("");
			jPasswordField_matkhaucu.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "Nhập sai tài khoản hoặc mật khẩu", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void thuchiendangnhap() {
		String taikhoan = textField_taikhoan.getText();
		char[] matkhau = passwordField_matkhau.getPassword(); // Lấy mật khẩu dưới dạng char[]

		boolean kiemtrataikhoan = this.daoDangNhap.kiemtramatkhau(taikhoan, new String(matkhau));

		if (kiemtrataikhoan) {
			if (RadioButton_admin.isSelected()) {
				JPasswordField passwordField = new JPasswordField();
				Object[] message = { "Nhập mật khẩu ADMIN:", passwordField };
				int option = JOptionPane.showConfirmDialog(this, message, "MESSENGER", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE);

				if (option == JOptionPane.OK_OPTION) {
					char[] enteredPassword = passwordField.getPassword();
					if (new String(enteredPassword).equals("010605")) {
						dispose();
						ADMIN ad = new ADMIN();
						ad.setVisible(true);
						RadioButton_admin.setSelected(false);
					} else {
						JOptionPane.showMessageDialog(this, "Nhập sai mật khẩu admin", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				dispose();
				NguoiDung nd = new NguoiDung();
				nd.setVisible(true);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Nhập sai tài khoản / mật khẩu", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		passwordField_matkhau.setText("");
	}
}
