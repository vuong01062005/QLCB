package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import Database.JDCBCUtil;
import Model.DangNhapDangKy;
import View.ViewDangNhap;

public class DAODangNhap {
	private ViewDangNhap dangNhap;

	public int insert(DangNhapDangKy nk) {
		int ketqua = 0;
		try {
			Connection con = JDCBCUtil.getConnection();
			String sql = "INSERT INTO dangnhapdangky (taiKhoan, matKhau)" + " VALUES (?,?)";
			PreparedStatement ptd = con.prepareStatement(sql);
			ptd.setString(1, nk.getTaiKhoan());
			ptd.setString(2, nk.getMatKhau());

			ketqua = ptd.executeUpdate();
			JOptionPane.showMessageDialog(this.dangNhap, "Đăng ký thành công", "Messenge", JOptionPane.INFORMATION_MESSAGE);
			JDCBCUtil.closeConnection(con);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this.dangNhap, "Tài khoản đã tồn tại", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return ketqua;
	}
	
	public int update(DangNhapDangKy nk) {
		int ketqua = 0;
		try {
			Connection con = JDCBCUtil.getConnection();
			String sql = "UPDATE dangnhapdangky " + 
						" SET "+
						" matKhau=?"+
						" WHERE taiKhoan=?";
			PreparedStatement ptd = con.prepareStatement(sql);
			ptd.setString(1, nk.getMatKhau());
			ptd.setString(2, nk.getTaiKhoan());

			ketqua = ptd.executeUpdate();
			JOptionPane.showMessageDialog(this.dangNhap, "Đổi mật khẩu thành công", "Messenge", JOptionPane.INFORMATION_MESSAGE);
			JDCBCUtil.closeConnection(con);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this.dangNhap, "Tài khoản hoặc mật khẩu không đúng", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return ketqua;
	}
	
	public boolean kiemtramatkhau(String tendangnhap, String matkhau) {
		Connection con=null;
		try {
			con= JDCBCUtil.getConnection();
			String sql= "SELECT * FROM dangnhapdangky WHERE taikhoan = ? AND matKhau = ?";
			PreparedStatement ptd=con.prepareStatement(sql);
			ptd.setString(1, tendangnhap);
	        ptd.setString(2, matkhau);
	        
	        ResultSet rs= ptd.executeQuery();
	        
	        if (rs.next()) {
	            return true;
	        } else {
	            return false;
	        }
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this.dangNhap, "Không tồn tại tài khoản", "ERROR", JOptionPane.ERROR_MESSAGE);
	        return false;
		}finally {
			JDCBCUtil.closeConnection(con);
	    }
	}
}
