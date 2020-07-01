
public class ImplementStrStr {

	public int strStr(String haystack, String needle) {

		if (needle.length() == 0) {
			return 0;
		}

		if (haystack.length() == 0 || needle.length() > haystack.length()) {
			return -1;
		}

		int result = -1;
		char first = needle.charAt(0);

		for (int i = 0; i < haystack.length(); i++) {

			if (haystack.charAt(i) == first) {

				if (needle.length() > haystack.length() - i) {
					continue;
				}

				inner: for (int j = 0; j < needle.length(); j++) {

					System.out.println("haystack: " + haystack.charAt(i + j) + "   needle: " + needle.charAt(j));
					if (haystack.charAt(i + j) != needle.charAt(j)) {
						System.out.println("//////\n");
						break inner;
					}

					if (j == needle.length() - 1) {
						System.out.println("result: " + i);
						return i;
					}

				}
			}

		}
		System.out.println("result: " + result);

		return result;

	}

}
