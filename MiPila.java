import java.util.LinkedList;

/**
 * Implementación de una Pila (Stack) genérica.
 * Sigue el principio LIFO (Last-In, First-Out).
 * Utiliza un LinkedList internamente por su eficiencia al agregar/quitar del final.
 * @param <T> El tipo de elementos que esta pila almacenará.
 */
public class MiPila<T> {
    private LinkedList<T> elementos;

    public MiPila() {
        elementos = new LinkedList<>();
    }

    // "Empuja" un elemento a la cima de la pila (apilar).
    public void apilar(T elemento) {
        elementos.addLast(elemento);
    }

    // "Saca" y devuelve el elemento de la cima de la pila (desapilar).
    public T desapilar() {
        if (estaVacia()) {
            return null; // O lanzar una excepción
        }
        return elementos.removeLast();
    }

    // Devuelve el elemento de la cima sin sacarlo (peek).
    public T cima() {
        if (estaVacia()) {
            return null; // O lanzar una excepción
        }
        return elementos.getLast();
    }

    // Verifica si la pila está vacía.
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    @Override
    public String toString() {
        return "Pila (Cima -> Base): " + elementos.reversed().toString();
    }
}
