package seccion2;

import java.util.stream.Stream;

/**
 * Sección 2 - Ejercicio 2.1.
 *
 * El objetivo es evidenciar el uso de métodos como distinct(), skip() y limit(), y cómo estas operaciones "lazy" se ejecutan al invocar la operación terminal count().
 */
public class ejercicio2_1 {
    public static void main(String[] args) {
        
        /*
         * fase 1: creo un Stream usando Stream.of()
         * el flujo de datos original es: [2, 5, 3, 3, 6, 2, 4]
         */
        System.out.println("--- Procesando el Stream de números ---");
        
        long cantidadElementos = Stream.of(2, 5, 3, 3, 6, 2, 4)
            /*fase 2: Operación Intermedia: distinct()
              -elimina los elementos duplicados basándose en equals()*/
            .distinct()
            /*Operación Intermedia: skip(1)
             - Descarta el primer elemento del flujo actual.  */
            .skip(1)
            /*  Operación Intermedia: limit(3)
             *-Trunca el flujo para que contenga un máximo de 3 elementos. */
            .limit(3)
            /* fase 3 : Operación Terminal: count()
             - Dispara la ejecución del pipeline y cuenta los elementos finales.
             */
            .count();

        System.out.println("La cantidad de elementos resultantes es: " + cantidadElementos);
    }
}