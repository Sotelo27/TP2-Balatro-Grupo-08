#!/bin/sh

diagramsPath="diagrams"

echo 'AVERTENCIA!!!'
echo
echo "Todos los archivos '*.png' dentro de \"$diagramsPath\" serán borrados."
echo "Se regeneraran a partir de los archivos '*.plantuml'."
echo

read -t 3 -n 1 -p "Desea continuar (y/N)? " answer
[ -z "$answer" ] && answer="n"

if [ "$answer" == "y" ]
then
    find $diagramsPath -name '*.plantuml' -exec plantuml -v {} \;
fi
