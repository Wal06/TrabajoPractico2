import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class grafoCompleto {
	
	ArrayList<HashSet<Integer>> vecinos;
	HashMap<Integer,Persona> personas;
	ArrayList<Arista> aristas;
	static int personaId;
	
	
	public grafoCompleto() 
	{
		vecinos = new ArrayList<HashSet<Integer>>();
		personas = new HashMap<>();
		aristas = new ArrayList<Arista>();
		personaId=0;
	}
	
	public void agregarPersona(String nombre, int deportes, int musica, int espectaculo, int ciencia) 
	{
        Persona persona = new Persona(nombre, deportes, musica, espectaculo, ciencia);
        
        if(personaId==0)
        {
        	personas.put(personaId, persona); 
        	personaId++;
        	vecinos.add(new HashSet<Integer>());
        }
        
        else
        {   
        	personas.put(personaId, persona);
        	vecinos.add(new HashSet<Integer>());
        	personaId++;
        	incluirEnElGrafo(personaId-1,persona.getIntereses());	
        }
    }
	
	private void incluirEnElGrafo(int personaId, int[] intereses) 
	{
		for(int i=0; i<tamano(); i++)
		{
			if(i != personaId && !existeArista(personaId,i))
			{
				agregarArista(personaId,i,intereses,personas.get(i).getIntereses());
			}
		}
	}

	private void agregarArista(int p1, int p2, int[] intereses1, int[] intereses2) 
	{
		verificarVertice(p1);
		verificarVertice(p2);
		verificarVerticesDistintos(p1, p2);
		
		vecinos.get(p1).add(p2);
		vecinos.get(p2).add(p1);
		Arista a = new Arista(p1,p2,intereses1,intereses2);
		aristas.add(a);	
	}

	public void eliminarArista(int i, int j) 
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarVerticesDistintos(i, j);
		
		vecinos.get(i).remove(j);
		vecinos.get(j).remove(i);
		
		for (Arista arista : aristas) 
		{
			if (comprobarArista(i,j,arista)) 
		    {
				aristas.remove(arista); 
		        break;
		    }
		}
	}
		    
	private boolean comprobarArista(int i,int j, Arista a)
	{
		return a.getP1() == i && a.getP2() == j;
	}
	
	public boolean existeArista(int i, int j) 
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarVerticesDistintos(i, j);

		return vecinos.get(i).contains(j);
	 }
	
	public int tamano()
	{
		return vecinos.size();
	}
	
	
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i);
		return vecinos.get(i);
	}
	
	
	private void verificarVerticesDistintos(int i, int j) {
		if(i==j) 
		{
			throw new IllegalArgumentException("No se permiten loops: (" + i + " , " +  j + ")");
		}
	}

	private void verificarVertice(int i) {
		if(i<0) 
		{
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		}
		
		if(i>=tamano()) 
		{
			throw new IllegalArgumentException("Los vertices deben estar contenidos dentro de A: " + i);
		}
	}
	
	
	boolean distanciaDos(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarVerticesDistintos(i, j);
		
		if(existeArista(i,j))
		{
			return false;
		}
		
		else
		{
			Set<Integer> vecinos = vecinos(i);
			for(int k : vecinos)
			{
				if(existeArista(j,k))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	boolean verticeUniversal(int i)
	{
		if(vecinos.get(i).size()==tamano()-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
