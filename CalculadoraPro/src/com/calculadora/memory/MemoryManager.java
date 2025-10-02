// src/com/calculadora/memory/MemoryManager.java
package com.calculadora.memory;

/**
 * Single Responsibility Principle (SRP)
 * Clase dedicada únicamente a gestionar la memoria de la calculadora
 */
public class MemoryManager {
    private double memory;

    public MemoryManager() {
        this.memory = 0.0;
    }

    public void clear() {
        memory = 0.0;
    }

    public void add(double value) {
        memory += value;
    }

    public void subtract(double value) {
        memory -= value;
    }

    public double recall() {
        return memory;
    }

    public void store(double value) {
        memory = value;
    }

    public boolean isEmpty() {
        return memory == 0.0;
    }
}
