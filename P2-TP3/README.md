Guía de Ejercicios Prácticos: Programación Funcional y Streams
Sección 1: Expresiones Lambda e Interfaces Funcionales
Objetivo: Practicar la sintaxis de las expresiones lambda y el uso de las interfaces funcionales del paquete java.util.function.

Ejercicio 1.1 (Interfaces Base): Implementa mediante expresiones lambda las cuatro interfaces funcionales principales de Java:

Crea un Predicate<Integer> que devuelva true si un número es par (usando su método test).

Crea una Function<String, Integer> que tome una cadena de texto y devuelva su longitud (usando su método apply).

Crea un Consumer<Integer> que imprima el número recibido por consola (usando su método accept).

Crea un Supplier<Double> que devuelva un número aleatorio usando Math.random() (usando su método get).

Ejercicio 1.2 (Ordenación con Comparator): Crea una List<String> con varios textos. Utiliza el método sort() pasándole una expresión lambda que implemente la interfaz Comparator para ordenar los textos según su longitud ((a, b) -> a.length() - b.length()).

Ejercicio 1.3 (Variantes Primitivas): Para evitar el uso de clases contenedoras, reemplaza la interfaz Function del Ejercicio 1.1 por su variante primitiva ToIntFunction<String> y el Predicate por IntPredicate. Llama a sus métodos respectivos.

Sección 2: Creación, Filtrado y Extracción de Datos en Streams
Objetivo: Crear flujos de datos y utilizar métodos intermedios para seleccionar y extraer información sin evaluarla hasta la operación final.

Ejercicio 2.1 (Creación y Extracción): Crea un Stream a partir de una serie de números usando Stream.of(2, 5, 3, 3, 6, 2, 4). Aplica el método distinct() para eliminar duplicados, usa skip(1) para saltarte el primer elemento y limit(3) para quedarte solo con los tres siguientes. Imprime el número total de elementos resultantes usando el método final count().

Ejercicio 2.2 (Filtrado y Procesamiento Intermedio): Crea un Stream de enteros. Aplica el método filter(s -> s > 3) para quedarte con los mayores a 3. Luego, encadena el método intermedio peek(n -> System.out.println(n)) para imprimir los valores mientras fluyen por el pipeline, y finaliza con count() para desencadenar la ejecución.

Sección 3: Transformación, Aplanamiento y Ordenación
Objetivo: Modificar los elementos del Stream y cambiar su tipo de retorno.

Ejercicio 3.1 (Transformación con Map): Dado un Stream de nombres ("Juan", "Maria", "Ana"), utiliza el método map(s -> s.toUpperCase()) para generar un nuevo Stream con los nombres en mayúsculas.

Ejercicio 3.2 (Map a tipos primitivos): Utiliza la misma lista de nombres y aplica el método mapToInt(s -> s.length()) para transformar el flujo de objetos String a un flujo primitivo IntStream. Finalmente, utiliza el método sum() para obtener la suma de todas las letras.

Ejercicio 3.3 (Aplanamiento con flatMap): Dada una lista que contenga sublistas de nombres (List<List<String>>), utiliza datos.stream() seguido de flatMap(l -> l.stream()) para aplanar las sublistas en un único Stream continuo. Cuenta cuántos nombres en total tienen más de 4 caracteres aplicando filter y luego count().

Ejercicio 3.4 (Ordenación): Crea un Stream de cadenas de texto y utiliza el método sorted() para ordenarlas por su orden natural. Luego, utiliza sorted(Comparator) pasándole una expresión lambda para ordenarlas por longitud (número de caracteres) y muéstralas con forEach().

Sección 4: Operaciones Finales y Clase Optional
Objetivo: Consumir el Stream para producir un único resultado, comprobar condiciones o recolectar datos.

Ejercicio 4.1 (Comprobaciones lógicas): Crea un Stream.of(2, 5, 7, 3, 6, 2, 3). Escribe tres sentencias independientes usando anyMatch(n -> n > 5), allMatch() y noneMatch(). Observa cómo estas operaciones finales de "cortocircuito" devuelven un valor booleano.

Ejercicio 4.2 (Búsqueda y Clase Optional): Crea un Stream de enteros, fíltralo buscando números pares (n % 2 == 0) y utiliza el método final findFirst(). Almacena el resultado en una variable de tipo Optional<Integer>. Comprueba si se encontró un valor utilizando el método isPresent() y, si es así, extráelo con get().

Ejercicio 4.3 (Reducción): Crea un flujo de números y utiliza el método reduce((a, b) -> a + b) para sumar todos sus elementos. Extrae el valor total desde el Optional que devuelve la función usando get().

Ejercicio 4.4 (Reducción a Colección): Dada una serie de números con duplicados, utiliza .distinct().collect(Collectors.toList()) para generar y devolver una List limpia. Luego, utilizando una clase Persona con un método getDni() y un método getNombre(), genera un mapa a partir de un flujo de personas usando .collect(Collectors.toMap(p -> p.getDni(), p -> p.getNombre())).