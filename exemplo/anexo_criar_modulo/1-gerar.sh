#!/bin/bash

echo "./1-gerar.sh in/commons-lang3-3.5.jar"

echo "===========================================================+"
echo "Apagando diretórios temporários...                         |"
echo "===========================================================+"

rm -rf diretorio_trabalho_temporario 
rm -rf diretorio_saida_classe_descritora

echo "===========================================================+"
echo "Recriando diretórios temporários...                        |"
echo "===========================================================+"

mkdir diretorio_trabalho_temporario diretorio_saida_classe_descritora

echo "====================================================================================+"
echo "jdeps --generate-module-info diretorio_trabalho_temporario in/commons-lang3-3.5.jar |"
echo "====================================================================================+"

jdeps --generate-module-info diretorio_trabalho_temporario/ ./$1

echo "===========================================================+"
echo "listando classe gerada                                     |"
echo "===========================================================+"

tree diretorio_trabalho_temporario/

