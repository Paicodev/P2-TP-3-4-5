package seccion_3;

/**
 * Clase principal para probar la captura obligatoria de excepciones comprobadas.
 * Corresponde al Ejercicio 3.1: Excepción Checked Personalizada.
 */
public class ejercicio_3_1 {

    /**
     * Método principal que gestiona la prueba de la clase CuentaBancaria.
    */
    public static void main(String[] args) {
        System.out.println("--- Iniciando sistema de pruebas bancarias ---");
        
        // Se inicializa una cuenta con un saldo base
        CuentaBancaria cuenta = new CuentaBancaria(1000.0);

        System.out.println("\n[Prueba A: Retiro válido]");
        try {
            cuenta.retirar(400.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n[Prueba B: Retiro que excede el saldo]");
        /*
         * El compilador exige este bloque try-catch porque el método retirar() declara una excepción comprobada personalizada.
         */
        try {
            cuenta.retirar(800.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Excepción capturada correctamente.");
            System.out.println("Detalle: " + e.getMessage());
        }
    }
}