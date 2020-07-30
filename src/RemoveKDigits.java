import java.util.Stack;

public class RemoveKDigits {

	public String removeKdigits(String num, int k) {

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < num.length(); i++) {

			int digit = num.charAt(i) - '0';

			while (!stack.isEmpty() && digit < stack.lastElement() && k > 0) {
				stack.pop();
				k--;
			}

			if (digit > 0 || !stack.isEmpty()) {
				stack.push(digit);
			}

		}

		while (!stack.isEmpty() && k > 0) {
			stack.pop();
			k--;
		}

		if (stack.isEmpty()) {
			return "0";
		}

		StringBuilder stringBuilder = new StringBuilder();
		int[] resultArr = new int[stack.size()];
		int n = stack.size();
		while (!stack.isEmpty()) {
			resultArr[n - 1] = stack.pop();
			n--;
		}

		for (int i = 0; i < resultArr.length; i++) {
			stringBuilder.append(resultArr[i]);
		}

		return stringBuilder.toString();

	}

}
