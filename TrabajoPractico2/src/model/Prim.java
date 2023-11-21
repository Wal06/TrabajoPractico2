package model;

import java.util.ArrayList;


import grafo.Arista;
import grafo.GrafoCompleto;

public class Prim {

	private GrafoCompleto grafoCompleto;

	ArrayList<Integer> Vt = new ArrayList<Integer>();
	ArrayList<Arista> Et =  new ArrayList<Arista>();
	ArrayList<Arista> aristasAuxiliares =  new ArrayList<Arista>();
	private int i = 0;
	private int v = 0;
	

	Prim(GrafoCompleto g)
	{
		grafoCompleto=g;
	}
	
	public void ejecutarPrim()
	{
		while(i<grafoCompleto.tamano())
		{
			Vt.add(v);
			obtenerAristas(v);
			seleccionarAristaDeMenorPeso();
			
			int proximoVertice = proximoVertice(v,Et.get(Et.size()-1));
			v=proximoVertice;
			
			i++;
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
			if(pesoAux==-1)
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
	}
	
	boolean verificarArista(Arista a,  int peso)
	{	
		int vert1 = a.getP1();
		int vert2 = a.getP2();
		
		if(verticesValidos(vert1,vert2) && a.getPeso()<peso)
		{
			return true;
		}
		
		return false;
	}
	
	boolean verticesValidos(int i, int j)
	{
		if(Vt.contains(i) && !Vt.contains(j))
		{
			return true;
		}
		if(Vt.contains(j) && !Vt.contains(i))
		{
			return true;
		}
		return false;
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
	
}

