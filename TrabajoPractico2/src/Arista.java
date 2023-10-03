
public class Arista {
	int peso;
	Persona persona1,persona2;
	
	public Arista(Persona p1,Persona p2) {
		this.persona1=p1;
		this.persona2=p2;
		this.peso=calcularSimilaridad(p1,p2);
	}
	private int calcularSimilaridad(Persona p1,Persona p2) {
		return Math.abs(p1.di-p2.di) + Math.abs(p1.mi-p2.mi ) + Math.abs(p1.ei-p2.ei) + Math.abs(p1.ci - p2.ci);
		
	}
}

