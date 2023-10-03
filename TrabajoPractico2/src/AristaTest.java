import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AristaTest {

	@Test
	void calcularSimilaridadTest() 
	{
		 int[] intereses1 = {1,2,3,4};
		 int[] intereses2 = {1,2,3,4};
		 Arista a = new Arista(1,2,intereses1,intereses2);
		 
		 assertEquals(0,a.getPeso());
	}

}
