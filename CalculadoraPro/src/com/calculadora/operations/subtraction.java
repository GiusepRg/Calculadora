package com.calculadora.operations;

public class subtraction implements Calculator {
    @Override
    public double calculate(double... operands) {
        if (operands.length != 2) {
            throw new IllegalArgumentException("Se requieren 2 operandos");
        }
        return operands[0] - operands[1];
    }

    @Override
    public String getOperationName() {
        return "Resta";
    }
}