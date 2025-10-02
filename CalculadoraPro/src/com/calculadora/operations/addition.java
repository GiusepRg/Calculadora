package com.calculadora.operations;

public class addition implements Calculator {
    
    @Override
    public double calculate(double... operands) {
        if (operands.length != 2) {
            throw new IllegalArgumentException("Se requieren 2 operandos para la suma");
        }
        return operands[0] + operands[1];
    }

    @Override
    public String getOperationName() {
        return "Suma";
    }
}
