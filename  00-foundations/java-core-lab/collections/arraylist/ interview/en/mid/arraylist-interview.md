# 🇺🇸 ArrayList Interview Guide — Mid-Level Engineer

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge\&logo=openjdk)
![Level](https://img.shields.io/badge/Level-Mid_Level_Engineer-blue?style=for-the-badge)
![Interview](https://img.shields.io/badge/Interview-International-success?style=for-the-badge)
![Collections](https://img.shields.io/badge/Topic-Collections_Framework-purple?style=for-the-badge)
![ArrayList](https://img.shields.io/badge/Data_Structure-ArrayList-green?style=for-the-badge)
![Language](https://img.shields.io/badge/Language-English-red?style=for-the-badge)
![Target](https://img.shields.io/badge/Target-Global_Market-black?style=for-the-badge)

</p>

---

# 🎯 Purpose

Mid-level interviews evaluate whether the engineer understands not only how to use `ArrayList`, but also:

* internal implementation details;
* computational complexity;
* practical trade-offs;
* performance implications;
* production use cases.

---

# 🎤 Question 1

# How does ArrayList grow internally?

---

## 🎯 What is being evaluated?

* internal JVM knowledge;
* understanding of dynamic arrays;
* memory management concepts.

---

## ✅ Expected Answer

> ArrayList automatically increases its internal capacity when the current array becomes full.

---

## 🚀 Strong Answer

> The JVM allocates a new array with approximately 50% more capacity and copies existing elements into the new memory region.

Example:

```text
10 → 15 → 22 → 33 → 49
```

---

## 🏆 Exceptional Answer

> Resizing is an expensive operation because it requires memory allocation and a full copy of the existing array using `Arrays.copyOf()`.

Because of this, pre-sizing collections can significantly improve performance in high-throughput systems.

---

## 🇧🇷 Tradução

O `ArrayList` aumenta automaticamente sua capacidade interna quando o vetor atual fica cheio.

Durante esse processo ocorre:

* alocação de novo bloco de memória;
* cópia dos elementos existentes;
* descarte do vetor antigo para o Garbage Collector.

---

# 🎤 Question 2

# Why is insertion at the beginning an O(n) operation?

---

## ✅ Expected Answer

> Because all subsequent elements must be shifted to the right.

---

## 🚀 Strong Answer

Example:

```text
Before:
[A][B][C]

Insert X at index 0

After:
[X][A][B][C]
```

---

## 🏆 Exceptional Answer

> The cost is not only algorithmic complexity.
>
> Memory movement also affects CPU cache efficiency and garbage collection behavior.

---

## 🇧🇷 Tradução

Inserções no início exigem deslocamento dos elementos existentes, tornando a operação O(n).

---

# 🎤 Question 3

# What is the difference between capacity and size?

---

## ✅ Expected Answer

> Size represents the number of elements currently stored.

> Capacity represents the size of the internal array.

---

## 🚀 Strong Answer

Example:

```java
List<String> list = new ArrayList<>(100);
```

Result:

```text
size = 0
capacity = 100
```

---

## 🏆 Exceptional Answer

> Proper capacity sizing can reduce memory reallocations and improve throughput under heavy workloads.

---

## 🇧🇷 Tradução

* `size()` → quantidade de elementos armazenados.
* capacidade → tamanho atual do vetor interno.

---

# 🎤 Question 4

# When should you specify an initial capacity?

---

## ✅ Expected Answer

> When the approximate number of elements is already known.

---

## 🚀 Strong Answer

Example:

```java
List<Order> orders = new ArrayList<>(100000);
```

---

## 🏆 Exceptional Answer

> Pre-sizing large collections reduces allocation pressure and improves GC efficiency.

---

## 🇧🇷 Tradução

Definir capacidade inicial reduz realocações e melhora performance em sistemas de alta carga.

---

# 🎤 Question 5

# Why does ArrayList usually outperform LinkedList?

---

## ✅ Expected Answer

> Because ArrayList provides better cache locality.

---

## 🚀 Strong Answer

Modern CPUs are optimized for sequential memory access.

---

## 🏆 Exceptional Answer

> CPU cache hierarchy and hardware prefetching often make ArrayList faster even in operations where LinkedList has better theoretical complexity.

---

## 🇧🇷 Tradução

A localidade de cache é um dos principais motivos pelos quais `ArrayList` costuma ser mais rápido na prática.

---

# 🚨 Common Mistakes

❌ Confusing size with capacity.

❌ Ignoring resize costs.

❌ Choosing LinkedList based only on Big-O analysis.

❌ Ignoring memory behavior.

---

# 🏆 What makes a strong Mid-Level Engineer?

✅ Understands internals.

✅ Explains trade-offs.

✅ Connects theory with production scenarios.

✅ Uses technical English naturally.

✅ Understands JVM implications.

---

# 🌍 Technical Vocabulary

| English           | Português            |
| ----------------- | -------------------- |
| Capacity          | Capacidade           |
| Resize            | Redimensionamento    |
| Memory Allocation | Alocação de Memória  |
| Contiguous Memory | Memória Contígua     |
| Cache Locality    | Localidade de Cache  |
| Throughput        | Vazão                |
| Memory Pressure   | Pressão de Memória   |
| Dynamic Growth    | Crescimento Dinâmico |

---

# 📌 Final Advice

Junior engineers know how to use `ArrayList`.

Mid-level engineers understand:

* why it behaves the way it does;
* when to use it;
* when not to use it;
* what happens inside the JVM during execution.

That transition from API knowledge to implementation understanding is one of the biggest milestones in a software engineer's career.
