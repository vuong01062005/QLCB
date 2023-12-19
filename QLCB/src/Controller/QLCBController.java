package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.ADMIN;
import View.NguoiDung;
import View.ViewDangNhap;

public class QLCBController implements ActionListener {
	private ViewDangNhap dangNhap;
	private NguoiDung nguoiDung;
	private ADMIN admin;

	public QLCBController(ADMIN admin) {
		this.admin = admin;
	}

	public QLCBController(ViewDangNhap dangNhap) {
		this.dangNhap = dangNhap;
	}

	public QLCBController(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src=e.getActionCommand();
		if(src.equals("Đăng Ký")) {
			this.dangNhap.thuchiendangky();
		} else if (src.equals("Xác Nhận Đổi")) {
			this.dangNhap.thuchiendoimatkhau();
		} else if (src.equals("Đăng Nhập")) {
			this.dangNhap.thuchiendangnhap();
		}  else if (src.equals("Thêm")) {
			this.admin.thuchienthem();
		} else if (src.equals("Tìm")) {
			this.nguoiDung.thuchientim();;
		} else if (src.equals("Chỉnh Sửa")) {
			this.admin.thuchienchinhsua();
		} else if (src.equals("Xóa")) {
			this.admin.thuchienxoa();;
		} else if (src.equals("Xác Nhận")) {
			this.admin.xacnhankhachhang();
		}
	}

}
