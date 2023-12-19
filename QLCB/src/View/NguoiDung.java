package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerDatVe;
import Controller.QLCBController;
import DAO.KhachHangDAO;
import DAO.LichBayDAO;
import Model.DSKhachHang;
import Model.DSLichBay;
import Model.EditLichBay;
import Model.KhachHang;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class NguoiDung extends JFrame {

	private DSKhachHang dsKhachHang;
	private KhachHangDAO khachHangDAO;
	private LichBayDAO lichBayDAO;
	private DSLichBay dsLichBay;
	private JPanel contentPane;
	private JTable table_lichbay;
	private JTextField textField_lbtimngaybay;
	private JTable table_datve;
	private JComboBox comboBox_lbtimhacanh;
	private JComboBox comboBox_lbtimkhoihanh;
	private JComboBox comboBox_lbtimhangbay;
	private JTextField textField_dtenkhachhang;
	private JTextField textField_dngaysinh;
	private JTextField textField_dsdt;
	private JTextField textField_dcccd;
	private JRadioButton NewRadioButton_dnam;
	private JRadioButton NewRadioButton_dnu;
	private ButtonGroup btn_groupDgioitinh;
	private JComboBox comboBox_datvemachuyenbay;
	private JTextField textField_tccccd;
	private JTextField textField_tcsdt;
	private JLabel NewLabel_machuyenbay;
	private JLabel NewLabel_ngaybay;
	private JLabel NewLabel_giobay;
	private JLabel NewLabel_khoihanh;
	private JLabel NewLabel_hacanh;
	private JLabel NewLabel_hangbay;
	private JLabel NewLabel_soghe;
	private JLabel NewLabel_tenkhachhang;
	private JLabel NewLabel_gioitinh;
	private JLabel NewLabel_ngaysinh;
	private JLabel NewLabel_trangthai;
	private JLabel NewLabel_loaighe;
	private JComboBox comboBox_EconomyClass;
	private JComboBox comboBox_BusinessClass;
	private JComboBox comboBox_FirstClass;
	private CardLayout cardLayout;
	private JPanel jPanel_card;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NguoiDung frame = new NguoiDung();
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
	public NguoiDung() {
		this.dsLichBay = new DSLichBay();
		this.lichBayDAO = new LichBayDAO();
		this.dsKhachHang = new DSKhachHang();
		this.khachHangDAO = new KhachHangDAO();
		setTitle("Người Dùng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 680);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		QLCBController controller = new QLCBController(this);
		ControllerDatVe controllerDatVe = new ControllerDatVe(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 246, 223, 311);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Lịch Bay");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 52, 189, 42);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Đặt Vé");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(10, 105, 189, 42);
		panel.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Đăng Xuất");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(10, 205, 189, 42);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int chon = JOptionPane.showConfirmDialog(null, "Xác nhận đăng xuất?", "Messenger",
						JOptionPane.YES_NO_OPTION);
				if (chon == JOptionPane.YES_OPTION) {
					dispose();
					ViewDangNhap dn = new ViewDangNhap();
					dn.setVisible(true);
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Chức Năng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(0, 0, 75, 24);
		panel.add(lblNewLabel);

		JButton btnNewButton_1_1_1 = new JButton("Thoát");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1_1.setBounds(10, 258, 189, 42);
		panel.add(btnNewButton_1_1_1);

		JButton btnNewButton_1_1_2 = new JButton("Tra Cứu");
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1_2.setBounds(10, 152, 189, 42);
		panel.add(btnNewButton_1_1_2);

		Panel panel_lichbay = new Panel();
		panel_lichbay.setBackground(new Color(128, 128, 255));
		panel_lichbay.setBounds(260, 246, 1013, 387);
		panel_lichbay.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 176, 993, 200);
		panel_lichbay.add(scrollPane);

		table_lichbay = new JTable();
		table_lichbay.setBackground(new Color(255, 255, 255));
		table_lichbay.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã Chuyến Bay", "Ngày Bay",
				"Giờ Bay", "Điểm Khởi Hành", "Điểm Hạ Cánh", "Hãng Bay", "Sức Chứa" }));
		scrollPane.setViewportView(table_lichbay);

		JLabel lblNewLabel_1 = new JLabel("Ngày Bay");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(74, 26, 147, 33);
		panel_lichbay.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Điểm Khởi Hành");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(74, 86, 147, 33);
		panel_lichbay.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Điểm Hạ Cánh");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(466, 26, 147, 33);
		panel_lichbay.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Hãng Bay");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(466, 86, 147, 33);
		panel_lichbay.add(lblNewLabel_1_3);

		textField_lbtimngaybay = new JTextField();
		textField_lbtimngaybay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_lbtimngaybay.setColumns(10);
		textField_lbtimngaybay.setBounds(231, 26, 187, 33);
		panel_lichbay.add(textField_lbtimngaybay);

		JButton btnNewButton_2 = new JButton("Tìm");
		btnNewButton_2.addActionListener(controller);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(881, 26, 122, 33);
		panel_lichbay.add(btnNewButton_2);

		JPanel jPanel_datghe = new JPanel();
		jPanel_datghe.setBounds(260, 246, 1013, 387);
		jPanel_datghe.setLayout(null);

		JPanel jPanel_datve = new JPanel();
		jPanel_datve.setBounds(260, 246, 1013, 387);
		jPanel_datve.setLayout(null);

		JPanel jPanel_tracuu = new JPanel();
		jPanel_tracuu.setBackground(new Color(192, 192, 192));
		jPanel_tracuu.setBounds(260, 246, 1013, 387);
		jPanel_tracuu.setLayout(null);

		cardLayout = new CardLayout();
		jPanel_card = new JPanel(cardLayout);
		jPanel_card.add(panel_lichbay, "panel_lichbay");
		jPanel_card.add(jPanel_tracuu, "jPanel_tracuu");
		jPanel_card.add(jPanel_datghe, "jPanel_datghe");

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(293, 177, 367, 68);
		jPanel_datghe.add(panel_1);

		JButton btnNewButton_3 = new JButton("Thêm");
		btnNewButton_3.addActionListener(controllerDatVe);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(29, 11, 130, 33);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_3_1 = new JButton("Chỉnh Sửa");
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3_1.setBounds(212, 11, 130, 33);
		panel_1.add(btnNewButton_3_1);

		JLabel lblNewLabel_6 = new JLabel("EconomyClass");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(10, 61, 138, 39);
		jPanel_datghe.add(lblNewLabel_6);

		JLabel lblNewLabel_6_1 = new JLabel("BusinessClass");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6_1.setBounds(360, 61, 138, 39);
		jPanel_datghe.add(lblNewLabel_6_1);

		JLabel lblNewLabel_6_2 = new JLabel("FirstClass");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6_2.setBounds(716, 61, 138, 39);
		jPanel_datghe.add(lblNewLabel_6_2);

		comboBox_EconomyClass = new JComboBox();
		comboBox_EconomyClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_EconomyClass.setBounds(158, 65, 152, 39);
		jPanel_datghe.add(comboBox_EconomyClass);

		comboBox_BusinessClass = new JComboBox();
		comboBox_BusinessClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_BusinessClass.setBounds(508, 65, 152, 39);
		jPanel_datghe.add(comboBox_BusinessClass);

		comboBox_FirstClass = new JComboBox();
		comboBox_FirstClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_FirstClass.setBounds(864, 65, 152, 39);
		jPanel_datghe.add(comboBox_FirstClass);

		JButton btnNewButton_4 = new JButton("<");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_4.setBounds(0, 11, 51, 39);
		jPanel_datghe.add(btnNewButton_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 1010, 50);
		jPanel_tracuu.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("CCCD/CMND");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 11, 128, 28);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_2sdt = new JLabel("Số Điện Thoại");
		lblNewLabel_2sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2sdt.setBounds(354, 11, 139, 28);
		panel_2.add(lblNewLabel_2sdt);

		textField_tccccd = new JTextField();
		textField_tccccd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_tccccd.setBounds(148, 11, 196, 28);
		panel_2.add(textField_tccccd);
		textField_tccccd.setColumns(10);

		textField_tcsdt = new JTextField();
		textField_tcsdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_tcsdt.setColumns(10);
		textField_tcsdt.setBounds(503, 11, 196, 28);
		panel_2.add(textField_tcsdt);

		JButton btnNewButtontracuu = new JButton("Tra Cứu");
		btnNewButtontracuu.addActionListener(controllerDatVe);
		btnNewButtontracuu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtontracuu.setBounds(709, 11, 139, 28);
		panel_2.add(btnNewButtontracuu);
		
		JButton btnNewButton_3_2 = new JButton("Hủy Chuyến");
		btnNewButton_3_2.addActionListener(controllerDatVe);
		btnNewButton_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3_2.setBounds(861, 11, 139, 28);
		panel_2.add(btnNewButton_3_2);

		JLabel lblNewLabel_3 = new JLabel("Điểm Hạ Cánh");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 282, 148, 38);
		jPanel_tracuu.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Điểm Khởi Hành");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(10, 233, 148, 38);
		jPanel_tracuu.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Giờ Bay");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(10, 184, 148, 38);
		jPanel_tracuu.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("Ngày Bay");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_3.setBounds(10, 135, 148, 38);
		jPanel_tracuu.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("Mã Chuyến Bay");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_4.setBounds(10, 86, 148, 38);
		jPanel_tracuu.add(lblNewLabel_3_4);

		NewLabel_machuyenbay = new JLabel("");
		NewLabel_machuyenbay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewLabel_machuyenbay.setBounds(168, 90, 148, 31);
		jPanel_tracuu.add(NewLabel_machuyenbay);

		NewLabel_ngaybay = new JLabel("");
		NewLabel_ngaybay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewLabel_ngaybay.setBounds(168, 139, 148, 31);
		jPanel_tracuu.add(NewLabel_ngaybay);

		NewLabel_giobay = new JLabel("");
		NewLabel_giobay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewLabel_giobay.setBounds(168, 188, 148, 31);
		jPanel_tracuu.add(NewLabel_giobay);

		NewLabel_khoihanh = new JLabel("");
		NewLabel_khoihanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewLabel_khoihanh.setBounds(168, 237, 218, 31);
		jPanel_tracuu.add(NewLabel_khoihanh);

		NewLabel_hacanh = new JLabel("");
		NewLabel_hacanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewLabel_hacanh.setBounds(168, 289, 218, 31);
		jPanel_tracuu.add(NewLabel_hacanh);

		JLabel lblNewLabel_3_5 = new JLabel("Hãng Bay");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_5.setBounds(10, 331, 148, 31);
		jPanel_tracuu.add(lblNewLabel_3_5);

		JLabel lblNewLabel_3_6 = new JLabel("Số Ghế");
		lblNewLabel_3_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_6.setBounds(489, 139, 148, 31);
		jPanel_tracuu.add(lblNewLabel_3_6);

		JLabel lblNewLabel_3_7 = new JLabel("Tên Khách Hàng");
		lblNewLabel_3_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_7.setBounds(489, 188, 148, 31);
		jPanel_tracuu.add(lblNewLabel_3_7);

		JLabel lblNewLabel_3_8 = new JLabel("Giới Tính");
		lblNewLabel_3_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_8.setBounds(489, 237, 148, 31);
		jPanel_tracuu.add(lblNewLabel_3_8);

		JLabel lblNewLabel_3_9 = new JLabel("Ngày Sinh");
		lblNewLabel_3_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_9.setBounds(489, 286, 148, 31);
		jPanel_tracuu.add(lblNewLabel_3_9);

		JLabel lblNewLabel_3_10 = new JLabel("Trạng Thái");
		lblNewLabel_3_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_10.setBounds(489, 331, 148, 31);
		jPanel_tracuu.add(lblNewLabel_3_10);

		NewLabel_hangbay = new JLabel("");
		NewLabel_hangbay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewLabel_hangbay.setBounds(168, 331, 218, 31);
		jPanel_tracuu.add(NewLabel_hangbay);

		NewLabel_soghe = new JLabel("");
		NewLabel_soghe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewLabel_soghe.setBounds(647, 142, 148, 31);
		jPanel_tracuu.add(NewLabel_soghe);

		NewLabel_tenkhachhang = new JLabel("");
		NewLabel_tenkhachhang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewLabel_tenkhachhang.setBounds(647, 191, 250, 31);
		jPanel_tracuu.add(NewLabel_tenkhachhang);

		NewLabel_gioitinh = new JLabel("");
		NewLabel_gioitinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewLabel_gioitinh.setBounds(647, 237, 148, 31);
		jPanel_tracuu.add(NewLabel_gioitinh);

		NewLabel_ngaysinh = new JLabel("");
		NewLabel_ngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewLabel_ngaysinh.setBounds(647, 289, 148, 31);
		jPanel_tracuu.add(NewLabel_ngaysinh);

		NewLabel_trangthai = new JLabel("");
		NewLabel_trangthai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewLabel_trangthai.setBounds(647, 331, 250, 31);
		jPanel_tracuu.add(NewLabel_trangthai);

		JLabel lblNewLabel_5 = new JLabel("Loại Ghế");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(489, 86, 148, 31);
		jPanel_tracuu.add(lblNewLabel_5);

		NewLabel_loaighe = new JLabel("");
		NewLabel_loaighe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewLabel_loaighe.setBounds(647, 90, 148, 31);
		jPanel_tracuu.add(NewLabel_loaighe);

		String[] sb = new String[] { "", "SB Nội Bài - HAN", "SB Tân Sơn Nhất - SGN", "SB Đà Nẵng - DAD",
				"SB Nha Trang - CXR", "SB Cát Bi - HPH", "SB Phù Cát - UIH", "SB Buôn Ma Thuột - BMV",
				"SB Lien Khuong - DLI", "SB Phan Rang - Tháp Chàm - PHAN RANG", "SB Tuy Hòa - TBB" };

		comboBox_lbtimhacanh = new JComboBox(sb);
		comboBox_lbtimhacanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_lbtimhacanh.setBounds(623, 30, 187, 33);
		panel_lichbay.add(comboBox_lbtimhacanh);

		comboBox_lbtimkhoihanh = new JComboBox(sb);
		comboBox_lbtimkhoihanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_lbtimkhoihanh.setBounds(231, 86, 187, 33);
		panel_lichbay.add(comboBox_lbtimkhoihanh);

		String[] hb = new String[] { "", "Vietnam Airlines", "VietJet Air", "Bamboo Airways", "Pacific Airlines",
				"Vasco", "Vietravel Airlines" };

		comboBox_lbtimhangbay = new JComboBox(hb);
		comboBox_lbtimhangbay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_lbtimhangbay.setBounds(623, 86, 187, 33);
		panel_lichbay.add(comboBox_lbtimhangbay);
		jPanel_card.add(jPanel_datve, "jPanel_datve");

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 176, 1010, 200);
		jPanel_datve.add(scrollPane_1);

		table_datve = new JTable();
		table_datve.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Tên Khách Hàng", "Ngày Sinh",
				"Giới Tính", "CCCD/CMND", "Mã Chuyến Bay", "Số Điện Thoại", "Tình Trạng", "Loại Ghế", "Số Ghế" }));
		scrollPane_1.setViewportView(table_datve);
		String[] macb = this.lichBayDAO.laymachuyenbay();
		comboBox_datvemachuyenbay = new JComboBox<>();
		comboBox_datvemachuyenbay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_datvemachuyenbay.addItem("");
		for (String string : macb) {
			comboBox_datvemachuyenbay.addItem(string);
		}
		comboBox_datvemachuyenbay.setBounds(606, 124, 157, 41);
		jPanel_datve.add(comboBox_datvemachuyenbay);

		JLabel lblNewLabel_2_1 = new JLabel("Tên Khách Hàng");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(10, 11, 157, 41);
		jPanel_datve.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Ngày Sinh");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(10, 63, 142, 41);
		jPanel_datve.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Giới Tính");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(10, 124, 142, 41);
		jPanel_datve.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("CCCD/CMND");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_4.setBounds(454, 11, 142, 41);
		jPanel_datve.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_5 = new JLabel("Số Điện Thoại");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_5.setBounds(454, 63, 142, 41);
		jPanel_datve.add(lblNewLabel_2_5);

		JLabel lblNewLabel_2_6 = new JLabel("Mã Chuyến Bay");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_6.setBounds(454, 124, 142, 41);
		jPanel_datve.add(lblNewLabel_2_6);

		textField_dtenkhachhang = new JTextField();
		textField_dtenkhachhang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_dtenkhachhang.setBounds(177, 11, 157, 41);
		jPanel_datve.add(textField_dtenkhachhang);
		textField_dtenkhachhang.setColumns(10);

		textField_dngaysinh = new JTextField();
		textField_dngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_dngaysinh.setColumns(10);
		textField_dngaysinh.setBounds(177, 63, 157, 41);
		jPanel_datve.add(textField_dngaysinh);

		textField_dsdt = new JTextField();
		textField_dsdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_dsdt.setColumns(10);
		textField_dsdt.setBounds(606, 63, 157, 41);
		jPanel_datve.add(textField_dsdt);

		textField_dcccd = new JTextField();
		textField_dcccd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_dcccd.setColumns(10);
		textField_dcccd.setBounds(606, 11, 157, 41);
		jPanel_datve.add(textField_dcccd);

		NewRadioButton_dnam = new JRadioButton("Nam");
		NewRadioButton_dnam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewRadioButton_dnam.setBounds(177, 124, 67, 41);
		jPanel_datve.add(NewRadioButton_dnam);

		NewRadioButton_dnu = new JRadioButton("Nữ");
		NewRadioButton_dnu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewRadioButton_dnu.setBounds(267, 124, 67, 41);
		jPanel_datve.add(NewRadioButton_dnu);
		jPanel_card.setBounds(243, 246, 1030, 387);

		btn_groupDgioitinh = new ButtonGroup();
		btn_groupDgioitinh.add(NewRadioButton_dnam);
		btn_groupDgioitinh.add(NewRadioButton_dnu);

		String[] lg = new String[] { "", "Economy Class", "Business Class", "First Class" };

		JButton btnNewButton_5 = new JButton("Đặt Ghế");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_5.setBounds(863, 11, 157, 41);
		jPanel_datve.add(btnNewButton_5);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(jPanel_card, "panel_lichbay");
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(jPanel_card, "jPanel_datve");
			}
		});
		btnNewButton_1_1_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(jPanel_card, "jPanel_tracuu");
			}
		});
		btnNewButton_1_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát khỏi chương trình?", "Messenger",
						JOptionPane.YES_NO_OPTION);
				if (chon == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox_datvemachuyenbay.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Chọn mã máy bay");
				} else {
					cardLayout.show(jPanel_card, "jPanel_datghe");
					String macb = comboBox_datvemachuyenbay.getSelectedItem() + "";
					String[] EconomyClass = lichBayDAO.layloaiEconomyClass(macb);
					for (String lb : EconomyClass) {
						if (lb != null)
							comboBox_EconomyClass.addItem(lb);
					}

					String[] FirstClass = lichBayDAO.layloaiFirstClass(macb);
					for (String lb : FirstClass) {
						if (lb != null)
							comboBox_FirstClass.addItem(lb);
					}

					String[] BusinessClass = lichBayDAO.layloaiBusinessClass(macb);
					for (String lb : BusinessClass) {
						if (lb != null)
							comboBox_BusinessClass.addItem(lb);
					}
					lammoi();
				}
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(jPanel_card, "jPanel_datve");
			}
		});
		contentPane.add(jPanel_card);
		this.tailichlenbang();
		this.dsKhachHang.capnhatdatabase();

		setVisible(true);
	}
	
	private void refreshComboBox(JComboBox<String> comboBox, String[] items) {
        comboBox.removeAllItems(); // Xóa tất cả các mục hiện tại
        for (String item : items) {
            if (item != null) {
                comboBox.addItem(item); // Thêm lại các mục mới
            }
        }
    }
	
	public void lammoi() {

        try {
            String macb = comboBox_datvemachuyenbay.getSelectedItem() + "";
            
            // Lấy lại dữ liệu từ cơ sở dữ liệu
            String[] EconomyClass = lichBayDAO.layloaiEconomyClass(macb);
            String[] FirstClass = lichBayDAO.layloaiFirstClass(macb);
            String[] BusinessClass = lichBayDAO.layloaiBusinessClass(macb);
            
            // Làm mới ComboBox
            refreshComboBox(comboBox_EconomyClass, EconomyClass);
            refreshComboBox(comboBox_FirstClass, FirstClass);
            refreshComboBox(comboBox_BusinessClass, BusinessClass);

        } catch (Exception ex) {
            ex.printStackTrace();
            // Xử lý ngoại lệ nếu có
        }
    
	}

	public String fomatNgay(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormat.format(date);
	}

	public static String format(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(date);
	}

	public static String formatGio(String h) {
		SimpleDateFormat inputFormat = new SimpleDateFormat("HH:mm");

		try {
			Date date = inputFormat.parse(h);
			return format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return "";
	}

	public void themkhachhangvaobangchuyenbay(EditLichBay lb) {
		DefaultTableModel model_table = (DefaultTableModel) table_lichbay.getModel();
		model_table.addRow(
				new Object[] { lb.getMaChuyenBay(), fomatNgay(new Date(lb.getNgayBay())), formatGio(lb.getGioBay()),
						lb.getDiemkhoihanh(), lb.getDiemHaCanh(), lb.getHangBay(), lb.getSucChua() + "" });
	}

	public void tailichlenbang() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table_lichbay.getModel();
			int soluongdong = model_table.getRowCount();
			if (soluongdong == 0) {
				break;
			} else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		ArrayList<EditLichBay> result = lichBayDAO.selectAll();
		for (EditLichBay editLichBay : result) {
			this.themkhachhangvaobangchuyenbay(editLichBay);
		}
	}

	public void thuchientim() {
		this.tailichlenbang();

		String ngaybay = textField_lbtimngaybay.getText();
		int diemkhoihanh = comboBox_lbtimkhoihanh.getSelectedIndex() - 1;
		int diemhacanh = comboBox_lbtimhacanh.getSelectedIndex() - 1;
		int hangbay = comboBox_lbtimhangbay.getSelectedIndex() - 1;

		DefaultTableModel model_table = (DefaultTableModel) table_lichbay.getModel();
		int soluongdong = model_table.getRowCount();

		Set<String> machuyenbaycanxoa = new TreeSet<String>();

		if (ngaybay.length() > 0) {
			for (int i = 0; i < soluongdong; i++) {
				String nb = model_table.getValueAt(i, 1) + "";
				String macb = model_table.getValueAt(i, 0) + "";
				if (!nb.equals(ngaybay)) {
					machuyenbaycanxoa.add(macb);
				}
			}
		}

		if (diemkhoihanh >= 0) {
			for (int i = 0; i < soluongdong; i++) {
				String kh = model_table.getValueAt(i, 3) + "";
				String macb = model_table.getValueAt(i, 0) + "";
				if (!kh.equals(comboBox_lbtimkhoihanh.getSelectedItem())) {
					machuyenbaycanxoa.add(macb);
				}
			}
		}

		if (diemhacanh >= 0) {
			for (int i = 0; i < soluongdong; i++) {
				String hc = model_table.getValueAt(i, 4) + "";
				String macb = model_table.getValueAt(i, 0) + "";
				if (!hc.equals(comboBox_lbtimhacanh.getSelectedItem())) {
					machuyenbaycanxoa.add(macb);
				}
			}
		}

		if (hangbay >= 0) {
			for (int i = 0; i < soluongdong; i++) {
				String hb = model_table.getValueAt(i, 5) + "";
				String macb = model_table.getValueAt(i, 0) + "";
				if (!hb.equals(comboBox_lbtimhangbay.getSelectedItem())) {
					machuyenbaycanxoa.add(macb);
				}
			}
		}

		for (String macbcanxoa : machuyenbaycanxoa) {
			for (int i = 0; i < soluongdong; i++) {
				String macbtrongbang = model_table.getValueAt(i, 0) + "";
				if (macbtrongbang.equals(macbcanxoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}

		textField_lbtimngaybay.setText("");
		comboBox_lbtimhacanh.setSelectedIndex(0);
		comboBox_lbtimhangbay.setSelectedIndex(0);
		comboBox_lbtimkhoihanh.setSelectedIndex(0);
	}

	private static boolean checkDateFormat(String ngBay) {
		try {
			String[] parts = ngBay.split("/");
			int day = Integer.parseInt(parts[0]);
			int month = Integer.parseInt(parts[1]);
			int year = Integer.parseInt(parts[2]);

			if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 2023) {
				return false;
			} else {
				if (month == 2) {
					// Kiểm tra năm nhuận và không nhuận
					if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
						if (day > 29) {
							return false;
						}
					} else {
						if (day > 28) {
							return false;
						}
					}
				} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
					return false;
				}
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	private boolean kiemtracccd(String ccCd) {
		if (ccCd.length() == 12) {
			try {
				int parsedSoghe = Integer.parseInt(ccCd);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	private boolean kiemtrasdt(String sdt) {
		if (sdt.length() == 10) {
			try {
				int parsedSoghe = Integer.parseInt(sdt);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public void themkhachhangvaobangkhachhang(KhachHang kh) {
		DefaultTableModel model_table = (DefaultTableModel) table_datve.getModel();
		model_table.addRow(
				new Object[] { kh.getTenKhachHang(), kh.getNgaySinh(), kh.isGioiTinh() ? "Nam" : "Nữ", kh.getCccd(),
						kh.getMaChuyenBay(), kh.getSoDienThoai(), kh.getTinhTrang(), kh.getLoaiGhe(), kh.getSoGhe() });
	}

	public void thuchienthemkhachhang(KhachHang kh) {
		if (!this.dsKhachHang.kiemtraCCCD(kh)) {
			if (!this.dsKhachHang.kiemtraSDT(kh)) {
				String xacthuc = JOptionPane.showInputDialog(this,
						"Nhập Mã OTP qua số điện thoại: " + kh.getSoDienThoai(), "Messenger",
						JOptionPane.OK_CANCEL_OPTION);
				if (xacthuc != null) {
					if (new String(xacthuc).equals("123")) {
						this.dsKhachHang.insert(kh);
						this.themkhachhangvaobangkhachhang(kh);
						this.khachHangDAO.insert(kh);
						EditLichBay lb= new EditLichBay(comboBox_datvemachuyenbay.getSelectedItem()+"", null, null, null, null, null, 0);
						if (comboBox_EconomyClass.getSelectedItem().equals(kh.getSoGhe()+"")) {
							this.lichBayDAO.xoaghe(lb, Integer.valueOf(comboBox_EconomyClass.getSelectedItem()+""), null, null);
						} else if(comboBox_BusinessClass.getSelectedItem().equals(kh.getSoGhe()+"")) {
							this.lichBayDAO.xoaghe(lb, null, Integer.valueOf(comboBox_BusinessClass.getSelectedItem()+""), null);
						} else if (comboBox_FirstClass.getSelectedItem().equals(kh.getSoGhe())) {
							this.lichBayDAO.xoaghe(lb, null, null, Integer.valueOf(comboBox_FirstClass.getSelectedItem()+""));
						}
						JOptionPane.showMessageDialog(this, "Thêm Thành Công!");
						cardLayout.show(jPanel_card, "jPanel_datve");
					} else {
						JOptionPane.showMessageDialog(this, "Mã OTP không đúng", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				this.textField_dtenkhachhang.setText("");
				this.textField_dngaysinh.setText("");
				this.btn_groupDgioitinh.clearSelection();
				this.textField_dcccd.setText("");
				this.comboBox_datvemachuyenbay.setSelectedIndex(0);
				this.textField_dsdt.setText("");
				this.comboBox_BusinessClass.setSelectedIndex(0);
				this.comboBox_EconomyClass.setSelectedIndex(0);
				this.comboBox_FirstClass.setSelectedIndex(0);
				} else {
				JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "CCCD/CMND đã tồn tại", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void thuchienthem() {
		if (textField_dtenkhachhang.getText().isEmpty() || textField_dngaysinh.getText().isEmpty()
				|| (!NewRadioButton_dnam.isSelected() && !NewRadioButton_dnu.isSelected())
				|| textField_dcccd.getText().isEmpty() || textField_dsdt.getText().isEmpty()
				|| comboBox_datvemachuyenbay.getSelectedIndex() == 0
				|| (comboBox_BusinessClass.getSelectedIndex() == 0 && comboBox_EconomyClass.getSelectedIndex() == 0
						&& comboBox_FirstClass.getSelectedIndex() == 0)) {
			JOptionPane.showMessageDialog(this, "Nhập đầy đủ thông tin.", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String hoten = textField_dtenkhachhang.getText();
		String ngaysinh = textField_dngaysinh.getText();
		boolean gioitinh = NewRadioButton_dnam.isSelected();
		String cccd = textField_dcccd.getText();
		String sdt = textField_dsdt.getText();
		String macb = comboBox_datvemachuyenbay.getSelectedItem() + "";
		String tinhtrang = "Chờ xác nhận";

		String loi = "Chú ý các lỗi sau:\n";
		if (!checkDateFormat(ngaysinh)) {
			loi += "Nhập đúng định dạng: dd/MM/yyyy.\n";
		}
		if (kiemtracccd(cccd)) {
			loi += "CCCD chứa 12 số.\n";
		}
		if (!kiemtrasdt(sdt)) {
			loi += "Số điện thoại chứa 10 số.\n";
		}
		if (loi != "Chú ý các lỗi sau:\n") {
			JOptionPane.showMessageDialog(this, loi, "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int count = 0;
		if (comboBox_EconomyClass.getSelectedIndex() != 0) {
			count++;
		}
		if (comboBox_BusinessClass.getSelectedIndex() != 0) {
			count++;
		}
		if (comboBox_FirstClass.getSelectedIndex() != 0) {
			count++;
		}
		if (count > 1) {
			JOptionPane.showMessageDialog(this, "Chỉ được chọn 1 loại ghế", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String S_soghe = comboBox_EconomyClass.getSelectedItem() + "" + comboBox_BusinessClass.getSelectedItem() + ""
				+ comboBox_FirstClass.getSelectedItem() + "";
		if (comboBox_EconomyClass.getSelectedIndex()!=0) {
			S_soghe=comboBox_EconomyClass.getSelectedItem() + "";
		}
		if (comboBox_BusinessClass.getSelectedIndex() != 0) {
			S_soghe=comboBox_BusinessClass.getSelectedItem()+"";
		}
		if (comboBox_FirstClass.getSelectedIndex() != 0) {
			S_soghe=comboBox_FirstClass.getSelectedItem()+"";
		}
		int soghe= Integer.valueOf(S_soghe);
		String loaighe="";
		if (soghe>0 && soghe<21) {
			loaighe="FirstClass";
		} else if (soghe>=21 && soghe<51) {
			loaighe="BusinessClass";
		} else {
			loaighe="EconomyClass";
		}
		KhachHang kh = new KhachHang(hoten, ngaysinh, gioitinh, cccd, sdt, macb, tinhtrang, loaighe, soghe);
		this.thuchienthemkhachhang(kh);
	}

	public void taikhachhanglenbang() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table_datve.getModel();
			int soluongdong = model_table.getRowCount();
			if (soluongdong == 0) {
				break;
			} else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		for (KhachHang kh : this.khachHangDAO.selectAll()) {
			this.themkhachhangvaobangkhachhang(kh);
		}
	}

	public void hienthithongtinkhachhang(KhachHang kh) {
		NewLabel_tenkhachhang.setText(kh.getTenKhachHang());
		NewLabel_ngaysinh.setText(kh.getNgaySinh());
		NewLabel_gioitinh.setText(kh.isGioiTinh() ? "Nam" : "Nữ");
		NewLabel_machuyenbay.setText(kh.getMaChuyenBay());
		NewLabel_trangthai.setText(kh.getTinhTrang());
		NewLabel_loaighe.setText(kh.getLoaiGhe());
		NewLabel_soghe.setText(kh.getSoGhe() + "");
	}

	public void hienthithongtinlichbay(EditLichBay lb) {
		NewLabel_ngaybay.setText(lb.getNgayBay());
		NewLabel_giobay.setText(lb.getGioBay());
		NewLabel_khoihanh.setText(lb.getDiemkhoihanh());
		NewLabel_hacanh.setText(lb.getDiemHaCanh());
		NewLabel_hangbay.setText(lb.getHangBay());
	}

	public void thuchientracuukhachhang() {
		this.dsKhachHang.capnhatdatabase();
		this.dsLichBay.laydulieutudatabase();
		String cccd = textField_tccccd.getText();
		String sdt = textField_tcsdt.getText();
		boolean timthay = false;
		for (KhachHang kh : this.dsKhachHang.getDsKhachHang()) {
			if (kh.getCccd().equals(cccd) || kh.getSoDienThoai().equals(sdt)) {
				String macb = kh.getMaChuyenBay();
				for (EditLichBay lb : this.dsLichBay.getDsLichBay()) {
					if (lb.getMaChuyenBay().equals(macb)) {
						this.hienthithongtinkhachhang(kh);
						this.hienthithongtinlichbay(lb);
						timthay = true;
						break;
					}
				}
			}
		}
		if (!timthay) {
			JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng trong danh sách.");
			NewLabel_tenkhachhang.setText("");
			NewLabel_ngaysinh.setText("");
			NewLabel_gioitinh.setText("");
			NewLabel_machuyenbay.setText("");
			NewLabel_trangthai.setText("");
			NewLabel_ngaybay.setText("");
			NewLabel_giobay.setText("");
			NewLabel_khoihanh.setText("");
			NewLabel_hacanh.setText("");
			NewLabel_hangbay.setText("");
			NewLabel_soghe.setText("");
			NewLabel_loaighe.setText("");
		}
	}

	public void thuchienhuychuyen() {
		if(NewLabel_trangthai.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa có thông tin khách hàng", "", JOptionPane.ERROR_MESSAGE);
		} else if(NewLabel_trangthai.getText().equals("Đã xác nhận")) {
			JOptionPane.showMessageDialog(this, "Quý khách không thể hủy chuyến bay này", "", JOptionPane.ERROR_MESSAGE);
		} else {
			int luachon=JOptionPane.showConfirmDialog(this, "Xác nhận hủy chuyến", "", JOptionPane.YES_NO_OPTION);
			if (luachon == JOptionPane.YES_OPTION) {
				String huy="Hủy chuyến";
				String cccd=textField_tccccd.getText();
				this.khachHangDAO.updatetinhtrang(cccd, huy);
				this.dsKhachHang.capnhatdatabase();
				this.thuchientracuukhachhang();
			}
		}
	}
}
