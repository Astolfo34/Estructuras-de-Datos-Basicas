package Implementaciones;
import Estructuras.ListaEnlazada;

/**
 * Clase que contiene los métodos de implementación de las listas
 * para gestionar las listas enlazadas
 */
public class Utils_ListImplementations {

    public void eliminarLista(ListaEnlazada lista) {
        lista.eliminarTodosLosElementos();
    }

    public boolean estaVacia(ListaEnlazada lista) {
        if (lista.estaVacia())
            return true;
        return false;
    }
    public int getCantidadNodosDelaLista(ListaEnlazada lista) {
        return lista.cantidadNodos();
    }
    public void insertarAlFinalDeLaLista(ListaEnlazada lista, Object valor) {
        lista.insertarAlFinal(valor);
    }
    public void insertarAlInicioDeLaLista(ListaEnlazada lista, Object valor) {
        lista.insertarAlInicio(valor);
    }
    public void insertarEnPosicionDeLaLista(ListaEnlazada lista, Object valor, int posicion) throws Exception {
        lista.insertarDespuesPosicion(posicion, valor);
    }
    public Object getValorDeLaLista(ListaEnlazada lista, int posicion) throws Exception {
        return lista.getValor(posicion);
    }
    public boolean buscarExisteEnLaLista(ListaEnlazada lista, Object valor) {
        return lista.buscarExiste(valor);
    }
    public int getPosicionEnLaLista(ListaEnlazada lista, Object valor) throws Exception {
        return lista.getPosicion(valor);
    }
    public void eliminarEnPosicionDeLaLista(ListaEnlazada lista, int posicion) throws Exception {
        lista.eliminarEnPosicion(posicion);
    }
    public void imprimirTodosLosElementosDeLaLista(ListaEnlazada lista) {
        lista.imprimirTodos();
    }
    public boolean buscarExisteRecursivoEnLaLista(ListaEnlazada lista, Object valor) {
        return lista.buscarExisteRecursivo(valor, lista.getCabecera().getSiguiente());
    }
    public void insertarAlFinalRecursivoEnLaLista(ListaEnlazada lista, Object valor) {
        lista.insertarAlFinalRecursivo(valor, lista.getCabecera());
    }
    public void eliminarEnPosicionRecursivoDeLaLista(ListaEnlazada lista, int posicion) throws Exception {
        lista.eliminarEnPosicionRecursivo(posicion, lista.getCabecera(), 0);
    }
    public void insertarAntesDelUltimoEnLaLista(ListaEnlazada lista, Object valor) {
        lista.insertarAntesDelUltimo(valor);
    }
    public void insertarEnPosicionRecursivoDeLaLista(ListaEnlazada lista, Object valor, int posicion) throws Exception {
        lista.insertarEnPosicionRecursivo(valor, posicion, lista.getCabecera(), 0);
    }
}
