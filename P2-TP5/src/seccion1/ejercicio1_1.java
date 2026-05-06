package seccion1;

/**
 * Clase de la Sección 1 - Ejercicio 1.1: Extendiendo la clase Thread.
 * - El objetivo es comprender la creación de hilos (threads) en Java 
 *   heredando de la clase Thread e invocando el método start() para
 *   lograr la ejecución concurrente.
 */
public class ejercicio1_1 {


    /**
     * Clase interna estática que hereda de Thread para definir una tarea concurrente.
     */
    static class TareaHilo extends Thread {
        
        private String nombreTarea;

        public TareaHilo(String nombreTarea) {
            this.nombreTarea = nombreTarea;
        }

        /*
         * Se sobrescribe el método run() para definir el código que 
         * ejecutará este hilo específico.
         */
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(nombreTarea + " imprimiendo el número: " + i);
            }
        }
    }

    public static void main(String[] args) {
        
        System.out.println("--- Iniciando hilos concurrentes ---");

        // Instanciamos tres hilos diferentes y les pasamos un nombre para identificarlos
        TareaHilo hilo1 = new TareaHilo("Hilo-A");
        TareaHilo hilo2 = new TareaHilo("Hilo-B");
        TareaHilo hilo3 = new TareaHilo("Hilo-C");

        /*
         * Invocamos start() en lugar de run(). 
         * Esto inicia un nuevo hilo de ejecución para cada instancia. 
         * El orden en que se verán las impresiones en consola será impredecible, ya que el planificador del SO reparte el tiempo de CPU entre ellos.
         */
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
        System.out.println("--- El hilo principal (main) ha terminado de lanzar los hilos ---");
    }

}