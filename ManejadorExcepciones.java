import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Este programa demuestra el manejo avanzado de excepciones.
 * Intenta leer un archivo de configuración "config.txt", extrae un valor numérico
 * y maneja múltiples tipos de errores de forma controlada.
 */
public class ManejadorExcepciones {

    public static void main(String[] args) {
        String archivoConfig = "config.txt";
        System.out.println("Intentando leer el archivo de configuración: " + archivoConfig);

        // El bloque try-with-resources asegura que el BufferedReader se cierre
        // automáticamente al final, sin importar si hubo una excepción o no.
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoConfig))) {
            
            String linea = reader.readLine();
            
            if (linea != null) {
                // Suponemos que el formato es "clave=valor"
                String[] partes = linea.split("=");
                if (partes.length == 2) {
                    // Intentamos convertir la segunda parte a un número entero.
                    // Esto puede lanzar una NumberFormatException si no es un número.
                    int timeout = Integer.parseInt(partes[1].trim());
                    System.out.println("Lectura exitosa. Valor de 'timeout' establecido en: " + timeout);
                } else {
                    System.out.println("El formato de la línea no es válido. Se esperaba 'clave=valor'.");
                }
            } else {
                 System.out.println("El archivo de configuración está vacío.");
            }

        } catch (FileNotFoundException e) {
            // Este bloque se ejecuta ESPECÍFICAMENTE si el archivo "config.txt" no se encuentra.
            System.err.println("¡ERROR! Archivo no encontrado: " + e.getMessage());
            System.err.println("Por favor, asegúrese de que el archivo '" + archivoConfig + "' exista en la misma carpeta.");
        
        } catch (IOException e) {
            // Este bloque se ejecuta si ocurre cualquier otro error de Entrada/Salida (I/O).
            System.err.println("¡ERROR! Ocurrió un problema al leer el archivo: " + e.getMessage());
        
        } catch (NumberFormatException e) {
            // Este bloque se ejecuta si el valor en el archivo no puede ser convertido a un número.
            System.err.println("¡ERROR! El valor en el archivo de configuración no es un número válido: " + e.getMessage());
        
        } finally {
            // El bloque 'finally' se ejecuta SIEMPRE, haya o no haya habido una excepción.
            // Es ideal para mensajes de finalización o limpieza.
            System.out.println("--- Proceso de lectura de configuración finalizado. ---");
        }
    }
}
