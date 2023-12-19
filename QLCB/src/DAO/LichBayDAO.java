package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.JDCBCUtil;
import Model.DSLichBay;
import Model.EditLichBay;

public class LichBayDAO {
	
	public int insert(EditLichBay lb) {
		int ketqua= 0;
		try {
			Connection con=JDCBCUtil.getConnection();
			
			String sql="INSERT INTO lichbay (maChuyenBay, ngayBay, gioBay, diemKhoiHanh, diemHaCanh, hangBay, sucChua)"+
						" VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setString(1, lb.getMaChuyenBay());
			pst.setString(2, lb.getNgayBay());
			pst.setString(3, lb.getGioBay());
			pst.setString(4, lb.getDiemkhoihanh());
			pst.setString(5, lb.getDiemHaCanh());
			pst.setString(6, lb.getHangBay());
			pst.setInt(7, lb.getSucChua());
			
			ketqua= pst.executeUpdate();
			JDCBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public int update(EditLichBay lb) {
		int ketqua= 0;
		try {
			Connection con=JDCBCUtil.getConnection();
			
			String sql="UPDATE lichbay"+
						" SET ngayBay=?, gioBay=?, diemKhoiHanh=?, diemHaCanh=?, hangBay=?, sucChua=?"+
						" WHERE maChuyenBay=?";
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setString(1, lb.getNgayBay());
			pst.setString(2, lb.getGioBay());
			pst.setString(3, lb.getDiemkhoihanh());
			pst.setString(4, lb.getDiemHaCanh());
			pst.setString(5, lb.getHangBay());
			pst.setInt(6, lb.getSucChua());
			pst.setString(7, lb.getMaChuyenBay());
			
			ketqua= pst.executeUpdate();
			JDCBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public int delete(EditLichBay lb) {
		int ketqua= 0;
		try {
			Connection con=JDCBCUtil.getConnection();
			
			String sql="DELETE FROM lichbay"+
						" WHERE maChuyenBay=?";
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setString(1, lb.getMaChuyenBay());
			
			ketqua= pst.executeUpdate();
			JDCBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public ArrayList<EditLichBay> selectAll(){
		ArrayList<EditLichBay> ketqua= new ArrayList<EditLichBay>();
		try {
			Connection con= JDCBCUtil.getConnection();
			String sql= "SELECT* FROM lichbay";
			
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			while (rs.next()) {
				String macb= rs.getString("maChuyenBay");
				String ngaybay= rs.getString("ngayBay");
				String giobay= rs.getString("gioBay");
				String diemkh= rs.getString("diemKhoiHanh");
				String diemhc= rs.getString("diemHaCanh");
				String hangbay= rs.getString("hangBay");
				int succhua= rs.getInt("sucChua");
				EditLichBay lb= new EditLichBay(macb, ngaybay, giobay, diemkh, diemhc, hangbay, succhua);
				ketqua.add(lb);
			}
			JDCBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public String[] laymachuyenbay() {
	    List<String> ketqua= new ArrayList<>();
	    try (Connection con = JDCBCUtil.getConnection();
	         PreparedStatement pst = con.prepareStatement("SELECT maChuyenBay FROM lichbay");
	         ResultSet rs = pst.executeQuery()) {
	        while (rs.next()) {
	            ketqua.add(rs.getString("maChuyenBay"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ketqua.toArray(new String[0]);
	}
	
	public String[] layloaiEconomyClass(String macb) {
	    List<String> ketqua= new ArrayList<>();
	    try (Connection con = JDCBCUtil.getConnection();
	         PreparedStatement pst = con.prepareStatement("SELECT EconomyClass FROM "+macb);
	         ResultSet rs = pst.executeQuery()) {
	        while (rs.next()) {
	            ketqua.add(rs.getString("EconomyClass"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ketqua.toArray(new String[0]);
	}
	
	public String[] layloaiBusinessClass(String macb) {
	    List<String> ketqua= new ArrayList<>();
	    try (Connection con = JDCBCUtil.getConnection();
	         PreparedStatement pst = con.prepareStatement("SELECT BusinessClass FROM "+macb);
	         ResultSet rs = pst.executeQuery()) {
	        while (rs.next()) {
	            ketqua.add(rs.getString("BusinessClass"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ketqua.toArray(new String[0]);
	}
	
	public String[] layloaiFirstClass(String macb) {
	    List<String> ketqua= new ArrayList<>();
	    try (Connection con = JDCBCUtil.getConnection();
	         PreparedStatement pst = con.prepareStatement("SELECT FirstClass FROM "+macb);
	         ResultSet rs = pst.executeQuery()) {
	        while (rs.next()) {
	            ketqua.add(rs.getString("FirstClass"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ketqua.toArray(new String[0]);
	}
	
	public int themloaigheEconomyClass(EditLichBay lb, int i) {
		int ketqua= 0;
		try {
			Connection con=JDCBCUtil.getConnection();
			
			String sql="INSERT INTO "+lb.getMaChuyenBay()+ " (EconomyClass)"+
						" VALUES (?)";
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setInt(1, i);
			
			ketqua= pst.executeUpdate();
			JDCBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public int themloaigheBusinessClass(EditLichBay lb, int i) {
		int ketqua= 0;
		try {
			Connection con=JDCBCUtil.getConnection();
			
			String sql="INSERT INTO "+lb.getMaChuyenBay()+ " (BusinessClass)"+
						" VALUES (?)";
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setInt(1, i);
			
			ketqua= pst.executeUpdate();
			JDCBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public int themloaigheFirstClass(EditLichBay lb, int i) {
		int ketqua= 0;
		try {
			Connection con=JDCBCUtil.getConnection();
			
			String sql="INSERT INTO "+lb.getMaChuyenBay()+ " (FirstClass)"+
						" VALUES (?)";
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setInt(1, i);
			
			ketqua= pst.executeUpdate();
			JDCBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public int themmachuyenbay(EditLichBay lb) {
		int ketqua= 0;
		try {
			Connection con=JDCBCUtil.getConnection();
			
			String sql="CREATE TABLE " + lb.getMaChuyenBay()
					+ " (EconomyClass INT(255),"
					+ "	BusinessClass INT(100),"
					+ "	FirstClass INT(100))";
			PreparedStatement pst= con.prepareStatement(sql);
			
			ketqua= pst.executeUpdate();
			JDCBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public int xoaghe(EditLichBay lb, Integer e, Integer b, Integer f) {
	    int ketqua = 0;
	    try {
	        Connection con = JDCBCUtil.getConnection();
	        
	        // Sử dụng điều kiện IS NULL khi giá trị là null
	        String sql = "DELETE FROM " + lb.getMaChuyenBay()
	                + " WHERE "
	                + " EconomyClass " + (e == null ? "IS NULL" : "= ?")
	                + " AND BusinessClass " + (b == null ? "IS NULL" : "= ?")
	                + " AND FirstClass " + (f == null ? "IS NULL" : "= ?");

	        PreparedStatement pst = con.prepareStatement(sql);
	        
	        // Đặt giá trị chỉ khi giá trị không phải là null
	        int parameterIndex = 1;
	        if (e != null) {
	            pst.setInt(parameterIndex++, e);
	        }
	        if (b != null) {
	            pst.setInt(parameterIndex++, b);
	        }
	        if (f != null) {
	            pst.setInt(parameterIndex++, f);
	        }
	        
	        ketqua = pst.executeUpdate();
	        JDCBCUtil.closeConnection(con);
	    } catch (SQLException r) {
	        r.printStackTrace();
	    }
	    return ketqua;
	}

}
