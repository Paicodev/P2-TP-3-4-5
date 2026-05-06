package seccion4;

import java.util.stream.Stream;

/**
 * Clase de la Sección 4 - Ejercicio 4.1: Comprobaciones lógicas.
 * - El objetivo es evidenciar el uso de operaciones finales de cortocircuito (anyMatch, allMatch, noneMatch) que consumen el flujo y devuelven un valor booleano.
 * Aqui no está presente la fase 2, de operaciones intermedias (lazys)
 */
public class ejercicio4_1 {

    public static void main(String[] args) {
        
        System.out.println("--- Evaluando comprobaciones lógicas (Cortocircuito) ---");

        /*
         * fase 1: se crea el Stream inicial.
         * fase 3: anyMatch() evalúa si AL MENOS UN elemento cumple el predicado.
         *         Al encontrar el '7', hace cortocircuito y devuelve true sin evaluar el resto.
         */
        boolean hayMayorACinco = Stream.of(2, 5, 7, 3, 6, 2, 3)
            .anyMatch(n -> n > 5);
        System.out.println("¿Hay algún número mayor a 5? " + hayMayorACinco);

        /*
         * fase 1: se crea un nuevo Stream porque el anterior fue consumido.
         * fase 2: allMatch() evalúa si TODOS los elementos cumplen el predicado.
         *         Al evaluar el primer '2', hace cortocircuito y devuelve false inmediatamente.
         */
        boolean todosMayoresACero = Stream.of(2, 5, 7, 3, 6, 2, 3)
            .allMatch(n -> n > 0);
        System.out.println("¿Son todos los números mayores a 0? " + todosMayoresACero);

        /*
         * fase 1: se crea el tercer y último Stream.
         * fase 2: noneMatch() evalúa si NINGÚN elemento cumple el predicado.
         *         Al no encontrar números negativos, procesa todo y devuelve true.
         */
        boolean ningunNegativo = Stream.of(2, 5, 7, 3, 6, 2, 3)
            .noneMatch(n -> n < 0);
        System.out.println("¿Es cierto que no hay ningún número negativo? " + ningunNegativo);
    }
}