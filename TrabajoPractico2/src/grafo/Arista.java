package grafo;

public class Arista {
	int peso;
	int p1, p2;
	
	public Arista() {}
	
	public Arista(int p1, int p2, int peso) 
	{
		this.p1=p1;
		this.p2=p2;
		this.peso= peso;
	}
	

	public int getP1()
	{
		return p1;
	}
	
	public int getP2()
	{
		return p2;
	}
	
	public int getPeso()
	{
		return peso;
	}
	
	public boolean contains(int i) 
	{
		if(p1==i || p2==i)
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		
		str.append("Vertices: " + getP1() + " - " + getP2() + "\n" + "Indice de similaridad: " + getPeso() + "\n\n");
		
		return str.toString();
	}
	
	public boolean equals(Arista b)
	{
		if(mismosVertices(b) && peso == b.getPeso())
		{
			return true;
		}
		return false;
	}

	private boolean mismosVertices(Arista b) 
	{
		boolean ret1 = p1 == b.getP1() || p1 == b.getP2();
		boolean ret2 = p2 == b.getP1() || p2 == b.getP2();
		
		return ret1 && ret2;
	}
}

