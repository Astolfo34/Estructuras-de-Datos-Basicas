package Estructuras;

public class ListaEnlazada {

	private Nodo cabecera;
	private Nodo ultimo;
	private int tam;

	/**
	 * insertar al final de la lista insertar antes del último eliminar cualquier
	 * posición
	 */

	public ListaEnlazada() {

		cabecera = new Nodo(null, null);
		ultimo = null;
		tam = 0;
	}

	/**
	 * Método para eliminar todos los elementos de la lista
	 */
	public void eliminarTodosLosElementos() {

		cabecera.setSiguiente(null);
		ultimo = null;
		tam = 0;
	}

	/**
	 * Determinar si la lista esta vacía
	 * 
	 * @return true en caso de que la lista esté vacía, false en caso contrario
	 */
	public boolean estaVacia() {

		if (cabecera.getSiguiente() == null)
			return true;
		return false;
	}

	/**
	 * Determinar la cantidad de nodos de la lista
	 * 
	 * @return Tamanio de la lista que sería la cantidad de nodos existentes a
	 *         excepción de la cabecera
	 */
	public int cantidadNodos() {
		return getTam();
	}

	/**
	 * Agregar un nuevo nodo al final de la lista
	 * 
	 * @param valor
	 *            Nodo nuevo para agregar al final de la lista
	 */
	public void insertarAlFinal(Object valor) {

		Nodo nuevo = new Nodo(valor, null);
		Nodo actual = cabecera.getSiguiente();

		if (actual == null) {

			cabecera.setSiguiente(nuevo);
			ultimo = nuevo;
			tam++;

		} else {
			ultimo.setSiguiente(nuevo);
			ultimo = nuevo;
			tam++;
		}
	}

	/**
	 * Agregar un nuevo nodo al incio de la lista
	 * 
	 * @param valor
	 *            Nodo que se va a agregar al inicio de la lista
	 */
	public void insertarAlInicio(Object valor) {

		Nodo nuevo = new Nodo(valor, null);
		Nodo actual = cabecera.getSiguiente();

		if (actual == null) {

			cabecera.setSiguiente(nuevo);
			ultimo = nuevo;
			tam++;

		} else {

			nuevo.setSiguiente(actual);
			cabecera.setSiguiente(nuevo);
			tam++;
		}
	}

	/**
	 * Insertar un nodo después de una posición predeterminada
	 * 
	 * @param posicion
	 *            Posición anterior en la que se agregará un nuevo Nodo
	 * @param valor
	 *            Nodo que se agregará en una posición predeterminada
	 * @throws Exception
	 *             Se muestra en caso de que no exista la posición
	 */
	public void insertarDespuesPosicion(int posicion, Object valor) throws Exception {

		Nodo nuevo = new Nodo(valor, null);
		Nodo actual = cabecera.getSiguiente();
		int cont = 0;

		if (posicion == (tam - 1)) {

			ultimo.setSiguiente(nuevo);
			ultimo = nuevo;
			tam++;

		} else {
			if (posicion < tam && posicion > -1) {

				while (cont < posicion) {

					actual = actual.getSiguiente();
					cont++;
				}
				nuevo.setSiguiente(actual.getSiguiente());
				actual.setSiguiente(nuevo);
				tam++;

			} else {
				throw new Exception("NO EXISTE ESA POSICIÓN.");
			}
		}
	}

	/**
	 * Obtener el valor de un nodo en una posicion predeterminada
	 * 
	 * @param posicion
	 *            Posición del nodo hallado
	 * @return Retorna el valor del nodo en caso de que exista dicha posición
	 * @throws Exception
	 *             Se muestra cuando la posición no existe
	 */
	public Object getValor(int posicion) throws Exception {

		Nodo actual = cabecera.getSiguiente();
		int cont = 1;

		if (posicion > 0 && posicion < tam) {

			while (actual != null) {

				if (cont == posicion) {

					return actual.getDato();
				}
				cont++;
				actual = actual.getSiguiente();
			}

		} else {
			throw new Exception("LA POSICIÓN NO EXISTE.");
		}
		return null;
	}

	/**
	 * Buscar si existe un valor en la lista
	 * 
	 * @param valor
	 *            Valor que se intentará buscar en la lista
	 * @return Retorna true en caso de que el valor exista en la lista, false en
	 *         caso contrario
	 */
	public boolean buscarExiste(Object valor) {

		Nodo actual = cabecera.getSiguiente();
		boolean centinela = false;
		Object dato;

		while (actual != null && centinela == false) {
			dato = actual.getDato();

			if (dato.equals(valor)) {
				centinela = true;
			}
			actual = actual.getSiguiente();
		}
		return centinela;
	}

	/**
	 * Obtiene la posición del elemento dado de la lista
	 * 
	 * @param valor
	 *            Valor que se buscará para dar con su posición
	 * @return Retorna la posición en la lista donde se encuentra dicho valor
	 * @throws Exception
	 *             Se muestra en caso de que el valor no exista en la lista
	 */
	public int getPosicion(Object valor) throws Exception {

		Nodo actual = cabecera.getSiguiente();
		int cont = 0;

		if (buscarExiste(valor)) {

			while (actual != null) {

				if (actual.getDato().equals(valor)) {
					return cont;
				}
				cont++;
				actual = actual.getSiguiente();
			}
		} else {

			throw new Exception("EL ELEMENTO NO EXISTE.");
		}

		return cont;
	}

	/**
	 * Elimina un nodo en la posicion indicada
	 * 
	 * @param posicion
	 *            Posición donde se buscará el Nodo a eliminar
	 * @throws Exception
	 *             Se muestra en caso de que la posición no exista
	 */
	public void eliminarEnPosicion(int posicion) throws Exception {

		Nodo actual = cabecera;
		int cont = 0;

		if (posicion > 0 && posicion < tam) {

			while (actual != null) {

				if (posicion == 1 && tam == 2) {
					cabecera.setSiguiente(null);
					actual = cabecera;
					ultimo = null;
					tam--;

				} else if ((cont + 1) == posicion && actual.getSiguiente().equals(ultimo)) {

					actual.setSiguiente(null);
					ultimo = actual;
					tam--;

				} else {
					if ((cont + 1) == posicion) {
						actual.setSiguiente(actual.getSiguiente().getSiguiente());
						tam--;
					}
				}
				cont++;
				actual = actual.getSiguiente();
			}

		} else {
			throw new Exception("LA POSICIÓN NO EXISTE.");
		}
	}

	/**
	 * Imprimir todos los elementos de la lista
	 */
	public void imprimirTodos() {

		System.out.println(this.toString());
	}

	/**
	 * Buscar si existe un valor en la lista de manera recursiva
	 * 
	 * @param valor
	 *            Valor que se buscará en la lista
	 * @param actual
	 *            Inicialmente es el nodo raiz
	 * @return Retorna true en caso de que el valor se encuentre en la lista, false
	 *         en caso contrario
	 */
	public boolean buscarExisteRecursivo(Object valor, Nodo actual) {

		if (actual != null) {

			if (actual.getDato().equals(valor)) {
				return true;
			} else {
				return buscarExisteRecursivo(valor, actual.getSiguiente());
			}
		} else {
			return false;
		}
	}

	/**
	 * Inserta un Nodo al final de la lista de manera recursiva
	 * 
	 * @param valor
	 *            Valor del nuevo nodo a insertar
	 * @param nodo
	 *            Inicialmente es el nodo cabecera
	 */
	public void insertarAlFinalRecursivo(Object valor, Nodo nodo) {

		Nodo nuevo = new Nodo(valor, null);

		if (nodo.getSiguiente() == null) {
			nodo.setSiguiente(nuevo);
			ultimo = nuevo;
			tam++;
		} else {
			insertarAlFinalRecursivo(valor, nodo.getSiguiente());
		}
	}

	/**
	 * Elimina un nodo en la posición indicada de forma recursiva
	 * 
	 * @param posicion
	 *            Posicón en que se buscará el nodo a eliminar
	 * @throws Exception
	 */
	public void eliminarEnPosicionRecursivo(int posicion, Nodo nodo, int cont) throws Exception {

		if (posicion > 0 && posicion < tam) {

			if (nodo != null) {

				if ((cont + 1) == posicion && nodo.getSiguiente().equals(ultimo)) {

					nodo.setSiguiente(null);
					ultimo = nodo;
					tam--;
				}
				if (posicion == 1 && tam == 2 && nodo.getSiguiente().equals(ultimo)) {

					cabecera.setSiguiente(null);
					ultimo = null;
					tam--;
				}
				if ((cont + 1) == posicion) {

					nodo.setSiguiente(nodo.getSiguiente().getSiguiente());
					tam--;

				} else {
					eliminarEnPosicionRecursivo(posicion, nodo.getSiguiente(), cont + 1);
				}
			}
		} else {
			throw new Exception("LA POSICIÓN NO EXISTE.");
		}
	}

	/**
	 * Inserta un nuevo nodo antes del último
	 * 
	 * @param valor
	 *            Valor del nuevo nodo
	 */
	public void insertarAntesDelUltimo(Object valor) {

		Nodo actual = cabecera.getSiguiente();
		Nodo nuevo = new Nodo(valor, null);

		if (actual == null) {

			cabecera.setSiguiente(nuevo);
			ultimo = nuevo;
			tam++;

		} else {

			while (actual.getSiguiente() != ultimo) {
				actual = actual.getSiguiente();
			}

			if (actual.getSiguiente() == ultimo) {

				actual.setSiguiente(nuevo);
				nuevo.setSiguiente(ultimo);
				tam++;
			}
		}
	}

	/**
	 * Método toString
	 * 
	 * @return Retorna el estado de la lista
	 */
	public String toString() {

		String salida = "";
		Nodo actual = cabecera;

		if (actual != null) {
			while (actual != null) {

				if (actual.equals(cabecera)) {
					salida += "[CABECERA] \n";
					actual = actual.getSiguiente();
				}
				salida += "[" + actual.getDato() + "] \n";
				actual = actual.getSiguiente();
			}
		} else {
			salida = "Lista vacía.";
		}
		return salida;
	}

	/**
	 * Métodos get y set
	 */
	public Nodo getCabecera() {
		return cabecera;
	}

	public void setCabecera(Nodo cabecera) {
		this.cabecera = cabecera;
	}

	public Nodo getUltimo() {
		return ultimo;
	}

	public void setUltimo(Nodo ultimo) {
		this.ultimo = ultimo;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public void insertarEnPosicionRecursivo(Object valor, int posicion, Nodo cabecera, int i) {

		if (i == posicion) {
			Nodo nuevo = new Nodo(valor, cabecera.getSiguiente());
			cabecera.setSiguiente(nuevo);
			if (nuevo.getSiguiente() == null) { // en caso de que sea la última posición
				ultimo = nuevo;
			}
			tam++;
			return;
		}

		if (cabecera.getSiguiente() != null) {
			insertarEnPosicionRecursivo(valor, posicion, cabecera.getSiguiente(), i + 1);
		} else {
			if (i + 1 == posicion) {  // en caso de que la posición sea la final --> saltamos al caso base
				Nodo nuevo = new Nodo(valor, null);
				cabecera.setSiguiente(nuevo);
				ultimo = nuevo;
				tam++;
			}

		}
	}

	/**
	 * Caso base: Si la lista está vacía o la referencia es null, no existe el elemento
	 * Caso Inductivo: Llamada al método recursivo existente iniciando desde el primer nodo real
	 * @param referencia
	 * @return
	 */
	public boolean buscarRecursivo(Object referencia) {

        if (cabecera.getSiguiente() == null || referencia == null) {
            return false;
        }

        return buscarExisteRecursivo(referencia, cabecera.getSiguiente());
    }

}