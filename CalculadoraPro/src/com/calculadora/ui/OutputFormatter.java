// src/com/calculadora/ui/OutputFormatter.java
package com.calculadora.ui;

/**
 * Single Responsibility Principle (SRP)
 * Responsable únicamente de formatear la salida al usuario
 */
public class OutputFormatter {

    public String formatResult(double result) {
        // Eliminar decimales innecesarios si es un número entero
        if (result == Math.floor(result)) {
            return String.format("Resultado: %.0f", result);
        }
        return String.format("Resultado: %.4f", result);
    }

    public String formatMemory(double memory) {
        if (memory == Math.floor(memory)) {
            return String.format("Memoria: %.0f", memory);
        }
        return String.format("Memoria: %.4f", memory);
    }

    public String formatError(String message) {
        return "❌ Error: " + message;
    }

    public String formatWelcome() {
        return """
                ╔═══════════════════════════════════════╗
                ║     🧮 CALCULADORA PRO - SOLID       ║
                ║   Giuseppe, Juliana y Tarazona       ║
                ╚═══════════════════════════════════════╝
                
                Escribe 'help' para ver comandos
                Escribe 'exit' para salir
                """;
    }

    public String formatHelp() {
        return """
                📚 COMANDOS DISPONIBLES:
                
                Operaciones básicas:
                  12 + 7.5      → Suma
                  20 - 8        → Resta
                  4 * 3         → Multiplicación
                  15 / 3        → División
                  
                Operaciones especiales:
                  sqrt 16       → Raíz cuadrada
                  % 50          → Porcentaje (50/100)
                  
                Memoria:
                  M+ 10         → Sumar a memoria
                  M- 5          → Restar de memoria
                  MR            → Recordar memoria
                  MC            → Limpiar memoria
                  
                Otros:
                  help          → Mostrar esta ayuda
                  exit          → Salir
                """;
    }

    public String formatGoodbye() {
        return "👋 ¡Hasta luego! Gracias por usar Calculadora Pro.";
    }
}
