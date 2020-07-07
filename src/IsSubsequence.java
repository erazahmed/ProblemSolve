
public class IsSubsequence {

	public boolean isSubsequence(String s, String t) {

		if (s.length() == 0) {
			return true;
		}

		int j = 0;
		for (int i = 0; i < t.length(); i++) {

			if (j == s.length()) {
				break;
			}

			if (t.charAt(i) == s.charAt(j)) {
				j++;
			}

		}

		if (j == s.length()) {
			return true;
		} else {
			return false;
		}

	}

}
