package seccion1;

public class ejercicio1_2 {
/**
 * Clase de la Sección 1 - Ejercicio 1.2: Implementando la interfaz Runnable.
   - El objetivo es comprender la segunda forma clásica de crear hilos en Java, separando la definición de la tarea (Runnable) del objeto que la ejecuta (Thread).
 */

/**
     * Clase interna estática que implementa la interfaz Runnable.
     * Aquí definimos "qué" se va a hacer, sin acoplarnos a la clase Thread.
     */
    static class TareaRunnable implements Runnable {
        
        @Override
        public void run() {
            // Obtenemos el nombre del hilo actual que está ejecutando esta tarea
            String nombreHilo = Thread.currentThread().getName();
            
            for (int i = 1; i <= 5; i++) {
                System.out.println(nombreHilo + " ejecutando paso: " + i);
            }
        }
}   


    public static void main(String[] args) {
        
        System.out.println("--- Iniciando hilos con Runnable ---");

        // 1. Instanciamos la tarea que queremos ejecutar
        TareaRunnable miTarea = new TareaRunnable();

        /*
         * 2. Creamos los objetos Thread pasándoles la tarea (el Runnable) 
         *    y un nombre al constructor para identificarlos en consola.
         */
        Thread hilo1 = new Thread(miTarea, "Hilo-Runnable-A");
        Thread hilo2 = new Thread(miTarea, "Hilo-Runnable-B");
        Thread hilo3 = new Thread(miTarea, "Hilo-Runnable-C");

        // 3. Solicitamos a la JVM que los ponga en ejecución concurrente
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
        System.out.println("--- El hilo principal (main) finalizó su bloque de instrucciones ---");
    }

    
}