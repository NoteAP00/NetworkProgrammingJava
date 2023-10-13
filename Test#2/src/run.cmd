@echo off

javac readMath.java
javac arr2dMake.java
echo Test 1 :
java arr2dMake 1.txt
java readMath 1.txt 
echo Test 2 :
java arr2dMake 2.txt
java readMath 2.txt
echo Test 3 :
java arr2dMake 3.txt
java readMath 3.txt
echo Test 4 :
java arr2dMake 4.txt
java readMath 4.txt
echo Test 5 :
java arr2dMake 5.txt
java readMath 5.txt

pause