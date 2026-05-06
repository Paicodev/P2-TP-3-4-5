package seccion4;

/**
 * Clase de la Sección 4 - Ejercicio 4.2: Espera e Interrupción.
 * - El objetivo es evidenciar el uso de join() para sincronizar la espera y el uso de interrupt() para detener un hilo que se encuentra en un estado de bloqueo temporal.
 */
public class ejercicio4_2 {

    public static void main(String[] args) {
        
        System.out.println("--- Ejecutando Hilo Largo ---");

        // Definimos la tarea larga (simulada con un sleep para pausar el proceso)
        Runnable tareaLarga = () -> {
            try {
                System.out.println("Hilo Secundario: Iniciando procesamiento pesado...");
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Hilo Secundario: Procesando lote " + i + "/10...");
                    // Simulamos trabajo bloqueando el hilo por 1 segundo en cada ciclo
                    Thread.sleep(1000); 
                }
                System.out.println("Hilo Secundario: Procesamiento finalizado exitosamente.\n");
            } catch (InterruptedException e) {
                /*
                 Aquí capturamos la excepción provocada por interrupt().
                 Ocurre porque el hilo estaba bloqueado en el sleep() cuando recibió la señal de interrupción desde el exterior.
                 */
                System.out.println("hilo secundario interrumpido\n");
            }
        };

        // Iniciamos el hilo
        Thread hilo = new Thread(tareaLarga, "Hilo-Trabajador");
        hilo.start();

        try {
            // El hilo principal espera 3 segundos para dejar que el secundario trabaje un poco
            System.out.println("Main: Dejando trabajar al hilo por 5 segundos...\n");
            Thread.sleep(5000);

            // prueba para interrumpir el hilo antes de que termine sus 10 lotes
            System.out.println("El tiempo expiró, el hilo principal enviará la señal para interrumpir al hilo secundario\n");
            hilo.interrupt();

            // Usamos join() para bloquear el main hasta que el hilo secundario muera por completo
            System.out.println("el hilo principal esta usando join() para esperar el cierre\n");
            hilo.join();
            
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido\n");
        }

        System.out.println("El hilo principal finalizó!\n");
    }
}