import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ArbolGeneradorMinimo {

	private GrafoCompleto grafoCompleto;
	
	private ArrayList<HashSet<Integer>> vecinos;
	private ArrayList<Arista> aristas;
	private ArrayList<Arista> aristasAuxiliares;
	private ArrayList<Integer> vertices;
	 
	
	ArbolGeneradorMinimo(GrafoCompleto g)
	{
		grafoCompleto=g;
		aristas = new ArrayList<Arista>();
		aristasAuxiliares = new ArrayList<Arista>();
		vertices = new ArrayList<Integer>();
		
		generarVecinos();
		 	 	
		prim();
	}
	
	private void generarVecinos()
	{
		this.vecinos = new ArrayList<HashSet<Integer>>();
		for (int i = 0; i<grafoCompleto.tamano(); i++)
		{
			vecinos.add(new HashSet<Integer>());
		}
			return;
	} 	 	

	
	
	public void prim() {
		
		
			vertices.add(0);
			obtenerAristas(0);
			generarAristas();
					

		
	}
	
	private void obtenerAristas(int i)
	{
		for(Arista a : grafoCompleto.aristas)
		{
			if(a.contains(i) && !existeArista(a))
			{
				aristasAuxiliares.add(a);
			}
		}
		
		return;
	}
	
	private boolean existeArista(Arista a) 
	{
		return vecinos.get(a.getP1()).contains(a.getP2());
	 }
	
	public void generarAristas()
	{
		Arista ret = new Arista();
		int i = 0; 	
		int vertice=0;
		
		while(i<grafoCompleto.tamano()-1)
		{
			int pesoAux=-1;
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
			vertice = proximoVertice(vertice,ret);
		
			agregarArista(ret);
			vertices.add(vertice);
			obtenerAristas(vertice);
			i++;
		} 
	}
	
	
	
	private boolean verificarArista(Arista a,  int peso)
	{	
		int vert1 = a.getP1();
		int vert2 = a.getP2();
		
		if(verticesValidos(vert1,vert2) && a.getPeso()<peso)
		{
			return true;
		}
		return false;
	}
	
	private boolean verticesValidos(int i, int j)
	{
		if(vertices.contains(i) && !vertices.contains(j))
		{
			return true;
		}
		if(vertices.contains(j) && !vertices.contains(i))
		{
			return true;
		}
		return false;
	}

	private int proximoVertice(int vertice, Arista ret) 
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
	
	private void agregarArista(Arista a) 
	{
		vecinos.get(a.getP1()).add(a.getP2());
		vecinos.get(a.getP2()).add(a.getP1());
		aristas.add(a);
		aristasAuxiliares.remove(a);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GrafoCompleto g = new GrafoCompleto();
		g.agregarPersona("a", 1, 2, 3, 4);
		g.agregarPersona("b", 2, 3, 4, 5);
		g.agregarPersona("c", 3, 4, 5, 1);
		g.agregarPersona("d", 4, 5, 1, 2);
		
		ArbolGeneradorMinimo agm = new ArbolGeneradorMinimo(g);
		System.out.println(agm.vecinos.get(0).contains(1));
		System.out.println(agm.vecinos.size());
		System.out.println(agm.grafoCompleto.tamano());
	}

	
	
}
