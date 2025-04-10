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

Write-ColoredHost "Empaquetando programa..." "Green"
mvn clean package 