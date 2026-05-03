package tp4;

/**
 * Corresponde al Ejercicio 1.2: El bloque finally
 */
public class Ejercicio1_2 {

     public static void main(String[] args) {
        simularDivisionPorCero();
    }

    /**
     * Simula una operación matemática inválida (división por cero) para forzar una ArithmeticException y demostrar la ejecución del bloque finally.
     */
    public static void simularDivisionPorCero() {

        try {
            System.out.println("Intentando realizar la división...");
            int resultado = 10 / 0; 
            
            // Esta línea no se ejecutará debido a la interrupción del flujo normal.
            System.out.println("El resultado es: " + resultado);

        } catch (ArithmeticException e) {
            System.out.println("Excepción capturada: Error aritmético.");
            System.out.println("Detalle del error: " + e.getMessage());

        } finally {
            /*
             * El bloque finally se ejecuta siempre, haya o no ocurrido una excepción.
             */
            System.out.println("Limpieza final");
        }
    }
}