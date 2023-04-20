package entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

import javax.swing.ImageIcon;

import custom_entity.Format;

public class Tour {
	private String maTour;
	private String tenTour;
	private Time tgTapTrung;
	private Time tgKhoiHanh;
	private LocalDate ngayKhoiHanh;
	private int soNgay;
	private int soVeConLai;
	private double gia;
	private BufferedImage hinhAnh;
	private String diemDi;
	private String diemDen;
	
	public String getMaTour() {
		return maTour;
	}
	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	public String getTenTour() {
		return tenTour;
	}
	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}
	public LocalDate getNgayKhoiHanh() {
		return ngayKhoiHanh;
	}
	public void setNgayKhoiHanh(LocalDate ngayKhoiHanh) {
		this.ngayKhoiHanh = ngayKhoiHanh;
	}
	public Time getTgKhoiHanh() {
		return tgKhoiHanh;
	}
	public void setTgKhoiHanh(Time tgKhoiHanh) {
		this.tgKhoiHanh = tgKhoiHanh;
	}
	public int getSoNgay() {
		return soNgay;
	}
	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}
	public int getSoVeConLai() {
		return soVeConLai;
	}
	public void setSoVeConLai(int soVeConLai) {
		this.soVeConLai = soVeConLai;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public BufferedImage getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(BufferedImage hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public Time getTgTapTrung() {
		return tgTapTrung;
	}
	public void setTgTapTrung(Time tgTapTrung) {
		this.tgTapTrung = tgTapTrung;
	}
	public String getDiemDi() {
		return diemDi;
	}
	public void setDiemDi(String diemDi) {
		this.diemDi = diemDi;
	}
	public String getDiemDen() {
		return diemDen;
	}
	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}
	
	
	public Tour(String maTour, String tenTour, Time tgTapTrung, Time tgKhoiHanh, LocalDate ngayKhoiHanh, int soNgay,
			int soVeConLai, double gia, BufferedImage hinhAnh, String diemDi, String diemDen) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.tgTapTrung = tgTapTrung;
		this.tgKhoiHanh = tgKhoiHanh;
		this.ngayKhoiHanh = ngayKhoiHanh;
		this.soNgay = soNgay;
		this.soVeConLai = soVeConLai;
		this.gia = gia;
		this.hinhAnh = hinhAnh;
		this.diemDi = diemDi;
		this.diemDen = diemDen;
	}
	public Tour(String maTour) {
		super();
		this.maTour = maTour;
	}
	public Tour() {
		super();
	}
	
	@Override
	public String toString() {
		return maTour + ";" + tenTour  + ";" + tgTapTrung + ";" + tgKhoiHanh  + ngayKhoiHanh + ";" + soNgay + ";" + soVeConLai + ";" + Format.formatMoneyVND(gia) + ";" + diemDi + ";" + diemDen;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTour);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		return Objects.equals(maTour, other.maTour);
	}
}
