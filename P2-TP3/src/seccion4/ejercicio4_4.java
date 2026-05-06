package seccion4;

import java.util.List;
import java.util.Map;
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

        System.out.println("\n--- Parte 2: Recolectando objetos en un Mapa ---");

        /*
         * fase 1: se crea el Stream de objetos de tipo Persona.
         * fase 3: collect() es la operación terminal. Al inyectarle Collectors.toMap(),
         *         transforma el flujo en un Map (diccionario clave-valor). 
         *         La primera lambda extrae la clave (DNI) y la segunda extrae el valor (Nombre).
         */
        Map<Integer, String> mapaPersonas = Stream.of(
                new Persona(11111111, "Pablo"),
                new Persona(22222222, "Geronimo"),
                new Persona(33333333, "Maia"),
                new Persona(44444444, "Jennifer")
            )
            .collect(Collectors.toMap(p -> p.getDni(), p -> p.getNombre()));

        System.out.println("Mapa resultante (Clave=DNI, Valor=Nombre):");
        System.out.println(mapaPersonas);
    }

    /**
     * Clase interna estática para representar la entidad Persona.
     */
    static class Persona {
        //atributos encapsulados
        private int dni;
        private String nombre;

        //constructor
        public Persona(int dni, String nombre) {
            this.dni = dni;
            this.nombre = nombre;
        }

        //metodos getters
        public int getDni() {
            return dni;
        }

        public String getNombre() {
            return nombre;
        }
    }
}