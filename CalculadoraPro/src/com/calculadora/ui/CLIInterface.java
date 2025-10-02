// src/com/calculadora/ui/CLIInterface.java
package com.calculadora.ui;

import com.calculadora.parser.InputParser;
import com.calculadora.parser.InputParser.ParsedCommand;
import com.calculadora.service.CalculatorService;

import java.util.Scanner;

/**
 * Single Responsibility Principle (SRP)
 * Responsable únicamente de la interacción con el usuario por consola
 * 
 * Dependency Inversion Principle (DIP)
 * Depende de abstracciones (CalculatorService) no de implementaciones
 */
public class CLIInterface {
    private final CalculatorService calculatorService;
    private final InputParser parser;
    private final OutputFormatter formatter;
    private final Scanner scanner;

    public CLIInterface(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
        this.parser = new InputParser();
        this.formatter = new OutputFormatter();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println(formatter.formatWelcome());

        boolean running = true;
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                continue;
            }

            ParsedCommand command = parser.parse(input);

            try {
                switch (command.getType()) {
                    case EXIT:
                        running = false;
                        System.out.println(formatter.formatGoodbye());
                        break;

                    case HELP:
                        System.out.println(formatter.formatHelp());
                        break;

                    case MEMORY:
                        handleMemoryCommand(command);
                        break;

                    case CALCULATION:
                        handleCalculation(command);
                        break;

                    case UNKNOWN:
                        System.out.println(formatter.formatError("Comando no reconocido. Usa 'help' para ver ejemplos."));
                        break;
                }
            } catch (Exception e) {
                System.out.println(formatter.formatError(e.getMessage()));
            }
        }

        scanner.close();
    }

    private void handleCalculation(ParsedCommand command) {
        double result = calculatorService.executeOperation(
            command.getOperation(),
            command.getOperands()
        );
        System.out.println(formatter.formatResult(result));
    }

    private void handleMemoryCommand(ParsedCommand command) {
        String operation = command.getOperation();
        
        switch (operation) {
            case "MC":
                calculatorService.memoryClear();
                System.out.println("✓ Memoria limpiada");
                break;

            case "MR":
                double memory = calculatorService.memoryRecall();
                System.out.println(formatter.formatMemory(memory));
                break;

            case "M+":
                calculatorService.memoryAdd(command.getOperands()[0]);
                System.out.println(formatter.formatMemory(calculatorService.memoryRecall()));
                break;

            case "M-":
                calculatorService.memorySubtract(command.getOperands()[0]);
                System.out.println(formatter.formatMemory(calculatorService.memoryRecall()));
                break;
        }
    }
}
