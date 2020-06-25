@echo off

title Hangman

clear

rem   Here, any third-party library JARs are located in lib and added to the classpath [-classpath option]
rem   Remove this -classpath "lib\*" if you're not using any.
java -classpath hangman.jar;"lib\*" com.games.hangman.client.Main