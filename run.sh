#!/bin/bash

SOURCE_DIR="src"

OUTPUT_DIR="bin"

mkdir -p "$OUTPUT_DIR"

javac -d "$OUTPUT_DIR" $(find "$SOURCE_DIR" -name '*.java')

if [ $? -eq 0 ]; then
    java -cp "$OUTPUT_DIR" br.inatel.pcmania.Main
else
    echo "Erro na compilação. Verifique os arquivos .java."
    exit 1
fi