package Test;

import DAO.DAODangNhap;
import DAO.LichBayDAO;
import Model.DangNhapDangKy;
import Model.EditLichBay;

public class TestJDBCUtil {
	public static void main(String[] args) {
		EditLichBay lb= new EditLichBay("sda", "sdfdf", "đá", "ads", "áds", "ads", 9);
		LichBayDAO dao=new LichBayDAO();
		dao.themmachuyenbay(lb);
	}
}
