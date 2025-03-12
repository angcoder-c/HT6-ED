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

**Referencia:**

GeeksForGeeks. (2025, enero 03). Linked List in Java. GeeksforGeeks. https://www.geeksforgeeks.org/linked-list-in-java/