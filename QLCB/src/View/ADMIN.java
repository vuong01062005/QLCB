package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.QLCBController;
import DAO.KhachHangDAO;
import DAO.LichBayDAO;
import Model.DSKhachHang;
import Model.DSLichBay;
import Model.EditLichBay;
import Model.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ADMIN extends JFrame {

	private DSKhachHang dsKhachHang;
	private KhachHangDAO khachHangDAO;
	private LichBayDAO lichBayDAO;
	private DSLichBay dsLichBay;
	private JPanel contentPane;
	private JTable table_lichbay;
	private JTextField textField_lichmachuyenbay;
	private JTextField textField_lichngaybay;
	private JTextField textField_lichgiobay;
	private JTextField textField_lichsucchua;
	private JComboBox comboBox_lichkhoihanh;
	private JComboBox comboBox_lichhacanh;
	private JComboBox comboBox_lichhangbay;
	private int selectedRow;
	private JTable table_khachang;
	private JLabel NewLabel_duyetcccd;
	private JComboBox comboBox_tinhtrang;
	private JComboBox comboBox_duyetmacb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADMIN frame = new ADMIN();
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
	public ADMIN() {
		this.dsLichBay = new DSLichBay();
		this.lichBayDAO = new LichBayDAO();
		this.dsKhachHang = new DSKhachHang();
		this.khachHangDAO = new KhachHangDAO();
		setTitle("ADMIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 680);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		QLCBController controller = new QLCBController(this);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 246, 223, 237);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton_lichbay = new JButton("Lịch Bay");
		btnNewButton_lichbay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_lichbay.setBounds(40, 11, 132, 39);
		panel.add(btnNewButton_lichbay);

		JButton btnNewButton_1 = new JButton("Đăng Xuất");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(40, 111, 132, 39);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int chon = JOptionPane.showConfirmDialog(null, "Xác nhận đăng xuất?", "Messenger",
						JOptionPane.YES_NO_OPTION);
				if (chon == JOptionPane.YES_OPTION) {
					dispose();
					ViewDangNhap dangNhap = new ViewDangNhap();
					dangNhap.setVisible(true);
				}
			}
		});

		JButton btnNewButton_duyet = new JButton("Duyệt");
		btnNewButton_duyet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_duyet.setBounds(40, 61, 132, 39);
		panel.add(btnNewButton_duyet);

		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(40, 161, 132, 39);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát khỏi chương trình?", "Messenger",
						JOptionPane.YES_NO_OPTION);
				if (chon == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_lichbay = new JPanel();
		panel_lichbay.setBackground(new Color(128, 255, 128));
		panel_lichbay.setBounds(282, 246, 991, 386);
		panel_lichbay.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 971, 145);
		panel_lichbay.add(scrollPane);

		table_lichbay = new JTable();
		table_lichbay.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã Chuyến Bay", "Ngày Bay",
				"Giờ Bay", "Điểm Khởi Hành", "Điểm Hạ Cánh", "Hãng Bay", "Sức Chứa" }));
		scrollPane.setViewportView(table_lichbay);

		JPanel jPanel_duyet = new JPanel();
		jPanel_duyet.setBounds(282, 246, 991, 386);
		jPanel_duyet.setLayout(null);

		CardLayout cardLayout = new CardLayout();
		JPanel jPanel_card = new JPanel(cardLayout);
		jPanel_card.add(panel_lichbay, "panel_lichbay");

		JLabel lblNewLabel = new JLabel("Mã Chuyến Bay");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 25, 143, 34);
		panel_lichbay.add(lblNewLabel);

		JLabel lblNgyBay = new JLabel("Ngày Bay");
		lblNgyBay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgyBay.setBounds(10, 92, 143, 34);
		panel_lichbay.add(lblNgyBay);

		JLabel lblGiBay = new JLabel("Giờ Bay");
		lblGiBay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiBay.setBounds(10, 161, 143, 34);
		panel_lichbay.add(lblGiBay);

		JLabel lblimKhiHnh = new JLabel("Điểm Khởi Hành");
		lblimKhiHnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblimKhiHnh.setBounds(368, 25, 153, 34);
		panel_lichbay.add(lblimKhiHnh);

		JLabel lblimHCnh = new JLabel("Điểm Hạ Cánh");
		lblimHCnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblimHCnh.setBounds(368, 92, 143, 34);
		panel_lichbay.add(lblimHCnh);

		JLabel lblHngBay = new JLabel("Hãng Bay");
		lblHngBay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHngBay.setBounds(368, 161, 143, 34);
		panel_lichbay.add(lblHngBay);

		JLabel lblScCha = new JLabel("Sức Chứa");
		lblScCha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblScCha.setBounds(694, 25, 143, 34);
		panel_lichbay.add(lblScCha);

		textField_lichmachuyenbay = new JTextField();
		textField_lichmachuyenbay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_lichmachuyenbay.setBounds(182, 26, 143, 34);
		panel_lichbay.add(textField_lichmachuyenbay);
		textField_lichmachuyenbay.setColumns(10);

		textField_lichngaybay = new JTextField();
		textField_lichngaybay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_lichngaybay.setColumns(10);
		textField_lichngaybay.setBounds(182, 92, 143, 34);
		panel_lichbay.add(textField_lichngaybay);

		textField_lichgiobay = new JTextField();
		textField_lichgiobay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_lichgiobay.setColumns(10);
		textField_lichgiobay.setBounds(182, 161, 143, 34);
		panel_lichbay.add(textField_lichgiobay);

		textField_lichsucchua = new JTextField();
		textField_lichsucchua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_lichsucchua.setColumns(10);
		textField_lichsucchua.setBounds(818, 26, 143, 34);
		panel_lichbay.add(textField_lichsucchua);

		String[] sb = new String[] { "", "SB Nội Bài - HAN", "SB Tân Sơn Nhất - SGN", "SB Đà Nẵng - DAD",
				"SB Nha Trang - CXR", "SB Cát Bi - HPH", "SB Phù Cát - UIH", "SB Buôn Ma Thuột - BMV",
				"SB Lien Khuong - DLI", "SB Phan Rang - Tháp Chàm - PHAN RANG", "SB Tuy Hòa - TBB" };
		comboBox_lichkhoihanh = new JComboBox(sb);
		comboBox_lichkhoihanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_lichkhoihanh.setBounds(531, 25, 153, 34);
		panel_lichbay.add(comboBox_lichkhoihanh);

		comboBox_lichhacanh = new JComboBox(sb);
		comboBox_lichhacanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_lichhacanh.setBounds(531, 92, 153, 34);
		panel_lichbay.add(comboBox_lichhacanh);

		String[] hb = new String[] { "", "Vietnam Airlines", "VietJet Air", "Bamboo Airways", "Pacific Airlines",
				"Vasco", "Vietravel Airlines" };
		comboBox_lichhangbay = new JComboBox(hb);
		comboBox_lichhangbay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_lichhangbay.setBounds(531, 171, 153, 34);
		panel_lichbay.add(comboBox_lichhangbay);

		JPanel panel_themsuaxoa = new JPanel();
		panel_themsuaxoa.setForeground(new Color(255, 255, 255));
		panel_themsuaxoa.setBackground(new Color(0, 64, 0));
		panel_themsuaxoa.setBounds(716, 70, 265, 149);
		panel_lichbay.add(panel_themsuaxoa);
		panel_themsuaxoa.setLayout(null);

		JButton btnNewButton_chinhsua = new JButton("Chỉnh Sửa");
		btnNewButton_chinhsua.addActionListener(controller);
		btnNewButton_chinhsua.setBackground(new Color(240, 240, 240));
		btnNewButton_chinhsua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_chinhsua.setBounds(71, 49, 132, 39);
		panel_themsuaxoa.add(btnNewButton_chinhsua);

		JButton btnNewButton_xoa = new JButton("Xóa");
		btnNewButton_xoa.addActionListener(controller);
		btnNewButton_xoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_xoa.setBounds(71, 99, 132, 39);
		panel_themsuaxoa.add(btnNewButton_xoa);

		JButton btnNewButton_them = new JButton("Thêm");
		btnNewButton_them.addActionListener(controller);
		btnNewButton_them.setBackground(new Color(255, 128, 128));
		btnNewButton_them.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_them.setBounds(71, -1, 132, 39);
		panel_themsuaxoa.add(btnNewButton_them);
		jPanel_card.add(jPanel_duyet, "jPanel_duyet");

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 215, 971, 160);
		jPanel_duyet.add(scrollPane_1);

		table_khachang = new JTable();
		table_khachang.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Tên Khách Hàng", "Ngày Sinh",
				"Giới Tính", "CCCD/CMND", "Mã Chuyến Bay", "Số Điện Thoại", "Tình Trạng", "Loại Ghế", "Số Ghế" }));
		scrollPane_1.setViewportView(table_khachang);
		table_khachang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow = table_khachang.getSelectedRow();
				if (selectRow != -1) {
					NewLabel_duyetcccd.setText(table_khachang.getValueAt(selectRow, 3) + "");
				}
			}
		});

		JLabel lblNewLabel_1 = new JLabel("CCCD/CMND");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 11, 126, 34);
		jPanel_duyet.add(lblNewLabel_1);

		NewLabel_duyetcccd = new JLabel("");
		NewLabel_duyetcccd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewLabel_duyetcccd.setBounds(146, 11, 190, 34);
		jPanel_duyet.add(NewLabel_duyetcccd);

		JLabel lblNewLabel_1_2 = new JLabel("Tình Trạng");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 74, 126, 34);
		jPanel_duyet.add(lblNewLabel_1_2);

		String[] tt = new String[] { "", "Chờ xác nhận", "Đã xác nhận", "Xác nhận hủy chuyến", "Hủy chuyến" };
		comboBox_tinhtrang = new JComboBox(tt);
		comboBox_tinhtrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_tinhtrang.setBounds(146, 74, 190, 34);
		jPanel_duyet.add(comboBox_tinhtrang);

		JLabel lblNewLabel_2 = new JLabel("Mã Chuyến Bay");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(431, 11, 150, 34);
		jPanel_duyet.add(lblNewLabel_2);

		JButton btnNewButton_2 = new JButton("Tìm");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timcackhachhangcungchuyenbay();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(826, 11, 126, 34);
		jPanel_duyet.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Xác Nhận");
		btnNewButton_3.addActionListener(controller);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(826, 56, 126, 34);
		jPanel_duyet.add(btnNewButton_3);
		
		comboBox_duyetmacb = new JComboBox();
		String[] macb = this.lichBayDAO.laymachuyenbay();
		comboBox_duyetmacb = new JComboBox<>();
		comboBox_duyetmacb.addItem("");
		for (String string : macb) {
			comboBox_duyetmacb.addItem(string);
		}
		comboBox_duyetmacb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_duyetmacb.setBounds(591, 11, 126, 34);
		jPanel_duyet.add(comboBox_duyetmacb);
		jPanel_card.setBounds(282, 246, 991, 386);
		btnNewButton_lichbay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(jPanel_card, "panel_lichbay");
			}
		});
		btnNewButton_duyet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(jPanel_card, "jPanel_duyet");
			}
		});
		contentPane.add(jPanel_card);

		table_lichbay.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = table_lichbay.getSelectedRow();
				if (selectedRow != -1) {
					textField_lichmachuyenbay.setText(table_lichbay.getValueAt(selectedRow, 0) + "");
					textField_lichngaybay.setText(table_lichbay.getValueAt(selectedRow, 1) + "");
					textField_lichgiobay.setText(table_lichbay.getValueAt(selectedRow, 2) + "");
					comboBox_lichkhoihanh.setSelectedItem(table_lichbay.getValueAt(selectedRow, 3));
					comboBox_lichhacanh.setSelectedItem(table_lichbay.getValueAt(selectedRow, 4));
					comboBox_lichhangbay.setSelectedItem(table_lichbay.getValueAt(selectedRow, 5));
					textField_lichsucchua.setText(table_lichbay.getValueAt(selectedRow, 6) + "");
				}
			}
		});
		ArrayList<EditLichBay> result = lichBayDAO.selectAll();
		for (EditLichBay editLichBay : result) {
			this.themchuyenbayvaobang(editLichBay);
		}
		this.dsLichBay.laydulieutudatabase();
		this.dsKhachHang.capnhatdatabase();
		this.taikhachhanglenbang();

		setVisible(true);
	}

	public static String format(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
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

	public void themchuyenbayvaobang(EditLichBay lb) {
		DefaultTableModel model_table = (DefaultTableModel) table_lichbay.getModel();
		model_table.addRow(new Object[] { lb.getMaChuyenBay(), lb.getNgayBay(), formatGio(lb.getGioBay()),
				lb.getDiemkhoihanh(), lb.getDiemHaCanh(), lb.getHangBay(), lb.getSucChua() + "" });
	}

	public void themhoaccapnhapchuyenbay(EditLichBay lb) {
		if (!this.dsLichBay.kiemtramachuyenbaytontai(lb)) {
			this.lichBayDAO.insert(lb);
			this.dsLichBay.insert(lb);
			this.themchuyenbayvaobang(lb);
			this.lichBayDAO.themmachuyenbay(lb);
			int x = Integer.valueOf(textField_lichsucchua.getText());
			this.lichBayDAO.themloaigheFirstClass(lb, 0);
			this.lichBayDAO.themloaigheBusinessClass(lb, 0);
			this.lichBayDAO.themloaigheEconomyClass(lb, 0);
			for (int i = 1; i <= 20; i++) {
				this.lichBayDAO.themloaigheFirstClass(lb, i);
			}
			for (int i = 21; i <= 50; i++) {
				this.lichBayDAO.themloaigheBusinessClass(lb, i);
			}
			for (int i = 51; i <= x; i++) {
				this.lichBayDAO.themloaigheEconomyClass(lb, i);
			}
			JOptionPane.showMessageDialog(this, "Thêm Thành Công!");
			this.textField_lichmachuyenbay.setText("");
			this.textField_lichngaybay.setText("");
			this.textField_lichgiobay.setText("");
			this.comboBox_lichkhoihanh.setSelectedIndex(0);
			this.comboBox_lichhacanh.setSelectedIndex(0);
			this.comboBox_lichhangbay.setSelectedIndex(0);
			this.textField_lichsucchua.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "Mã chuyến bay đã tồn tại!");
		}
	}

	private boolean kiemtramachuyenbay(String macb) {
		if (macb.matches(".*[^a-zA-Z0-9].*")) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean checkDateFormat(String ngBay) {
		try {
			String[] parts = ngBay.split("/");
			int day = Integer.parseInt(parts[0]);
			int month = Integer.parseInt(parts[1]);
			int year = Integer.parseInt(parts[2]);

			if (day < 1 || day > 31 || month < 1 || month > 12 || year < 2023) {
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

	private boolean checkTimeFormat(String time) {
		try {
			// tạo 1 mảng gồm các kí tự thời gian đc đc cắt bằng dấu ":"
			// time = "12:56"
			// parts[] = {12, 56}
			String[] parts = time.split(":");
			int h = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			if (h < 0 || h > 23 || m < 0 || m > 59) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	private boolean kiemtrasucchua(String soghe) {
		try {
			int parsedSoghe = Integer.parseInt(soghe);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void thuchienthem() {
		if (this.textField_lichmachuyenbay.getText().isEmpty() || this.textField_lichngaybay.getText().isEmpty()
				|| this.textField_lichgiobay.getText().isEmpty() || this.comboBox_lichkhoihanh.getSelectedItem() == ""
				|| this.comboBox_lichhacanh.getSelectedItem() == "" || this.comboBox_lichhangbay.getSelectedItem() == ""
				|| this.textField_lichsucchua.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Nhập đầy đủ thông tin", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String machuyenbay = this.textField_lichmachuyenbay.getText();
		String ngaybay = this.textField_lichngaybay.getText();
		String gioBay = this.textField_lichgiobay.getText();
		String diemkhoihanh = this.comboBox_lichkhoihanh.getSelectedItem() + "";
		String diemhacanh = this.comboBox_lichhacanh.getSelectedItem() + "";
		String hangbay = this.comboBox_lichhangbay.getSelectedItem() + "";
		int succhua = Integer.valueOf(this.textField_lichsucchua.getText());
		String loi = "Chú ý các lỗi sau:\n";
		if (!kiemtramachuyenbay(machuyenbay)) {
			loi += "Quy định mã chuyến bay chỉ có chữ và số.\n";
		}
		if (!checkDateFormat(ngaybay)) {
			loi += "Nhập đúng định dạng: dd/MM/yyyy.\n";
		}
		if (!checkTimeFormat(gioBay)) {
			loi += "Nhập đúng định dạng: HH:mm.\n";
		}
		if (!kiemtrasucchua(this.textField_lichsucchua.getText())) {
			loi += "Sức chứa nhập số.\n";
		}
		if (succhua > 250 || succhua < 200) {
			loi += "Sức chứa nằm trong khoảng [200,500]\n";
		}
		if (loi != "Chú ý các lỗi sau:\n") {
			JOptionPane.showMessageDialog(this, loi, "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		EditLichBay lb = new EditLichBay(machuyenbay, ngaybay, gioBay, diemkhoihanh, diemhacanh, hangbay, succhua);
		this.themhoaccapnhapchuyenbay(lb);
	}
	
	public void tailichbaylenbang() {
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
		for (EditLichBay lb : this.lichBayDAO.selectAll()) {
			this.themchuyenbayvaobang(lb);;
		}
	}

	public void thuchienchinhsua() {
		selectedRow = table_lichbay.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để chỉnh sửa");
			return;
		}
		DefaultTableModel model_table = (DefaultTableModel) table_lichbay.getModel();
		String machuyenbay = this.textField_lichmachuyenbay.getText();
		String ngaybay = this.textField_lichngaybay.getText();
		String gioBay = this.textField_lichgiobay.getText();
		String diemkhoihanh = this.comboBox_lichkhoihanh.getSelectedItem() + "";
		String diemhacanh = this.comboBox_lichhacanh.getSelectedItem() + "";
		String hangbay = this.comboBox_lichhangbay.getSelectedItem() + "";
		int succhua = Integer.valueOf(this.textField_lichsucchua.getText());
		String loi = "Chú ý các lỗi sau:\n";
		if (!kiemtramachuyenbay(machuyenbay)) {
			loi += "Quy định mã chuyến bay chỉ có chữ và số.\n";
		}
		if (!checkDateFormat(ngaybay)) {
			loi += "Nhập đúng định dạng: dd/MM/yyyy.\n";
		}
		if (!checkTimeFormat(gioBay)) {
			loi += "Nhập đúng định dạng: HH:mm.\n";
		}
		if (!kiemtrasucchua(this.textField_lichsucchua.getText())) {
			loi += "Sức chứa nhập số.\n";
		}
		if (loi != "Chú ý các lỗi sau:\n") {
			JOptionPane.showMessageDialog(this, loi, "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		EditLichBay lb = new EditLichBay(machuyenbay, ngaybay, gioBay, diemkhoihanh, diemhacanh, hangbay, succhua);
		this.lichBayDAO.update(lb);
		this.dsLichBay.update(lb);
		this.tailichbaylenbang();
	}

	public EditLichBay getChuyenBayDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table_lichbay.getModel();
		selectedRow = table_lichbay.getSelectedRow();
		String machuyenbay = model_table.getValueAt(selectedRow, 0) + "";
		String ngaybay = model_table.getValueAt(selectedRow, 1) + "";
		String giobay = model_table.getValueAt(selectedRow, 2) + "";
		String khoihanh = model_table.getValueAt(selectedRow, 3) + "";
		String hacanh = model_table.getValueAt(selectedRow, 4) + "";
		String hangbay = model_table.getValueAt(selectedRow, 5) + "";
		int soghe = Integer.valueOf(model_table.getValueAt(selectedRow, 6) + "");
		EditLichBay lb = new EditLichBay(machuyenbay, ngaybay, giobay, khoihanh, hacanh, hangbay, soghe);
		return lb;
	}

	public void thuchienxoa() {
		DefaultTableModel model_table = (DefaultTableModel) table_lichbay.getModel();
		selectedRow = table_lichbay.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để chỉnh sửa");
			return;
		} else {
			int luachon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa chuyến bay này không");
			if (luachon == JOptionPane.YES_OPTION) {
				EditLichBay ed = getChuyenBayDangChon();
				this.dsLichBay.delete(ed);
				this.lichBayDAO.delete(ed);
				model_table.removeRow(selectedRow);
			}
		}
	}

	public void themkhachhangvaobangkhachhang(KhachHang kh) {
		DefaultTableModel model_table = (DefaultTableModel) table_khachang.getModel();
		model_table.addRow(
				new Object[] { kh.getTenKhachHang(), kh.getNgaySinh(), kh.isGioiTinh() ? "Nam" : "Nữ", kh.getCccd(),
						kh.getMaChuyenBay(), kh.getSoDienThoai(), kh.getTinhTrang(), kh.getLoaiGhe(), kh.getSoGhe() });
	}

	public void taikhachhanglenbang() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table_khachang.getModel();
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

	public void xacnhankhachhang() {
		DefaultTableModel model_table = (DefaultTableModel) table_khachang.getModel();
		int i_row = table_khachang.getSelectedRow();
		if (i_row < 0) {
			JOptionPane.showMessageDialog(this, "Chọn khách hàng cần thông báo");
			return;
		} else {
			int luachon = JOptionPane.showConfirmDialog(this, "Xác nhận thay đổi thông bao cho khác hàng");
			if (luachon == JOptionPane.YES_OPTION) {
				String xn = NewLabel_duyetcccd.getText();
				String tt = comboBox_tinhtrang.getSelectedItem() + "";
				this.khachHangDAO.updatetinhtrang(xn, tt);
				this.dsKhachHang.capnhatdatabase();
				this.taikhachhanglenbang();
			}
		}
	}
	
	public void timcackhachhangcungchuyenbay() {
		this.taikhachhanglenbang();
		String macb=comboBox_duyetmacb.getSelectedItem()+"";
		
		DefaultTableModel model_table= (DefaultTableModel) table_khachang.getModel();
		int soluongdong=model_table.getRowCount();
		
		Set<String> machuyenbaycanxoa= new TreeSet<String>();
		if (macb.length()>0) {
			for (int i = 0; i < soluongdong; i++) {
				String cb=model_table.getValueAt(i, 4)+"";
				if (!cb.equals(macb)) {
					machuyenbaycanxoa.add(cb);
				}
			}
		}
		for (String s : machuyenbaycanxoa) {
			for (int i = 0; i < soluongdong; i++) {
				String cb=model_table.getValueAt(i, 4)+"";
				if(cb.equals(s.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
}
