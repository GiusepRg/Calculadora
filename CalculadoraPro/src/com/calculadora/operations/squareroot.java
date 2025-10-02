package com.calculadora.operations;

public class squareroot implements Calculator {
    @Override
    public double calculate(double... operands) {
        if (operands.length != 1) {
            throw new IllegalArgumentException("Se requiere 1 operando");
        }
        if (operands[0] < 0) {
            throw new ArithmeticException("No se puede calcular raíz de número negativo");
        }
        return Math.sqrt(operands[0]);
    }

    @Override
    public String getOperationName() {
        return "Raíz Cuadrada";
    }
}