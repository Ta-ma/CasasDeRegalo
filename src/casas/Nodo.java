package casas;

import java.util.LinkedList;
import java.util.List;

public class Nodo implements Comparable<Nodo> {
    private int nombre;
    private List<Arista> aristas;

    public Nodo(int nombre) {
	aristas = new LinkedList<Arista>();
	this.nombre = nombre;
    }

    public void agregarArista(Arista arista) {
	aristas.add(arista);
    }
    
    public void setAristas(List<Arista> aristas) {
	this.aristas = aristas;
    }
    
    public List<Arista> getAristas() {
	return aristas;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
    public int getGrado() {
        return aristas.size();
    }

    @Override
    public int compareTo(Nodo o) {
	return ((Integer)this.getGrado()).compareTo(o.getGrado());
    }

    @Override
    public String toString() {
	return "Nodo [nombre=" + nombre + ", aristas=" + aristas + "]";
    }
    
}
