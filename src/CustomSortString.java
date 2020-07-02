
public class CustomSortString {

	public String customSortString(String S, String T) {

		int[] priorityArray = new int[26];
		for (int i = 0; i < S.length(); i++) {
			priorityArray[S.charAt(i) - 'a'] = i;
		}
//		Main.printArray(priorityArray);
		char[] words = T.toCharArray();
		char[] sortedArray = sort(words, T.length() - 1, 0, priorityArray);

		return String.valueOf(sortedArray);
	}

	private char[] sort(char[] words, int high, int low, int[] orderArray) {

		if (low < high) {
			int pivot = partition(words, high, low, orderArray);
			sort(words, pivot - 1, low, orderArray);
			sort(words, high, pivot + 1, orderArray);

		}

		return words;
	}

	private int partition(char[] words, int high, int low, int[] orderArray) {

		int pivot = high;
		int i = low - 1;
//		System.out.println("low: " + low + " high: " + high);

		for (int j = low; j <= high - 1; j++) {

			if (orderArray[words[j] - 'a'] < orderArray[words[pivot] - 'a']) {
				i++;
				char temp = words[i];
				words[i] = words[j];
				words[j] = temp;
			}

		}

		char temp = words[high];
		words[high] = words[i + 1];
		words[i + 1] = temp;

//		Main.printCharArray(words);
		return i + 1;
	}

}
