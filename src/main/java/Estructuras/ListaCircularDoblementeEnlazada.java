package Estructuras;

/**
 * Clase que representa una lista circular doblemente enlazada
 */
public class ListaCircularDoblementeEnlazada {
    
    private NodoDoble cabeza;
    private int tam;

    /**
     * Constructor de la lista enlazada
     * 
     * Complejidad: O(1) - Solo inicializa variables
     */
    public ListaCircularDoblementeEnlazada() {
        this.cabeza = null;
        this.tam = 0;
    }

    /**
     * Elimina todos los elementos de la lista
     * 
     * Complejidad: O(1) - Solo reinicia las referencias
     */
    public void eliminar() {
        this.cabeza = null;
        this.tam = 0;
    }

    /**
     * Determina si la lista está vacía
     * 
     * @return true en caso de que la lista esté vacía, false en caso contrario
     * 
     * Complejidad: O(1) - Solo verifica si la cabeza es null
     */
    public boolean estaVacia() {
        return this.cabeza == null;
    }

    /**
     * Determina la cantidad de nodos de la lista
     * 
     * @return Tamaño de la lista que sería la cantidad de nodos existentes
     * 
     * Complejidad: O(1) - Solo devuelve el valor del contador
     */
    public int getCantidadNodos() {
        return this.tam;
    }

    /**
     * Agrega un nuevo nodo al final de la lista
     * 
     * @param valor Valor del nuevo nodo a agregar al final de la lista
     * 
     * Complejidad: O(1) - En una lista circular doblemente enlazada se puede insertar al final en tiempo constante
     */
    public void insertarFinal(int valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        
        if (estaVacia()) {
            this.cabeza = nuevo;
            this.cabeza.setSiguiente(this.cabeza);
            this.cabeza.setAnterior(this.cabeza);
        } else {
            NodoDoble cola = this.cabeza.getAnterior(); // El anterior a la cabeza es la cola en una lista circular
            nuevo.setSiguiente(this.cabeza);
            nuevo.setAnterior(cola);
            this.cabeza.setAnterior(nuevo);
            cola.setSiguiente(nuevo);
        }
        
        this.tam++;
    }

    /**
     * Agrega un nuevo nodo al inicio de la lista
     * 
     * @param valor Valor del nuevo nodo a agregar al inicio de la lista
     * 
     * Complejidad: O(1) - En una lista circular doblemente enlazada se puede insertar al inicio en tiempo constante
     */
    public void insertarInicio(int valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        
        if (estaVacia()) {
            this.cabeza = nuevo;
            this.cabeza.setSiguiente(this.cabeza);
            this.cabeza.setAnterior(this.cabeza);
        } else {
            NodoDoble cola = this.cabeza.getAnterior(); // El anterior a la cabeza es la cola en una lista circular
            nuevo.setSiguiente(this.cabeza);
            nuevo.setAnterior(cola);
            this.cabeza.setAnterior(nuevo);
            cola.setSiguiente(nuevo);
            this.cabeza = nuevo;
        }
        
        this.tam++;
    }

    /**
     * Inserta un nuevo nodo en una posición determinada
     * 
     * @param posicion Posición donde se agregará el nuevo nodo
     * @param valor Valor del nuevo nodo a insertar
     * 
     * Complejidad: O(n) - En el peor caso recorre la lista para encontrar la posición
     */
    public void insertarEnPosicion(int posicion, int valor) throws Exception {
        if (posicion < 0 || posicion > this.tam) {
            throw new Exception("POSICIÓN INVÁLIDA.");
        }
        
        if (posicion == 0) {
            insertarInicio(valor);
            return;
        }
        
        if (posicion == this.tam) {
            insertarFinal(valor);
            return;
        }
        
        NodoDoble actual = this.cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        
        NodoDoble nuevo = new NodoDoble(valor, actual, actual.getAnterior());
        actual.getAnterior().setSiguiente(nuevo);
        actual.setAnterior(nuevo);
        this.tam++;
    }

    /**
     * Obtiene el valor de un nodo en una determinada posición
     * 
     * @param posicion Posición del nodo cuyo valor se quiere obtener
     * @return El valor del nodo en la posición especificada
     * @throws Exception Si la posición no existe
     * 
     * Complejidad: O(n) - En el peor caso recorre la lista para encontrar la posición
     */
    public Object getValor(int posicion) throws Exception {
        if (posicion < 0 || posicion >= this.tam) {
            throw new Exception("LA POSICIÓN NO EXISTE.");
        }
        
        NodoDoble nodo = obtenerNodoEnPosicion(posicion);
        return nodo.getDato();
    }

    /**
     * Busca si existe un valor en la lista
     * 
     * @param referencia Valor que se intentará buscar en la lista
     * @return true en caso de que el valor exista en la lista, false en caso contrario
     * 
     * Complejidad: O(n) - En el peor caso recorre toda la lista
     */
    public boolean buscar(Object referencia) {
        if (estaVacia()) {
            return false;
        }
        
        NodoDoble actual = this.cabeza;
        do {
            if (actual.getDato().equals(referencia)) {
                return true;
            }
            actual = actual.getSiguiente();
        } while (actual != this.cabeza);
        
        return false;
    }

    /**
     * Obtiene la posición de un elemento en la lista
     * 
     * @param referencia Valor cuya posición se quiere obtener
     * @return La posición del elemento en la lista
     * @throws Exception Si el elemento no existe en la lista
     * 
     * Complejidad: O(n) - En el peor caso recorre toda la lista
     */
    public int getPosicion(Object referencia) throws Exception {
        if (estaVacia()) {
            throw new Exception("EL ELEMENTO NO EXISTE.");
        }
        
        NodoDoble actual = this.cabeza;
        int posicion = 0;
        do {
            if (actual.getDato().equals(referencia)) {
                return posicion;
            }
            actual = actual.getSiguiente();
            posicion++;
        } while (actual != this.cabeza);
        
        throw new Exception("EL ELEMENTO NO EXISTE.");
    }

    /**
     * Elimina un nodo en la posición indicada
     * 
     * @param posicion Posición donde se encuentra el nodo a eliminar
     * @throws Exception Si la posición no existe
     * 
     * Complejidad: O(n) - En el peor caso recorre la lista para encontrar la posición
     */
    public void removerPorPosicion(int posicion) throws Exception {
        if (posicion < 0 || posicion >= this.tam) {
            throw new Exception("LA POSICIÓN NO EXISTE.");
        }
        
        if (this.tam == 1) {
            // Último elemento
            this.cabeza = null;
        } else {
            NodoDoble nodoEliminar = obtenerNodoEnPosicion(posicion);
            
            if (nodoEliminar == this.cabeza) {
                // Si es la cabeza, actualizar la cabeza
                this.cabeza = this.cabeza.getSiguiente();
            }
            
            nodoEliminar.getAnterior().setSiguiente(nodoEliminar.getSiguiente());
            nodoEliminar.getSiguiente().setAnterior(nodoEliminar.getAnterior());
        }
        
        this.tam--;
    }

    /**
     * Imprime todos los elementos de la lista
     * 
     * Complejidad: O(n) - Recorre toda la lista para mostrar sus elementos
     */
    public void imprimir() {
        System.out.println(this.toString());
    }

    /**
     * Agrega un nuevo nodo al final de la lista de forma recursiva
     * 
     * Caso Base: Si la lista está vacía, se crea el primer nodo. Si se llega al último nodo, se inserta el nuevo nodo.
     * Caso Recursivo: Se llama al mismo método con el siguiente nodo hasta llegar al final.
     * 
     * @param valor Valor del nuevo nodo a insertar
     * 
     * Complejidad: O(n) - Recorre toda la lista recursivamente
     */
    public void insertarFinalRecursivo(int valor) {
        if (estaVacia()) {
            insertarFinal(valor);
        } else {
            insertarFinalRecursivoAux(this.cabeza, valor, 0);
        }
    }
    
    /**
     * Método auxiliar recursivo para insertar al final
     * 
     * Caso Base: Si se ha recorrido toda la lista (contador == tamaño), se inserta el nuevo nodo
     * Caso Recursivo: Se avanza al siguiente nodo incrementando el contador
     * 
     * @param actual Nodo actual en la recursión
     * @param valor Valor del nuevo nodo a insertar
     * @param contador Contador de posición actual
     */
    private void insertarFinalRecursivoAux(NodoDoble actual, int valor, int contador) {
        if (contador == this.tam - 1) {
            // Estamos en el último nodo, insertamos después de él
            NodoDoble nuevo = new NodoDoble(valor, actual.getSiguiente(), actual);
            actual.getSiguiente().setAnterior(nuevo);
            actual.setSiguiente(nuevo);
            this.tam++;
        } else {
            insertarFinalRecursivoAux(actual.getSiguiente(), valor, contador + 1);
        }
    }

    /**
     * Agrega un nuevo nodo al inicio de la lista de forma recursiva
     * 
     * Caso Base: Se crea un nuevo nodo y se convierte en la nueva cabeza
     * Caso Recursivo: No aplica ya que siempre se inserta al inicio
     * 
     * @param valor Valor del nuevo nodo a insertar
     * 
     * Complejidad: O(1) - Solo modifica referencias al inicio de la lista
     */
    public void insertarInicioRecursivo(int valor) {
        // Para insertar al inicio, la recursividad no aporta nada útil
        // Por lo tanto, simplemente llamamos al método iterativo
        insertarInicio(valor);
    }

    /**
     * Inserta un nuevo nodo en una posición determinada de forma recursiva
     * 
     * Caso Base: Cuando se alcanza la posición deseada, se inserta el nuevo nodo
     * Caso Recursivo: Se avanza a la siguiente posición decrementando el contador
     * 
     * @param posicion Posición donde se agregará el nuevo nodo
     * @param valor Valor del nuevo nodo a insertar
     * 
     * Complejidad: O(n) - En el peor caso recorre recursivamente la lista hasta la posición
     */
    public void insertarEnPosicionRecursivo(int posicion, int valor) throws Exception {
        if (posicion < 0 || posicion > this.tam) {
            throw new Exception("POSICIÓN INVÁLIDA.");
        }
        
        if (posicion == 0) {
            insertarInicio(valor);
            return;
        }
        
        if (posicion == this.tam) {
            insertarFinal(valor);
            return;
        }
        
        insertarEnPosicionRecursivoAux(this.cabeza, posicion, valor, 0);
    }
    
    /**
     * Método auxiliar recursivo para insertar en posición
     * 
     * Caso Base: Cuando se alcanza la posición deseada, se inserta el nuevo nodo
     * Caso Recursivo: Se avanza al siguiente nodo decrementando el contador
     * 
     * @param actual Nodo actual en la recursión
     * @param posicion Posición objetivo
     * @param valor Valor del nuevo nodo a insertar
     * @param indiceActual Índice actual en la recursión
     */
    private void insertarEnPosicionRecursivoAux(NodoDoble actual, int posicion, int valor, int indiceActual) {
        if (indiceActual == posicion) {
            NodoDoble nuevo = new NodoDoble(valor, actual, actual.getAnterior());
            actual.getAnterior().setSiguiente(nuevo);
            actual.setAnterior(nuevo);
            this.tam++;
        } else {
            insertarEnPosicionRecursivoAux(actual.getSiguiente(), posicion, valor, indiceActual + 1);
        }
    }

    /**
     * Busca si existe un valor en la lista de forma recursiva
     * 
     * Caso Base: Si el nodo actual es la cabeza (segunda vez) o la lista está vacía, retorna false. 
     *            Si encuentra el valor, retorna true.
     * Caso Recursivo: Se llama al mismo método con el siguiente nodo
     * 
     * @param referencia Valor que se buscará en la lista
     * @return true en caso de que el valor exista en la lista, false en caso contrario
     * 
     * Complejidad: O(n) - En el peor caso recorre toda la lista recursivamente
     */
    public boolean buscarRecursivo(Object referencia) {
        if (estaVacia()) {
            return false;
        }
        return buscarRecursivoAux(this.cabeza, referencia, false);
    }
    
    /**
     * Método auxiliar recursivo para buscar un valor
     * 
     * Caso Base: Si el nodo actual es la cabeza por segunda vez, retorna false. 
     *            Si encuentra el valor, retorna true.
     * Caso Recursivo: Se llama al mismo método con el siguiente nodo
     * 
     * @param actual Nodo actual en la recursión
     * @param referencia Valor a buscar
     * @param cabezaVisitada Indica si ya se pasó por la cabeza una vez
     * @return true si encuentra el valor, false en caso contrario
     */
    private boolean buscarRecursivoAux(NodoDoble actual, Object referencia, boolean cabezaVisitada) {
        // Si estamos en la cabeza por segunda vez, terminamos la búsqueda
        if (actual == this.cabeza && cabezaVisitada) {
            return false;
        }
        
        if (actual.getDato().equals(referencia)) {
            return true;
        }
        
        return buscarRecursivoAux(actual.getSiguiente(), referencia, actual == this.cabeza || cabezaVisitada);
    }

    /**
     * Método toString para representar la lista como cadena
     * 
     * @return Representación en cadena de la lista
     */
    public String toString() {
        if (estaVacia()) {
            return "Lista vacía.";
        }
        
        StringBuilder sb = new StringBuilder();
        NodoDoble actual = this.cabeza;
        int contador = 0;
        
        do {
            sb.append(actual.toString()).append(" ");
            actual = actual.getSiguiente();
            contador++;
            // Prevenir bucle infinito en caso de inconsistencia en la lista
            if (contador > this.tam) {
                break;
            }
        } while (actual != this.cabeza);
        
        return sb.toString().trim();
    }
    
    /**
     * Método auxiliar para obtener un nodo en una posición específica
     * 
     * @param posicion Posición del nodo a obtener
     * @return Nodo en la posición especificada
     */
    private NodoDoble obtenerNodoEnPosicion(int posicion) {
        NodoDoble actual = this.cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }
}