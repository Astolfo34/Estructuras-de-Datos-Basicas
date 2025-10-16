package Estructuras;

/**
 * Clase que representa una pila (LIFO - Last In, First Out)
 */
public class Pila {
    
    private Nodo tope;
    private int tam;

    /**
     * Constructor de la pila
     * 
     * Complejidad: O(1) - Solo inicializa variables
     */
    public Pila() {
        this.tope = null;
        this.tam = 0;
    }

    /**
     * Determina si la pila está vacía
     * 
     * @return true en caso de que la pila esté vacía, false en caso contrario
     * 
     * Complejidad: O(1) - Solo verifica si el tope es null
     */
    public boolean estaVacia() {
        return this.tope == null;
    }

    /**
     * Agrega un elemento a la pila
     * 
     * @param valor Elemento que se agregará al tope de la pila
     * 
     * Complejidad: O(1) - Solo crea un nuevo nodo y actualiza referencias
     */
    public void push(Object valor) {
        Nodo nuevo = new Nodo(valor, this.tope);
        this.tope = nuevo;
        this.tam++;
    }

    /**
     * Retorna el elemento tope de la pila sin eliminarlo
     * 
     * @return El elemento en el tope de la pila
     * @throws Exception Si la pila está vacía
     * 
     * Complejidad: O(1) - Solo devuelve el dato del nodo en el tope
     */
    public Object top() throws Exception {
        if (estaVacia()) {
            throw new Exception("La pila está vacía.");
        }
        return this.tope.getDato();
    }

    /**
     * Elimina el elemento tope de la pila y lo retorna
     * 
     * @return El elemento que estaba en el tope de la pila
     * @throws Exception Si la pila está vacía
     * 
     * Complejidad: O(1) - Solo actualiza referencias para eliminar el nodo del tope
     */
    public Object pop() throws Exception {
        if (estaVacia()) {
            throw new Exception("La pila está vacía.");
        }
        Object valor = this.tope.getDato();
        this.tope = this.tope.getSiguiente();
        this.tam--;
        return valor;
    }
    
    /**
     * Obtiene el tamaño de la pila
     * 
     * @return Número de elementos en la pila
     * 
     * Complejidad: O(1) - Solo devuelve el valor del contador
     */
    public int getTam() {
        return this.tam;
    }
    
    /**
     * Método toString para representar la pila como cadena
     * Muestra los elementos de arriba hacia abajo (tope hacia el fondo)
     * 
     * @return Representación en cadena de la pila
     * 
     * Complejidad: O(n) - Recorre todos los elementos de la pila
     */
    public String toString() {
        if (estaVacia()) {
            return "Pila vacía.";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Pila (tope -> fondo): ");
        Nodo actual = this.tope;
        
        while (actual != null) {
            sb.append(actual.getDato()).append(" ");
            actual = actual.getSiguiente();
        }
        
        return sb.toString().trim();
    }
}