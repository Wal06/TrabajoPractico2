package model;

import org.junit.Before;
import org.junit.Test;

import grafo.GrafoCompleto;

public class SolucionTest {

	Solucion solucion;
	
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
		ArbolGeneradorMinimo agm = p.generarArbol();
		solucion = new Solucion(agm);
	}
	
	@Test
	public void contieneVecinoTest()
	{
		PrimAssert.eliminarAristaTest(solucion);
	}
	
	@Test
	public void verificarAristaMayorTest()
	{
		PrimAssert.verificarAristaMayor(solucion);
	}
	
	@Test
	public void verificarAristaMenorTest()
	{
		PrimAssert.verificarAristaMenor(solucion);
	}
	
	@Test
	public void eliminarAristaMayor()
	{
		PrimAssert.eliminararAristaMayor(solucion);
	}
	
	@Test
	public void obtenerComponentesConexasTest()
	{
		PrimAssert.obtenerComponentesConexas(solucion);
	}

	@Test
	public void obtenerVerticesDeLasComponentes()
	{
		PrimAssert.otenerVerticesDeLasComponentes(solucion);
	}
	
	@Test
	public void dfsTest()
	{
		PrimAssert.dfs(solucion);
	}
	
	@Test
	public void completarComponente2VaciaTest()
	{
		GrafoCompleto g = new GrafoCompleto();
		g.agregarPersona("a", 1, 1, 1, 1);              
		g.agregarPersona("b", 1, 1, 1, 1);
		g.agregarPersona("c", 1, 1, 1, 1);
		g.agregarPersona("d", 1, 1, 1, 1);

		Prim p = new Prim(g);
		p.ejecutarPrim();
		ArbolGeneradorMinimo agm = p.generarArbol();
		solucion = new Solucion(agm);
		
		PrimAssert.completarComponente2Vacia(solucion);
	}
	
	@Test
	public void completarComponente2Test()
	{
		PrimAssert.completarComponente2(solucion);
	}
	
}
