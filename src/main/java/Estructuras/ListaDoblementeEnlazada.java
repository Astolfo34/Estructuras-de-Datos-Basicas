package Estructuras;

/**
 * Clase que representa una lista doblemente enlazada
 */
public class ListaDoblementeEnlazada {
    
    private NodoDoble cabeza;
    private NodoDoble cola;
    private int tam;

    /**
     * Constructor de la lista enlazada
     * 
     * Complejidad: O(1) - Solo inicializa variables
     */
    public ListaDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tam = 0;
    }

    /**
     * Elimina todos los elementos de la lista
     * 
     * Complejidad: O(1) - Solo reinicia las referencias
     */
    public void eliminar() {
        this.cabeza = null;
        this.cola = null;
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
     * Complejidad: O(1) - Solo modifica referencias al final de la lista
     */
    public void insertarFinal(int valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        
        if (estaVacia()) {
            this.cabeza = nuevo;
        } else {
            nuevo.setAnterior(this.cola);
            this.cola.setSiguiente(nuevo);
        }
        
        this.cola = nuevo;
        this.tam++;
    }

    /**
     * Agrega un nuevo nodo al inicio de la lista
     * 
     * @param valor Valor del nuevo nodo a agregar al inicio de la lista
     * 
     * Complejidad: O(1) - Solo modifica referencias al inicio de la lista
     */
    public void insertarInicio(int valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        
        if (estaVacia()) {
            this.cola = nuevo;
        } else {
            nuevo.setSiguiente(this.cabeza);
            this.cabeza.setAnterior(nuevo);
        }
        
        this.cabeza = nuevo;
        this.tam++;
    }

    /**
     * Inserta un nuevo nodo en una posición determinada
     * 
     * @param posicion Posición donde se agregará el nuevo nodo
     * @param valor Valor del nuevo nodo a insertar
     * 
     * Complejidad: O(n) - En el peor caso recorre la mitad de la lista para encontrar la posición
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
        
        NodoDoble actual = obtenerNodoEnPosicion(posicion);
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
     * Complejidad: O(n) - En el peor caso recorre la mitad de la lista para encontrar la posición
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
        NodoDoble actual = this.cabeza;
        
        while (actual != null) {
            if (actual.getDato().equals(referencia)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        
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
        NodoDoble actual = this.cabeza;
        int posicion = 0;
        
        while (actual != null) {
            if (actual.getDato().equals(referencia)) {
                return posicion;
            }
            actual = actual.getSiguiente();
            posicion++;
        }
        
        throw new Exception("EL ELEMENTO NO EXISTE.");
    }

    /**
     * Elimina un nodo en la posición indicada
     * 
     * @param posicion Posición donde se encuentra el nodo a eliminar
     * @throws Exception Si la posición no existe
     * 
     * Complejidad: O(n) - En el peor caso recorre la mitad de la lista para encontrar la posición
     */
    public void removerPorPosicion(int posicion) throws Exception {
        if (posicion < 0 || posicion >= this.tam) {
            throw new Exception("LA POSICIÓN NO EXISTE.");
        }
        
        NodoDoble nodoEliminar = obtenerNodoEnPosicion(posicion);
        
        if (nodoEliminar.getAnterior() != null) {
            nodoEliminar.getAnterior().setSiguiente(nodoEliminar.getSiguiente());
        } else {
            this.cabeza = nodoEliminar.getSiguiente();
        }
        
        if (nodoEliminar.getSiguiente() != null) {
            nodoEliminar.getSiguiente().setAnterior(nodoEliminar.getAnterior());
        } else {
            this.cola = nodoEliminar.getAnterior();
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
     * Caso Base: Si la lista está vacía, se crea el primer nodo
     * Caso Recursivo: Se llama al mismo método con el siguiente nodo hasta llegar al final
     * 
     * @param valor Valor del nuevo nodo a insertar
     * 
     * Complejidad: O(n) - Recorre toda la lista recursivamente
     */
    public void insertarFinalRecursivo(int valor) {
        if (estaVacia()) {
            NodoDoble nuevo = new NodoDoble(valor);
            this.cabeza = nuevo;
            this.cola = nuevo;
            this.tam++;
        } else {
            insertarFinalRecursivoAux(this.cabeza, valor);
        }
    }
    
    /**
     * Método auxiliar recursivo para insertar al final
     * 
     * Caso Base: Si el nodo actual es la cola, se inserta el nuevo nodo al final
     * Caso Recursivo: Se llama al mismo método con el siguiente nodo
     * 
     * @param actual Nodo actual en la recursión
     * @param valor Valor del nuevo nodo a insertar
     */
    private void insertarFinalRecursivoAux(NodoDoble actual, int valor) {
        if (actual == this.cola) {
            NodoDoble nuevo = new NodoDoble(valor);
            nuevo.setAnterior(actual);
            actual.setSiguiente(nuevo);
            this.cola = nuevo;
            this.tam++;
        } else {
            insertarFinalRecursivoAux(actual.getSiguiente(), valor);
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
        if (indiceActual == posicion - 1) {
            NodoDoble nuevo = new NodoDoble(valor, actual.getSiguiente(), actual);
            actual.getSiguiente().setAnterior(nuevo);
            actual.setSiguiente(nuevo);
            this.tam++;
        } else {
            insertarEnPosicionRecursivoAux(actual.getSiguiente(), posicion, valor, indiceActual + 1);
        }
    }

    /**
     * Busca si existe un valor en la lista de forma recursiva
     * 
     * Caso Base: Si el nodo actual es null, retorna false. Si encuentra el valor, retorna true
     * Caso Recursivo: Se llama al mismo método con el siguiente nodo
     * 
     * @param referencia Valor que se buscará en la lista
     * @return true en caso de que el valor exista en la lista, false en caso contrario
     * 
     * Complejidad: O(n) - En el peor caso recorre toda la lista recursivamente
     */
    public boolean buscarRecursivo(Object referencia) {
        return buscarRecursivoAux(this.cabeza, referencia);
    }
    
    /**
     * Método auxiliar recursivo para buscar un valor
     * 
     * Caso Base: Si el nodo actual es null, retorna false. Si encuentra el valor, retorna true
     * Caso Recursivo: Se llama al mismo método con el siguiente nodo
     * 
     * @param actual Nodo actual en la recursión
     * @param referencia Valor a buscar
     * @return true si encuentra el valor, false en caso contrario
     */
    private boolean buscarRecursivoAux(NodoDoble actual, Object referencia) {
        if (actual == null) {
            return false;
        }
        
        if (actual.getDato().equals(referencia)) {
            return true;
        }
        
        return buscarRecursivoAux(actual.getSiguiente(), referencia);
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
        
        while (actual != null) {
            sb.append(actual.toString()).append(" ");
            actual = actual.getSiguiente();
        }
        
        return sb.toString().trim();
    }
    
    /**
     * Método auxiliar para obtener un nodo en una posición específica
     * Optimizado para recorrer desde la cabeza o la cola según cual esté más cerca
     * 
     * @param posicion Posición del nodo a obtener
     * @return Nodo en la posición especificada
     */
    private NodoDoble obtenerNodoEnPosicion(int posicion) {
        NodoDoble actual;
        
        // Optimización: decidir desde qué extremo recorrer la lista
        if (posicion < this.tam / 2) {
            // Recorrer desde la cabeza
            actual = this.cabeza;
            for (int i = 0; i < posicion; i++) {
                actual = actual.getSiguiente();
            }
        } else {
            // Recorrer desde la cola
            actual = this.cola;
            for (int i = this.tam - 1; i > posicion; i--) {
                actual = actual.getAnterior();
            }
        }
        
        return actual;
    }
}