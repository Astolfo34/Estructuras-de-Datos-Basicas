package Estructuras;

/**
 * Clase que representa un árbol binario de búsqueda
 */
public class Arbol {
    
    private NodoArbol raiz;
    private int tam;

    /**
     * Constructor del árbol
     * 
     * Complejidad: O(1) - Solo inicializa variables
     */
    public Arbol() {
        this.raiz = null;
        this.tam = 0;
    }

    /**
     * Busca un nodo en el árbol
     * 
     * @param nodo Nodo a buscar en el árbol
     * @return true si el nodo se encuentra en el árbol, false en caso contrario
     * 
     * Complejidad: O(log n) en promedio, O(n) en el peor caso (árbol degenerado)
     */
    public boolean buscar(NodoArbol nodo) {
        if (nodo == null) return false;
        return buscarAux(this.raiz, nodo.getDato());
    }
    
    /**
     * Método auxiliar para buscar un valor en el árbol
     * 
     * @param actual Nodo actual en la búsqueda
     * @param dato Dato a buscar
     * @return true si el dato se encuentra en el árbol, false en caso contrario
     */
    private boolean buscarAux(NodoArbol actual, Object dato) {
        if (actual == null) {
            return false;
        }
        
        Comparable datoActual = (Comparable) actual.getDato();
        Comparable datoBuscado = (Comparable) dato;
        
        if (datoActual.compareTo(datoBuscado) == 0) {
            return true;
        } else if (datoActual.compareTo(datoBuscado) > 0) {
            return buscarAux(actual.getIzquierdo(), dato);
        } else {
            return buscarAux(actual.getDerecho(), dato);
        }
    }

    /**
     * Inserta un nodo en el árbol
     * 
     * @param nodo Nodo a insertar en el árbol
     * 
     * Complejidad: O(log n) en promedio, O(n) en el peor caso (árbol degenerado)
     */
    public void insertarNodo(NodoArbol nodo) {
        if (nodo == null) return;
        
        this.raiz = insertarAux(this.raiz, nodo);
    }
    
    /**
     * Método auxiliar para insertar un nodo en el árbol
     * 
     * @param actual Nodo actual en la inserción
     * @param nodo Nodo a insertar
     * @return Nodo actualizado
     */
    private NodoArbol insertarAux(NodoArbol actual, NodoArbol nodo) {
        if (actual == null) {
            this.tam++;
            return nodo;
        }
        
        Comparable datoActual = (Comparable) actual.getDato();
        Comparable datoNuevo = (Comparable) nodo.getDato();
        
        if (datoActual.compareTo(datoNuevo) > 0) {
            actual.setIzquierdo(insertarAux(actual.getIzquierdo(), nodo));
        } else if (datoActual.compareTo(datoNuevo) < 0) {
            actual.setDerecho(insertarAux(actual.getDerecho(), nodo));
        }
        // Si son iguales, no hacemos nada (no insertamos duplicados)
        
        return actual;
    }

    /**
     * Elimina un nodo del árbol
     * 
     * @param nodo Nodo a eliminar del árbol
     * 
     * Complejidad: O(log n) en promedio, O(n) en el peor caso (árbol degenerado)
     */
    public void eliminarNodo(NodoArbol nodo) {
        if (nodo == null) return;
        
        this.raiz = eliminarAux(this.raiz, nodo.getDato());
    }
    
    /**
     * Método auxiliar para eliminar un nodo del árbol
     * 
     * @param actual Nodo actual en la eliminación
     * @param dato Dato a eliminar
     * @return Nodo actualizado
     */
    private NodoArbol eliminarAux(NodoArbol actual, Object dato) {
        if (actual == null) {
            return null;
        }
        
        Comparable datoActual = (Comparable) actual.getDato();
        Comparable datoEliminar = (Comparable) dato;
        
        if (datoActual.compareTo(datoEliminar) > 0) {
            actual.setIzquierdo(eliminarAux(actual.getIzquierdo(), dato));
        } else if (datoActual.compareTo(datoEliminar) < 0) {
            actual.setDerecho(eliminarAux(actual.getDerecho(), dato));
        } else {
            // Encontramos el nodo a eliminar
            this.tam--;
            
            // Caso 1: Nodo sin hijos
            if (actual.getIzquierdo() == null && actual.getDerecho() == null) {
                return null;
            }
            
            // Caso 2: Nodo con un hijo
            if (actual.getIzquierdo() == null) {
                return actual.getDerecho();
            }
            
            if (actual.getDerecho() == null) {
                return actual.getIzquierdo();
            }
            
            // Caso 3: Nodo con dos hijos
            // Encontrar el sucesor inorden (menor del subárbol derecho)
            NodoArbol sucesor = buscarMenorAux(actual.getDerecho());
            actual.setDato(sucesor.getDato());
            actual.setDerecho(eliminarAux(actual.getDerecho(), sucesor.getDato()));
            this.tam++; // Compensar el decremento doble
        }
        
        return actual;
    }

    /**
     * Elimina un subárbol del árbol
     * 
     * @param nodo Raíz del subárbol a eliminar
     * 
     * Complejidad: O(log n) para encontrar el nodo + O(m) para eliminar el subárbol,
     * donde m es el número de nodos en el subárbol
     */
    public void eliminarSubArbol(NodoArbol nodo) {
        if (nodo == null || this.raiz == null) return;
        
        // Si el nodo a eliminar es la raíz
        if (this.raiz == nodo) {
            int nodosEliminados = contarNodos(this.raiz);
            this.raiz = null;
            this.tam -= nodosEliminados;
            return;
        }
        
        // Buscar el padre del nodo
        NodoArbol padre = buscarPadre(this.raiz, nodo);
        if (padre != null) {
            int nodosEliminados = contarNodos(nodo);
            
            // Determinar si el nodo es hijo izquierdo o derecho
            if (padre.getIzquierdo() == nodo) {
                padre.setIzquierdo(null);
            } else {
                padre.setDerecho(null);
            }
            
            this.tam -= nodosEliminados;
        }
    }
    
    /**
     * Método auxiliar para buscar el padre de un nodo
     * 
     * @param actual Nodo actual en la búsqueda
     * @param nodo Nodo cuyo padre se busca
     * @return Padre del nodo, o null si no se encuentra
     */
    private NodoArbol buscarPadre(NodoArbol actual, NodoArbol nodo) {
        if (actual == null || actual == nodo) {
            return null;
        }
        
        // Verificar si alguno de los hijos es el nodo buscado
        if (actual.getIzquierdo() == nodo || actual.getDerecho() == nodo) {
            return actual;
        }
        
        // Buscar en el subárbol izquierdo
        NodoArbol padre = buscarPadre(actual.getIzquierdo(), nodo);
        if (padre != null) {
            return padre;
        }
        
        // Buscar en el subárbol derecho
        return buscarPadre(actual.getDerecho(), nodo);
    }
    
    /**
     * Método auxiliar para contar nodos en un subárbol
     * 
     * @param nodo Raíz del subárbol
     * @return Número de nodos en el subárbol
     */
    private int contarNodos(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
    }

    /**
     * Buscar el menor elemento del árbol
     * 
     * @return Nodo con el menor valor, o null si el árbol está vacío
     * 
     * Complejidad: O(log n) en promedio, O(n) en el peor caso (árbol degenerado)
     */
    public NodoArbol buscarMenor() {
        if (this.raiz == null) {
            return null;
        }
        return buscarMenorAux(this.raiz);
    }
    
    /**
     * Método auxiliar para buscar el menor elemento
     * 
     * @param nodo Nodo desde el cual comenzar la búsqueda
     * @return Nodo con el menor valor
     */
    private NodoArbol buscarMenorAux(NodoArbol nodo) {
        if (nodo.getIzquierdo() == null) {
            return nodo;
        }
        return buscarMenorAux(nodo.getIzquierdo());
    }

    /**
     * Buscar el mayor elemento del árbol
     * 
     * @return Nodo con el mayor valor, o null si el árbol está vacío
     * 
     * Complejidad: O(log n) en promedio, O(n) en el peor caso (árbol degenerado)
     */
    public NodoArbol buscarMayor() {
        if (this.raiz == null) {
            return null;
        }
        return buscarMayorAux(this.raiz);
    }
    
    /**
     * Método auxiliar para buscar el mayor elemento
     * 
     * @param nodo Nodo desde el cual comenzar la búsqueda
     * @return Nodo con el mayor valor
     */
    private NodoArbol buscarMayorAux(NodoArbol nodo) {
        if (nodo.getDerecho() == null) {
            return nodo;
        }
        return buscarMayorAux(nodo.getDerecho());
    }

    /**
     * Elimina el menor elemento del árbol
     * 
     * @return Nodo eliminado con el menor valor, o null si el árbol está vacío
     * 
     * Complejidad: O(log n) en promedio, O(n) en el peor caso (árbol degenerado)
     */
    public NodoArbol eliminarMenor() {
        if (this.raiz == null) {
            return null;
        }
        
        NodoArbol menor = buscarMenorAux(this.raiz);
        this.raiz = eliminarAux(this.raiz, menor.getDato());
        return menor;
    }

    /**
     * Elimina el mayor elemento del árbol
     * 
     * @return Nodo eliminado con el mayor valor, o null si el árbol está vacío
     * 
     * Complejidad: O(log n) en promedio, O(n) en el peor caso (árbol degenerado)
     */
    public NodoArbol eliminarMayor() {
        if (this.raiz == null) {
            return null;
        }
        
        NodoArbol mayor = buscarMayorAux(this.raiz);
        this.raiz = eliminarAux(this.raiz, mayor.getDato());
        return mayor;
    }

    /**
     * Retorna la altura del árbol
     * 
     * @return Altura del árbol (número de aristas en el camino más largo desde la raíz hasta una hoja)
     * 
     * Complejidad: O(n) - Debe recorrer todos los nodos en el peor caso
     */
    public int altura() {
        return alturaAux(this.raiz);
    }
    
    /**
     * Método auxiliar para calcular la altura del árbol
     * 
     * @param nodo Nodo desde el cual calcular la altura
     * @return Altura del subárbol con raíz en nodo
     */
    private int alturaAux(NodoArbol nodo) {
        if (nodo == null) {
            return -1; // La altura de un árbol vacío es -1
        }
        
        int alturaIzq = alturaAux(nodo.getIzquierdo());
        int alturaDer = alturaAux(nodo.getDerecho());
        
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    /**
     * Retorna la cantidad de nodos del árbol
     * 
     * @return Número de nodos en el árbol
     * 
     * Complejidad: O(1) - Solo devuelve el valor del contador
     */
    public int cantidadNodos() {
        return this.tam;
    }

    /**
     * Retorna el peso del árbol (cantidad de nodos con al menos un hijo)
     * 
     * @return Peso del árbol
     * 
     * Complejidad: O(n) - Debe recorrer todos los nodos
     */
    public int peso() {
        return pesoAux(this.raiz);
    }
    
    /**
     * Método auxiliar para calcular el peso del árbol
     * 
     * @param nodo Nodo desde el cual calcular el peso
     * @return Peso del subárbol con raíz en nodo
     */
    private int pesoAux(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        
        // Un nodo contribuye al peso si tiene al menos un hijo
        int contribucion = (nodo.getIzquierdo() != null || nodo.getDerecho() != null) ? 1 : 0;
        
        return contribucion + pesoAux(nodo.getIzquierdo()) + pesoAux(nodo.getDerecho());
    }

    /**
     * Imprime el contenido del árbol en inorden (izquierdo, raíz, derecho)
     * 
     * @param n Nodo desde el cual comenzar la impresión
     * 
     * Complejidad: O(n) - Debe visitar todos los nodos
     */
    public void imprimirInorder(NodoArbol n) {
        if (n != null) {
            imprimirInorder(n.getIzquierdo());
            System.out.print(n.getDato() + " ");
            imprimirInorder(n.getDerecho());
        }
    }

    /**
     * Imprime el contenido del árbol en posorden (izquierdo, derecho, raíz)
     * 
     * @param n Nodo desde el cual comenzar la impresión
     * 
     * Complejidad: O(n) - Debe visitar todos los nodos
     */
    public void imprimirPostorder(NodoArbol n) {
        if (n != null) {
            imprimirPostorder(n.getIzquierdo());
            imprimirPostorder(n.getDerecho());
            System.out.print(n.getDato() + " ");
        }
    }

    /**
     * Imprime el contenido del árbol en preorden (raíz, izquierdo, derecho)
     * 
     * @param n Nodo desde el cual comenzar la impresión
     * 
     * Complejidad: O(n) - Debe visitar todos los nodos
     */
    public void imprimirPreorder(NodoArbol n) {
        if (n != null) {
            System.out.print(n.getDato() + " ");
            imprimirPreorder(n.getIzquierdo());
            imprimirPreorder(n.getDerecho());
        }
    }
    
    /**
     * Método para obtener la raíz del árbol
     * 
     * @return Nodo raíz del árbol
     */
    public NodoArbol getRaiz() {
        return this.raiz;
    }
}