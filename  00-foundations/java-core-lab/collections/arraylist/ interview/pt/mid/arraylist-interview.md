# 🎯 ArrayList Interview Guide — Mid-Level Engineer

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge\&logo=openjdk)
![Collections](https://img.shields.io/badge/Collections-Framework-blue?style=for-the-badge)
![Interview](https://img.shields.io/badge/Interview-Mid_Level-yellow?style=for-the-badge)
![Language](https://img.shields.io/badge/Language-Português-success?style=for-the-badge)
![Focus](https://img.shields.io/badge/Focus-Internals%20%26%20Tradeoffs-purple?style=for-the-badge)
![Market](https://img.shields.io/badge/Market-Brazil%20%7C%20LATAM%20%7C%20Global-red?style=for-the-badge)

</p>

---

# 👨‍💼 Objetivo deste módulo

Nesta etapa o entrevistador espera mais do que conhecimento da API.

O objetivo passa a ser avaliar:

* entendimento da implementação interna;
* conhecimento de complexidade temporal;
* capacidade de analisar trade-offs;
* entendimento de comportamento em produção;
* maturidade técnica.

---

# 📋 Pergunta 1

# Como o ArrayList é implementado internamente?

---

## 🎯 O que o entrevistador deseja avaliar

* conhecimento interno da Collections Framework;
* entendimento da implementação da JVM;
* conhecimento de estruturas de dados.

---

## ❌ Resposta fraca

> Ele usa um array.

---

## ⚠️ Resposta aceitável

> O ArrayList utiliza internamente um Object[].

---

## ✅ Resposta recomendada

> O ArrayList é implementado utilizando internamente um vetor dinâmico baseado em um `Object[]`.
>
> O objeto ArrayList mantém uma referência para esse array interno e controla atributos como:
>
> * size;
> * capacity;
> * modCount.

---

## 🏆 Resposta diferenciada

> O ArrayList desacopla a quantidade de elementos armazenados da capacidade física do array interno.
>
> Isso permite crescimento dinâmico da coleção enquanto preserva acesso aleatório O(1).

---

# 📋 Pergunta 2

# O que acontece quando a capacidade é atingida?

---

## 🎯 O que está sendo avaliado

* resize;
* realocação;
* custo computacional.

---

## ❌ Resposta fraca

> Ele aumenta sozinho.

---

## ✅ Resposta recomendada

> Quando o array interno atinge sua capacidade máxima, o ArrayList cria um novo array maior e copia os elementos existentes para esse novo bloco de memória.

---

## 🏆 Resposta diferenciada

> O crescimento normalmente segue aproximadamente:
>
> ```text
> novaCapacidade = capacidadeAtual + (capacidadeAtual >> 1)
> ```
>
> Isso equivale a um crescimento próximo de 50%.

---

## Pergunta derivada

> Por que não dobrar a capacidade?

Resposta esperada:

* menor desperdício de memória;
* equilíbrio entre realocações e consumo de heap.

---

# 📋 Pergunta 3

# Por que add() possui complexidade amortizada O(1)?

---

## 🎯 O que está sendo avaliado

* análise algorítmica;
* conhecimento matemático básico;
* amortização.

---

## ❌ Resposta fraca

> Porque inserir no final é rápido.

---

## ✅ Resposta recomendada

> A maioria das inserções ocorre sem necessidade de resize.
>
> Apenas ocasionalmente ocorre uma realocação completa do array.

---

## 🏆 Resposta diferenciada

> Embora algumas operações individuais possuam custo O(n), o custo médio distribuído ao longo de milhares de inserções aproxima-se de O(1).

---

# 📋 Pergunta 4

# Por que inserir no meio possui custo O(n)?

---

## 🎯 O que está sendo avaliado

* movimentação de memória;
* conhecimento interno da estrutura.

---

## ✅ Resposta recomendada

> Todos os elementos posteriores precisam ser deslocados uma posição para a direita.

---

## Exemplo:

```text
Antes:

[Java][Spring][Kafka][AWS]

Inserção posição 1:

[Java][Docker][Spring][Kafka][AWS]
```

Todos os elementos após o índice precisam ser copiados.

---

# 📋 Pergunta 5

# O que é modCount?

---

## 🎯 O que está sendo avaliado

* conhecimento menos superficial;
* fail-fast iterators.

---

## ✅ Resposta recomendada

> modCount é um contador interno utilizado pelo ArrayList para detectar modificações estruturais durante iteração.

---

## 🏆 Resposta diferenciada

> O Iterator compara continuamente seu expectedModCount com o modCount da coleção.
>
> Caso exista divergência, ocorre:
>
> ```text
> ConcurrentModificationException
> ```

---

# 📋 Pergunta 6

# O ArrayList é thread-safe?

---

## ❌ Resposta incorreta

> Sim.

---

## ✅ Resposta correta

> Não.
>
> O ArrayList não possui mecanismos internos de sincronização.

---

## Resposta diferenciada

> Em cenários concorrentes normalmente utilizamos:
>
> * Collections.synchronizedList();
> * CopyOnWriteArrayList;
> * estruturas concorrentes especializadas.

---

# 📋 Pergunta 7

# Qual a diferença entre tamanho e capacidade?

---

## ✅ Resposta recomendada

| Conceito | Significado                        |
| -------- | ---------------------------------- |
| Size     | Quantidade real de elementos       |
| Capacity | Espaço disponível no array interno |

---

## Exemplo

```java
ArrayList<String> list = new ArrayList<>(100);
```

```text
size = 0
capacity = 100
```

---

# 📋 Pergunta 8

# O que acontece ao executar clear()?

---

## ❌ Resposta incorreta

> O array é destruído.

---

## ✅ Resposta correta

> O método remove as referências dos elementos e redefine o size para zero.

---

## Resposta diferenciada

> O array interno normalmente permanece alocado e pode ser reutilizado em futuras inserções.

---

# 📋 Pergunta 9

# Explique o impacto de pré-definir capacidade.

---

## Resposta recomendada

> Definir a capacidade inicial reduz a quantidade de realocações e cópias de memória durante inserções massivas.

---

## Exemplo

```java
List<Integer> numbers = new ArrayList<>(1_000_000);
```

---

## Benefícios

* menos resize;
* menos GC;
* menor latência;
* melhor throughput.

---

# 🚨 Erros comuns

❌ Confundir capacidade com tamanho.

❌ Dizer que ArrayList cresce automaticamente sem entender como.

❌ Não saber explicar amortização.

❌ Acreditar que clear() libera memória imediatamente.

---

# 🎯 O que diferencia um Mid-Level forte

✅ Entende implementação interna.

✅ Conhece trade-offs.

✅ Sabe explicar complexidade.

✅ Entende resize e capacidade.

✅ Conecta teoria com produção.

---

# 📊 Critérios normalmente avaliados

| Critério                 | Peso  |
| ------------------------ | ----- |
| Collections Framework    | ⭐⭐⭐⭐⭐ |
| Complexidade Algorítmica | ⭐⭐⭐⭐⭐ |
| Internals da JVM         | ⭐⭐⭐   |
| Comunicação Técnica      | ⭐⭐⭐⭐⭐ |
| Trade-offs               | ⭐⭐⭐⭐  |

---

# 🏁 Conclusão

O nível Mid-Level marca a transição entre:

> "Eu sei usar ArrayList."

para

> "Eu entendo como ArrayList funciona internamente e consigo justificar tecnicamente sua utilização."

Essa transição é exatamente o que separa desenvolvedores operacionais de engenheiros de software mais maduros tecnicamente.
