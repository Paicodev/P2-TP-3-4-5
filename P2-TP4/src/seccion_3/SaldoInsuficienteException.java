package seccion_3;

/**
 * Excepción comprobada (checked) personalizada para el dominio bancario.
 * Se lanza cuando una operación de retiro excede el saldo disponible.
 */
public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String mensaje) {
        // Llama al constructor de la clase padre (Exception) para almacenar el mensaje
        super(mensaje); 
    }
}