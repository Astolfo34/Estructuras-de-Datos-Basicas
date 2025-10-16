package Runners;

import Estructuras.ListaCircularDoblementeEnlazada;

public class MainCircularDoble {

    public static void main(String[] args) {
        ListaCircularDoblementeEnlazada miLista = new ListaCircularDoblementeEnlazada();
        
        System.out.println("=== DEMOSTRACIÓN DE LISTA CIRCULAR DOBLEMENTE ENLAZADA ===\n");
        
        // Verificar si está vacía
        System.out.println("1. ¿La lista está vacía? " + miLista.estaVacia());
        
        // Insertar elementos al final
        System.out.println("2. Insertando elementos al final: 10, 20, 30");
        miLista.insertarFinal(10);
        miLista.insertarFinal(20);
        miLista.insertarFinal(30);
        
        // Imprimir la lista
        System.out.println("3. Contenido de la lista:");
        miLista.imprimir();
        
        // Insertar al inicio
        System.out.println("4. Insertando elemento al inicio: 5");
        miLista.insertarInicio(5);
        miLista.imprimir();
        
        // Obtener cantidad de nodos
        System.out.println("5. Cantidad de nodos en la lista: " + miLista.getCantidadNodos());
        
        // Insertar en posición específica
        try {
            System.out.println("6. Insertando el valor 15 en la posición 2");
            miLista.insertarEnPosicion(2, 15);
            miLista.imprimir();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Obtener valor en posición específica
        try {
            System.out.println("7. Valor en la posición 3: " + miLista.getValor(3));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Buscar si existe un elemento
        System.out.println("8. ¿Existe el valor 20 en la lista? " + miLista.buscar(20));
        System.out.println("9. ¿Existe el valor 100 en la lista? " + miLista.buscar(100));
        
        // Buscar posición de un elemento
        try {
            System.out.println("10. Posición del valor 30: " + miLista.getPosicion(30));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Buscar elemento de forma recursiva
        System.out.println("11. ¿Existe el valor 15 en la lista? (búsqueda recursiva): " + 
                          miLista.buscarRecursivo(15));
        
        // Insertar al final de forma recursiva
        System.out.println("12. Insertando el valor 40 al final (recursivo)");
        miLista.insertarFinalRecursivo(40);
        miLista.imprimir();
        
        // Insertar en posición específica (recursivo)
        try {
            System.out.println("13. Insertando el valor 25 en la posición 3 (recursivo)");
            miLista.insertarEnPosicionRecursivo(3, 25);
            miLista.imprimir();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Eliminar en posición específica
        try {
            System.out.println("14. Eliminando elemento en la posición 2");
            miLista.removerPorPosicion(2);
            miLista.imprimir();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Verificar si está vacía
        System.out.println("15. ¿La lista está vacía? " + miLista.estaVacia());
        
        // Obtener cantidad de nodos
        System.out.println("16. Cantidad de nodos en la lista: " + miLista.getCantidadNodos());
        
        // Eliminar todos los elementos
        System.out.println("17. Eliminando todos los elementos de la lista");
        miLista.eliminar();
        
        // Verificar si está vacía
        System.out.println("18. ¿La lista está vacía? " + miLista.estaVacia());
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}