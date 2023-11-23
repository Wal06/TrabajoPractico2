package Presenter;

import interfaz.Interfaz;
import model.Model;

public class Presenter {
	
	private Model model;
	private Interfaz view;
	
	public Presenter(Model m, Interfaz v)
	{
		model = m;
		view = v;
		view.setPresenter(this);
	}

	public void agregarPersona(String nombre, int i, int j, int k, int l) 
	{
		model.agregarPersona(nombre, i, j, k, l);
	}

	public void generarGrupos() 
	{
		model.generarGrupos();
	}

	public String obtenerGrupo1() 
	{
		String ret = model.obtenerGrupo1();
		
		return ret;
	}

	public String obtenerGrupo2() 
	{
		String ret = model.obtenerGrupo2();
		
		return ret;
	}
}
