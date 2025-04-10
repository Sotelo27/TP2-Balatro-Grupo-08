# PowerShell

# Salir inmediatamente si ocurre un error
$ErrorActionPreference = "Stop"

# Colores para la salida del terminal (más compatible)
function Write-ColoredHost ($Message, $Color) {
    switch ($Color) {
        "Green" { Write-Host -ForegroundColor Green $Message }
        "Red"   { Write-Host -ForegroundColor Red $Message }
        default { Write-Host $Message }
    }
}

# Mensaje de inicio de compilación
Write-ColoredHost "Iniciando la compilación y ejecución de pruebas..." "Green"

# Compilación en paralelo con 1 hilo por núcleo de CPU
# Ejecutar el comando mvn y capturar la salida y el código de salida
mvn -T 1C compile
$exitCode = $LASTEXITCODE

# Verificar el resultado de las pruebas
if ($exitCode -eq 0) {
    Write-ColoredHost "Compilación y pruebas completadas exitosamente." "Green"
} else {
    Write-ColoredHost "Error durante la compilación o ejecución de pruebas." "Red"
    exit 1
}