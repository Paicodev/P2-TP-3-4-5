package seccion4;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Clase de la Sección 4 - Ejercicio 4.2: Búsqueda y Clase Optional.
 * - El objetivo es demostrar cómo encontrar un elemento específico en un flujo y manejar el resultado de forma segura contra valores nulos mediante la clase Optional.
 */
public class ejercicio4_2 {

    public static void main(String[] args) {
        
        System.out.println("--- Búsqueda del primer número par y manejo de Optional ---");

        /*
         * fase 1: se crea el Stream de enteros.
         * fase 2: filter() es una operación intermedia que retiene solo los números pares.
         * fase 3: findFirst() es la operación terminal que devuelve un Optional describiendo  el primer elemento del flujo, o un Optional vacío si el flujo está vacío.
         */
        Optional<Integer> primerPar = Stream.of(3, 7, 5, 8, 9, 12, 1)
            .filter(n -> n % 2 == 0)
            .findFirst();

        /*
         * La clase Optional encapsula el resultado para evitar NullPointerExceptions.
         - isPresent() verifica si la caja fuerte contiene algún valor.
         - get() extrae el valor real envuelto por el Optional (lanzaría error si estuviera vacío).
         */
        if (primerPar.isPresent()) {
            System.out.println("Se encontró el primer número par: " + primerPar.get());
        } else {
            System.out.println("No se encontraron números pares en el Stream.");
        }
    }
}