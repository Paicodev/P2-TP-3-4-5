package seccion1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Corresponde a la Sección 1 - Ejercicio 1.1.
 * 
 * Se implementan las cuatro interfaces principales del paquete java.util.function, invocando los métodos abstractos de cada una de ellas para ejecutar el código almacenado en la lambda.
 */
public class ejercicio1_1 {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Interfaz Predicate ---");
        /*
         * Un Predicate representa una función que evalúa una condición booleana.
         * Su método abstracto es: boolean test(T t)
         */
        Predicate<Integer> esPar = n -> n % 2 == 0;
        int numeroPrueba = 8;
        System.out.println("¿El número " + numeroPrueba + " es par? " + esPar.test(numeroPrueba));

        System.out.println("\n--- 2. Interfaz Function ---");
        /*
         * Una Function representa una operación que toma un argumento de un tipo T y produce un resultado de otro tipo R.
         * Su método abstracto es: R apply(T t)
         */
        Function<String, Integer> obtenerLongitud = cadena -> cadena.length();
        String textoPrueba = "PabloEdgarMatíasAguilar";
        System.out.println("La longitud de '" + textoPrueba + "' es: " + obtenerLongitud.apply(textoPrueba));

        System.out.println("\n--- 3. Interfaz Consumer ---");
        /*
         * Un Consumer representa una operación que acepta un único argumento de entrada y no devuelve ningún resultado (ejecuta un efecto secundario).
         * Su método abstracto es: void accept(T t)
         */
        Consumer<Integer> imprimirEnConsola = n -> System.out.println("Número recibido por el consumidor: " + n);
        imprimirEnConsola.accept(402);

        System.out.println("\n--- 4. Interfaz Supplier ---");
        /*
         * Un Supplier es lo opuesto a un Consumer. No toma argumentos y devuelve un resultado de tipo T.
         * Su método abstracto es: T get()
         */
        Supplier<Double> generarNumeroAleatorio = () -> Math.random();
        System.out.println("Número aleatorio suministrado: " + generarNumeroAleatorio.get());
    }
}