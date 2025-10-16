package Runners;

import Estructuras.Pila;

public class MainPila {

    public static void main(String[] args) {
        Pila miPila = new Pila();
        
        System.out.println("=== DEMOSTRACIÓN DE PILA ===\n");
        
        // Verificar si está vacía
        System.out.println("1. ¿La pila está vacía? " + miPila.estaVacia());
        
        // Agregar elementos a la pila
        System.out.println("2. Agregando elementos a la pila: 10, 20, 30, 40");
        miPila.push(10);
        miPila.push(20);
        miPila.push(30);
        miPila.push(40);
        
        // Mostrar el contenido de la pila
        System.out.println("3. Contenido de la pila:");
        System.out.println(miPila);
        
        // Verificar si está vacía
        System.out.println("4. ¿La pila está vacía? " + miPila.estaVacia());
        
        // Obtener el tamaño de la pila
        System.out.println("5. Tamaño de la pila: " + miPila.getTam());
        
        try {
            // Obtener el elemento del tope
            System.out.println("6. Elemento en el tope: " + miPila.top());
            
            // Eliminar elementos de la pila
            System.out.println("7. Eliminando elementos de la pila:");
            System.out.println("   Elemento eliminado: " + miPila.pop());
            System.out.println("   Contenido actual:");
            System.out.println("   " + miPila);
            
            System.out.println("   Elemento eliminado: " + miPila.pop());
            System.out.println("   Contenido actual:");
            System.out.println("   " + miPila);
            
            // Obtener el elemento del tope
            System.out.println("8. Elemento en el tope: " + miPila.top());
            
            // Obtener el tamaño de la pila
            System.out.println("9. Tamaño de la pila: " + miPila.getTam());
            
            // Eliminar el resto de elementos
            System.out.println("10. Eliminando el resto de elementos:");
            System.out.println("    Elemento eliminado: " + miPila.pop());
            System.out.println("    Elemento eliminado: " + miPila.pop());
            
            // Verificar si está vacía
            System.out.println("11. ¿La pila está vacía? " + miPila.estaVacia());
            
            // Intentar obtener el tope de una pila vacía
            System.out.println("12. Intentando obtener el tope de una pila vacía:");
            System.out.println("    Elemento en el tope: " + miPila.top());
            
        } catch (Exception e) {
            System.err.println("    Error: " + e.getMessage());
        }
        
        try {
            // Intentar eliminar de una pila vacía
            System.out.println("13. Intentando eliminar de una pila vacía:");
            System.out.println("    Elemento eliminado: " + miPila.pop());
        } catch (Exception e) {
            System.err.println("    Error: " + e.getMessage());
        }
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}