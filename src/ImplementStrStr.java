
public class ImplementStrStr {

	public int strStr(String haystack, String needle) {

		if (needle.length() == 0) {
			return 0;
		}

		if (haystack.length() == 0 || needle.length() > haystack.length()) {
			return -1;
		}

		int[] lps = getTempArray(needle);
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

	private int[] getTempArray(String pattern) {

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

		Main.printArray(lpsArray);

		return lpsArray;

	}

//	solution 2
//	
//	public int strStr(String haystack, String needle) {
//		
//		if (needle.length() == 0) {
//			return 0;
//		}
//
//		if (haystack.length() == 0 || needle.length() > haystack.length()) {
//			return -1;
//		}
//		
//		char first = needle.charAt(0);
//		int result = -1;
//
//		for (int i = 0; i < haystack.length(); i++) {
//
//			if (haystack.charAt(i) == first) {
//
//				if (needle.length() > haystack.length() - i) {
//					continue;
//				}
//
//				inner: for (int j = 0; j < needle.length(); j++) {
//
//					System.out.println("haystack: " + haystack.charAt(i + j) + "   needle: " + needle.charAt(j));
//					if (haystack.charAt(i + j) != needle.charAt(j)) {
//						System.out.println("//////\n");
//						break inner;
//					}
//
//					if (j == needle.length() - 1) {
//						System.out.println("result: " + i);
//						return i;
//					}
//
//				}
//			}
//
//		}
//		
//		return result;
//		
//	}

}
