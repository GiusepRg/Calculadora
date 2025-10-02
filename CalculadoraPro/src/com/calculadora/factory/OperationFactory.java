package com.calculadora.factory;

import com.calculadora.operations.*;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {
    private final Map<String, Calculator> operations;

    public OperationFactory() {
        operations = new HashMap<>();
        registerDefaultOperations();
    }

    private void registerDefaultOperations() {
        operations.put("+", new addition());
        operations.put("-", new subtraction());
        operations.put("*", new multiplication());
        operations.put("/", new division());
        operations.put("%", new percentage());
        operations.put("sqrt", new squareroot());
        operations.put("+/-", new signchange());
    }

    public void registerOperation(String symbol, Calculator operation) {
        operations.put(symbol, operation);
    }

    public Calculator getOperation(String symbol) {
        Calculator op = operations.get(symbol);
        if (op == null) {
            throw new IllegalArgumentException("Operación no soportada: " + symbol);
        }
        return op;
    }

    public boolean hasOperation(String symbol) {
        return operations.containsKey(symbol);
    }
}
