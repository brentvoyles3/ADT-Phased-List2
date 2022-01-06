#!/usr/bin/bash
javac -d bin -cp phase2.jar src/cs1302/p2/BaseStringList.java
javac -d bin -cp bin:phase2.jar src/cs1302/p2/ArrayStringList.java
javac -d bin -cp bin:phase2.jar src/cs1302/p2/LinkedStringList.java
javac -d bin -cp bin:phase2.jar src/cs1302/p2/Driver.java
check1302 src
java -cp bin:phase2.jar cs1302/p2/Driver
