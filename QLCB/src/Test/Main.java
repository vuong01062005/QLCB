package Test;

import DAO.KhachHangDAO;
import DAO.LichBayDAO;
import Model.EditLichBay;
import Model.KhachHang;

public class Main {
	public static void main(String[] args) {
		String s= "045205004698";
		String a="xác nhận";
		KhachHangDAO khd= new KhachHangDAO();
		khd.updatetinhtrang(s,a);
	}
}
