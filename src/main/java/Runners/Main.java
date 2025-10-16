package Runners;

import Estructuras.ListaEnlazada;

public class Main {

	public static void main(String[] args) {

		ListaEnlazada miLista = new ListaEnlazada();

		miLista.insertarAlFinal(1);
		miLista.insertarAlFinal(2);
		miLista.insertarAlFinal(3);

		try {
			miLista.insertarDespuesPosicion(0, 7);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		miLista.insertarAntesDelUltimo(5);

		System.out.println("Buscar si existe 7: " + miLista.buscarExiste(7));

		System.out.println("Buscar si existe 7 (recursivo): "
				+ miLista.buscarExisteRecursivo(7, miLista.getCabecera().getSiguiente()));

		try {
			System.out.println("Obtener la posición del 5: " + miLista.getPosicion(5));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		try {
			System.out.println("Obtener el valor de la posición 2: " + miLista.getValor(2));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		miLista.insertarAlFinalRecursivo(9, miLista.getCabecera());

		try {
			miLista.eliminarEnPosicionRecursivo(3, miLista.getCabecera(), 0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		System.out.println("Cantidad de nodos: " + miLista.cantidadNodos() + "\n");

		System.out.println("MI LISTA FINAL: \n" + miLista);
	}

}
