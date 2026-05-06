package seccion4;

/**
 * Clase de la Sección 4 - Ejercicio 4.1: Identidad y Prioridades.
 * - El objetivo es evidenciar el uso de métodos estáticos para obtener la identidad del hilo en ejecución y cómo la asignación de prioridades sugiere (aunque no garantiza) al planificador del SO el tiempo de CPU.
 */
public class ejercicio4_1 {

    public static void main(String[] args) {
        
        System.out.println("--- Ejecutando Hilos con Identidad y Prioridades ---");

        // Definimos la tarea
        Runnable tareaIdentidad = () -> {
            // Obtenemos la referencia al hilo exacto que está ejecutando este bloque
            Thread hiloActual = Thread.currentThread();
            
            for (int i = 1; i <= 5; i++) {
                System.out.println("Soy [" + hiloActual.getName() + 
                                   "] con prioridad (" + hiloActual.getPriority() + 
                                   ") ejecutando el paso: " + i);
            }
        };

        // Instanciamos los hilos con nombres descriptivos
        Thread hiloBaja = new Thread(tareaIdentidad, "Hilo-Baja-Prioridad");
        Thread hiloAlta = new Thread(tareaIdentidad, "Hilo-Alta-Prioridad");

        /*
         * Asignamos las prioridades antes de invocar start().
         * 1 es la prioridad mínima (Thread.MIN_PRIORITY).
         * 10 es la prioridad máxima (Thread.MAX_PRIORITY).
         */
        hiloBaja.setPriority(1);
        hiloAlta.setPriority(10);

        // Iniciamos la ejecución concurrente
        hiloBaja.start();
        hiloAlta.start();
        
    }
}