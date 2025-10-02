# 🧮 Calculadora Pro — Proyecto Final

> Una calculadora simple y funcional desarrollada **solo en Java**.
> Hecha por **Giuseppe**, **Juliana** y **Tarazona**.

---

![calculadora-banner](./assets/banner.svg)

# Descripción

Calculadora Pro es una aplicación Java ligera para realizar operaciones aritméticas básicas y algunas utilidades prácticas (porcentaje, raíz cuadrada, cambio de signo y memoria). Pensada para usarse desde la consola o como base para una futura GUI, pero ahora **solo Java**, sin frameworks ni herramientas externas.

# Características principales

* Sumas, restas, multiplicaciones y divisiones.
* Punto decimal.
* Porcentaje (`%`), raíz cuadrada (`sqrt`), cambio de signo (`+/-`).
* Memoria simple: `M+`, `M-`, `MR`, `MC`.
* Lógica separada en clases para facilitar lectura y mantenimiento.
* Uso sencillo desde consola (no requiere Maven/Gradle).

# Tecnologías

* Java 11+ (funciona con Java 17 también)

# Estructura del proyecto (sugerida)

```
calculadora-pro/
├─ assets/
│  └─ banner.svg
├─ src/
│  └─ com/
│     └─ calculadora/
│        ├─ Calculator.java   <-- lógica
│        └─ Main.java         <-- launcher CLI
├─ README.md
└─ LICENSE
```

# Código mínimo (lista para copiar)

```java
// src/com/calculadora/Calculator.java
package com.calculadora;

public class Calculator {
    private double memory = 0.0;

    public double add(double a, double b) { return a + b; }
    public double sub(double a, double b) { return a - b; }
    public double mul(double a, double b) { return a * b; }
    public double div(double a, double b) {
        if (b == 0) throw new ArithmeticException("División por cero");
        return a / b;
    }

    public double percent(double value) { return value / 100.0; }
    public double sqrt(double value) {
        if (value < 0) throw new ArithmeticException("Raíz de número negativo");
        return Math.sqrt(value);
    }
    public double changeSign(double value) { return -value; }

    // memoria
    public void memoryClear() { memory = 0.0; }
    public void memoryAdd(double v) { memory += v; }
    public void memorySub(double v) { memory -= v; }
    public double memoryRecall() { return memory; }
}
```

```java
// src/com/calculadora/Main.java
package com.calculadora;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);
        System.out.println("Calculadora Pro (CLI) — escribe 'help' para comandos, 'exit' para salir.");
        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            if (line.equalsIgnoreCase("exit")) break;
            if (line.equalsIgnoreCase("help")) {
                System.out.println("Ejemplos:\n 12 + 7.5\n sqrt 9\n M+ 5\n MR\n MC\n exit");
                continue;
            }
            try {
                String[] parts = line.split("\\s+");
                if (parts[0].equalsIgnoreCase("sqrt") && parts.length==2) {
                    double x = Double.parseDouble(parts[1]);
                    System.out.println("Resultado: " + calc.sqrt(x));
                } else if ((parts[0].equalsIgnoreCase("M+") || parts[0].equalsIgnoreCase("M-")) && parts.length==2) {
                    double x = Double.parseDouble(parts[1]);
                    if (parts[0].equalsIgnoreCase("M+")) calc.memoryAdd(x); else calc.memorySub(x);
                    System.out.println("Memoria: " + calc.memoryRecall());
                } else if (parts[0].equalsIgnoreCase("MR")) {
                    System.out.println("Memoria: " + calc.memoryRecall());
                } else if (parts[0].equalsIgnoreCase("MC")) {
                    calc.memoryClear();
                    System.out.println("Memoria limpiada.");
                } else if (parts.length==3) {
                    double a = Double.parseDouble(parts[0]);
                    String op = parts[1];
                    double b = Double.parseDouble(parts[2]);
                    double res;
                    switch(op) {
                        case "+": res = calc.add(a,b); break;
                        case "-": res = calc.sub(a,b); break;
                        case "*": res = calc.mul(a,b); break;
                        case "/": res = calc.div(a,b); break;
                        case "%": res = calc.percent(b); break;
                        default: throw new IllegalArgumentException("Operador no soportado");
                    }
                    System.out.println("Resultado: " + res);
                } else {
                    System.out.println("Entrada no reconocida. Usa 'help' para ver ejemplos.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
        System.out.println("Adiós 👋");
    }
}
```

# Compilar y ejecutar (sin herramientas externas)

Abre terminal en la carpeta raíz del proyecto:

```bash
# compilar
javac -d out src/com/calculadora/*.java

# ejecutar
java -cp out com.calculadora.Main
```

(Esto crea la carpeta `out` con las clases y ejecuta la aplicación CLI.)

# Uso (ejemplo)

```
> 12 + 7.5
Resultado: 19.5

> M+ 10
Memoria: 10.0

> MR
Memoria: 10.0

> sqrt 16
Resultado: 4.0
```

# Buenas prácticas que seguimos

* Lógica separada de la interfaz.
* Manejo simple de excepciones (división por cero, raíz de negativo).
* Código legible y fácil de extender.

# Roles del equipo

* **Giuseppe** — diseño y estructura del proyecto
* **Juliana** — lógica y validaciones (Calculator.java)
* **Tarazona** — pruebas manuales y empaquetado

# Cómo contribuir (rápido)

1. Fork / clona el repo.
2. Crea rama: `git checkout -b feat/nombre`
3. Haz cambios y PR con descripción clara.

# Licencia

Proyecto bajo **MIT**. 
---
