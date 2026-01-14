#!/bin/zsh

# Script per avviare l'applicazione Bling con JavaFX

echo "Avvio dell'applicazione Bling..."

# Compila il progetto
mvn clean compile

# Esegue l'applicazione usando java direttamente
# Questo evita problemi noti con il plugin javafx-maven-plugin su macOS
java --module-path ~/.m2/repository/org/openjfx/javafx-controls/21/javafx-controls-21-mac.jar:~/.m2/repository/org/openjfx/javafx-base/21/javafx-base-21-mac.jar:~/.m2/repository/org/openjfx/javafx-graphics/21/javafx-graphics-21-mac.jar \
     --add-modules javafx.controls \
     -cp target/classes \
     Main

