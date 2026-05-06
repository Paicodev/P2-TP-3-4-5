package seccion4;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Clase de la Sección 4 - Ejercicio 4.3: Reducción.
 * - El objetivo es evidenciar el uso del método reduce() para combinar
 *   todos los elementos de un flujo en un único resultado matemático (la suma total),
 *   y extraer dicho valor desde la clase Optional.
 */
public class ejercicio4_3 {

    public static void main(String[] args) {
        
        System.out.println("--- Reduciendo el Stream para sumar sus elementos ---");

        /*
         * fase 1: se crea el Stream inicial con valores numéricos.
         * fase 3: reduce() es una operación terminal que toma un BinaryOperator como acumulador.
         *         La expresión (a, b) -> a + b toma dos elementos y los combina en uno,
         *         repitiendo el proceso hasta reducir todo el flujo a un solo valor.
         */
        Optional<Integer> sumaTotal = Stream.of(15, 25, 35, 45)
            .reduce((a, b) -> a + b);

        /*
         * Como esta forma de reduce() devuelve un Optional para manejar de forma
         * segura los flujos vacíos, extraemos el valor final utilizando get().
         */
        if (sumaTotal.isPresent()) {
            System.out.println("La suma total de los elementos es: " + sumaTotal.get());
        }
    }
}