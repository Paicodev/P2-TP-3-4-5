package seccion2;

/**
 * Clase de la Sección 2 - Ejercicio 2.1: Simulando una anomalía.
 * - El objetivo es provocar una condición de carrera (race condition)
 *   al permitir que múltiples hilos manipulen un recurso compartido 
 *   sin ningún mecanismo de sincronización.
 */
public class ejercicio2_1 {

     /**
     * Clase interna estática que representa el recurso compartido.
     */
    static class Contador {
        private int valor = 0;

        /*
         * SECCIÓN CRÍTICA: La operación valor++ consta de 3 pasos a nivel de CPU.
         * Al no estar protegida, los hilos se sobrescriben perdiendo incrementos.
         */
        public void incrementar() {
            valor++;
        }

        public int getValor() {
            return valor;
        }
    }

    public static void main(String[] args) {
        
        System.out.println("--- Simulando Condición de Carrera ---");

        // Instanciamos el recurso que será compartido por los hilos
        Contador contadorCompartido = new Contador();

        // Definimos la tarea: incrementar el contador 100,000 veces
        Runnable tareaIncremento = () -> {
            for (int i = 0; i < 100000; i++) {
                contadorCompartido.incrementar();
            }
        };

        // Creamos dos hilos inyectando la MISMA tarea (mismo recurso)
        Thread hilo1 = new Thread(tareaIncremento, "Hilo-A");
        Thread hilo2 = new Thread(tareaIncremento, "Hilo-B");

        // Iniciamos la ejecución concurrente
        hilo1.start();
        hilo2.start();

        /*
         * El método join() pausa la ejecución del hilo principal (main) 
         * hasta que hilo1 e hilo2 terminen sus tareas. Es necesario capturar
         * la excepción InterruptedException por si el hilo es interrumpido mientras espera.
         */
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }

        /*
         * El resultado matemático esperado es 200,000. 
         * Debido a la condición de carrera, el resultado será impredecible y menor al esperado.
         */
        System.out.println("Valor final del contador: " + contadorCompartido.getValor());
    }

   
}