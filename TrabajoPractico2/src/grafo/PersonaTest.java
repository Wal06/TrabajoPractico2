package grafo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;


public class PersonaTest {

	@Test(expected = IllegalArgumentException.class)
	public void deportesNegativosTest() 
	{
		Persona p = new Persona("Test", -1, 2, 3, 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void musicaNegativaTest() 
	{
		Persona p = new Persona("Test", 5, 0, 3, 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void espectaculoNegativoTest() 
	{
		Persona p = new Persona("Test", 3, 2, -2, 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cienciaNegativaTest() 
	{
		Persona p = new Persona("Test", 3, 2, 5, -5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deportesExcedidosTest() 
	{
		Persona p = new Persona("Test", 6, 2, 5, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void musicaExcedidaTest() 
	{
		Persona p = new Persona("Test", 5, 8, 3, 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void espectaculoExcedidoTest() 
	{
		Persona p = new Persona("Test", 3, 2, 10, 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cienciaExcedidaTest() 
	{
		Persona p = new Persona("Test", 3, 2, 5, 15);
	}
	
	@Test
	public void getInteresesTest() 
	{
            Persona p = new Persona("Test", 1, 2, 3, 4);
            int[] intereses = {1,2,3,4};
            
            Assert.intereses(intereses,p.getIntereses());
	}
}
