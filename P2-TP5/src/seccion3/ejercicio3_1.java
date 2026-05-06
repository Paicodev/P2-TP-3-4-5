package seccion3;

/**
 * Clase de la Sección 3 - Ejercicio 3.1: Sincronización de métodos.
 * - El objetivo es garantizar la integridad de los datos utilizando 
 *   la palabra clave synchronized para bloquear el acceso concurrente 
 *   a la sección crítica y evitar la condición de carrera.
 */
public class ejercicio3_1 {

     /**
     * Clase interna estática que representa el recurso compartido y protegido.
     */
    static class ContadorSincronizado {
        private int valor = 0;

        /*
         * SECCIÓN CRÍTICA PROTEGIDA: La palabra 'synchronized' asegura que solo un hilo a la vez pueda ejecutar este método sobre esta instancia.
         * El hilo adquiere el "monitor del objeto" y bloquea a los demás.
         */
        public synchronized void incrementar() {
            valor++;
        }

        public int getValor() {
            return valor;
        }
    }

    public static void main(String[] args) {
        
        System.out.println("--- Ejecutando Hilos con Sincronización ---");

        // Instanciamos el recurso compartido
        ContadorSincronizado contadorCompartido = new ContadorSincronizado();

        // Definimos la tarea repetitiva
        Runnable tareaIncremento = () -> {
            for (int i = 0; i < 100000; i++) {
                contadorCompartido.incrementar();
            }
        };

        // Creamos los hilos compitiendo por el mismo recurso
        Thread hilo1 = new Thread(tareaIncremento, "Hilo-A");
        Thread hilo2 = new Thread(tareaIncremento, "Hilo-B");

        // Iniciamos la ejecución concurrente
        hilo1.start();
        hilo2.start();

        // Obligamos al hilo principal a esperar que ambos terminen
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }

        /*
         * Gracias al monitor del objeto, la sección crítica está protegida.
         * El resultado matemático final será exactamente 200,000, sin pérdida de datos.
         */
        System.out.println("Valor final del contador protegido: " + contadorCompartido.getValor());
    }

   
}