package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import grafo.Arista;

public class PrimAssert {

	public static void aristaDeMenorPeso(Prim p, Arista a)
	{
		p.aristasAuxiliares.add(a);
		p.seleccionarAristaDeMenorPeso();
		Arista b = p.Et.get(0);
		
		assertEquals(1,p.Et.size());
		assertEquals(0,p.aristasAuxiliares.size());
		assertTrue(a.equals(b));
	}
	
	public static void obtenerAristas(Prim p)
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
	
	public static void ejecutarPrim(Prim p)
	{
		p.ejecutarPrim();
		
		Arista a03 = new Arista(0,3,5);
		Arista a23 = new Arista(2,3,0);
		Arista a12 = new Arista(1,2,5);
		
		assertEquals(3,p.Et.size());
		assertTrue(p.Et.get(0).equals(a03));
		assertTrue(p.Et.get(1).equals(a23));
		assertTrue(p.Et.get(2).equals(a12));
	}
	
	public static void eliminarAristaTest(Solucion solucion)
	{
		Arista a = new Arista(2,3,7);
		
		assertEquals(2,solucion.agm.getVecinos().get(2).size());
		assertEquals(1,solucion.agm.getVecinos().get(3).size());
		assertEquals(3,solucion.agm.getAristas().size());
		
		solucion.eliminarArista(a);
		
		assertEquals(1,solucion.agm.getVecinos().get(2).size());
		assertEquals(0,solucion.agm.getVecinos().get(3).size());
		assertEquals(2,solucion.agm.getAristas().size());
	}
	
	public static void verificarAristaMayor(Solucion solucion)
	{
		Arista a = new Arista(2,3,7);
		
		assertTrue (solucion.verificarAristaMayor(a,3));
	}
	
	public static void verificarAristaMenor(Solucion solucion)
	{
		Arista a = new Arista(2,3,7);
		
		assertFalse (solucion.verificarAristaMayor(a,8));
	}
	
	public static void eliminararAristaMayor(Solucion solucion)
	{
		Arista a = new Arista(2,1,9);
		solucion.eliminarAristaMayor();
		boolean ret = false;
		
		for(Arista b : solucion.agm.getAristas())
		{
			ret = ret || b.equals(a);
		}
		
		assertEquals (2,solucion.agm.getAristas().size());
		assertFalse (ret);
	}
	
	public static void agregarArista(ArbolGeneradorMinimo agm)
	{
		Arista a = new Arista(0,2,7);
		HashSet<Integer> aux= new HashSet<Integer>();
		aux.add(1);
		
		assertEquals(1,agm.vecinos.get(0).size());
		assertEquals(aux,agm.vecinos.get(0));
		
		agm.agregarArista(a);
		aux.add(2);
		assertEquals(2,agm.vecinos.get(0).size());
		assertEquals(aux,agm.vecinos.get(0));
	}

	public static void completarLista(ArbolGeneradorMinimo agm) 
	{
		assertEquals(0,agm.vecinos.size());
		
		agm.generarVecinos(agm.personas.size());
		agm.completarListaDeVecinos();
		
		assertEquals(4,agm.vecinos.size());
		assertEquals(1,agm.vecinos.get(0).size());	
		assertEquals(2,agm.vecinos.get(1).size());
		assertEquals(2,agm.vecinos.get(2).size());
		assertEquals(1,agm.vecinos.get(3).size());	
	}

	public static void generarVecinos(ArbolGeneradorMinimo agm) 
	{
		assertEquals(0,agm.vecinos.size());
		
		agm.generarVecinos(4);
		
		assertEquals(4,agm.vecinos.size());
	}

	public static void obtenerComponentesConexas(Solucion solucion) 
	{
		assertTrue(solucion.getComponenteConexa1().isEmpty());
		assertTrue(solucion.getComponenteConexa2().isEmpty());
		
		solucion.eliminarAristaMayor();
		solucion.obtenerComponentesConexas();
		
		assertFalse(solucion.getComponenteConexa1().isEmpty());
		assertFalse(solucion.getComponenteConexa2().isEmpty());
	}

	public static void otenerVerticesDeLasComponentes(Solucion solucion) 
	{
		assertTrue(solucion.getPersonasGrupo1().isEmpty());
		assertTrue(solucion.getPersonasGrupo2().isEmpty());
		
		solucion.eliminarAristaMayor();
		solucion.obtenerComponentesConexas();

		assertFalse(solucion.getPersonasGrupo1().isEmpty());
		assertFalse(solucion.getPersonasGrupo2().isEmpty());
	}

	public static void dfs(Solucion solucion) 
	{
		Arista a01 = new Arista(0,1,0);
		Arista a23 = new Arista(2,3,7);
		
		assertTrue(solucion.getComponenteConexa1().isEmpty());
		assertTrue(solucion.getComponenteConexa2().isEmpty());
		
		solucion.eliminarAristaMayor();
		solucion.obtenerComponentesConexas();
		
		assertTrue(solucion.getComponenteConexa1().get(0).equals(a01));
		assertTrue(solucion.getComponenteConexa2().get(0).equals(a23));
	}

	public static void completarComponente2Vacia(Solucion solucion) 
	{
		assertTrue(solucion.getComponenteConexa1().isEmpty());
		assertTrue(solucion.getComponenteConexa2().isEmpty());
		
		solucion.eliminarAristaMayor();
		solucion.obtenerComponentesConexas();
		
		assertFalse(solucion.getPersonasGrupo1().isEmpty());
		assertTrue(solucion.getComponenteConexa2().isEmpty());
		assertFalse(solucion.getPersonasGrupo2().isEmpty());
	}

	public static void completarComponente2(Solucion solucion) 
	{
		assertTrue(solucion.getComponenteConexa1().isEmpty());
		assertTrue(solucion.getComponenteConexa2().isEmpty());
		
		assertTrue(solucion.getPersonasGrupo1().isEmpty());
		assertTrue(solucion.getPersonasGrupo2().isEmpty());
		
		solucion.eliminarAristaMayor();
		solucion.obtenerComponentesConexas();

		assertFalse(solucion.getComponenteConexa1().isEmpty());
		assertFalse(solucion.getComponenteConexa2().isEmpty());
		
		assertFalse(solucion.getPersonasGrupo1().isEmpty());
		assertFalse(solucion.getPersonasGrupo2().isEmpty());
	}
}
