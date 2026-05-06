package seccion3;

/**
 * Clase de la Sección 3 - Ejercicio 3.2: Bloques sincronizados.
 * - El objetivo es evidenciar cómo optimizar el rendimiento de la concurrencia utilizando un bloque sincronizado para proteger únicamente la sección crítica, en lugar de bloquear el método completo.
 */
public class ejercicio3_2 {

    /**
     * Clase interna estática que representa el recurso compartido optimizado.
     */
    static class ContadorBloque {
        private int valor = 0;

        public void incrementar() {
            /*
             * SECCIÓN CRÍTICA PROTEGIDA: El bloque synchronized(this) utiliza el monitor de la instancia actual ('this') para bloquear solo el incremento.
             */
            synchronized (this) {
                valor++;
            }
        }

        public int getValor() {
            return valor;
        }
    }

    public static void main(String[] args) {
        
        System.out.println("--- Ejecutando Hilos con Bloque Sincronizado ---");

        // Instanciamos el recurso compartido
        ContadorBloque contadorCompartido = new ContadorBloque();

        // Definimos la tarea repetitiva
        Runnable tareaIncremento = () -> {
            for (int i = 0; i < 100000; i++) {
                contadorCompartido.incrementar();
            }
        };

        // Creamos los hilos
        Thread hilo1 = new Thread(tareaIncremento, "Hilo-A");
        Thread hilo2 = new Thread(tareaIncremento, "Hilo-B");

        // Iniciamos la ejecución concurrente
        hilo1.start();
        hilo2.start();

        // Sincronizamos la finalización con el hilo principal
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }

        /*
         * El resultado final seguirá siendo exactamente 200,000, 
         * pero ahora el bloqueo a nivel de CPU es mucho más eficiente.
         */
        System.out.println("Valor final del contador (bloque granular): " + contadorCompartido.getValor());
    }

   
}