# /bin/bash
set -e
GREEN='\033[0;32m'

echo -e "${GREEN}Iniciando empaquetado...${NC}"
mvn clean package -DskipTests 
