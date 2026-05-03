package seccion_3;

/**
 * Corresponde al Ejercicio 3.2: Excepción Unchecked Personalizada.
 */
public class ejercicio_3_2 {

    /**
     * Método principal que ejecuta la prueba.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("--- Intentando registrar un producto válido ---");
        Producto producto1 = new Producto("Pizza Especial", 8500.0);

        System.out.println("\n--- Intentando registrar un producto con precio negativo ---");
        /*
         * Al instanciar un producto con precio negativo, se lanzará la ProductoInvalidoException.
         * Como hereda de RuntimeException, Java permite escribir
         * este código sin envolverlo en un bloque try-catch.
         * 
         * El resultado será la interrupción abrupta del programa (crash) y la impresión del Stack Trace (pila de llamadas) en la consola, demostrando que el error no fue gestionado.
         */
        Producto producto2 = new Producto("Empanadas (Docena)", -1200.0);
        
        // Esta línea jamás se ejecutará porque el programa fallará en la línea anterior.
        System.out.println("Fin del programa.");
    }
}
