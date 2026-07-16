# 🇪🇸 Guía de Entrevista — ArrayList para Ingeniero Mid-Level

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge\&logo=openjdk)
![Nivel](https://img.shields.io/badge/Nivel-Mid_Level_Engineer-blue?style=for-the-badge)
![Entrevista](https://img.shields.io/badge/Entrevista-Internacional-success?style=for-the-badge)
![Collections](https://img.shields.io/badge/Collections-Framework-purple?style=for-the-badge)
![ArrayList](https://img.shields.io/badge/Data_Structure-ArrayList-green?style=for-the-badge)
![Idioma](https://img.shields.io/badge/Idioma-Español-red?style=for-the-badge)
![Mercado](https://img.shields.io/badge/Mercado-España%20%7C%20Latam-black?style=for-the-badge)

</p>

---

# 🎯 Objetivo

Las entrevistas para Ingeniero Mid-Level evalúan si el candidato comprende:

* implementación interna;
* complejidad computacional;
* comportamiento de memoria;
* implicaciones de rendimiento;
* trade-offs técnicos.

El entrevistador ya no busca únicamente:

> "¿Sabes utilizar ArrayList?"

Ahora busca:

> "¿Entiendes cómo funciona internamente y cuándo utilizarlo?"

---

# 📊 Criterios de Evaluación

| Categoría               | Peso  |
| ----------------------- | ----- |
| Fundamentos Java        | ⭐⭐⭐⭐⭐ |
| Complejidad Algorítmica | ⭐⭐⭐⭐⭐ |
| Implementación Interna  | ⭐⭐⭐⭐  |
| Comunicación Técnica    | ⭐⭐⭐⭐  |
| Escenarios Reales       | ⭐⭐⭐   |
| Vocabulario Técnico     | ⭐⭐⭐⭐  |

---

# 🎤 Pregunta 1

# ¿Cómo crece internamente un ArrayList?

---

## 🎯 ¿Qué se está evaluando?

* conocimiento interno del Collections Framework;
* gestión de memoria;
* estructuras dinámicas.

---

## ✅ Respuesta Esperada

> ArrayList aumenta automáticamente su capacidad cuando el arreglo interno se llena.

---

## 🚀 Respuesta Fuerte

> La JVM crea un nuevo arreglo con aproximadamente un 50% más de capacidad y copia los elementos existentes.

Ejemplo:

```text
10 → 15 → 22 → 33 → 49
```

---

## 🏆 Respuesta Excelente

> El proceso de redimensionamiento implica asignación de memoria y copia completa del arreglo utilizando `Arrays.copyOf()`.

Por ello, inicializar correctamente la capacidad puede mejorar significativamente el rendimiento.

---

## 🇧🇷 Tradução

O `ArrayList` aumenta automaticamente sua capacidade interna e realiza uma cópia dos elementos para o novo vetor.

---

# 🎤 Pregunta 2

# ¿Cuál es la diferencia entre size y capacity?

---

## ✅ Respuesta Esperada

> Size representa la cantidad actual de elementos almacenados.

> Capacity representa el tamaño del arreglo interno.

---

## 🚀 Respuesta Fuerte

Ejemplo:

```java
List<String> list = new ArrayList<>(100);
```

Resultado:

```text
size = 0
capacity = 100
```

---

## 🏆 Respuesta Excelente

> Configurar correctamente la capacidad inicial reduce realocaciones y mejora el rendimiento bajo carga elevada.

---

## 🇧🇷 Tradução

`size()` representa a quantidade de elementos e `capacity` representa o tamanho do vetor interno.

---

# 🎤 Pregunta 3

# ¿Por qué insertar al inicio tiene complejidad O(n)?

---

## ✅ Respuesta Esperada

> Porque todos los elementos posteriores deben desplazarse una posición hacia la derecha.

---

## 🚀 Respuesta Fuerte

Ejemplo:

```text
Antes:
[A][B][C]

Insertar X en índice 0

Después:
[X][A][B][C]
```

---

## 🏆 Respuesta Excelente

> El coste no es únicamente algorítmico.

También existe movimiento de memoria y pérdida de eficiencia en caché.

---

## 🇧🇷 Tradução

Inserções no início exigem deslocamento dos elementos existentes.

---

# 🎤 Pregunta 4

# ¿Cuándo especificarías una capacidad inicial?

---

## ✅ Respuesta Esperada

> Cuando el número aproximado de elementos es conocido previamente.

---

## 🚀 Respuesta Fuerte

Ejemplo:

```java
List<Order> orders = new ArrayList<>(100000);
```

---

## 🏆 Respuesta Excelente

> Preasignar capacidad reduce presión sobre el Garbage Collector y mejora el throughput.

---

## 🇧🇷 Tradução

Pré-dimensionar coleções reduz realocações e pressão no GC.

---

# 🎤 Pregunta 5

# ¿Por qué ArrayList suele superar a LinkedList en producción?

---

## ✅ Respuesta Esperada

> Debido a la localidad de caché.

---

## 🚀 Respuesta Fuerte

Los procesadores modernos están optimizados para acceso secuencial a memoria.

---

## 🏆 Respuesta Excelente

> La combinación de caché L1, L2 y mecanismos de prefetch hace que ArrayList sea más eficiente en muchos escenarios reales.

---

## 🇧🇷 Tradução

A localidade de cache é um dos maiores diferenciais do ArrayList.

---

# 🎤 Pregunta 6

# ¿Qué ocurre durante un resize?

---

## ✅ Respuesta Esperada

> Se crea un nuevo arreglo y se copian todos los elementos existentes.

---

## 🚀 Respuesta Fuerte

Internamente ocurre algo similar a:

```java
Arrays.copyOf(oldArray, newCapacity);
```

---

## 🏆 Respuesta Excelente

> El proceso genera picos temporales de uso de memoria y aumenta el trabajo del recolector de basura.

---

## 🇧🇷 Tradução

O processo de resize aumenta temporariamente o consumo de memória.

---

# 🚨 Errores Comunes

❌ Confundir capacidad con tamaño.

❌ Elegir LinkedList únicamente por complejidad teórica.

❌ Ignorar el coste del resize.

❌ No comprender el comportamiento de memoria.

---

# 🏆 ¿Qué caracteriza a un buen Ingeniero Mid-Level?

✅ Comprende las estructuras internamente.

✅ Explica trade-offs.

✅ Relaciona teoría con producción.

✅ Utiliza inglés y español técnico correctamente.

✅ Comprende implicaciones de memoria y CPU.

---

# 🌍 Vocabulario Técnico

| Español               | Portugués           | English           |
| --------------------- | ------------------- | ----------------- |
| Capacidad             | Capacidade          | Capacity          |
| Redimensionamiento    | Redimensionamento   | Resize            |
| Memoria Contigua      | Memória Contígua    | Contiguous Memory |
| Localidad de Caché    | Localidade de Cache | Cache Locality    |
| Asignación de Memoria | Alocação de Memória | Memory Allocation |
| Rendimiento           | Desempenho          | Performance       |
| Throughput            | Vazão               | Throughput        |
| Presión de Memoria    | Pressão de Memória  | Memory Pressure   |

---

# 📌 Consejo Final

Un Ingeniero Junior sabe utilizar `ArrayList`.

Un Ingeniero Mid-Level entiende:

* por qué funciona así;
* cuándo utilizarlo;
* cuándo evitarlo;
* qué ocurre internamente durante su ejecución.

Ese cambio de perspectiva es uno de los mayores saltos en la carrera de un ingeniero de software.
