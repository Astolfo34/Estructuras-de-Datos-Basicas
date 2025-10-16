# Taller de Algoritmos y Estructuras de Datos

Este proyecto implementa varias estructuras de datos en Java, incluyendo listas enlazadas simples y doblemente enlazadas.

## Estructuras de Datos Implementadas

### Lista Enlazada Simple
- Implementación completa con operaciones básicas
- Métodos iterativos y recursivos

### Lista Doblemente Enlazada
- Implementación completa con nodos dobles (anterior y siguiente)
- Operaciones básicas y avanzadas
- Métodos iterativos y recursivos

## Clases Principales

1. `Nodo` - Nodo para la lista enlazada simple
2. `NodoDoble` - Nodo para la lista doblemente enlazada
3. `ListaEnlazada` - Implementación de lista enlazada simple
4. `ListaDoblementeEnlazada` - Implementación de lista doblemente enlazada

## Runners

1. `Main` - Demostración de la lista enlazada simple
2. `MainDoble` - Demostración de la lista doblemente enlazada
3. `MainUtils` - Demostración de las utilidades de la lista enlazada simple

## Características

- Todos los métodos incluyen documentación con casos base y recursivos cuando aplica
- Complejidad temporal de cada método especificada
- Implementación siguiendo buenas prácticas de programación
- Código en español

## Cómo ejecutar

Para ejecutar cualquiera de los runners:
```bash
javac -d bin src/main/java/**/*.java
java -cp bin Runners.Main
java -cp bin Runners.MainDoble
java -cp bin Runners.MainUtils
```