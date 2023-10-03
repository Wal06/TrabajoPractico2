import java.util.*;

public class Persona {
	
	private String nombre;
	int di,mi,ei,ci;
	
	public Persona(String nombre,int di,int mi,int ei,int ci) {
		this.nombre=nombre;
		this.di=di;
		this.mi=mi;
		this.ei=ei;
		this.ci=ci;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDi() {
		return di;
	}

	public void setDi(int di) {
		this.di = di;
	}

	public int getMi() {
		return mi;
	}

	public void setMi(int mi) {
		this.mi = mi;
	}

	public int getEi() {
		return ei;
	}

	public void setEi(int ei) {
		this.ei = ei;
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

}
