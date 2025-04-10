# /bin/bash
set -e

source scripts/package.sh

GREEN='\033[0;32m'
echo -e "${GREEN}Hallando y ejecutando .jar${NC}"
java -jar target/tp2-0.0.2.jar
