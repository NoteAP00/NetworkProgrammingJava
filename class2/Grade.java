import java.io.*;
public class Grade{
	public static void main(String[] args) {
		try{
		int score = Integer.parseInt(args[0]);
		if (score < 0 || score > 100){
			throw new IllegalArgumentException();
		}else if (score >= 80){
			System.out.println("A");
		} else if (score >= 70){
			System.out.println("B");
		} else if (score >= 60){
			System.out.println("C");
		} else if (score >= 50){
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		}
		catch(ArrayIndexOutOfBoundsException e){
			//Parameter missing
			System.out.println("Please enter you score");
		}
		catch(NumberFormatException e){
			//Input isn't an Integer
			System.out.println("Plese enter integer number");
		}
		catch(IllegalArgumentException e){
			//Not in length (0-100)
			System.out.println("Please enter number 0 - 100");
		}
	}
}
