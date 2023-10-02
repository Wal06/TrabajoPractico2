package tp2;

import java.util.Vector;

import tp2.Persona;


public class ListaDePersonas {
	
	private Vector vectorDePersonas;
	
	public ListaDePersonas() {
		
		vectorDePersonas=new Vector();
	}
	public void agregarPersona(Persona aPerosna) {
		
		vectorDePersonas.add(aPerosna);
	}
	public int getNumeroDePersonas() {
		
		return vectorDePersonas.size();
	}




}
