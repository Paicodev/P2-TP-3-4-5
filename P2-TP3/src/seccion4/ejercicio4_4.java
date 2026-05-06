package seccion4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clase de la Sección 4 - Ejercicio 4.4: Reducción a Colección.
 * - El objetivo es evidenciar el uso de collect() para acumular los elementos de un Stream en diferentes tipos de colecciones.
 */
public class ejercicio4_4 {

    public static void main(String[] args) {
        
        System.out.println("--- Recolectando números sin duplicados en una Lista ---");

        /*
         * fase 1: se crea el Stream inicial con valores numéricos que contienen duplicados.
         * fase 2: distinct() es una operación intermedia que elimina los elementos repetidos.
         * fase 3: collect() es la operación terminal que acumula los elementos. Al pasarle 
         *         Collectors.toList(), agrupa el resultado en una estructura List.
         */
        List<Integer> numerosLimpios = Stream.of(1, 2, 2, 3, 4, 4, 5)
            .distinct()
            .collect(Collectors.toList());

        System.out.println("Lista resultante sin duplicados: " + numerosLimpios);
    }
}