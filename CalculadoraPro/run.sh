#!/bin/bash

# Script de ejecución para Calculadora Pro SOLID
# Creado por Giuseppe, Juliana y Tarazona

# Verificar si existe el directorio out
if [ ! -d "out" ]; then
    echo "⚠️  No se encontró el directorio 'out'"
    echo "Ejecuta primero: ./compile.sh"
    exit 1
fi

# Ejecutar la aplicación
echo "🚀 Iniciando Calculadora Pro..."
echo ""
java -cp out com.calculadora.Main