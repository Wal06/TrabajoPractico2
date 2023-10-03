import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class grafoCompletoTest {

	@Test
	void tamanoTest()
	{
		grafoCompleto g = inicializarGrafo();
		
		assertEquals(2,g.tamano());
	}

	private grafoCompleto inicializarGrafo() 
	{
		grafoCompleto g = new grafoCompleto();
		g.agregarPersona("a", 1, 2, 3, 4);
		g.agregarPersona("b", 4, 3, 2, 1);
		
		return g;
	}
}
