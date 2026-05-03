package seccion_3;

/**
 * Clase que representa una cuenta bancaria con operaciones transaccionales básicas.
 */
public class CuentaBancaria {
    
    private double saldo;

    /**
     * Constructor para inicializar la cuenta bancaria.
     * 
     * @param saldoInicial Monto de apertura de la cuenta.
     */
    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    /**
     * Realiza un retiro de la cuenta, validando previamente el saldo.
     * 
     * @param monto Cantidad de dinero a retirar.
     * @throws SaldoInsuficienteException Si el monto a retirar supera el saldo actual.
     */
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            // Se interrumpe el flujo y se lanza la excepción personalizada
            throw new SaldoInsuficienteException("Operación denegada. intento retirar $" + monto + " disponiendo solo de $" + saldo);
        }
        
        saldo -= monto;
        System.out.println("Retiro procesado: $" + monto + ". Saldo disponible: $" + saldo);
    }
}