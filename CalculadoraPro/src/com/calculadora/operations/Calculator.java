// src/com/calculadora/operations/Calculator.java
package com.calculadora.operations;

/**
 * Interface Segregation Principle (ISP)
 * Interfaz base para todas las operaciones de la calculadora
 */
public interface Calculator {
    double calculate(double... operands);
    String getOperationName();
}
