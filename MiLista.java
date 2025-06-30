import java.util.ArrayList;

/**
 * Implementación de una Lista genérica simple.
 * Utiliza un ArrayList internamente para almacenar los elementos,
 * pero expone sus propios métodos para controlar la funcionalidad.
 * @param <T> El tipo de elementos que esta lista almacenará.
 */
public class MiLista<T> {
    private ArrayList<T> elementos;

    public MiLista() {
        elementos = new ArrayList<>();
    }

    // Agrega un elemento al final de la lista.
    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    // Elimina un elemento en un índice específico.
    public T eliminar(int indice) {
        if (indice >= 0 && indice < elementos.size()) {
            return elementos.remove(indice);
        }
        return null; // O lanzar una excepción
    }

    // Obtiene un elemento de un índice específico.
    public T obtener(int indice) {
         if (indice >= 0 && indice < elementos.size()) {
            return elementos.get(indice);
        }
        return null; // O lanzar una excepción
    }

    // Verifica si la lista está vacía.
    public boolean estaVacia() {
        return elementos.isEmpty();
    }
    
    // Muestra todos los elementos de la lista.
    @Override
    public String toString() {
        return "Lista: " + elementos.toString();
    }
}
