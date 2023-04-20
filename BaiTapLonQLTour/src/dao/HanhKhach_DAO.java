package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.HanhKhach;
import my_Interfaces.IHanhKhach;
public class HanhKhach_DAO implements IHanhKhach {

	@Override
	public ArrayList<HanhKhach> getDS() {
		ArrayList<HanhKhach> ds = new ArrayList<HanhKhach>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from dbo.HanhKhach";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				boolean gioiTinh = rs.getBoolean(2);
				String ten = rs.getString(3);
				String email = rs.getString(4);
				String sdt = rs.getString(5);
				String loaiKhach = rs.getString(6);
				String quocTich = rs.getString(7);
				String loaiPhong = rs.getString(8);
				String ghiChu = rs.getString(9);
				HanhKhach k = new HanhKhach(ma, gioiTinh, ten, email, ten, quocTich,ghiChu);
				ds.add(k);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public HanhKhach getTour(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean themTour() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoaTour() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean suaTour() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<HanhKhach> timKiem(String diemDi, String diemDen, String ngayDi) {
		// TODO Auto-generated method stub
		return null;
	}

}
