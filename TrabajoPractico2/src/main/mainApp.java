package main;

import Presenter.Presenter;
import interfaz.Interfaz;
import model.Model;

public class mainApp {
	
	static Interfaz view;
	static Presenter presenter;
	static Model model;

	public static void main(String[] args) 
	{
		try 
		{
			model = new Model();
			view = new Interfaz();
			presenter = new Presenter(model,view);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
