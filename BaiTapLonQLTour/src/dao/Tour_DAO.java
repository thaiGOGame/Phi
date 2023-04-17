package dao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
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
				Date gtKhoiHanh = rs.getDate(3);
				int thoiGian = rs.getInt(4);
				int soVeConLai = rs.getInt(5);
				double gia= rs.getDouble(6);
				Blob clob = rs.getBlob(7);
				byte[] byteArr = clob.getBytes(1, (int)clob.length());
				//FileOutputStream fos = new FileOutputStream("./src/images/"+ma+".png");
				//System.out.println("Image retrieved successfully.");
				//fos.write(byteArr);
				ByteArrayInputStream bis = new ByteArrayInputStream(byteArr);
				BufferedImage img = ImageIO.read(bis);
				//fos.close();
				Date gtTapTrung = rs.getDate(8);
				String noiKhoiHanh = rs.getNString(9);
				Tour t = new Tour(ma, ten, gtKhoiHanh, thoiGian, soVeConLai, gia, img, gtTapTrung, noiKhoiHanh);
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

}
