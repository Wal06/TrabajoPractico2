package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import grafo.Arista;
import grafo.Persona;

public class ArbolGeneradorMinimo {

	ArrayList<HashSet<Integer>> vecinos = new ArrayList<HashSet<Integer>>();
	HashMap<Integer,Persona> personas;
	public ArrayList<Arista> aristas;
	static int personaId;
	
	ArbolGeneradorMinimo(ArrayList<Arista> Et,HashMap<Integer,Persona> p, int cantidadDeVertices)
	{
		aristas = Et;	//Guardamos el subconjunto de aristas generado por Prim como las aristas del agm
		personas = p;	
		generarVecinos(cantidadDeVertices);
		completarListaDeVecinos();	//Completamos las listas de vecinos de acuerdo a las aristas del agm
	}
	
	ArbolGeneradorMinimo(ArrayList<Arista> Et,HashMap<Integer,Persona> p) //Constructor para testeo
	{
		aristas = Et;
		personas = p;	
	}

	void generarVecinos(int cantidadDeVertices)
	{
		for (int i = 0; i<cantidadDeVertices; i++)
		{
			vecinos.add(new HashSet<Integer>());
		}
		return;
	} 
	
	void completarListaDeVecinos() 
	{
		for(Arista a : aristas)
		{
			agregarArista(a);
		}
	}

	void agregarArista(Arista a) 
	{
		int p1 = a.getP1();
		int p2 = a.getP2();
		
		vecinos.get(p1).add(p2);
		vecinos.get(p2).add(p1);
	}	
	
	
	public int tamano()
	{
		return vecinos.size();
	}
	
	public ArrayList<Arista> getAristas() 
	{
		return aristas;
	}

	public ArrayList<HashSet<Integer>> getVecinos() 
	{
		return vecinos;
	}

	public HashMap<Integer, Persona> getPersonas() 
	{
		return personas;
	}
	
	public String mostrarPersonas() 
	{
		 StringBuilder str = new StringBuilder();
		    
		    for (Entry<Integer, Persona> entry : personas.entrySet()) 
		    {
		        int personaId = entry.getKey();
		        Persona persona = entry.getValue();
		        str.append("Persona ").append(personaId).append("\n").append(persona).append("\n");
		    }
		    
		    return str.toString();	
	}
	
	public String mostrarAristas() 
	{
		 StringBuilder str = new StringBuilder();
		    
		    for (Arista  entry : aristas) 
		    {
		       
		        str.append(entry);
		    }
		    
		    return str.toString();	
	}


	@Override
	public String toString()
	{
		 StringBuilder str = new StringBuilder();
		 
		 str.append(mostrarPersonas());
		 str.append(mostrarAristas());
		 
		 return str.toString();
	}
	
}
