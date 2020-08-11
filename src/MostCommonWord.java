import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MostCommonWord {

	public String mostCommonWord(String paragraph, String[] banned) {

		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		HashSet<String> bannedSet = new HashSet<String>();

		for (int i = 0; i < banned.length; i++) {
			bannedSet.add(banned[i]);
		}

		String result = "";

		paragraph = paragraph.replaceAll("[^a-zA-Z ]", " ").replace("  ", " ").toLowerCase();
		System.out.println(paragraph);
		String[] words = paragraph.split(" ");

		for (int i = 0; i < words.length; i++) {
			if (!bannedSet.contains(words[i])) {

				if (wordCount.containsKey(words[i])) {
					wordCount.put(words[i], wordCount.get(words[i]) + 1);
				} else {
					wordCount.put(words[i], 1);
				}

			}
		}

		int currentMax = 0;

		for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
			if (entry.getValue() > currentMax) {
				currentMax = entry.getValue();
				result = entry.getKey();
			}
		}

		System.out.println(wordCount);
		System.out.println(result);

		return result;

	}

}
