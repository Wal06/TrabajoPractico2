
public class Arista {
	int peso;
	int p1, p2;
	
	public Arista() {
		
	}
	
	public Arista(int p1, int p2, int peso) {
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
}

