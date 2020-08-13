
public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {

		int start = 0;

		int[] char_counts = new int[26];
		int max_length = 0;
		int max_count = 0;

		for (int end = 0; end < s.length(); end++) {

			char_counts[s.charAt(end) - 'A']++;
			int current_char_count = char_counts[s.charAt(end) - 'A'];
			max_count = Math.max(max_count, current_char_count);

			while (end - start - max_count + 1 > k) {
				char_counts[s.charAt(start) - 'A']--;
				start++;
			}

			max_length = Math.max(end - start + 1, max_length);

		}

		return max_length;

	}

}
