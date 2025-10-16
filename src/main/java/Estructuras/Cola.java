package Estructuras;

/**
 * Clase que representa una cola (FIFO - First In, First Out)
 */
public class Cola {
    
    private Nodo frente;
    private Nodo fin;
    private int tam;

    /**
     * Constructor de la cola
     * 
     * Complejidad: O(1) - Solo inicializa variables
     */
    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tam = 0;
    }

    /**
     * Determina si la cola está vacía
     * 
     * @return true en caso de que la cola esté vacía, false en caso contrario
     * 
     * Complejidad: O(1) - Solo verifica si el frente es null
     */
    public boolean estaVacia() {
        return this.frente == null;
    }

    /**
     * Agrega un elemento a la cola
     * 
     * @param nuevo Elemento que se agregará al final de la cola
     * 
     * Complejidad: O(1) - Solo crea un nuevo nodo y actualiza referencias
     */
    public void enqueue(Object nuevo) {
        Nodo nodo = new Nodo(nuevo, null);
        
        if (estaVacia()) {
            this.frente = nodo;
        } else {
            this.fin.setSiguiente(nodo);
        }
        
        this.fin = nodo;
        this.tam++;
    }

    /**
     * Retorna el elemento frente de la cola sin eliminarlo
     * 
     * @return El elemento en el frente de la cola
     * @throws Exception Si la cola está vacía
     * 
     * Complejidad: O(1) - Solo devuelve el dato del nodo en el frente
     */
    public Object front() throws Exception {
        if (estaVacia()) {
            throw new Exception("La cola está vacía.");
        }
        return this.frente.getDato();
    }

    /**
     * Elimina un elemento de la cola y lo retorna
     * 
     * @return El elemento que estaba en el frente de la cola
     * @throws Exception Si la cola está vacía
     * 
     * Complejidad: O(1) - Solo actualiza referencias para eliminar el nodo del frente
     */
    public Object dequeue() throws Exception {
        if (estaVacia()) {
            throw new Exception("La cola está vacía.");
        }
        
        Object dato = this.frente.getDato();
        this.frente = this.frente.getSiguiente();
        
        // Si se eliminó el último elemento, también actualizar el fin
        if (this.frente == null) {
            this.fin = null;
        }
        
        this.tam--;
        return dato;
    }
    
    /**
     * Determina la cantidad de elementos de la cola
     * 
     * @return Número de elementos en la cola
     * 
     * Complejidad: O(1) - Solo devuelve el valor del contador
     */
    public int size() {
        return this.tam;
    }
    
    /**
     * Método toString para representar la cola como cadena
     * Muestra los elementos de frente hacia atrás
     * 
     * @return Representación en cadena de la cola
     * 
     * Complejidad: O(n) - Recorre todos los elementos de la cola
     */
    public String toString() {
        if (estaVacia()) {
            return "Cola vacía.";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Cola (frente -> fin): ");
        Nodo actual = this.frente;
        
        while (actual != null) {
            sb.append(actual.getDato()).append(" ");
            actual = actual.getSiguiente();
        }
        
        return sb.toString().trim();
    }
}