package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import grafo.GrafoCompleto;

public class ArbolGeneradorMinimoTest {
	
	ArbolGeneradorMinimo agm;
	
	@Before
	public void generarArbol() 
	{
		GrafoCompleto g = new GrafoCompleto();
		g.agregarPersona("a", 1, 2, 3, 4);              
		g.agregarPersona("b", 1, 2, 3, 4);
		g.agregarPersona("c", 3, 4, 5, 1);
		g.agregarPersona("d", 4, 5, 1, 2);

		Prim p = new Prim(g);
		p.ejecutarPrim();
		agm = p.generarArbol();
	}
	
	public ArbolGeneradorMinimo generarArbolSimulado()
	{
		GrafoCompleto g = new GrafoCompleto();
		g.agregarPersona("a", 1, 2, 3, 4);              
		g.agregarPersona("b", 1, 2, 3, 4);
		g.agregarPersona("c", 3, 4, 5, 1);
		g.agregarPersona("d", 4, 5, 1, 2);

		Prim p = new Prim(g);
		p.ejecutarPrim();
		ArbolGeneradorMinimo agms = new ArbolGeneradorMinimo(p.Et, g.getPersonas());;
		
		return agms;
	}
	
	@Test
	public void agregarArista()
	{
		PrimAssert.agregarArista(agm);
	}
	
	@Test
	public void completarListaDeVecinosTest()
	{
		ArbolGeneradorMinimo agms = generarArbolSimulado();
		PrimAssert.completarLista(agms);
	}
	
	@Test
	public void generarVecinosTest()
	{
		ArbolGeneradorMinimo agms = generarArbolSimulado();
		PrimAssert.generarVecinos(agms);
	}
	
	
}