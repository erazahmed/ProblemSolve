package util;

public class StringUtil {

	public static int kmp(String haystack, String needle) {

		if (needle.length() == 0) {
			return 0;
		}

		if (haystack.length() == 0 || needle.length() > haystack.length()) {
			return -1;
		}

		int[] lps = getLpsArray(needle);
		int i = 0, j = 0;
		while (i < haystack.length()) {

			if (haystack.charAt(i) == needle.charAt(j)) {

				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}

			if (j == needle.length()) {
				return i - j;
			}

		}

		return -1;

	}

	public static int[] getLpsArray(String pattern) {

		int[] lpsArray = new int[pattern.length()];
		int index = 0;
		lpsArray[index] = index;

		for (int i = 1; i < pattern.length();) {
			if (pattern.charAt(index) == pattern.charAt(i)) {
				lpsArray[i] = index + 1;
				index++;
				i++;
			} else {

				if (index != 0) {
					index = lpsArray[index - 1];
				} else {
					lpsArray[i] = index;
					i++;
				}

			}

		}

		return lpsArray;

	}

}
