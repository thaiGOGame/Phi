package my_Interfaces;

import java.util.ArrayList;

import entities.HuongDanVien;

import java.time.LocalDate;

public interface IHuongDanVien {
	public ArrayList<HuongDanVien> getDS();
	public HuongDanVien getTour(String id);
	public int count();
	public boolean themTour();
	public boolean xoaTour();
	public boolean suaTour();
	public ArrayList<HuongDanVien> timKiem(String noiDungTimKiem);
}
