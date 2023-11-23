package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import grafo.Arista;
import grafo.GrafoCompleto;
import grafo.Persona;

public class Solucion {
	
	ArbolGeneradorMinimo agm;
	
	private ArrayList<Arista> componenteConexa1;
    private ArrayList<Arista> componenteConexa2;
   
    private ArrayList<Persona> personasGrupo1;
    private ArrayList<Persona> personasGrupo2;
    
    private HashSet<Integer> visitados;
    
	Solucion(ArbolGeneradorMinimo arbol)
	{
		agm = arbol;
		componenteConexa1 = new ArrayList<>();
		componenteConexa2 = new ArrayList<>();
		
		personasGrupo1 = new ArrayList<>();
		personasGrupo2 = new ArrayList<>();
		
		visitados = new HashSet<>();
		
		if(agm.tamano()==1)
		{
			agmConUnaPersona();
			return;
		}
		
		else if(agm.tamano()==2)
		{
			agmConDosPersonas();
			return;
		}
		else
		{
			eliminarAristaMayor();
			obtenerComponentesConexas();
		}
	}
	
	public void eliminarAristaMayor()
	{	
		Arista ret = new Arista();
		int pesoAux=-1;
		
		for(Arista a: agm.getAristas())
		{
			if(pesoAux==-1 || verificarAristaMayor(a,pesoAux))
			{
				pesoAux=a.getPeso();
				ret=a;
			}
		}
		eliminarArista(ret);
	}	
	
	private void agmConUnaPersona()
	{
		personasGrupo1.add(agm.getPersonas().get(0));
	}

	private void agmConDosPersonas() 
	{
		personasGrupo1.add(agm.getPersonas().get(0));
		personasGrupo2.add(agm.getPersonas().get(1));
	}

	boolean verificarAristaMayor(Arista a,  int peso)
	{		
		return  a.getPeso()>peso;
	}
	
	void eliminarArista(Arista a) 
	{	
			int vert1 = a.getP1();
			int vert2 = a.getP2();
			
			agm.getVecinos().get(vert1).remove(vert2);
			agm.getVecinos().get(vert2).remove(vert1);
			
			agm.getAristas().removeIf(b -> a.equals(b));
	}
	
	public void obtenerComponentesConexas()
	{
	    for (int vertice = 0; vertice < agm.getVecinos().size(); vertice++)
	    {
	        if (!visitados.contains(vertice))	
	        {
	            ArrayList<Arista> componenteConexa = new ArrayList<>();
	            
	            dfs(vertice, componenteConexa);	//Ejecutamos dfs recursivamente para obtener las componentes
	            asignarComponenteConexa(componenteConexa);	//asignamos la componente respectiva
	        }
	    }    
	    obtenerVerticesDeLasComponentes();		//Obtenemos los vertices desde las componentes para obtener las personas
    }
	
	private void dfs(int vertice, ArrayList<Arista> componenteConexa) 
	{
		visitados.add(vertice);	

		for (Arista arista : agm.getAristas()) 	
		{
			int p1 = arista.getP1();
			int p2 = arista.getP2(); 

			if (p1 == vertice && !visitados.contains(p2)) //Si alguno de los vertices es el que estamos evaluando, y el otro no fue visitado ejecutamos dfs sobre el segundo vertice
			{
				componenteConexa.add(arista);
				dfs(p2, componenteConexa);
			} 
			else if (p2 == vertice && !visitados.contains(p1)) 
			{
				componenteConexa.add(arista);
				dfs(p1, componenteConexa);
			}
		}
	}
	
	private void asignarComponenteConexa(ArrayList<Arista> componenteConexa)
	{
	    if (componenteConexa1.isEmpty())	//Por defecto se completa primero la componente 1
	    {
	        componenteConexa1.addAll(componenteConexa);
	    }
	    else
	    {
	        componenteConexa2.addAll(componenteConexa);
	    }
	}
	
    private void obtenerVerticesDeLasComponentes()
    {
    	ArrayList<Integer> verticesDelPrimerGrupo = new ArrayList<>();	//Listas auxiliares de vertices
    	ArrayList<Integer> verticesDelSegundoGrupo = new ArrayList<>();
    
        for (Arista a : componenteConexa1)	// Obtenemos los vértices del primer grupo
        {	 
            if (!verticesDelPrimerGrupo.contains(a.getP1())) 
            {
                verticesDelPrimerGrupo.add(a.getP1());
            }
            if (!verticesDelPrimerGrupo.contains(a.getP2())) 
            {
                verticesDelPrimerGrupo.add(a.getP2());
            }
        }
        
        for (Arista a : componenteConexa2) 
        {
            if (!verticesDelSegundoGrupo.contains(a.getP1())) 
            {
                verticesDelSegundoGrupo.add(a.getP1());
            }
            if (!verticesDelSegundoGrupo.contains(a.getP2())) 
            {
                verticesDelSegundoGrupo.add(a.getP2());
            }
        }

        // Si hay aristas de igual peso y queda una componente conformada por solo un vertice, lo agregamos a la segunda componente
        for (int i = 0; i < agm.tamano(); i++) 
        {
            if (!verticesDelPrimerGrupo.contains(i) && !verticesDelSegundoGrupo.contains(i)) 
            {
                verticesDelSegundoGrupo.add(i);
            }
        }
        
        obtenerPersonas(verticesDelPrimerGrupo, verticesDelSegundoGrupo);
    }
    
    private void obtenerPersonas(ArrayList<Integer> verticesDelPrimerGrupo, ArrayList<Integer> verticesDelSegundoGrupo) 
    {
    	HashMap<Integer,Persona> p = agm.getPersonas();	//A partir de los vertices obtenemos las personas
		
    	for(Integer i : verticesDelPrimerGrupo)
		{
			personasGrupo1.add(p.get(i));
		}
    	
    	for(Integer j : verticesDelSegundoGrupo)
		{
			personasGrupo2.add(p.get(j));
		}		
	}

	public ArbolGeneradorMinimo getAgm() 
	{
		return agm;
	}

	public ArrayList<Arista> getComponenteConexa1() 
	{
		return componenteConexa1;
	}

	public ArrayList<Arista> getComponenteConexa2() 
	{
		return componenteConexa2;
	}

	

	public String getPersonasGrupo1() 
	{
		StringBuilder strb = new StringBuilder("Grupo 1 : \n\n");

		for (Persona p : personasGrupo1)
		{
			strb.append(p.toString()).append("\n");
		}

		return strb.toString();
	}

	public String getPersonasGrupo2() 
	{
		StringBuilder strb = new StringBuilder("Grupo 2 : \n\n");

	    for (Persona p : personasGrupo2)
	    {
	        strb.append(p).append("\n");
	    }

	    return strb.toString();
	}
	
	public HashSet<Integer> getVisitados() 
	{
		return visitados;
	}
}
