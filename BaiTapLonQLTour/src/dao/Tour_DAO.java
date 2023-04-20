package dao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

import connectDB.ConnectDB;
import entities.Tour;
import my_Interfaces.ITour;

public class Tour_DAO implements ITour{
	public Tour_DAO() {
		
	}
	@Override
	public ArrayList<Tour> getDS() {
		// TODO Auto-generated method stub
		ArrayList<Tour> ds = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from Tour order by tgCapNhat desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				LocalDate ngayKhoiHanh = rs.getDate(3).toLocalDate();
				Time tgKhoiHanh = rs.getTime(3);
				int soNgay = rs.getInt(4);
				int soVeConLai = rs.getInt(5);
				double gia= rs.getDouble(6);
				Blob clob = rs.getBlob(7);
				byte[] byteArr = clob.getBytes(1, (int)clob.length());
				ByteArrayInputStream bis = new ByteArrayInputStream(byteArr);
				BufferedImage img = ImageIO.read(bis);
				Time tgTapTrung = rs.getTime(8);
				String diemDI = rs.getNString(9);
				String diemDen = rs.getNString(10);
				Tour t = new Tour(ma, ten, tgTapTrung, tgKhoiHanh, ngayKhoiHanh,  soNgay, soVeConLai, gia, img, diemDI, diemDen);
				ds.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
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
	public Tour getTour(String id) {
		// TODO Auto-generated method stub
		Tour t = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select * from tour where maTour = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				LocalDate ngayKhoiHanh = rs.getDate(3).toLocalDate();
				Time tgKhoiHanh = rs.getTime(3);
				int soNgay = rs.getInt(4);
				int soVeConLai = rs.getInt(5);
				double gia= rs.getDouble(6);
				Blob clob = rs.getBlob(7);
				byte[] byteArr = clob.getBytes(1, (int)clob.length());
				ByteArrayInputStream bis = new ByteArrayInputStream(byteArr);
				BufferedImage img = ImageIO.read(bis);
				LocalDate ngayTapTrung = rs.getDate(8).toLocalDate();
				Time tgTapTrung = rs.getTime(8);
				String diemDI = rs.getNString(9);
				String diemDen = rs.getNString(10);
				t = new Tour(ma, ten, tgTapTrung, tgKhoiHanh, ngayKhoiHanh,  soNgay, soVeConLai, gia, img, diemDI, diemDen);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return t;
	}
	@Override
	public ArrayList<Tour> timKiem(String diemDi, String diemDen,String ngayDi) {
		// TODO Auto-generated method stub
		ArrayList<Tour> list = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select * from tour where diemDi = ? and diemDen = ? and convert(DATE,tgKhoiHanh) = ?";// and convert(date,tgKhoiHanh) = ?
			statement = con.prepareStatement(sql);
			statement.setNString(1, diemDi);
			statement.setNString(2, diemDen);
			statement.setNString(3, ngayDi.trim());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				LocalDate ngayKhoiHanh = rs.getDate(3).toLocalDate();
				Time tgKhoiHanh = rs.getTime(3);
				int soNgay = rs.getInt(4);
				int soVeConLai = rs.getInt(5);
				double gia= rs.getDouble(6);
				Blob clob = rs.getBlob(7);
				byte[] byteArr = clob.getBytes(1, (int)clob.length());
				ByteArrayInputStream bis = new ByteArrayInputStream(byteArr);
				BufferedImage img = ImageIO.read(bis);
				LocalDate ngayTapTrung = rs.getDate(8).toLocalDate();
				Time tgTapTrung = rs.getTime(8);
				String dDi = rs.getNString(9);
				String dDen = rs.getNString(10);
				Tour t = new Tour(ma, ten, tgTapTrung, tgKhoiHanh, ngayKhoiHanh,  soNgay, soVeConLai, gia, img, dDi, dDen);
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	@Override
	public ArrayList<Tour> timKiem(String noiDungTimKiem) {
		// TODO Auto-generated method stub
		return null;
	}

}
