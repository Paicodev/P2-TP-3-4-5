package seccion_3;

/**
 * Excepción no comprobada (unchecked) para validaciones de productos.
 * Al heredar de RuntimeException, el compilador no obliga a capturarla.
 */
public class ProductoInvalidoException extends RuntimeException {

    /**
     * Constructor que recibe un mensaje descriptivo del error.
     * 
     * @param mensaje Detalle del dato inválido provisto.
     */
    public ProductoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
