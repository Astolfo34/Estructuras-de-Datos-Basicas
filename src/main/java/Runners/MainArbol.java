package Runners;

import Estructuras.Arbol;
import Estructuras.NodoArbol;

public class MainArbol {

    public static void main(String[] args) {
        Arbol miArbol = new Arbol();
        
        System.out.println("=== DEMOSTRACIÓN DE ÁRBOL BINARIO DE BÚSQUEDA ===\n");
        
        // Insertar nodos en el árbol
        System.out.println("1. Insertando nodos en el árbol: 50, 30, 70, 20, 40, 60, 80");
        miArbol.insertarNodo(new NodoArbol(50));
        miArbol.insertarNodo(new NodoArbol(30));
        miArbol.insertarNodo(new NodoArbol(70));
        miArbol.insertarNodo(new NodoArbol(20));
        miArbol.insertarNodo(new NodoArbol(40));
        miArbol.insertarNodo(new NodoArbol(60));
        miArbol.insertarNodo(new NodoArbol(80));
        
        // Mostrar recorridos del árbol
        System.out.println("2. Recorrido en preorden:");
        miArbol.imprimirPreorder(miArbol.getRaiz());
        System.out.println();
        
        System.out.println("3. Recorrido en inorden:");
        miArbol.imprimirInorder(miArbol.getRaiz());
        System.out.println();
        
        System.out.println("4. Recorrido en postorden:");
        miArbol.imprimirPostorder(miArbol.getRaiz());
        System.out.println();
        
        // Obtener información del árbol
        System.out.println("5. Cantidad de nodos: " + miArbol.cantidadNodos());
        System.out.println("6. Altura del árbol: " + miArbol.altura());
        System.out.println("7. Peso del árbol: " + miArbol.peso());
        
        // Buscar elementos
        System.out.println("8. ¿Está el valor 40 en el árbol? " + 
                          miArbol.buscar(new NodoArbol(40)));
        System.out.println("9. ¿Está el valor 90 en el árbol? " + 
                          miArbol.buscar(new NodoArbol(90)));
        
        // Buscar menor y mayor
        NodoArbol menor = miArbol.buscarMenor();
        NodoArbol mayor = miArbol.buscarMayor();
        System.out.println("10. Menor elemento: " + (menor != null ? menor.getDato() : "No hay"));
        System.out.println("11. Mayor elemento: " + (mayor != null ? mayor.getDato() : "No hay"));
        
        // Eliminar menor y mayor
        NodoArbol menorEliminado = miArbol.eliminarMenor();
        System.out.println("12. Menor elemento eliminado: " + 
                          (menorEliminado != null ? menorEliminado.getDato() : "No hay"));
        
        NodoArbol mayorEliminado = miArbol.eliminarMayor();
        System.out.println("13. Mayor elemento eliminado: " + 
                          (mayorEliminado != null ? mayorEliminado.getDato() : "No hay"));
        
        // Mostrar el árbol después de eliminar menor y mayor
        System.out.println("14. Recorrido en inorden después de eliminar menor y mayor:");
        miArbol.imprimirInorder(miArbol.getRaiz());
        System.out.println();
        
        System.out.println("15. Cantidad de nodos actual: " + miArbol.cantidadNodos());
        
        // Eliminar un nodo específico
        System.out.println("16. Eliminando el nodo con valor 30");
        miArbol.eliminarNodo(new NodoArbol(30));
        
        System.out.println("17. Recorrido en inorden después de eliminar 30:");
        miArbol.imprimirInorder(miArbol.getRaiz());
        System.out.println();
        
        System.out.println("18. Cantidad de nodos actual: " + miArbol.cantidadNodos());
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}