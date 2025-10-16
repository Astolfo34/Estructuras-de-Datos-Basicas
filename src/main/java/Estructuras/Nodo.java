package Estructuras;

public class Nodo {

	private Object dato;
	private Nodo siguiente;

	public Nodo(Object dato, Nodo siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}

	public Object getDato() {
		return dato;
	}

	public void setDato(Object dato) {
		this.dato = dato;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public String toString() {
		String salida = "" + this.getDato();
		return salida;
	}
	public Nodo getAnterior (Nodo nodo){
		Nodo actual = this;
		Nodo anterior = null;
		while (actual != null && actual != nodo) {
			anterior = actual;
			actual = actual.getSiguiente();
		}
		return anterior;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	public int hashCode(){
		return super.hashCode();
	}
}