package my_Interfaces;

import java.util.ArrayList;

import entities.Tour;

public interface ITour {
	public ArrayList<Tour> getDS();
	public Tour getTour(String id);
	public int count();
	public boolean themTour();
	public boolean xoaTour();
	public boolean suaTour();
}
