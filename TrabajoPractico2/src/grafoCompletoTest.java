import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class grafoCompletoTest {

	@Test
	void tamanoTest()
	{
		grafoCompleto g = inicializarGrafo();
		
		assertEquals(4,g.tamano());
	}
	
	@Test
	void personaIdTest()
	{
		grafoCompleto g = inicializarGrafo();
		
		assertEquals(4,g.personaId);
	}

	@Test
	void vecinosTest()
	{
		grafoCompleto g = inicializarGrafo();
		
		assertEquals(6,g.aristas.size());
	}
	
	@Test
	void agregarPersonaTest()
	{
		grafoCompleto g = inicializarGrafo();
		
		Assert.agregarPersonas(g, 4, 4, 6);
	}
	
	@Test
	void incluirEnElGrafoTest()
	{
		grafoCompleto g = inicializarGrafo();
		
		assertEquals(3,g.vecinos(0).size());
	}
	
	private grafoCompleto inicializarGrafo() 
	{
		grafoCompleto g = new grafoCompleto();
		g.agregarPersona("a", 1, 2, 3, 4);
		g.agregarPersona("b", 4, 3, 2, 1);
		g.agregarPersona("c", 4, 2, 2, 5);
		g.agregarPersona("d", 4, 2, 2, 5);
		
		return g;
	}
}
