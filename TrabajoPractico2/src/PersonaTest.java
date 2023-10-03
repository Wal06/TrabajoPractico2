import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;


class PersonaTest {

	@Test
	public void deportesNegativosTest() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
            Persona p = new Persona("Test", -1, 2, 3, 4);
        });
	}
	
	@Test
	public void musicaNegativaTest() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
            Persona p = new Persona("Test", 5, 0, 3, 4);
        });
	}
	
	@Test
	public void espectaculoNegativoTest() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
            Persona p = new Persona("Test", 3, 2, -2, 4);
        });
	}
	
	@Test
	public void cienciaNegativaTest() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
            Persona p = new Persona("Test", 3, 2, 5, -5);
        });
	}

	@Test
	public void deportesExcedidosTest() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
            Persona p = new Persona("Test", 6, 2, 5, 1);
        });
	}
	
	@Test
	public void musicaExcedidaTest() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
            Persona p = new Persona("Test", 5, 8, 3, 4);
        });
	}
	
	@Test
	public void espectaculoExcedidoTest() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
            Persona p = new Persona("Test", 3, 2, 10, 4);
        });
	}
	
	@Test
	public void cienciaExcedidaTest() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
            Persona p = new Persona("Test", 3, 2, 5, 15);
        });
	}
}
