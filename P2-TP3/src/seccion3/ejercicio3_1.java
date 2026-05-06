package seccion3;

import java.util.stream.Stream;

/**
 * clase de la Sección 3 - Ejercicio 3.1: Transformación con Map.
 *
 * El objetivo es evidenciar cómo la operación intermedia map() toma un elemento, le aplica una función de transformación (Function<T, R>) y devuelve un nuevo Stream con los elementos modificados.
 */
public class ejercicio3_1 {

    public static void main(String[] args) {
        
        System.out.println("--- Transformando lista de nombres ---");
        
        /*
         * fase 1: creación del Stream inicial con los nombres provistos.
         */
        Stream.of("Juan", "Maria", "Ana")
            /*
             * fase 2: operación intermedia: map()
             - Aplica la función s -> s.toUpperCase() a cada elemento.
             - Recibe un String y devuelve un String, modificando sus elementos a Mayusculas.
             */
            .map(s -> s.toUpperCase())
            /*
             * fase 3: operación final: forEach()
             esta consume el Stream resultante para imprimir cada nombre ya transformado.
             */
            .forEach(nombreTransformado -> System.out.println("Nombre procesado: " + nombreTransformado));
    }
}