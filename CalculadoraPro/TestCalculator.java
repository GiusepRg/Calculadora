// src/com/calculadora/test/TestCalculator.java
package com.calculadora.test;

import com.calculadora.operations.*;
import com.calculadora.factory.OperationFactory;
import com.calculadora.memory.MemoryManager;
import com.calculadora.service.CalculatorService;

/**
 * Clase de pruebas manuales para Calculadora Pro
 * Demuestra cómo testear la arquitectura SOLID
 * 
 * Para testing real, usar JUnit, pero aquí mostramos
 * cómo la arquitectura facilita las pruebas
 */
public class TestCalculator {
    
    public static void main(String[] args) {
        System.out.println("🧪 Ejecutando pruebas de Calculadora Pro SOLID\n");
        
        int passed = 0;
        int failed = 0;
        
        // Test 1: Operaciones básicas
        System.out.println("📝 Test 1: Operaciones Básicas");
        try {
            Calculator add = new addition();
            assert add.calculate(5, 3) == 8.0 : "Error en suma";
            
            Calculator sub = new subtraction();
            assert sub.calculate(10, 4) == 6.0 : "Error en resta";
            
            Calculator mul = new multiplication();
            assert mul.calculate(3, 7) == 21.0 : "Error en multiplicación";
            
            Calculator div = new division();
            assert div.calculate(15, 3) == 5.0 : "Error en división";
            
            System.out.println("✅ Operaciones básicas: PASSED\n");
            passed++;
        } catch (AssertionError e) {
            System.out.println("❌ Operaciones básicas: FAILED - " + e.getMessage() + "\n");
            failed++;
        }
        
        // Test 2: Operaciones avanzadas
        System.out.println("📝 Test 2: Operaciones Avanzadas");
        try {
            Calculator sqrt = new squareroot();
            assert sqrt.calculate(16) == 4.0 : "Error en raíz cuadrada";
            
            Calculator percent = new percentage();
            assert percent.calculate(50) == 0.5 : "Error en porcentaje";
            
            Calculator sign = new signchange();
            assert sign.calculate(10) == -10.0 : "Error en cambio de signo";
            
            System.out.println("✅ Operaciones avanzadas: PASSED\n");
            passed++;
        } catch (AssertionError e) {
            System.out.println("❌ Operaciones avanzadas: FAILED - " + e.getMessage() + "\n");
            failed++;
        }
        
        // Test 3: Manejo de errores
        System.out.println("📝 Test 3: Manejo de Errores");
        try {
            Calculator div = new division();
            boolean exceptionThrown = false;
            
            try {
                div.calculate(10, 0);
            } catch (ArithmeticException e) {
                exceptionThrown = true;
            }
            
            assert exceptionThrown : "Debería lanzar excepción en división por cero";
            
            Calculator sqrt = new squareroot();
            exceptionThrown = false;
            
            try {
                sqrt.calculate(-4);
            } catch (ArithmeticException e) {
                exceptionThrown = true;
            }
            
            assert exceptionThrown : "Debería lanzar excepción en raíz de negativo";
            
            System.out.println("✅ Manejo de errores: PASSED\n");
            passed++;
        } catch (AssertionError e) {
            System.out.println("❌ Manejo de errores: FAILED - " + e.getMessage() + "\n");
            failed++;
        }
        
        // Test 4: MemoryManager
        System.out.println("📝 Test 4: Gestión de Memoria");
        try {
            MemoryManager memory = new MemoryManager();
            
            assert memory.isEmpty() : "Memoria debería estar vacía";
            
            memory.add(10);
            assert memory.recall() == 10.0 : "Error al agregar a memoria";
            
            memory.add(5);
            assert memory.recall() == 15.0 : "Error al sumar a memoria";
            
            memory.subtract(3);
            assert memory.recall() == 12.0 : "Error al restar de memoria";
            
            memory.clear();
            assert memory.isEmpty() : "Memoria debería estar limpia";
            
            System.out.println("✅ Gestión de memoria: PASSED\n");
            passed++;
        } catch (AssertionError e) {
            System.out.println("❌ Gestión de memoria: FAILED - " + e.getMessage() + "\n");
            failed++;
        }
        
        // Test 5: OperationFactory (OCP)
        System.out.println("📝 Test 5: Factory Pattern (Extensibilidad)");
        try {
            OperationFactory factory = new OperationFactory();
            
            assert factory.hasOperation("+") : "Debería tener operación +";
            assert factory.hasOperation("-") : "Debería tener operación -";
            assert factory.hasOperation("sqrt") : "Debería tener operación sqrt";
            
            Calculator op = factory.getOperation("+");
            assert op.calculate(7, 3) == 10.0 : "Error al obtener operación desde factory";
            
            // Extensibilidad: agregar nueva operación sin modificar código
            factory.registerOperation("test", new Calculator() {
                @Override
                public double calculate(double... operands) {
                    return 42.0;
                }
                
                @Override
                public String getOperationName() {
                    return "Test";
                }
            });
            
            assert factory.hasOperation("test") : "Debería poder registrar nueva operación";
            
            System.out.println("✅ Factory Pattern: PASSED\n");
            passed++;
        } catch (AssertionError e) {
            System.out.println("❌ Factory Pattern: FAILED - " + e.getMessage() + "\n");
            failed++;
        }
        
        // Test 6: CalculatorService (Integración)
        System.out.println("📝 Test 6: CalculatorService (Integración)");
        try {
            OperationFactory factory = new OperationFactory();
            MemoryManager memory = new MemoryManager();
            CalculatorService service = new CalculatorService(factory, memory);
            
            double result = service.executeOperation("+", 10, 5);
            assert result == 15.0 : "Error en servicio de suma";
            
            result = service.executeOperation("*", 4, 3);
            assert result == 12.0 : "Error en servicio de multiplicación";
            
            service.memoryAdd(20);
            assert service.memoryRecall() == 20.0 : "Error en memoria del servicio";
            
            System.out.println("✅ CalculatorService: PASSED\n");
            passed++;
        } catch (AssertionError e) {
            System.out.println("❌ CalculatorService: FAILED - " + e.getMessage() + "\n");
            failed++;
        }
        
        // Test 7: Principio de Liskov (LSP)
        System.out.println("📝 Test 7: Liskov Substitution Principle");
        try {
            // Todas las operaciones deben ser intercambiables
            Calculator[] operations = {
                new addition(),
                new subtraction(),
                new multiplication(),
                new division(),
                new squareroot(),
                new percentage()
            };
            
            for (Calculator op : operations) {
                assert op.getOperationName() != null : "Todas las operaciones deben tener nombre";
                // Cada operación se puede usar polimórficamente
            }
            
            System.out.println("✅ Liskov Substitution: PASSED\n");
            passed++;
        } catch (AssertionError e) {
            System.out.println("❌ Liskov Substitution: FAILED - " + e.getMessage() + "\n");
            failed++;
        }
        
        // Resumen
        System.out.println("═══════════════════════════════════");
        System.out.println("📊 RESUMEN DE PRUEBAS");
        System.out.println("═══════════════════════════════════");
        System.out.println("✅ Pasadas: " + passed);
        System.out.println("❌ Falladas: " + failed);
        System.out.println("📈 Total: " + (passed + failed));
        
        if (failed == 0) {
            System.out.println("\n🎉 ¡Todas las pruebas pasaron exitosamente!");
            System.out.println("La arquitectura SOLID está funcionando correctamente.");
        } else {
            System.out.println("\n⚠️  Algunas pruebas fallaron. Revisa el código.");
        }
    }
}
