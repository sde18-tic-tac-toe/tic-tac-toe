@echo off

rem   Compile the application code [*not* the test code]
rem   Here, any third-party library JARs are located in lib and added to the classpath [-classpath option]
rem   Remove this -classpath "lib\*" if you're not using any.
javac -d classes -classpath src\com\tictactoe\tictactoe\client\*.java src\com\tictactoe\tictactoe\game\*.java src\com\tictactoe\tictactoe\grid\*.java src\com\tictactoe\tictactoe\player\*.java

rem   Build the application JAR
rem   This command adds the directory tree of .class files starting at 'classes', and also the entire 'data' directory.
rem   The 'data' directory is included in the JAR because the application reads from files in there
jar --create --file tictactoe.jar -C classes .

rem   Create the Javadoc
rem   The '-package' flag will include non-public classes and all class members except for private ones.
rem   Again, any third-party library JARs are located in lib and added to the classpath
rem   And again, remove this -classpath "lib\*" if you're not using any.
javadoc -d doc --source-path src -classpath -package -windowtitle TicTacToe com.tictactoe.tictactoe.client com.tictactoe.tictactoe.game com.tictactoe.tictactoe.grid com.tictactoe.tictactoe.player