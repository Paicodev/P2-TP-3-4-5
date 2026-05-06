package seccion2;

import java.util.stream.Stream;

/**
 * Clase de Sección 2 - Ejercicio 2.2: Filtrado y Procesamiento Intermedio.
 *
 * El objetivo es evidenciar cómo los elementos fluyen a través de un pipeline, utilizando la operación filter() para establecer condiciones y peek() para observar el estado del flujo antes de la operación terminal.
 */
public class ejercicio2_2 {
    public static void main(String[] args) {
        
        System.out.println("--- Iniciando el pipeline del Stream ---");
        
        //fase 1: creacion del stream
        long cantidadMayoresAtres = Stream.of(1, 2, 3, 4, 5, 6)
            /*
             * fase 2: operación intermedia: filter()
             -solo deja pasar al siguiente nivel los elementos que sean mayores a 3.
             */
            .filter(s -> s > 3)
            /*
             * 2- operación intermedia: peek()
             -toma un Consumer y realiza un "efecto secundario" (imprimir en consola) sin alterar los elementos del Stream.
             */
            .peek(n -> System.out.println("Elemento que pasó el filtro: " + n))
            /*
             * fase 3: operación fnal: count()
              -Desencadena toda la ejecución "perezosa" del pipeline y cuenta cuántos elementos lograron llegar hasta el final.
             */
            .count();

        System.out.println("--- Pipeline finalizado ---");
        System.out.println("Total de elementos resultantes: " + cantidadMayoresAtres);
    }
}
