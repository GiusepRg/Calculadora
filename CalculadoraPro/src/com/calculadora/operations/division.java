// src/com/calculadora/operations/Division.java
package com.calculadora.operations;

public class division implements Calculator {
    @Override
    public double calculate(double... operands) {
        if (operands.length != 2) {
            throw new IllegalArgumentException("Se requieren 2 operandos");
        }
        if (operands[1] == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        return operands[0] / operands[1];
    }

    @Override
    public String getOperationName() {
        return "División";
    }
}