import java.util.Scanner;

/**
 * Programa principal para demostrar el uso de las estructuras de datos
 * MiLista, MiPila y MiCola a través de un menú interactivo en la consola.
 */
public class DemoEstructuras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal = 0;

        while (opcionPrincipal != 4) {
            System.out.println("\n--- MENÚ PRINCIPAL DE ESTRUCTURAS ---");
            System.out.println("1. Probar MiLista");
            System.out.println("2. Probar MiPila (Stack)");
            System.out.println("3. Probar MiCola (Queue)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcionPrincipal = Integer.parseInt(scanner.nextLine());

                switch (opcionPrincipal) {
                    case 1:
                        probarLista(scanner);
                        break;
                    case 2:
                        probarPila(scanner);
                        break;
                    case 3:
                        probarCola(scanner);
                        break;
                    case 4:
                        System.out.println("Saliendo del programa. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
            }
        }
        scanner.close();
    }

    public static void probarLista(Scanner scanner) {
        MiLista<String> lista = new MiLista<>();
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("\n--- Probando MiLista ---");
            System.out.println(lista);
            System.out.println("1. Agregar elemento");
            System.out.println("2. Eliminar elemento (por índice)");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione: ");
            opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 1) {
                System.out.print("Ingrese el elemento a agregar: ");
                lista.agregar(scanner.nextLine());
            } else if (opcion == 2) {
                System.out.print("Ingrese el índice a eliminar: ");
                int indice = Integer.parseInt(scanner.nextLine());
                String eliminado = lista.eliminar(indice);
                if (eliminado != null) {
                    System.out.println("Elemento eliminado: " + eliminado);
                } else {
                    System.out.println("Índice fuera de rango.");
                }
            }
        }
    }

    public static void probarPila(Scanner scanner) {
        MiPila<String> pila = new MiPila<>();
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- Probando MiPila (LIFO) ---");
            System.out.println(pila);
            System.out.println("1. Apilar (push) elemento");
            System.out.println("2. Desapilar (pop) elemento");
            System.out.println("3. Ver cima (peek)");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a apilar: ");
                    pila.apilar(scanner.nextLine());
                    break;
                case 2:
                    String desapilado = pila.desapilar();
                    if (desapilado != null) {
                         System.out.println("Elemento desapilado: " + desapilado);
                    } else {
                        System.out.println("La pila está vacía.");
                    }
                    break;
                case 3:
                     String cima = pila.cima();
                    if (cima != null) {
                         System.out.println("Elemento en la cima: " + cima);
                    } else {
                        System.out.println("La pila está vacía.");
                    }
                    break;
            }
        }
    }
    
    public static void probarCola(Scanner scanner) {
        MiCola<String> cola = new MiCola<>();
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- Probando MiCola (FIFO) ---");
            System.out.println(cola);
            System.out.println("1. Encolar (enqueue) elemento");
            System.out.println("2. Desencolar (dequeue) elemento");
            System.out.println("3. Ver frente (peek)");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a encolar: ");
                    cola.encolar(scanner.nextLine());
                    break;
                case 2:
                    String desencolado = cola.desencolar();
                    if (desencolado != null) {
                         System.out.println("Elemento desencolado: " + desencolado);
                    } else {
                        System.out.println("La cola está vacía.");
                    }
                    break;
                case 3:
                     String frente = cola.frente();
                    if (frente != null) {
                         System.out.println("Elemento en el frente: " + frente);
                    } else {
                        System.out.println("La cola está vacía.");
                    }
                    break;
            }
        }
    }
}
