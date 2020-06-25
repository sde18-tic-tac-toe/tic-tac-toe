#!/usr/bin/env sh



clear

#     Here, any third-party library JARs are located in lib and added to the classpath [-classpath option]
#     Remove this -classpath "lib/*" if you're not using any.
java -classpath tictactoe: com.tictactoe.tictactoe.client.Main