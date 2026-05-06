package seccion3;

import java.util.List;

/**
   Clase de la Sección 3 - Ejercicio 3.3: Aplanamiento con flatMap.
  - El objetivo es evidenciar cómo convertir un Stream de colecciones (List<List<String>>) en un único Stream continuo de elementos (Stream<String>) para su posterior filtrado y conteo.
 */
public class ejercicio3_3 {

    public static void main(String[] args) {
        
        System.out.println("--- Aplanando y filtrando sublistas de nombres ---");
        
        // Inicializamos una lista principal que contiene varias sublistas
        List<List<String>> datos = List.of(
            List.of("Geronimo", "Maia", "Zoe"),
            List.of("Pablo", "Mia", "Angelina"),
            List.of("Paz", "Jennifer", "Ana")
        );

        /*
         * fase 1: se crea el String datos.stream() 
         * fase 2: flatMap toma una función que devuelve un Stream por cada elemento.
            - Al hacer l -> l.stream(), desempaqueta cada sublista y aplana todos esos flujos en un único Stream<String> continuo.
         *  2b - filter evalúa cada String suelto y retiene solo los mayores a 4 caracteres.
         * fase 3: count() desencadena el pipeline y cuenta los resultados.
         */
        long cantidadNombres = datos.stream()
            .flatMap(l -> l.stream())
            .filter(nombre -> nombre.length() > 4)
            .count();

        System.out.println("Cantidad de nombres con más de 4 caracteres: " + cantidadNombres);
    }
}