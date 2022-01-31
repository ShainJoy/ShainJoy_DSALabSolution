package gl.lab.balanceBrackets;
import java.util.Stack;

/* Program to check, the given string has balanced brackets or not.
 * It has only driver class and string contains brackets is hard coded.
 * It uses STACK data structure for the operation.
 */

public class BalancedBrackets {
	static Stack<String> bkts;

	public static void main(String[] args) {
		// String contains brackets to check.
		String input = "([[{}]])";
		
		bkts =  new Stack<>();
		int len = input.length();

		// If string length is an odd number, it can't have balanced bracket. 
		// So, it is directly printing result, else it is checking the brackets.  
		if(len%2 == 0) {
			if (bktLogic(input,len)){
				System.out.println("The entered String has Balanced Brackets");
			}
			else {
				System.out.println("The entered Strings do NOT contain Balanced Brackets");
			}
		}
		else {
			System.out.println("The entered Strings do NOT contain Balanced Brackets");
		}
	}

	/* method checks and return TRUE if the passed-in string has balanced bracket, 
	 * else FALSE.
	 * It 'pushes' all characters until half of the string to stack. 
	 * Pops out each character from stack and compares with remaining characters in the string  
	 */
	static boolean bktLogic(String input, int len) {
		boolean rslt = true;
		int i;
		String tmp = "";
		
		for (i = 0; i < len/2; i++) {
			bkts.push(input.charAt(i) + "");
		}
		for  (i = 0; i < len/2; i++) {
			tmp = bkts.pop();
			switch (tmp) {
			case "{":
				if (!(input.charAt((len/2)+i) + "").equals("}")) {
					rslt = false;
					i = len;
				}
				break;
			case "}":
				if (!(input.charAt((len/2)+i) + "").equals("{")) {
					rslt = false;
					i = len;
				}
				break;
			case "(":
				if (!(input.charAt((len/2)+i) + "").equals(")")) {
					rslt = false;
					i = len;
				}
				break;
			case ")":
				if (!(input.charAt((len/2)+i) + "").equals("(")) {
					rslt = false;
					i = len;
				}
				break;
			case "[":
				if (!(input.charAt((len/2)+i) + "").equals("]")) {
					rslt = false;
					i = len;
				}
				break;
			case "]":
				if (!(input.charAt((len/2)+i) + "").equals("[")) {
					rslt = false;
					i = len;
				}
				break;
			}
		}
		return rslt;
	}
}
