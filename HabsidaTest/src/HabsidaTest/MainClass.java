package HabsidaTest;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws ExceptionOfInput {
		String userInput;
		System.out.println("Enter your arithmetic expression");
		Scanner sc = new Scanner(System.in);
		userInput = sc.nextLine();
		String clearInput = userInput.replaceAll(" ", "");
		CheckInput ci = new CheckInput(clearInput);
		if (ci.toCheck()) {
			throw new ExceptionOfInput("Incorrect input");
		} else if (ci.howManySigns == 1){
			Calc1Sign c1 = new Calc1Sign(clearInput);
			System.out.println("Result: " + c1.toCalc1());
		} else {
			Calc2Signs c2 = new Calc2Signs(clearInput);
			System.out.println("Result: " + c2.toCalc2());
		}
	}

}
