import static org.junit.Assert.*;

import java.util.Set;

public class Assert {

	public static void intereses(int[] interesesEsperados, int[] interesesRecibidos)
	{
		assertEquals(interesesEsperados.length, interesesRecibidos.length);
		for (int i=0; i<interesesEsperados.length; i++)
		{
			assertTrue(interesesRecibidos[i]==interesesEsperados[i]);
		}	
	}

	public static void agregarPersonas(GrafoCompleto g, int personaId, int tamano, int aristas)
	{
		assertEquals(g.personaId, personaId);
		assertEquals(g.tamano(), tamano);
		assertEquals(g.aristas.size(), aristas);
	}
}
