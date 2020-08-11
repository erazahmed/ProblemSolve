import java.util.Stack;

public class DecodeString {

	public String decodeString(String s) {

		Stack<Integer> count = new Stack<Integer>();
		Stack<String> str = new Stack<String>();
		String result = "";
		int index = 0;

		while (index < s.length()) {

			if (Character.isDigit(s.charAt(index))) {

				int digit = 0;
				while (Character.isDigit(s.charAt(index))) {
					digit = 10 * digit + (s.charAt(index) - '0');
					index++;
				}
				count.push(digit);

			} else if (s.charAt(index) == '[') {

				str.push(result);
				result = "";
				index++;

			} else if (s.charAt(index) == ']') {

				StringBuilder sb = new StringBuilder(str.pop());
				int counts = count.pop();
				for (int i = 0; i < counts; i++) {
					sb.append(result);
				}
				result = sb.toString();
				index++;

			} else {

				result += s.charAt(index);
				index++;

			}

		}

		return result;

	}

}
