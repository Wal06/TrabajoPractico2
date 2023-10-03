
public class Arista {
	int peso;
	int p1, p2;
	
	
	public Arista(int p1, int p2, int[] intereses1, int[] intereses2) {
		this.p1=p1;
		this.p2=p2;
		this.peso=calcularSimilaridad(intereses1,intereses2);
	}
	
	private int calcularSimilaridad(int[] intereses1, int[] intereses2) 
	{
		return Math.abs(intereses1[0]-intereses2[0]) 
			 + Math.abs(intereses1[1]-intereses2[1]) 
			 + Math.abs(intereses1[2]-intereses2[2]) 
			 + Math.abs(intereses1[3]-intereses2[3]);	
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
}

