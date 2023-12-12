package HabsidaTest;

public class Calc1Sign {

	String expression;

	Calc1Sign(String expression) {
		super();
		this.expression = expression;
	}
	int toCalc1() throws ExceptionOfInput {
		int theSign = 0;
		for (int i = 1; i < expression.length() - 1; i++ ) {
			if ((int)expression.charAt(i) < 48) {
				theSign = (int)expression.charAt(i);
				break;
			}
		}
		int res = 0;
		String aSign = new String(new char[] {(char) theSign});
		String[] twoNumbers = new String[2];
		twoNumbers = expression.split("\\" + aSign);
		//System.out.println("theSign = " + theSign + " aSign = " + aSign);
		Integer a = Integer.parseInt(twoNumbers[0]);
		Integer b = Integer.parseInt(twoNumbers[1]);
		if ((a < 1)||(a > 10)||(b < 1)||(b > 10)) {
			throw new ExceptionOfInput("From 1 to 10 only");
		}
		return ToCalc.toCalc(a, b, (char) theSign);
	}
}
