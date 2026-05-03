package seccion_1;

public class ejercicio_1_3 {
/**
 * Clase que demuestra el uso de la estructura multi-catch en Java.
 */
    public static void main(String[] args) {
        System.out.println("--- Prueba 1: Entrada no numérica ---");
        // Provoca una NumberFormatException
        procesarCadena("abc");
        
        System.out.println("\n--- Prueba 2: División por cero ---");
        // Provoca una ArithmeticException
        procesarCadena("0");

        System.out.println("\n--- Prueba 3: Ejecución exitosa ---");
        // Ejecución correcta
        procesarCadena("25");
    }

    /**
     * Recibe una cadena de texto, la convierte a un número entero y 
     * divide 100 por ese valor. Utiliza multi-catch para manejar excepciones de formato y de aritmética simultáneamente.
     *
     * @param entrada La cadena de texto a procesar y evaluar.
     */
    public static void procesarCadena(String entrada) {
        /*
         * El bloque try contiene las operaciones que pueden fallar:
         * 1. Integer.parseInt puede lanzar NumberFormatException.
         * 2. La división por el número evaluado puede lanzar ArithmeticException.
         */
        try {
            int numero = Integer.parseInt(entrada);
            int resultado = 100 / numero;
            
            System.out.println("El resultado de 100 / " + numero + " es: " + resultado);
            
        } catch (NumberFormatException | ArithmeticException e) {
            /*
             * El bloque multi-catch permite capturar dos o más excepciones no relacionadas con un solo bloque catch.
             * Al atrapar NumberFormatException o ArithmeticException, se ejecuta un tratamiento de error unificado.
             */
            System.out.println("Error de cálculo o conversión");
        }
    }
}
