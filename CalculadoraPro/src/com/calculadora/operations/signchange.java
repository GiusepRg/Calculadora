package com.calculadora.operations;

public class signchange implements Calculator {
    @Override
    public double calculate(double... operands) {
        if (operands.length != 1) {
            throw new IllegalArgumentException("Se requiere 1 operando");
        }
        return -operands[0];
    }

    @Override
    public String getOperationName() {
        return "Cambio de Signo";
    }
}