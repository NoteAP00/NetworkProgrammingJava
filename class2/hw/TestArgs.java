import java.io.*;
public class TestArgs{
        public static void main(String[] args) {
                try{
                double num1 = Double.parseDouble(args[0]);
                double num2 = Double.parseDouble(args[1]);
                System.out.println(num1 + " x " + num2 + " = " + (num1*num2));
                }
                catch(NumberFormatException en){
                        System.out.println("Usage : java TestArgs <number1> <number2>");
                }
 		catch(ArrayIndexOutOfBoundsException ea){
                        System.out.println("Usage : java TestArgs <number1> <number2>");
            }
        	}
}
