package my_Interfaces;

import java.util.ArrayList;

import entities.Tour;

public interface ITour {
	public ArrayList<Tour> getDS();
	public int count();
	public boolean themTour();
	public boolean xoaTour();
	public boolean suaTour();
}
