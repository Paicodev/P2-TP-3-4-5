package tp4;
/**
 * Clase que corresponde al Ejercicio 1.1: Bloques try/catch y captura de información.
 */
public class ejercicio_1_1 {
    public static void main(String[] args) {
        String texto = "abc";

        /*
         * El bloque try encierra el código que es susceptible a lanzar
         * una excepción durante su ejecución.
         */
        try {
            /*Intento de conversión de la cadena "abc" a un valor    entero. Al no contener dígitos válidos, el flujo se interrumpe y salta al catch. */
            int numero = Integer.parseInt(texto);
            
            // Si la conversión hubiera sido exitosa, se imprimiría el número convertido.
            System.out.println("El número convertido es: " + numero);

        } catch (NumberFormatException e) {
            /*
             * El bloque catch captura específicamente la excepción NumberFormatException, esta excepción se lanza cuando el método parseInt no puede convertir la cadena a un número entero debido a que el formato no es válido.
             */
            System.out.println("--- EXCEPCIÓN CAPTURADA ---");
            
            // e.getMessage() devuelve un mensaje describiendo la causa de la excepción.
            System.out.println("causa del error: " + e.getMessage());
            
            // e.getClass().getName() devuelve el tipo de clase de la excepción capturada
            System.out.println("tipo de excepción: " + e.getClass().getName());
        }
    }
}
