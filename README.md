# Hoja de trabajo 6

[https://github.com/angcoder-c/HT6-ED](https://github.com/angcoder-c/HT6-ED)

# Diagrama UML de clases

![image](https://github.com/user-attachments/assets/4bfc8a6a-ed88-41f3-853a-ab9eaa5bf9a4)


# Ejecución

**Instalación**

```bash
mvn install
```

---

**Compilación**

```bash
mvn package
```

**Correr**

```bash
mvn exec:java -Dexec.mainClass="com.api.App"
```

**Test**

```bash
mvn -Dtest=AppTest test
```

**Explicación:**

Utilicé LinkedList para guardar los pokemon del usuario debido a:

- Quise probar esta implementación debido a que es practicamente igual a ArrayList, con la que ya estoy familiarizado. Quise afianzar mis conocimientos con listas enlazadas.

- Se puede ordenar la lista sólo cuando sea necesario mostrarla ordenada por tipo, sin mutar permanentemente un orden que podría no ser necesario para todas las operaciones.

- LinkedList es muy eficiente para recorrer todos los elementos secuencialmente. Ya que LinkedList usa una lista doblemente enlazada, por lo que se pueden insertar y eliminar elementos en medio de la lista eficientemente (GeeksForGeeks, 2025)

**Complejidad**

Para el ordenamiento de todos los Pokémon por su tipo, decidí usar el método `sort` de `HashMap`. En realidad, todas las colecciones de Java Collection Framework implementan el mismo algoritmo en su método `sort`, el cual es `TimSort`.

`TimSort` es un algoritmo de ordenamiento derivado de `Merge Sort` e `Insertion Sort`. Fue diseñado para proporcionar un rendimiento óptimo en datos parcialmente ordenados (GeeksForGeeks, 2023) dad en el peor de los casos es ``O(n log(n))`, mientras que en el mejor de los casos puede alcanzar `O(n)` (Helmy, 2024).


## Tabla de tiempos de ejecución

| Entradas (n) | Tiempo (ms) |
|----------------------|----------------------|
| 100  | 18.65 |
| 200  | 18.78 |
| 300  | 18.90 |
| 400  | 19.01 |
| 500  | 19.10 |
| 600  | 19.13 |
| 700  | 19.23 |
| 800  | 19.31 |
| 900  | 19.50 |

Con esto en mente, y con los tiempos registrados por el profiler al ordenar cierta cantidad de pokemons, se pudo graficar los puntos y compararlos con la línea de tendencia esperada.



Como se muestra en la figura, la mayoría de los tiempos analizados coinciden con los esperados por la línea de tendencia.

**Referencia:**

GeeksForGeeks. (enero 03 de 2025). Linked List in Java. GeeksforGeeks. [https://www.geeksforgeeks.org/linked-list-in-java/](https://www.geeksforgeeks.org/linked-list-in-java/)

GeeksForGeeks. (noviembre 20 de 2023). TimSort – Data Structures and Algorithms Tutorials.  [https://www.geeksforgeeks.org/timsort/](https://www.geeksforgeeks.org/timsort/)

Helmy, M. (2024, enero 8). *Time complexity of Java Collections sort in Java*. Recuperado de [https://www.baeldung.com/java-time-complexity-collections-sort](https://www.baeldung.com/java-time-complexity-collections-sort)