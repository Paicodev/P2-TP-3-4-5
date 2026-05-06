package seccion3;

import java.util.stream.Stream;

/**
 * clase de la Sección 3 - Ejercicio 3.2: Map a tipos primitivos.
 *
 * El objetivo es evidenciar cómo optimizar el rendimiento transformando un  flujo de objetos String en un IntStream primitivo para realizar operaciones matemáticas de forma eficiente sin costos de unboxing.
 */
public class ejercicio3_2 {

    public static void main(String[] args) {
        
        System.out.println("--- Calculando la suma total de caracteres ---");
        
        /*
         * fase 1: creación del Stream inicial con los nombres provistos.
         */
        int totalLetras = Stream.of("Juan", "Maria", "Ana")
            /*
             * fase 2: Operación Intermedia: mapToInt()
              esta operacion transforma cada elemento (String) en un primitivo (int) extrayendo su longitud.
             - Esto convierte el Stream genérico en un IntStream.
             */
            .mapToInt(s -> s.length())
            /*
             * fase 3: Operación final: sum()
             - Esta operación es exclusiva de los flujos primitivos (como IntStream).
              - Suma todos los elementos del flujo de forma optimizada y devuelve un entero.
             */
            .sum();

        System.out.println("La cantidad total de letras en los nombres es: " + totalLetras);
    }
}