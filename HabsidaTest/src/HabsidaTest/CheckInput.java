package HabsidaTest;

public class CheckInput {
	String theInput;
	int howManySigns = 0;

	CheckInput(String theInput) {
		super();
		this.theInput = theInput;
	}
	boolean toCheck() {
		int lng = theInput.length();
		for (int i = 0; i < lng; i++) {
			int codeOfLet = (int)theInput.charAt(i);
			if ((codeOfLet < 42)||(codeOfLet > 57)) {
				return true;
			}
			if ((codeOfLet == 44)||(codeOfLet == 46)) {
				return true;
			}
			if (codeOfLet < 48) {
				++howManySigns;
			}
		}
		
		if ((howManySigns > 2)||(howManySigns < 1)) {
			return true;
		}
		
		if (((int)theInput.charAt(0) < 48)) {
			return true;
		}
		if (((int)theInput.charAt(lng - 1) < 48)) {
			return true;
		}
		return false;
	}
	
}
