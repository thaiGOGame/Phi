package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import custom_entity.Format;

public class DonDatTour {
	private String soDonDatTour;
	private Tour tour;
	private NguoiDung nguoiDung;
	private LocalDateTime thoiGianDat;
	private int soVe;
	
	public String getSoDonDatTour() {
		return soDonDatTour;
	}
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	public void setSoDonDatTour(String soDonDatTour) {
		this.soDonDatTour = soDonDatTour;
	}
	public NguoiDung getKhachHang() {
		return nguoiDung;
	}
	public LocalDateTime getNgayDat() {
		return thoiGianDat;
	}
	public void setKhachHang(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}
	private void setNgayDat() {
		this.thoiGianDat = LocalDateTime.now();
	}
	
	public int getSoVe() {
		return soVe;
	}
	private void setSoVe(int soVe) {
		this.soVe = soVe;
	}
	
	public DonDatTour(String soDonDatTour, NguoiDung nguoiDung, int soVe) {
		this.soDonDatTour = soDonDatTour;
		this.nguoiDung = nguoiDung;
		this.soVe = soVe;
	}
	
	public DonDatTour(String soDonDatTour) {
		super();
		this.soDonDatTour = soDonDatTour;
	}
	
	public DonDatTour() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(soDonDatTour);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonDatTour other = (DonDatTour) obj;
		return Objects.equals(soDonDatTour, other.soDonDatTour);
	}
	@Override
	public String toString() {
		return soDonDatTour + ";" + tour.getMaTour() + ";" + tour.getTenTour() + ";" +nguoiDung.getSoNguoiDung() + ";" +nguoiDung.getHoTen() + ";"  + thoiGianDat + ";" + soVe +";"+ Format.formatMoneyVND(tinhTongTienTra());
	}
	public double tinhTongTienTra() {
		return soVe*tour.getGia();
	}
	
}
