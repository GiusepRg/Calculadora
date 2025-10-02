@echo off
REM Script de ejecución para Windows
REM Calculadora Pro SOLID

REM Verificar si existe el directorio out
if not exist out (
    echo ⚠️ No se encontró el directorio 'out'
    echo Ejecuta primero: compile.bat
    pause
    exit /b 1
)

REM Ejecutar la aplicación
echo 🚀 Iniciando Calculadora Pro...
echo.
java -cp out com.calculadora.Main

pause