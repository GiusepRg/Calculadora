// src/com/calculadora/Main.java
package com.calculadora;

import com.calculadora.factory.OperationFactory;
import com.calculadora.memory.MemoryManager;
import com.calculadora.service.CalculatorService;
import com.calculadora.ui.CLIInterface;

/**
 * Dependency Inversion Principle (DIP)
 * Clase principal que ensambla las dependencias (Composition Root)
 * 
 * Aquí se realiza la inyección de dependencias manual
 */
public class Main {
    public static void main(String[] args) {
        // Crear dependencias (Dependency Injection)
        OperationFactory operationFactory = new OperationFactory();
        MemoryManager memoryManager = new MemoryManager();
        
        // Inyectar dependencias en el servicio
        CalculatorService calculatorService = new CalculatorService(
            operationFactory,
            memoryManager
        );
        
        // Inyectar servicio en la interfaz
        CLIInterface cli = new CLIInterface(calculatorService);
        
        // Iniciar aplicación
        cli.start();
    }
}
