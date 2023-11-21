package grafo;
import java.util.*;

public class Persona {
	
	private String nombre;
	int di,mi,ei,ci;
	
	public Persona(String nombre,int di,int mi,int ei,int ci) 
	{
		validarIntereses(di,mi,ei,ci);
		this.nombre=nombre;
		this.di=di;
		this.mi=mi;
		this.ei=ei;
		this.ci=ci;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public int getDi() 
	{
		return di;
	}

	public void setDi(int di) 
	{
		this.di = di;
	}

	public int getMi() 
	{
		return mi;
	}

	public void setMi(int mi) 
	{
		this.mi = mi;
	}

	public int getEi() 
	{
		return ei;
	}

	public void setEi(int ei) 
	{
		this.ei = ei;
	}

	public int getCi() 
	{
		return ci;
	}

	public void setCi(int ci) 
	{
		this.ci = ci;
	}
	
	public int[] getIntereses()
	{
		int[] ret = {di,mi,ei,ci};
		return ret;
	}
	
	private void validarIntereses(int di,int mi,int ei,int ci)
	{
		if(di<1||mi<1||ei<1||ci<1)
		{
			throw new IllegalArgumentException("No se admiten numeros menores a 1");
		}
		if(di>5||mi>5||ei>5||ci>5)
		{
			throw new IllegalArgumentException("No se admiten numeros mayores a 5");
		}
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		
		str.append("Nombre: " + nombre + "\n\n");
		str.append("Interes por los deportes: " + di + "\n");
		str.append("Interes por la musica: " + mi + "\n");
		str.append("Interes por las noticias del espectaculo: " + ei + "\n");
		str.append("Interes por la ciencia: " + ci + "\n");
		
		return str.toString();
	}

}
