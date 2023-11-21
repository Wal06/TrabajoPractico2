package grafo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AristaTest {

	@Test
	public void containsTest()
	{
		Arista a = new Arista(1,2,3);
		
		assertTrue(a.contains(1));
	}
	
	@Test
	public void notContainsTest()
	{
		Arista a = new Arista(1,2,3);
		
		assertFalse(a.contains(3));
	}
	
	@Test
	public void equalsTest()
	{
		Arista a = new Arista(1,2,3);
		Arista b = new Arista(1,2,3);
		
		assertTrue(a.equals(b));
	}
	
	@Test
	public void notEqualVertTest()
	{
		Arista a = new Arista(1,2,3);
		Arista b = new Arista(1,3,3);
		
		assertFalse(a.equals(b));
	}
	
	@Test
	public void notEqualPesoTest()
	{
		Arista a = new Arista(1,2,3);
		Arista b = new Arista(1,2,4);
		
		assertFalse(a.equals(b));
	}
}
