package model;
//import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

//import org.junit.jupiter.api.Test;

import grafo.GrafoCompleto;

class ArbolGeneradorMinimoTest {
	
	
	private ArbolGeneradorMinimo ArbolGeneradorMinimo() 
	{
	GrafoCompleto g = new GrafoCompleto();
	g.agregarPersona("a", 1, 2, 3, 4);              
	g.agregarPersona("b", 1, 2, 3, 4);
	g.agregarPersona("c", 3, 4, 5, 1);
	g.agregarPersona("d", 4, 5, 1, 2);
	
	ArbolGeneradorMinimo agm = new ArbolGeneradorMinimo(g);
    return agm;
	}
	
	@Test
	public void contieneVecinoTest()
	{
		ArbolGeneradorMinimo agm = ArbolGeneradorMinimo();
		assertTrue(agm.vecinos.get(0).contains(1));
	}
	
    
}