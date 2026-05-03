package tp4;

/**
 * corresponde al Ejercicio 2.2: Uso de mensajes claros y captura específica.
 */
public class ejercicio_2_2 {

    /**
     * Método principal que ejecuta la lógica de prueba.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("--- Ejecutando Prueba 2.2 ---");
        try {
            // Se envía una edad inválida para forzar el error
            registrarUsuario("Juan Perez", -10);
            
        } catch (IllegalArgumentException e) {
            /*
             * Capturar la excepción específica esperada.
             * ademas, retorna un mensaje con detalle de la excepción.
             */
            System.out.println("Error de validación capturado.");
            System.out.println("Detalle: " + e.getMessage());
        }
    }

    /**
     * Registra un nuevo usuario validando sus datos.
     *
     * @param nombre El nombre del usuario. No debe ser nulo ni estar en blanco.
     * @param edad   La edad del usuario. Debe ser mayor o igual a 0.
     * @throws IllegalArgumentException Si algún parámetro no cumple las reglas de negocio.
     */
    public static void registrarUsuario(String nombre, int edad) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del usuario no puede ser nulo ni estar compuesto solo por espacios en blanco.");
        }

        if (edad < 0) {
            throw new IllegalArgumentException("La edad ingresada (" + edad + ") no es válida. La edad no puede ser negativa.");
        }

        System.out.println("Usuario registrado: " + nombre);
    }
}