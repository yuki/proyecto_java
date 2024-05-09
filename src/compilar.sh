#!/bin/bash

echo ""
echo "Se va a proceder a la compilacion"
echo "*********************************"
echo
echo
echo "Compilando las clases"
echo "javac CLASES/*.java"
javac CLASES/*.java
echo
echo
echo "Compilando la Gestora de BD"
echo "javac GESQL/Gestor.java"
javac GESQL/Gestor.java
echo
echo
echo "Compilando las excepciones"
echo "javac EXCEP/*.java"
javac EXCEP/*.java
echo
echo
echo "Compilando el entorno grafico"
echo "javac VENTANAS/*.java"
javac VENTANAS/*.java
echo
echo
echo "Compilacion terminada"
echo 
echo "Ejecute el archivo de ejecucion 'ejecutar.sh'"
echo ""
