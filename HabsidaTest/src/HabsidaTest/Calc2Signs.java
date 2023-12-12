package HabsidaTest;

public class Calc2Signs {

	String expression;

	public Calc2Signs(String expression) {
		super();
		this.expression = expression;
	}
	
	int toCalc2() throws ExceptionOfInput {
		int[] twoSigns = new int[2];
		int[] indOfSign = new int[2];
		int k = 0;
		for(int i = 1; i < expression.length() - 1; i++) {
			if ((int)expression.charAt(i) < 48) {
				twoSigns[k] = (int)expression.charAt(i);
				indOfSign[k] = i;
				++k;
			}
		}
		if ((indOfSign[1] - indOfSign[0]) == 1) {
			throw new ExceptionOfInput("Incorrect signs");
		}
		int res = 0;
		String[] threeNum = new String[3];
		String[] tmp = expression.split("\\" + new String(new char[] {(char)twoSigns[0]}), 2);
		threeNum[0] = tmp[0];
		tmp = tmp[1].split("\\" + new String(new char[] {(char)twoSigns[1]}), 2);
		threeNum[1] = tmp[0];
		threeNum[2] = tmp[1];
		Integer a = Integer.parseInt(threeNum[0]);
		Integer b = Integer.parseInt(threeNum[1]);
		Integer c = Integer.parseInt(threeNum[2]);
		if ((a < 1)||(a > 10)||(b < 1)||(b > 10)||(c < 1)||(c > 10)) {
			throw new ExceptionOfInput("From 1 to 10 only");
		}
		if ((twoSigns[0] == 42)||(twoSigns[0] == 47)) {
			res = ToCalc.toCalc(ToCalc.toCalc(a, b, (char)twoSigns[0]), c, (char)twoSigns[1]);
		} else if ((twoSigns[1] == 43)||(twoSigns[1] == 45)) {
			res = ToCalc.toCalc(ToCalc.toCalc(a, b, (char)twoSigns[0]), c, (char)twoSigns[1]);
		} else {
			res = ToCalc.toCalc(a, ToCalc.toCalc(b, c, (char)twoSigns[1]), (char)twoSigns[0]);
		}
		return res;
	}
}
