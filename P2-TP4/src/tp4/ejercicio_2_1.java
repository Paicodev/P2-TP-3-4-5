package tp4;

public class ejercicio_2_1 {
/**
 * Clase que demuestra una validación básica de entradas.
 * Corresponde al Ejercicio 2.1: Validar entradas y Fallar Rápido 
 */

    public static void main(String[] args) {
        System.out.println("--- Ejecutando Prueba 2.1 ---");
        try {
            // Se envía una edad inválida para forzar el error
            registrarUsuario("Juan Perez", -5);
        } catch (Exception e) {
            System.out.println("Hubo un error al registrar el usuario");
        }
    }

    /**
     * Registra un nuevo usuario validando sus datos.
     *
     * @param nombre El nombre del usuario.
     * @param edad   La edad del usuario.
     */
    public static void registrarUsuario(String nombre, int edad) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no debe estar vacio");
        }

        if (edad < 0) {
            throw new IllegalArgumentException("La edad no debe ser negativa");
        }

        System.out.println("Usuario registrado: " + nombre);
    }
}
