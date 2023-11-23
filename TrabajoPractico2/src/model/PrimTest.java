package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import grafo.Arista;
import grafo.GrafoCompleto;

public class PrimTest {
	
	Prim p;
	Arista a;
	
	@Before
	public void crearPrim()
	{	
		p = new Prim(crearGrafo(),true);	
		a = new Arista(0,1,2);
	}
	
	GrafoCompleto crearGrafo()
	{
		GrafoCompleto g;
		
		g = new GrafoCompleto();
		g.agregarPersona("a", 1, 2, 3, 4);
		g.agregarPersona("b", 4, 3, 2, 1);
		g.agregarPersona("c", 4, 2, 2, 5);
		g.agregarPersona("d", 4, 2, 2, 5);
		
		/*g.agregarPersona("a", 1, 2, 3, 4);
		g.agregarPersona("b", 1, 2, 3, 4);
		g.agregarPersona("c", 1, 2, 3, 4);
		g.agregarPersona("d", 1, 2, 3, 4);*/
		
		return g;
	}
	
	@Test
	public void proximoVerticeP2Test() 
	{
		int v = 0;
		
		assertEquals(1,p.proximoVertice(v,a));
	}
	
	@Test
	public void proximoVerticeP1Test() 
	{
		int v = 1;
		
		assertEquals(0,p.proximoVertice(v,a));
	}
	
	@Test
	public void verificarAristaAgregada()
	{
		p.Et.add(a);
		assertFalse(p.verificarArista(a,4));
	}
	
	@Test
	public void verificarAristaDeMayorPesoTest()
	{
		assertFalse(p.verificarArista(a,1));
	}
	
	@Test
	public void verificarAristaDeMenorSinAgregarPesoTest()
	{		
		assertTrue(p.verificarArista(a,5));
	}
	
	@Test
	public void seleccionarAristaDeMenorPesoTest()
	{
		PrimAssert.aristaDeMenorPeso(p,a);
	}

	@Test
	public void existeAristaAuxiliar()
	{
		p.aristasAuxiliares.add(a);
		
		assertTrue(p.existeAristaAuxiliar(a));
	}
	
	@Test
	public void noExisteAristaAuxiliar()
	{
		assertFalse(p.existeAristaAuxiliar(a));
	}
	
	@Test
	public void obtenerAristasTest()
	{
		PrimAssert.obtenerAristas(p);
	}
	
	@Test
	public void ejecutarPrimTest()
	{
		PrimAssert.ejecutarPrim(p);
	}
	
}
