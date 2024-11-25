#!/bin/bash

# Salir inmediatamente si ocurre un error
set -e

# Colores para la salida del terminal
GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m' # Sin color

# Mensaje de inicio de compilación
echo -e "${GREEN}Iniciando la compilación y ejecución de pruebas...${NC}"

# Compilación en paralelo con 1 hilo por núcleo de CPU
mvn -T 1C clean install

# Verificar el resultado de las pruebas
if [ $? -eq 0 ]; then
    echo -e "${GREEN}Compilación y pruebas completadas exitosamente.${NC}"
else
    echo -e "${RED}Error durante la compilación o ejecución de pruebas.${NC}"
    exit 1
fi
