package entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import javax.swing.ImageIcon;

public class Tour {
	private String maTour;
	private String tenTour;
	private Date tgKhoiHanh;
	private int thoiGian;
	private int soVeConLai;
	private double gia;
	private BufferedImage hinhAnh;
	private Date tgTapTrung;
	private String noiKhoiHanh;
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
	public Date getTgKhoiHanh() {
		return tgKhoiHanh;
	}
	public void setTgKhoiHanh(Date tgKhoiHanh) {
		this.tgKhoiHanh = tgKhoiHanh;
	}
	public int getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(int thoiGian) {
		this.thoiGian = thoiGian;
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
	public Date getTgTapTrung() {
		return tgTapTrung;
	}
	public void setTgTapTrung(Date tgTapTrung) {
		this.tgTapTrung = tgTapTrung;
	}
	public String getNoiKhoiHanh() {
		return noiKhoiHanh;
	}
	public void setNoiKhoiHanh(String noiKhoiHanh) {
		this.noiKhoiHanh = noiKhoiHanh;
	}
	public Tour(String maTour, String tenTour, Date tgKhoiHanh, int thoiGian, int soVeConLai, double gia,
			BufferedImage hinhAnh, Date tgTapTrung, String noiKhoiHanh) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.tgKhoiHanh = tgKhoiHanh;
		this.thoiGian = thoiGian;
		this.soVeConLai = soVeConLai;
		this.gia = gia;
		this.hinhAnh = hinhAnh;
		this.tgTapTrung = tgTapTrung;
		this.noiKhoiHanh = noiKhoiHanh;
	}
	public Tour(String maTour) {
		super();
		this.maTour = maTour;
	}
	public Tour() {
		super();
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
	@Override
	public String toString() {
		return "Tour [maTour=" + maTour + ", tenTour=" + tenTour + ", tgKhoiHanh=" + tgKhoiHanh + ", thoiGian="
				+ thoiGian + ", soVeConLai=" + soVeConLai + ", gia=" + gia + ", hinhAnh=" + hinhAnh + ", tgTapTrung="
				+ tgTapTrung + ", noiKhoiHanh=" + noiKhoiHanh + "]";
	}
	
	
	
	
}
