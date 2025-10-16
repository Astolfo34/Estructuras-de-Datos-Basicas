#!/bin/bash

# Script para inicializar el repositorio Git y subirlo a GitHub

echo "=== Script para subir el proyecto a GitHub ==="
echo

# Verificar si git está instalado
if ! command -v git &> /dev/null
then
    echo "Git no está instalado. Por favor, instala Git primero."
    exit 1
fi

# Navegar al directorio del proyecto
cd "/home/sebas_jsdv/Documentos/PROYECTO SFW 3/ProyectoDevopsColaborativo/TallerAlgoritmos_EstructurasDatos"

echo "1. Verificando el estado actual del repositorio..."
echo
git status
echo

echo "2. Añadiendo todos los archivos al staging area..."
echo
git add .
echo

echo "3. Haciendo commit de los cambios..."
echo
git commit -m "Initial commit: Implementación de listas enlazadas simples y doblemente enlazadas"
echo

echo "4. Para subir a un repositorio remoto, sigue estos pasos:"
echo
echo "   a. Crea un nuevo repositorio en GitHub (no inicialices con README)"
echo "   b. Copia la URL del repositorio (por ejemplo: https://github.com/tu_usuario/nombre_repo.git)"
echo "   c. Ejecuta los siguientes comandos:"
echo
echo "      git remote add origin <URL_DEL_REPOSITORIO>"
echo "      git branch -M main"
echo "      git push -u origin main"
echo
echo "¡Listo! Tu proyecto ha sido preparado para subir a GitHub."
echo "Recuerda reemplazar <URL_DEL_REPOSITORIO> con la URL real de tu repositorio en GitHub."