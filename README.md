# 🧮 Calculadora Pro

> **Trabajo para:** Análisis y Diseño de Sistemas — 2.º semestre, Ingeniería de Sistemas e Informática — UPB
> **Equipo:** Giuseppe · Juliana · Tarazona

---

![calculadora-banner](./assets/banner.svg)

---

## ✨ Un poco sobre el proyecto

**Calculadora Pro** es una calculadora hecha **solo en Java**, pensada para práctica académica: código limpio, modular y con **los 5 principios SOLID** aplicados. Ideal para presentar en la asignatura y demostrar diseño, tests y buenas prácticas.

---

## 🌟 ¿Por qué es especial?

* Código modular y fácil de entender (ideal para nota y revisión).
* Diseñada para extender sin romper lo que ya funciona.
* CLI simple, clara y con memoria integrada.
* No usa librerías externas: **Java puro** (fácil de compilar y entregar).
* Pensada para estudiantes: explicaciones claras y ejemplos listos.

---

## 🚀 Características principales

* ✅ Suma, resta, multiplicación, división
* ✅ Raíz cuadrada (`sqrt`), porcentaje (`%`), cambio de signo (`+/-`)
* ✅ Memoria: `M+`, `M-`, `MR`, `MC`
* ✅ CLI intuitiva (mensajes claros y ejemplos)
* ✅ Arquitectura SOLID: SRP, OCP, LSP, ISP, DIP

---

## 🧭 Comandos / Ejemplos (usa en la terminal)

```text
> 12 + 7.5
Resultado: 19.5

> sqrt 16
Resultado: 4

> M+ 10
Memoria: 10

> MR
Memoria: 10

> M- 3
Memoria: 7

> MC
✓ Memoria limpiada

> help
Lista de comandos disponibles...

> exit
👋 ¡Hasta luego!
```

---

## 🏗 Estructura (simple y ordenada)

```
calculadora-pro/
├─ src/com/calculadora/
│  ├─ Main.java
│  ├─ operations/
│  │  ├─ Calculator.java
│  │  ├─ Addition.java
│  │  └─ ...
│  ├─ factory/ OperationFactory.java
│  ├─ memory/  MemoryManager.java
│  ├─ parser/  InputParser.java
│  └─ ui/      CLIInterface.java
```

---

## 🔧 Compilar y ejecutar

Requisitos: **Java 11+**

```bash
# compilar (desde la raíz del proyecto)
javac -d out src/com/calculadora/*.java \
              src/com/calculadora/operations/*.java \
              src/com/calculadora/factory/*.java \
              src/com/calculadora/memory/*.java \
              src/com/calculadora/parser/*.java \
              src/com/calculadora/ui/*.java

# ejecutar
java -cp out com.calculadora.Main
```

> Tip: si usas Windows, ajusta las barras o crea `compile.bat` y `run.bat` con estos comandos.

---

## 🧪 Testing

* Escribe tests unitarios para las operaciones con JUnit (por ejemplo `AdditionTest`, `DivisionTest`).
* Prueba casos de error: división por cero, raíz de negativo, entradas inválidas.

Ejemplo rápido de test (concepto):

```java
@Test
public void additionWorks() {
    Calculator add = new Addition();
    assertEquals(8.0, add.calculate(5, 3), 0.001);
}
```

---

## 👥 Roles (Trabajo académico)

| Integrante | Rol (Análisis y Diseño de Sistemas)          |
| ---------- | -------------------------------------------- |
| Giuseppe   | Arquitectura y organización del proyecto     |
| Juliana    | Implementación de operaciones y validaciones |
| Tarazona   | Interfaz CLI, parser y pruebas               |

---

## 🛠 Cómo añadir una operación 

1. Crear clase que implemente `Calculator`.
2. Registrar en `OperationFactory` (ej.: `operationFactory.registerOperation("^", new Power())`).
3. Probar desde CLI — sin tocar código existente.

---
| Integrante | Rol | Foto |
|---:|:--|:---|
| Giuseppe | Arquitectura y organización del proyecto | ![Giuseppe](./assets/team/giuseppe.jpg) |
| Juliana  | Implementación de operaciones y validaciones | ![Juliana](./assets/team/juliana.jpg) |
## 📜 Licencia

Este proyecto usa **MIT License**. Consulta la licencia completa: [LICENSE](./LICENSE.txt)


```text
MIT License
Copyright (c) 2025 Giuseppe, Juliana y Tarazona
...
```

---


