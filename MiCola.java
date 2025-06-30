import java.util.LinkedList;

/**
 * Implementación de una Cola (Queue) genérica.
 * Sigue el principio FIFO (First-In, First-Out).
 * Utiliza un LinkedList internamente por su eficiencia al agregar al final y quitar del inicio.
 * @param <T> El tipo de elementos que esta cola almacenará.
 */
public class MiCola<T> {
    private LinkedList<T> elementos;

    public MiCola() {
        elementos = new LinkedList<>();
    }

    // Agrega un elemento al final de la cola (enqueue).
    public void encolar(T elemento) {
        elementos.addLast(elemento);
    }

    // Quita y devuelve el elemento del frente de la cola (dequeue).
    public T desencolar() {
        if (estaVacia()) {
            return null; // O lanzar una excepción
        }
        return elementos.removeFirst();
    }

    // Devuelve el elemento del frente sin quitarlo (peek).
    public T frente() {
        if (estaVacia()) {
            return null; // O lanzar una excepción
        }
        return elementos.getFirst();
    }

    // Verifica si la cola está vacía.
    public boolean estaVacia() {
        return elementos.isEmpty();
    }
    
    @Override
    public String toString() {
        return "Cola (Frente -> Final): " + elementos.toString();
    }
}
