package grafo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class grafoCompletoTest {
	
	public GrafoCompleto g;

	@Before
	public void inicializarGrafo()
	{
		g = new GrafoCompleto();
		g.agregarPersona("a", 1, 2, 3, 4);
		g.agregarPersona("b", 4, 3, 2, 1);
		g.agregarPersona("c", 4, 2, 2, 5);
		g.agregarPersona("d", 4, 2, 2, 5);
	}
	
	@Test
	public void tamanoTest()
	{		
		assertEquals(4,g.tamano());
	}
	
	@Test
	public void personaIdTest()
	{
		assertEquals(4,g.personaId);
	}
	
	@Test
	public void agregarPersonaTest()
	{		
		Assert.agregarPersonas(g, 4, 4, 6);
	}
	
	@Test
	public void esGrafoCompletoTest()
	{
		Assert.esGrafoCompleto(g);
	}
	
	@Test
	public void existeArista()
	{
		assertTrue(g.existeArista(0, 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void noExisteArista()
	{
		g.existeArista(0, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verticeInexistente()
	{
		g.existeArista(0, 6);
	}
	
	@Test
	public void calcularSimilaridadTest()
	{
		int[] intereses1 = {1,2,3,4}; 
		int[] intereses2 = {5,6,7,8};		
		
		assertEquals(16,g.calcularSimilaridad(intereses1,intereses2));
	}
}
