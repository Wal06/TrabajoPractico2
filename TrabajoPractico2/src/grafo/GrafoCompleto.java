package grafo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GrafoCompleto {
	
	ArrayList<HashSet<Integer>> vecinos;
	HashMap<Integer,Persona> personas;
	public ArrayList<Arista> aristas;
	static int personaId;
	
	
	public GrafoCompleto() 
	{
		vecinos = new ArrayList<HashSet<Integer>>();
		personas = new HashMap<>();
		aristas = new ArrayList<Arista>();
		personaId=0;
	}
	
	public void agregarPersona(String nombre, int deportes, int musica, int espectaculo, int ciencia) 
	{
        Persona persona = new Persona(nombre, deportes, musica, espectaculo, ciencia);
        
        if(personaId==0) //Vemos si es la primer persona en agregarse
        {
        	personas.put(personaId, persona); 
        	personaId++;
        	vecinos.add(new HashSet<Integer>());
        }
        
        else
        {   
        	personas.put(personaId, persona);
        	vecinos.add(new HashSet<Integer>());
        	incluirEnElGrafo(personaId,persona);	//Si hay mas de una persona se generan aristas con todo el resto de las personas
        	personaId++;
        }
    }
	
	private void incluirEnElGrafo(int personaId, Persona p) 
	{
		for(int i=0; i<tamano(); i++)
		{
			if(i != personaId && !existeArista(personaId,i))
			{
				int peso = calcularSimilaridad(p.getIntereses(),personas.get(i).getIntereses());
				agregarArista(personaId,i,peso);
			}
		}
	}

	private void agregarArista(int p1, int p2, int peso) 
	{
		verificarVertice(p1);
		verificarVertice(p2);
		verificarVerticesDistintos(p1, p2);
		
		vecinos.get(p1).add(p2);
		vecinos.get(p2).add(p1);
		Arista a = new Arista(p1,p2,peso);
		aristas.add(a);	
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
	
	
	public Set<Integer> getVecinos(int i)
	{
		verificarVertice(i);
		return vecinos.get(i);
	}
	
	public HashMap<Integer,Persona> getPersonas()
	{
		HashMap<Integer,Persona> ret = this.personas;
		
		return ret;
	}
	
	private void verificarVerticesDistintos(int i, int j) 
	{
		if(i==j) 
		{
			throw new IllegalArgumentException("No se permiten loops: (" + i + " , " +  j + ")");
		}
	}

	private void verificarVertice(int i) 
	{
		if(i<0) 
		{
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		}
		
		if(i>=tamano()) 
		{
			throw new IllegalArgumentException("Los vertices deben estar contenidos dentro de A: " + tamano());
		}
	}
	
	
	int calcularSimilaridad(int[] intereses1, int[] intereses2) 
	{
		return Math.abs(intereses1[0]-intereses2[0]) 
			 + Math.abs(intereses1[1]-intereses2[1]) 
			 + Math.abs(intereses1[2]-intereses2[2]) 
			 + Math.abs(intereses1[3]-intereses2[3]);	
	}
	
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		
		str.append("Cantidad de personas: " + tamano() + "\n\n");
		
	    for (Map.Entry<Integer, Persona> entry : personas.entrySet()) 
	    {
	        int personaId = entry.getKey();
	        Persona persona = entry.getValue();
	        str.append("Persona ").append(personaId).append("\n\n").append(persona).append("\n");
	        str.append("Vecinos: ").append(vecinos.get(personaId)).append("\n").append("\n");
	  
	    }
	    
	    str.append("Aristas: \n\n");
	    
	    for(Arista a : aristas)
	    {
	    	str.append(a);
	    }
	    
	    return str.toString();
	}

}
