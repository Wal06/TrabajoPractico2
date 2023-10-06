import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ArbolGeneradorMinimo {

	private GrafoCompleto grafoCompleto;
	
	private ArrayList<HashSet<Integer>> vecinos;
	private ArrayList<Arista> aristas;
	private ArrayList<Integer> vertices;
	
	ArbolGeneradorMinimo(GrafoCompleto g)
	{
		
		grafoCompleto=g;
		vecinos = new ArrayList<HashSet<Integer>>();
		aristas = new ArrayList<Arista>();
		vertices = new ArrayList<Integer>();
		
		for(int i=0; i<g.tamano();i++)
		{
			vertices.add(i);
			int pesoAux=0;
			Arista aux = new Arista();
					
			for(Arista a: g.aristas)
			{
				if(pesoAux==0 && a.contains(i))
				{
					pesoAux=a.getPeso();
					aux=a;
				}
				
				else if(a.contains(i) && a.getPeso()<pesoAux)
				{
					pesoAux=a.getPeso();
					aux=a;
				}
			}
			
			if(!existeArista(aux,g)) {
				
				if(vertices.contains(aux.getP1()) && !vertices.contains(aux.getP2()))
				{	
				
					agregarArista(aux);
				}
				
				if(vertices.contains(aux.getP2()) && !vertices.contains(aux.getP1()))
				{	
		
					agregarArista(aux);
				}
			}
		}	
	}

	private boolean existeArista(Arista a, GrafoCompleto g) 
	{
		
		return g.vecinos.get(a.getP1()).contains(a.getP2());
	 }
	
	private void agregarArista(Arista a) 
	{
		vecinos.get(a.getP1()).add(a.getP2());
		vecinos.get(a.getP2()).add(a.getP1());
		aristas.add(a);	
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GrafoCompleto g = new GrafoCompleto();
		g.agregarPersona("a", 1, 2, 3, 4);
		g.agregarPersona("b", 4, 3, 2, 1);
		g.agregarPersona("c", 4, 2, 2, 5);
		g.agregarPersona("d", 4, 2, 2, 5);
		
		ArbolGeneradorMinimo agm = new ArbolGeneradorMinimo(g);
		System.out.println(agm.vecinos.get(0).contains(1));
	}

	
	
}
