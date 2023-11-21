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
		p = new Prim(crearGrafo());	
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
	public void primerVerticeMarcadoTest() 
	{
		p.Vt.add(0);
		assertTrue(p.verticesValidos(0,1));
	}
	
	@Test
	public void segundoVerticeMarcadoTest() 
	{
		p.Vt.add(1);
		assertTrue(p.verticesValidos(0,1));
	}

	@Test
	public void ambosVerticesMarcadosTest() 
	{
		p.Vt.add(0);
		p.Vt.add(1);
		assertFalse(p.verticesValidos(0,1));
	}
	
	@Test
	public void ningunVerticesMarcadosTest() 
	{
		p.Vt.add(0);
		p.Vt.add(1);
		assertFalse(p.verticesValidos(0,1));
	}
	
	@Test
	public void verificarAristaDeMenorPesoTest()
	{
		p.Vt.add(0);
		p.Vt.add(1);
		
		assertFalse(p.verificarArista(a,3));
	}
	

	@Test
	public void verificarAristaDeMayorPesoTest()
	{
		p.Vt.add(0);
		
		assertTrue(p.verificarArista(a,5));
	}
	
	@Test
	public void seleccionarAristaDeMenorPesoTest()
	{
		p.aristasAuxiliares.add(a);
		p.seleccionarAristaDeMenorPeso();
		Arista b = p.Et.get(0);
		
		assertEquals(1,p.Et.size());
		assertTrue(a.equals(b));
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
		Arista a01 = new Arista(0,1,8);
		Arista a02 = new Arista(0,2,5);
		Arista a03 = new Arista(0,3,5);
		p.obtenerAristas(0);
		
		assertEquals(3,p.aristasAuxiliares.size());
		assertTrue(p.aristasAuxiliares.get(0).equals(a01));
		assertTrue(p.aristasAuxiliares.get(1).equals(a02));
		assertTrue(p.aristasAuxiliares.get(2).equals(a03));
	}
	
	
}
