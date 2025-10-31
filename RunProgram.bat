@echo off
cd /d "%~dp0"
echo Compiling Nutrition Calculator...
javac *.java
echo Starting application...
java Main
pause