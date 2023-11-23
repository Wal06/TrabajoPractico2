package model;

import grafo.GrafoCompleto;

public class Model {
	
	private GrafoCompleto grafo = new GrafoCompleto();
	private Prim prim = new Prim(grafo);
	private ArbolGeneradorMinimo agm;
	private Solucion solucion;
	
	public Model(){}
	
	public void agregarPersona(String nombre, int i, int j, int k, int l) 
	{
		grafo.agregarPersona(nombre, i, j, k, l);	
	}

	public void generarGrupos() 
	{
		prim.ejecutarPrim();
		agm = prim.generarArbol();
		solucion = new Solucion(agm);
	}

	public String obtenerGrupo1() 
	{
		String ret = solucion.getPersonasGrupo1();
		return ret;
	}

	public String obtenerGrupo2() 
	{
		String ret = solucion.getPersonasGrupo2();
		return ret;	
	}
}
