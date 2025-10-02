#!/bin/bash

# Script de compilación para Calculadora Pro SOLID
# Creado por Giuseppe, Juliana y Tarazona

echo "🧮 Compilando Calculadora Pro (SOLID)..."
echo ""

# Crear directorio de salida
mkdir -p out

# Compilar todas las clases
javac -d out \
    src/com/calculadora/Main.java \
    src/com/calculadora/operations/Calculator.java \
    src/com/calculadora/operations/BasicOperations.java \
    src/com/calculadora/factory/OperationFactory.java \
    src/com/calculadora/memory/MemoryManager.java \
    src/com/calculadora/service/CalculatorService.java \
    src/com/calculadora/parser/InputParser.java \
    src/com/calculadora/ui/OutputFormatter.java \
    src/com/calculadora/ui/CLIInterface.java

# Verificar si la compilación fue exitosa
if [ $? -eq 0 ]; then
    echo "✅ Compilación exitosa!"
    echo ""
    echo "Para ejecutar la aplicación usa:"
    echo "  ./run.sh"
    echo ""
    echo "O directamente:"
    echo "  java -cp out com.calculadora.Main"
else
    echo "❌ Error en la compilación"
    exit 1
fi