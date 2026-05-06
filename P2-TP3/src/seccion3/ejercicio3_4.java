package seccion3;

import java.util.List;

/**
 * Clase de la Sección 3 - Ejercicio 3.4: Ordenación.
 * - El objetivo es evidenciar cómo ordenar los elementos de un Stream, tanto por su orden natural como mediante un Comparator personalizado usando lambdas.
 */
public class ejercicio3_4 {

    public static void main(String[] args) {
        
        // Inicializamos la fuente de datos
        List<String> textos = List.of("Liu Kang", "Raiden", "Baraka", "Stryker", "Shang Tsung");

        System.out.println("--- Orden Natural (Alfabético) ---");
        /*
         * fase 1: se crea el Stream a partir de la lista original.
         * fase 2: sorted() es una operación intermedia con estado que ordena los elementos utilizando su orden natural (Comparable).
         * fase 3: forEach() es la operación terminal que desencadena el pipeline e imprime cada elemento.
         */
        textos.stream()
            .sorted()
            .forEach(texto -> System.out.println(texto));

        System.out.println("\n--- Orden Personalizado (Por Longitud) ---");
        /*
         * fase 1: se crea un nuevo Stream, ya que el anterior fue consumido y los streams no son reutilizables.
         * fase 2: sorted(Comparator) ordena los elementos inyectando la expresión lambda (s1, s2) -> s1.length() - s2.length().
         * fase 3: forEach() desencadena el nuevo pipeline e imprime cada elemento.
         */
        textos.stream()
            .sorted((s1, s2) -> s1.length() - s2.length())
            .forEach(texto -> System.out.println(texto));
    }
}