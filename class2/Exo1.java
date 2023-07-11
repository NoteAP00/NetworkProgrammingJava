import java.io.*;
public class Exo1{
	public static void main(String[] args) {
		/* if(args.length != 2){
			System.out.println("Please enter 2 arguments");
			System.exit(1);
		} */
		int num1,num2;
		try{
		num1 = Integer.parseInt(args[0]);
		num2 = Integer.parseInt(args[1]);
		System.out.println("Result = " + (num1+num2));
		}
		//Error this line if args isn't int
		//Fix with try-catch
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("From try-catch : args Error");
			System.out.println("Usage : java Exo1 <num1> <num2>");
			System.exit(1);
		}
		catch(NumberFormatException ee){
			System.out.println("Num format error");
		}
		catch(Exception le){
			System.out.println("Global Error : " + le);
		} 
	}
}
