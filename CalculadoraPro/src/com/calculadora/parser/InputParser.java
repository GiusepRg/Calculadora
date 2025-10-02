// src/com/calculadora/parser/InputParser.java
package com.calculadora.parser;

/**
 * Single Responsibility Principle (SRP)
 * Responsable únicamente de parsear la entrada del usuario
 */
public class InputParser {
    
    public static class ParsedCommand {
        private final CommandType type;
        private final String operation;
        private final double[] operands;

        public ParsedCommand(CommandType type, String operation, double[] operands) {
            this.type = type;
            this.operation = operation;
            this.operands = operands;
        }

        public CommandType getType() { return type; }
        public String getOperation() { return operation; }
        public double[] getOperands() { return operands; }
    }

    public enum CommandType {
        CALCULATION, MEMORY, HELP, EXIT, UNKNOWN
    }

    public ParsedCommand parse(String input) {
        String[] parts = input.trim().split("\\s+");

        if (parts.length == 0 || input.isEmpty()) {
            return new ParsedCommand(CommandType.UNKNOWN, "", new double[0]);
        }

        String firstPart = parts[0].toLowerCase();

        // Comandos especiales
        if (firstPart.equals("exit") || firstPart.equals("salir")) {
            return new ParsedCommand(CommandType.EXIT, "", new double[0]);
        }

        if (firstPart.equals("help") || firstPart.equals("ayuda")) {
            return new ParsedCommand(CommandType.HELP, "", new double[0]);
        }

        // Comandos de memoria
        if (firstPart.equals("mc")) {
            return new ParsedCommand(CommandType.MEMORY, "MC", new double[0]);
        }

        if (firstPart.equals("mr")) {
            return new ParsedCommand(CommandType.MEMORY, "MR", new double[0]);
        }

        if ((firstPart.equals("m+") || firstPart.equals("m-")) && parts.length == 2) {
            try {
                double value = Double.parseDouble(parts[1]);
                return new ParsedCommand(CommandType.MEMORY, firstPart.toUpperCase(), new double[]{value});
            } catch (NumberFormatException e) {
                return new ParsedCommand(CommandType.UNKNOWN, "", new double[0]);
            }
        }

        // Operaciones unarias (sqrt, +/-)
        if (firstPart.equals("sqrt") && parts.length == 2) {
            try {
                double value = Double.parseDouble(parts[1]);
                return new ParsedCommand(CommandType.CALCULATION, "sqrt", new double[]{value});
            } catch (NumberFormatException e) {
                return new ParsedCommand(CommandType.UNKNOWN, "", new double[0]);
            }
        }

        // Operaciones binarias (12 + 5)
        if (parts.length == 3) {
            try {
                double a = Double.parseDouble(parts[0]);
                String op = parts[1];
                double b = Double.parseDouble(parts[2]);
                return new ParsedCommand(CommandType.CALCULATION, op, new double[]{a, b});
            } catch (NumberFormatException e) {
                return new ParsedCommand(CommandType.UNKNOWN, "", new double[0]);
            }
        }

        return new ParsedCommand(CommandType.UNKNOWN, "", new double[0]);
    }
}
