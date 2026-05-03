package seccion_3;

public class Producto {

    private String nombre;
    private double precio;

    /**
     * Constructor de Producto que aplica la metodología Fail-fast.
     * 
     * @param nombre Nombre del producto.
     * @param precio Precio de venta. Debe ser estrictamente mayor a 0.
     */
    public Producto(String nombre, double precio) {
        if (precio <= 0) {
            // Se lanza una excepción no comprobada. 
            throw new ProductoInvalidoException("El precio del producto '" + nombre + "' es inválido: $" + precio + ". Debe ser mayor a cero.");
        }
        
        this.nombre = nombre;
        this.precio = precio;
        System.out.println("Producto instanciado correctamente: " + this.nombre);
    }
}