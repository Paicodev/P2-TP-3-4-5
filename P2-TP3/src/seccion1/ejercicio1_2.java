package seccion1;

import java.util.ArrayList;
import java.util.List;

/**
 * Corresponde a la Sección 1 - Ejercicio 1.2.
 * 
 * El objetivo es demostrar cómo se pasa el comportamiento como argumento a un método (en este caso, el criterio de ordenación al método sort) utilizando la sintaxis concisa de las lambdas.
 */
public class ejercicio1_2 {
    public static void main(String[] args) {
        
        /*
         * Se inicializa una lista mutable (ArrayList) con varias cadenas de texto.
         * La lista debe ser mutable para poder aplicar el método sort() sobre ella misma y modificar el orden de sus elementos.
         */
        List<String> textos = new ArrayList<>(List.of(
            "CSS",
            "Java 17",
            "SQL",
            "HTML",
            "JavaScript"
        ));

        System.out.println("--- Lista Original ---");
        textos.forEach(texto -> System.out.println(texto));

        /*
         * El método sort() recibe un Comparator. Como Comparator es una interfaz funcional (su único método abstracto es 'int compare(T o1, T o2)'), podemos implementarlo directamente con una expresión lambda.
         * 
         * La expresión (a, b) -> a.length() - b.length() evalúa:
          - Si el resultado es negativo: 'a' va antes que 'b' (es más corto).
          - Si el resultado es cero: mantienen su orden relativo.
          - Si el resultado es positivo: 'b' va antes que 'a' ('b' es más corto).
         */
        textos.sort((a, b) -> a.length() - b.length());

        System.out.println("\n--- Lista Ordenada por Longitud (Ascendente) ---");
        textos.forEach(texto -> System.out.println(texto));
    }
}