@echo off
title Nutrition Calculator
cd /d "%~dp0"
mode con: cols=50 lines=15
echo Compiling Nutrition Calculator...
javac *.java
echo Starting application...
java Main
pause