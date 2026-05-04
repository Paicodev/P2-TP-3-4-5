package seccion1;

import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;

/**
 * Corresponde a la Sección 1 - Ejercicio 1.3.
 * 
 * Se reemplazan las interfaces genéricas por sus variantes primitivas para evitar el costo de rendimiento asociado al autoboxing/unboxing de las clases contenedoras.
 */
public class ejercicio1_3 {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Interfaz IntPredicate ---");
        /*
         * IntPredicate es la variante primitiva de Predicate<Integer>.
         * Evita el autoboxing trabajando directamente con el tipo primitivo int.
         * Su método abstracto es: boolean test(int value)
         */
        IntPredicate esPar = n -> n % 2 == 0;
        int numeroPrueba = 8;
        System.out.println("¿El número " + numeroPrueba + " es par? " + esPar.test(numeroPrueba));

        System.out.println("\n--- 2. Interfaz ToIntFunction ---");
        /*
         * ToIntFunction<T> es una variante de Function<T, R> diseñada para devolver un tipo primitivo int.
         * Su método abstracto cambia ligeramente de nombre y es: int applyAsInt(T value)
         */
        ToIntFunction<String> obtenerLongitud = cadena -> cadena.length();
        String textoPrueba = "PabloEdgarMatíasAguilar";
        System.out.println("La longitud de '" + textoPrueba + "' es: " + obtenerLongitud.applyAsInt(textoPrueba));
    }
}