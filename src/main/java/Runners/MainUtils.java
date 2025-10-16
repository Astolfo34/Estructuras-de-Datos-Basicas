package Runners;

import Estructuras.ListaEnlazada;
import Implementaciones.Utils_ListImplementations;

public class MainUtils {

    public static void main(String[] args) {
        Utils_ListImplementations utils = new Utils_ListImplementations();
        
        System.out.println("=== DEMOSTRACIÓN DE MÉTODOS DE LA CLASE Utils_ListImplementations ===\n");
        
        // Crear una lista para trabajar
        ListaEnlazada lista = new ListaEnlazada();
        System.out.println("1. Creando una nueva lista enlazada...");
        
        // Verificar si está vacía
        System.out.println("2. ¿La lista está vacía? " + utils.estaVacia(lista));
        
        // Insertar elementos al final
        System.out.println("3. Insertando elementos al final: 10, 20, 30");
        utils.insertarAlFinalDeLaLista(lista, 10);
        utils.insertarAlFinalDeLaLista(lista, 20);
        utils.insertarAlFinalDeLaLista(lista, 30);
        
        // Imprimir la lista
        System.out.println("4. Contenido de la lista:");
        utils.imprimirTodosLosElementosDeLaLista(lista);
        
        // Insertar al inicio
        System.out.println("5. Insertando elemento al inicio: 5");
        utils.insertarAlInicioDeLaLista(lista, 5);
        utils.imprimirTodosLosElementosDeLaLista(lista);
        
        // Obtener cantidad de nodos
        System.out.println("6. Cantidad de nodos en la lista: " + utils.getCantidadNodosDelaLista(lista));
        
        // Insertar en posición específica
        try {
            System.out.println("7. Insertando el valor 15 en la posición 2");
            utils.insertarEnPosicionDeLaLista(lista, 15, 2);
            utils.imprimirTodosLosElementosDeLaLista(lista);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Obtener valor en posición específica
        try {
            System.out.println("8. Valor en la posición 3: " + utils.getValorDeLaLista(lista, 3));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Buscar si existe un elemento
        System.out.println("9. ¿Existe el valor 20 en la lista? " + utils.buscarExisteEnLaLista(lista, 20));
        System.out.println("10. ¿Existe el valor 100 en la lista? " + utils.buscarExisteEnLaLista(lista, 100));
        
        // Buscar posición de un elemento
        try {
            System.out.println("11. Posición del valor 30: " + utils.getPosicionEnLaLista(lista, 30));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Buscar elemento de forma recursiva
        System.out.println("12. ¿Existe el valor 15 en la lista? (búsqueda recursiva): " + 
                          utils.buscarExisteRecursivoEnLaLista(lista, 15));
        
        // Insertar al final de forma recursiva
        System.out.println("13. Insertando el valor 40 al final (recursivo)");
        utils.insertarAlFinalRecursivoEnLaLista(lista, 40);
        utils.imprimirTodosLosElementosDeLaLista(lista);
        
        // Insertar antes del último
        System.out.println("14. Insertando el valor 35 antes del último elemento");
        utils.insertarAntesDelUltimoEnLaLista(lista, 35);
        utils.imprimirTodosLosElementosDeLaLista(lista);
        
        // Eliminar en posición específica
        try {
            System.out.println("15. Eliminando elemento en la posición 2");
            utils.eliminarEnPosicionDeLaLista(lista, 2);
            utils.imprimirTodosLosElementosDeLaLista(lista);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Eliminar en posición específica (recursivo)
        try {
            System.out.println("16. Eliminando elemento en la posición 4 (recursivo)");
            utils.eliminarEnPosicionRecursivoDeLaLista(lista, 4);
            utils.imprimirTodosLosElementosDeLaLista(lista);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Insertar en posición específica (recursivo)
        try {
            System.out.println("17. Insertando el valor 25 en la posición 3 (recursivo)");
            utils.insertarEnPosicionRecursivoDeLaLista(lista, 25, 3);
            utils.imprimirTodosLosElementosDeLaLista(lista);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Verificar si está vacía
        System.out.println("18. ¿La lista está vacía? " + utils.estaVacia(lista));
        
        // Obtener cantidad de nodos
        System.out.println("19. Cantidad de nodos en la lista: " + utils.getCantidadNodosDelaLista(lista));
        
        // Eliminar todos los elementos
        System.out.println("20. Eliminando todos los elementos de la lista");
        utils.eliminarLista(lista);
        
        // Verificar si está vacía
        System.out.println("21. ¿La lista está vacía? " + utils.estaVacia(lista));
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}