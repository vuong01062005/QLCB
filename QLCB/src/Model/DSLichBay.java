package Model;

import java.util.ArrayList;
import java.util.Iterator;

import DAO.LichBayDAO;

public class DSLichBay {
	private ArrayList<EditLichBay> dsLichBay;

	public DSLichBay() {
		this.dsLichBay = new ArrayList();
	}

	public DSLichBay(ArrayList<EditLichBay> dsLichBay) {
		this.dsLichBay = dsLichBay;
	}

	public ArrayList<EditLichBay> getDsLichBay() {
		return dsLichBay;
	}

	public void setDsLichBay(ArrayList<EditLichBay> dsLichBay) {
		this.dsLichBay = dsLichBay;
	}
	
	public void insert(EditLichBay lb) {
		this.dsLichBay.add(lb);
	}
	
	public void delete(EditLichBay lb) {
		Iterator<EditLichBay> iterator= this.dsLichBay.iterator();
		while (iterator.hasNext()) {
			EditLichBay edlb= iterator.next();
			if (edlb.getMaChuyenBay().equals(lb.getMaChuyenBay())) {
				iterator.remove();
				break;
			}
		}
	}
	
	public void update(EditLichBay lb) {
		this.delete(lb);
		this.dsLichBay.add(lb);
	}
	
	public boolean kiemtramachuyenbaytontai(EditLichBay lb) {
		for (EditLichBay editLichBay : dsLichBay) {
			if(editLichBay.getMaChuyenBay().equals(lb.getMaChuyenBay())) {
				return true;
			}
		}
		return false;
	}
	
	public void laydulieutudatabase() {
		LichBayDAO lbd= new LichBayDAO();
		dsLichBay= lbd.selectAll();
	}
}
