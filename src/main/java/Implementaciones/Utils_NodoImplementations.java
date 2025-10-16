package Implementaciones;

import Estructuras.Nodo;

public class Utils_NodoImplementations {

    public Object getDatoNodoAnteriorAlNodo(Nodo nodo){
        Nodo aux = nodo.getAnterior(nodo);
        return aux.getDato();
    }
}
