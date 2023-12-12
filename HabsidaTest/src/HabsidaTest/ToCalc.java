package HabsidaTest;

public class ToCalc {

	static int toCalc(int f, int s, char sign) {
		int res = 0;
		switch (sign){
		case('+'):
			res = f + s;
			break;
		case ('-'):
			res = f - s;
			break;
		case ('/'):
			res = f / s;
			break;
		case ('*'):
			res = f * s;
			break;
		}
		return res;
	}
}
