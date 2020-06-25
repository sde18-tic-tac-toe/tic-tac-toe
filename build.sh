#!/usr/bin/env sh

#     Compile the application code [*not* the test code]
#     Here, any third-party library JARs are located in lib and added to the classpath [-classpath option]
#     Remove this -classpath "lib/*" if you're not using any.
javac -d classes -classpath "lib/*" src/com/games/hangman/core/*.java src/com/games/hangman/client/*.java

#     Build the application JAR
#     This command adds the directory tree of .class files starting at 'classes', and also the entire 'data' directory.
#     The 'data' directory is included in the JAR because the application reads from files in there
jar --create --file hangman.jar -C classes . data

#     Create the Javadoc
#     The '-package' flag will include non-public classes and all class members except for private ones.
#     Again, any third-party library JARs are located in lib and added to the classpath
#     And again, remove this -classpath "lib/*" if you're not using any.
javadoc -d doc --source-path src -classpath "lib/*" -package -windowtitle Hangman com.games.hangman.core com.games.hangman.client