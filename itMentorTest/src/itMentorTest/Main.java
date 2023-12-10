package itMentorTest;

import java.util.Scanner;

public class Main {
 
	static int ordSign;
	static String theSign;
	static Integer n0;
	static Integer n1;
	static String[] twoNumbers = new String[2];
	public static void main(String[] args) throws TestException {
		String userInput;
		System.out.println("Enter your arithmetic expression");
		Scanner sc = new Scanner(System.in);
		userInput = sc.nextLine();
		String clearInput = userInput.replaceAll(" ", "");
		if (checkInput(clearInput)) {
			throw new TestException("Incorrect input");
		} else {
			System.out.println("Result: " + calc(n0, n1,  theSign));
		}
	}
	
	private static boolean checkInput(String input) {
		int lng = input.length();
		int chk = 0;
		for (int i = 0; i < lng; i++) {
			int codeOfLet = (int)input.charAt(i);
			if ((codeOfLet < 42)||(codeOfLet > 57)) {
				System.out.println("Unacceptable symbols");
				return true;
			}
			if ((codeOfLet == 44)||(codeOfLet == 46)) {
				System.out.println("Unacceptable symbols");
				return true;
			}
			if (codeOfLet < 48) {
				chk += codeOfLet;
				ordSign = chk;
			}
		}
		
		if ((chk > 80)||(chk < 40)) {
			System.out.println("Incorrect signs");
			return true;
		}
		
		if (((int)input.charAt(0) < 48)||((int)input.charAt(0) > 57)) {
			System.out.println("Incorrect data");
			return true;
		}
		
		if (((int)input.charAt(lng - 1) < 48)||((int)input.charAt(lng - 1) > 57)) {
			System.out.println("Incorrect data");
			return true;
		}
		theSign = new String(new char[]{(char) ordSign});
		twoNumbers = input.split("\\" + theSign);
		n0 = Integer.parseInt(twoNumbers[0]);
		n1 = Integer.parseInt(twoNumbers[1]);
		if ((n1 < 1)||(n1 > 10)||(n0 < 1)||(n0 > 10)) {
			System.out.println("from 1 to 10 only!");
			return true;
		}
		return false;
	}
	
	private static int calc(int a, int b, String aSign) {
		int res = 0;
		switch (aSign){
		case("+"):
			res = a + b;
			break;
		case ("-"):
			res = a - b;
			break;
		case ("/"):
			res = a / b;
			break;
		case ("*"):
			res = a * b;
			break;
		}
		return res;
	}
}
