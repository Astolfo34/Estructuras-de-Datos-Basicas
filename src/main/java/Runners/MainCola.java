package Runners;

import Estructuras.Cola;

public class MainCola {

    public static void main(String[] args) {
        Cola miCola = new Cola();
        
        System.out.println("=== DEMOSTRACIÓN DE COLA ===\n");
        
        // Verificar si está vacía
        System.out.println("1. ¿La cola está vacía? " + miCola.estaVacia());
        
        // Agregar elementos a la cola
        System.out.println("2. Agregando elementos a la cola: 10, 20, 30, 40");
        miCola.enqueue(10);
        miCola.enqueue(20);
        miCola.enqueue(30);
        miCola.enqueue(40);
        
        // Mostrar el contenido de la cola
        System.out.println("3. Contenido de la cola:");
        System.out.println(miCola);
        
        // Verificar si está vacía
        System.out.println("4. ¿La cola está vacía? " + miCola.estaVacia());
        
        // Obtener el tamaño de la cola
        System.out.println("5. Tamaño de la cola: " + miCola.size());
        
        try {
            // Obtener el elemento del frente
            System.out.println("6. Elemento en el frente: " + miCola.front());
            
            // Eliminar elementos de la cola
            System.out.println("7. Eliminando elementos de la cola:");
            System.out.println("   Elemento eliminado: " + miCola.dequeue());
            System.out.println("   Contenido actual:");
            System.out.println("   " + miCola);
            
            System.out.println("   Elemento eliminado: " + miCola.dequeue());
            System.out.println("   Contenido actual:");
            System.out.println("   " + miCola);
            
            // Obtener el elemento del frente
            System.out.println("8. Elemento en el frente: " + miCola.front());
            
            // Obtener el tamaño de la cola
            System.out.println("9. Tamaño de la cola: " + miCola.size());
            
            // Eliminar el resto de elementos
            System.out.println("10. Eliminando el resto de elementos:");
            System.out.println("    Elemento eliminado: " + miCola.dequeue());
            System.out.println("    Elemento eliminado: " + miCola.dequeue());
            
            // Verificar si está vacía
            System.out.println("11. ¿La cola está vacía? " + miCola.estaVacia());
            
            // Intentar obtener el frente de una cola vacía
            System.out.println("12. Intentando obtener el frente de una cola vacía:");
            System.out.println("    Elemento en el frente: " + miCola.front());
            
        } catch (Exception e) {
            System.err.println("    Error: " + e.getMessage());
        }
        
        try {
            // Intentar eliminar de una cola vacía
            System.out.println("13. Intentando eliminar de una cola vacía:");
            System.out.println("    Elemento eliminado: " + miCola.dequeue());
        } catch (Exception e) {
            System.err.println("    Error: " + e.getMessage());
        }
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}