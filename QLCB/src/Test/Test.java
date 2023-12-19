package Test;

import javax.swing.UIManager;

import View.ViewDangNhap;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ViewDangNhap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
