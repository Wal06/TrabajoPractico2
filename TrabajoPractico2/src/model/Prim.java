package model;

import java.util.ArrayList;


import grafo.Arista;
import grafo.GrafoCompleto;

public class Prim {

	private GrafoCompleto grafoCompleto;

	ArrayList<Integer> Vt = new ArrayList<Integer>();
	ArrayList<Arista> Et =  new ArrayList<Arista>();
	ArrayList<Arista> aristasAuxiliares =  new ArrayList<Arista>(); //Guarda las posibles aristas a agregar al AGM de acuerdo a los vertices visitados
	private int i = 0;
	private int v = 0;
	

	Prim(GrafoCompleto g)
	{
		grafoCompleto=g;
		ejecutarPrim();
	}
	 
	Prim(GrafoCompleto g, boolean condicion) 	//Este constructor se usa para simular un Prim para los tests 
	{
		grafoCompleto=g;
	}
	
	public void ejecutarPrim()
	{
		if(grafoCompleto.tamano()==1)	//En caso de que solo exista una persona en el grafo
		{
			Vt.add(v);
			return;
		}	
		else if(grafoCompleto.tamano()==2) //En caso de que solo exista una arista en el grafo
		{
			Vt.add(v);
			Vt.add(v+1);
			Et.add(grafoCompleto.aristas.get(0));
			return;
		}
		else 
		{
			while(i<grafoCompleto.tamano()-1)	//Cuando hay mas de una arista
			{
				Vt.add(v);
				obtenerAristas(v);				//Obtenemos las aristas que contienen al vertice evaluado
				seleccionarAristaDeMenorPeso();	

				int proximoVertice = proximoVertice(v,Et.get(Et.size()-1));		//Obtenemos el siguiente vertice en base a la arista agregada
				v=proximoVertice;

				i++;
			}
			Vt.add(v);
		}
	}
	
	void obtenerAristas(int i)
	{
		for(Arista a : grafoCompleto.aristas)
		{
			if(a.contains(i) && !existeAristaAuxiliar(a))	
			{
				aristasAuxiliares.add(a);
			}
		}
	}
	
	boolean existeAristaAuxiliar(Arista a) 
	{
		return aristasAuxiliares.contains(a);
	}
	
	void seleccionarAristaDeMenorPeso() 
	{
		int pesoAux=-1;
		Arista ret = new Arista();
		
		for(Arista a: aristasAuxiliares)
		{
			if (Vt.contains(a.getP1()) && Vt.contains(a.getP2()))  // Evitamos ciclos pasando a la siguiente arista
			{
				continue; 
			}
			
			else if(pesoAux==-1)
			{
				pesoAux=a.getPeso();
				ret=a;
			}
	
			else if(verificarArista(a,pesoAux))
			{
				pesoAux=a.getPeso();
				ret=a;
			}
		}
		Et.add(ret);
		aristasAuxiliares.remove(ret);		//Eliminamos aristas que ya no sea relevante considerar
	}


	boolean verificarArista(Arista a,  int peso)
	{			
		if( a.getPeso()<=peso && !aristaAgregada(a)) 	//Si a tiene un peso menor o igual al de referencia y 
		{												//no esta en el conjunto solucion Et, devuelve true
			return true;								
		}	
		return false;
	}
	
	private boolean aristaAgregada(Arista a) //Comprobamos si la arista esta agregada en el conjunto solucion Et
	{
		boolean ret = false;
		
		for(Arista arista : Et)
		{
			ret = ret || a.equals(arista);
		}
		return ret;
	}

	int proximoVertice(int vertice, Arista ret) 
	{
		if(ret.getP1()==vertice)
		{ 
			return ret.getP2();
		}
		
		else
		{
			return ret.getP1();
		}
	}
	
	public ArbolGeneradorMinimo generarArbol()
	{
        ArrayList<Arista> copiaAristas = new ArrayList<>(Et);
		ArbolGeneradorMinimo agm = new ArbolGeneradorMinimo(copiaAristas,grafoCompleto.getPersonas(),grafoCompleto.getPersonas().size());
		return agm;
	}

}

