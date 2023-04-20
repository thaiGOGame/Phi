package bus;

import java.util.ArrayList;

import dao.HanhKhach_DAO;
import entities.HanhKhach;
import my_Interfaces.IHanhKhach;

public class HanhKhach_BUS implements IHanhKhach {
	private HanhKhach_DAO hk_dao;
	public HanhKhach_BUS() {
		hk_dao = new HanhKhach_DAO();
	}
	@Override
	public ArrayList<HanhKhach> getDS() {
		ArrayList<HanhKhach> ds = hk_dao.getDS();
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
