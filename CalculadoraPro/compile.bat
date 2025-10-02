@echo off
REM Script de compilación para Windows
REM Calculadora Pro SOLID

echo 🧮 Compilando Calculadora Pro (SOLID)...
echo.

REM Crear directorio de salida
if not exist out mkdir out

REM Compilar todas las clases
javac -d out ^
    src\com\calculadora\Main.java ^
    src\com\calculadora\operations\Calculator.java ^
    src\com\calculadora\operations\BasicOperations.java ^
    src\com\calculadora\factory\OperationFactory.java ^
    src\com\calculadora\memory\MemoryManager.java ^
    src\com\calculadora\service\CalculatorService.java ^
    src\com\calculadora\parser\InputParser.java ^
    src\com\calculadora\ui\OutputFormatter.java ^
    src\com\calculadora\ui\CLIInterface.java

if %errorlevel% equ 0 (
    echo ✅ Compilación exitosa!
    echo.
    echo Para ejecutar la aplicación usa:
    echo   run.bat
    echo.
    echo O directamente:
    echo   java -cp out com.calculadora.Main
) else (
    echo ❌ Error en la compilación
    exit /b 1
)

pause