// src/com/calculadora/service/CalculatorService.java
package com.calculadora.service;

import com.calculadora.factory.OperationFactory;
import com.calculadora.memory.MemoryManager;
import com.calculadora.operations.Calculator;

/**
 * Dependency Inversion Principle (DIP)
 * Depende de abstracciones (Calculator interface) no de implementaciones concretas
 * 
 * Single Responsibility Principle (SRP)
 * Coordina las operaciones, no las implementa
 */
public class CalculatorService {
    private final OperationFactory operationFactory;
    private final MemoryManager memoryManager;

    public CalculatorService(OperationFactory operationFactory, MemoryManager memoryManager) {
        this.operationFactory = operationFactory;
        this.memoryManager = memoryManager;
    }

    public double executeOperation(String operationSymbol, double... operands) {
        Calculator operation = operationFactory.getOperation(operationSymbol);
        return operation.calculate(operands);
    }

    public boolean isOperationSupported(String symbol) {
        return operationFactory.hasOperation(symbol);
    }

    // Delegación a MemoryManager
    public void memoryClear() {
        memoryManager.clear();
    }

    public void memoryAdd(double value) {
        memoryManager.add(value);
    }

    public void memorySubtract(double value) {
        memoryManager.subtract(value);
    }

    public double memoryRecall() {
        return memoryManager.recall();
    }

    public void memoryStore(double value) {
        memoryManager.store(value);
    }
}
