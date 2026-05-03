package seccion_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Corresponde al Ejercicio 4.1: Manejo de archivos con try-with-resources.
 *
 * El objetivo es evidenciar cómo Java cierra automáticamente los recursos de E/S
 * (Entrada/Salida) que implementan la interfaz AutoCloseable o Closeable, 
 * resultando en un código más limpio y seguro sin necesidad de un bloque finally.
 */
public class ejercicio_4_1 {

    /**
     * Método principal que ejecuta la lectura del archivo.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("--- Iniciando lectura del archivo personas.txt ---");
        
        /*
         * El bloque try-with-resources declara e inicializa el BufferedReader.
         * Al estar entre los paréntesis del try, Java se encarga de invocar automáticamente su método close() al finalizar el bloque, ya sea porque terminó de leer exitosamente o porque ocurrió una excepción.
         */
        try (BufferedReader br = new BufferedReader(new FileReader("personas.txt"))) {
            
            String linea;
            int numeroLinea = 1;
            
            // Se lee el archivo línea por línea hasta llegar al final (null)
            while ((linea = br.readLine()) != null) {
                System.out.println("Línea " + numeroLinea + ": " + linea);
                numeroLinea++;
            }
            
            System.out.println("--- Lectura finalizada con éxito ---");

        } catch (IOException e) {
            /*
             * El bloque catch captura cualquier problema relacionado con la Entrada/Salida,
             * por ejemplo: que el archivo no exista, que no haya permisos de lectura, etc.
             */
            System.out.println("Error crítico: No se pudo procesar el archivo.");
            System.out.println("Detalle del sistema: " + e.getMessage());
        }
    }
}