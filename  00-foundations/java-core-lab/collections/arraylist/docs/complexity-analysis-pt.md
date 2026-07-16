# ☕ Internals de ArrayList

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge\&logo=openjdk)
![Collections](https://img.shields.io/badge/Collections-Framework-blue?style=for-the-badge)
![Data Structure](https://img.shields.io/badge/Data_Structure-Arreglo_Dinámico-green?style=for-the-badge)
![Complexity](https://img.shields.io/badge/Acceso_Aleatorio-O\(1\)-brightgreen?style=for-the-badge)
![Insertion](https://img.shields.io/badge/Inserción-O\(1\)_Amortizado-yellow?style=for-the-badge)
![Removal](https://img.shields.io/badge/Eliminación-O\(n\)-orange?style=for-the-badge)
![Interview Level](https://img.shields.io/badge/Interview-Senior%20%7C%20Staff-red?style=for-the-badge)

</p>

---

# 🎯 Objetivo

Comprender profundamente el funcionamiento interno de `ArrayList`, incluyendo:

* implementación en la JVM;
* estrategia de crecimiento;
* consumo de memoria;
* comportamiento de la CPU;
* localidad de caché;
* impacto sobre el Garbage Collector;
* escenarios reales de utilización;
* preguntas de entrevistas técnicas internacionales.

El objetivo de este documento no es solamente enseñar a utilizar la API, sino comprender los mecanismos que influyen directamente en el rendimiento, la escalabilidad y las decisiones arquitectónicas en sistemas modernos.

---

# 📚 Clases Estudiadas

## ArrayListExample.java

Responsable de demostrar:

* creación de la colección;
* inserción de elementos;
* iteración utilizando `forEach()`;
* inferencia de tipos mediante Generics.

---

## ArrayListPerformanceExample.java

Responsable de demostrar:

* inserción masiva de elementos;
* medición del acceso aleatorio;
* comportamiento de lectura en memoria;
* análisis preliminar de rendimiento.

---

# 🧪 Laboratorios Prácticos del Módulo

Este módulo será desarrollado progresivamente mediante laboratorios prácticos que simulan escenarios encontrados en sistemas distribuidos, aplicaciones cloud-native y entrevistas técnicas internacionales.

Cada laboratorio posee un objetivo específico dentro del proceso de formación de un especialista Java.

| Clase                                     | Objetivo                                                                              | Estado         |
| ----------------------------------------- | ------------------------------------------------------------------------------------- | -------------- |
| `ArrayListExample.java`                   | Introducción a ArrayList, creación de la colección e iteración utilizando `forEach()` | ✅ Implementado |
| `ArrayListPerformanceExample.java`        | Benchmark inicial utilizando `System.nanoTime()`                                      | ✅ Implementado |
| `ArrayListCapacityGrowthExample.java`     | Estudio del mecanismo de crecimiento interno y expansión de capacidad                 | 🚧 Planificado |
| `ArrayListInsertionExample.java`          | Inserciones al inicio, medio y final de la colección                                  | 🚧 Planificado |
| `ArrayListRemovalExample.java`            | Eliminación de elementos y desplazamiento interno del arreglo                         | 🚧 Planificado |
| `ArrayListIterationExample.java`          | Comparación entre `for`, `Iterator`, `ListIterator`, Streams y `forEach()`            | 🚧 Planificado |
| `ArrayListConcurrencyProblemExample.java` | Problemas de concurrencia y `ConcurrentModificationException`                         | 🚧 Planificado |
| `ArrayListMemoryExample.java`             | Consumo de memoria y comportamiento del Heap                                          | 🚧 Planificado |
| `ArrayListResizeExample.java`             | Reasignación de memoria durante el crecimiento                                        | 🚧 Planificado |
| `ArrayListCacheLocalityExample.java`      | Caché de CPU y mecanismos de prefetching                                              | 🚧 Planificado |
| `ArrayListJmhBenchmark.java`              | Benchmark profesional utilizando JMH                                                  | 🚧 Planificado |
| `ArrayListVsLinkedListBenchmark.java`     | Comparación práctica entre ArrayList y LinkedList                                     | 🚧 Planificado |
| `ArrayListGcPressureExample.java`         | Impacto sobre el Garbage Collector                                                    | 🚧 Planificado |
| `ArrayListSerializationExample.java`      | Serialización en aplicaciones distribuidas                                            | 🚧 Planificado |
| `ArrayListImmutableExample.java`          | Inmutabilidad y buenas prácticas arquitectónicas                                      | 🚧 Planificado |
| `CopyOnWriteArrayListExample.java`        | Introducción a colecciones concurrentes                                               | 🚧 Planificado |

---

# 🎯 Competencias Desarrolladas

Al finalizar todos los laboratorios, el profesional deberá dominar:

* funcionamiento interno de `ArrayList`;
* estrategias de crecimiento y reasignación;
* análisis de complejidad temporal y espacial;
* impacto de la localidad de caché;
* comportamiento del Garbage Collector;
* benchmarking profesional con JMH;
* análisis de consumo de memoria;
* problemas de concurrencia;
* decisiones arquitectónicas relacionadas con estructuras de datos;
* trade-offs entre rendimiento, memoria y escalabilidad.

---

# 🏆 Niveles Profesionales Cubiertos

| Nivel              | Competencia Esperada                                     |
| ------------------ | -------------------------------------------------------- |
| Beginner           | Utilizar correctamente la API de ArrayList               |
| Junior             | Comprender operaciones básicas y complejidad             |
| Mid-Level          | Comprender crecimiento interno y capacidad               |
| Senior             | Dominar implementación interna y rendimiento             |
| Specialist         | Comprender caché de CPU, GC y JVM                        |
| Staff Engineer     | Evaluar trade-offs arquitectónicos                       |
| Principal Engineer | Definir estándares organizacionales                      |
| Architect          | Tomar decisiones estructurales para plataformas globales |

---

# 🏗 ¿Qué es un ArrayList?

`ArrayList` es una implementación de la interfaz `List` basada en un arreglo dinámico.

Internamente, su estructura principal es extremadamente simple:

```java
transient Object[] elementData;
```

Todo el funcionamiento del `ArrayList` gira alrededor de este arreglo.

Visualmente:

```text
┌──────┬─────────────┬────────┬──────┬────────────┐
│ Java │ Spring Boot │ Kafka  │ AWS  │ Kubernetes │
└──────┴─────────────┴────────┴──────┴────────────┘
   0         1           2       3         4
```

A diferencia de una lista enlazada, todos los elementos se almacenan de forma contigua en memoria.

Esta característica tiene un enorme impacto sobre el rendimiento.

---

# 🧠 Organización en Memoria

La JVM mantiene internamente:

```text
ArrayList Object
│
├── size = 5
├── modCount = 5
│
└── elementData
    │
    ├── [0] -> "Java"
    ├── [1] -> "Spring Boot"
    ├── [2] -> "Kafka"
    ├── [3] -> "AWS"
    └── [4] -> "Kubernetes"
```

El objeto `ArrayList` no contiene directamente los elementos.

Mantiene una referencia hacia otro objeto:

```text
Object[]
```

Este arreglo almacena referencias hacia los objetos reales.

---

# ⚙ ¿Cómo Funciona el Acceso O(1)?

Cuando ejecutamos:

```java
technologies.get(3);
```

La JVM realiza aproximadamente:

```text
dirección_base + (índice × tamaño_de_la_referencia)
```

Ejemplo:

```text
base_address + (3 × 8 bytes)
```

El procesador puede calcular inmediatamente la dirección de memoria deseada.

No es necesario recorrer elementos intermedios.

Por esta razón:

```text
get(index) -> O(1)
```

---

# 📈 Complejidad Computacional

| Operación        | Complejidad     |
| ---------------- | --------------- |
| `get(index)`     | O(1)            |
| `set(index)`     | O(1)            |
| `add()` al final | O(1) amortizado |
| `add(index)`     | O(n)            |
| `remove(index)`  | O(n)            |
| `contains()`     | O(n)            |
| `indexOf()`      | O(n)            |

---

# 🚀 Crecimiento Interno

Cuando se alcanza la capacidad máxima interna, el `ArrayList` necesita crecer.

La implementación actual utiliza aproximadamente:

```text
nueva_capacidad = capacidad_actual + (capacidad_actual >> 1)
```

Es decir:

```text
10 → 15
15 → 22
22 → 33
33 → 49
```

Este crecimiento cercano al 50% reduce significativamente la cantidad de reasignaciones necesarias.

---

# 🔄 ¿Qué Ocurre Durante un Resize?

Supongamos:

```text
[Java][Spring][Kafka]
```

Capacidad actual:

```text
3
```

Al insertar un nuevo elemento:

```text
[AWS]
```

La JVM ejecuta algo similar a:

```java
Arrays.copyOf(oldArray, newCapacity);
```

Resultado:

```text
[Java][Spring][Kafka][AWS]
```

Todo el contenido debe copiarse hacia un nuevo bloque de memoria.

Este es el motivo por el cual el proceso de redimensionamiento posee complejidad O(n).

---

# 🧩 Localidad de Caché

Esta es una de las principales razones por las cuales `ArrayList` suele superar a `LinkedList`.

Los procesadores modernos utilizan:

* Caché L1
* Caché L2
* Caché L3
* Memoria RAM

La velocidad disminuye drásticamente entre estos niveles.

Como los elementos del `ArrayList` se encuentran físicamente próximos en memoria, la CPU puede precargar bloques completos utilizando mecanismos de prefetching.

Esto reduce:

* fallos de caché;
* accesos a RAM;
* latencia de memoria.

---

# ❌ ¿Por Qué LinkedList Frecuentemente Pierde?

Teóricamente:

```text
LinkedList.addFirst() -> O(1)
ArrayList.add(0) -> O(n)
```

Sin embargo, en la práctica:

```text
ArrayList suele ser más rápido.
```

Razones:

* mejor localidad de caché;
* menor presión sobre el Garbage Collector;
* menor cantidad de objetos;
* menos punteros;
* mejor aprovechamiento del prefetch de CPU.

---

# 🧪 Benchmark Actual

Código analizado:

```java
for (int i = 0; i < 1_000_000; i++) {
    numbers.add(i);
}
```

Posteriormente sustituiremos `System.nanoTime()` por:

* JMH;
* Java Flight Recorder;
* Mission Control;
* Async Profiler.

---

# 🎤 Preguntas de Entrevista

## Junior

* ¿Qué es un ArrayList?
* ¿Cuál es la diferencia entre `List` y `ArrayList`?

## Mid-Level

* ¿Cuál es la complejidad de las operaciones principales?
* ¿Cómo funciona el crecimiento interno?

## Senior

* Explique el funcionamiento interno de `Arrays.copyOf()`.
* ¿Por qué `get(index)` es O(1)?

## Specialist

* ¿Cómo influye la localidad de caché sobre el rendimiento?
* ¿Cuál es el impacto sobre el Garbage Collector?

## Staff Engineer

* ¿Cómo influye la elección de una estructura de datos sobre el throughput y la latencia en sistemas distribuidos?

## Architect

* ¿Cómo pueden decisiones aparentemente simples sobre estructuras de datos impactar los costes operativos en entornos cloud de gran escala?

---

# 🌎 Vocabulario Técnico

| Español               | Português           | English            |
| --------------------- | ------------------- | ------------------ |
| Arreglo Dinámico      | Vetor Dinâmico      | Dynamic Array      |
| Recolección de Basura | Coleta de Lixo      | Garbage Collection |
| Localidad de Caché    | Localidade de Cache | Cache Locality     |
| Acceso Aleatorio      | Acesso Aleatório    | Random Access      |
| Reasignación          | Realocação          | Reallocation       |

---

# 📌 Conclusión

`ArrayList` es una de las estructuras de datos más utilizadas del ecosistema Java moderno y continúa siendo la elección predeterminada para la mayoría de escenarios de lectura intensiva e iteración frecuente.

Comprender su funcionamiento interno constituye una de las bases fundamentales para evolucionar desde desarrollador Java hacia especialista en JVM, rendimiento y arquitectura de software.
