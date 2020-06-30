import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShortestCompletingWord {

	public String shortestCompletingWord(String licensePlate, String[] words) {

		licensePlate = licensePlate.toLowerCase();
		HashMap<Character, Integer> lpMap = new HashMap<Character, Integer>();
		TreeMap<Integer, String> resultMap = new TreeMap<Integer, String>();
		loadLicensePlateMap(licensePlate, lpMap);
		// System.out.println(lpMap.toString());

		for (int i = 0; i < words.length; i++) {

			if (words[i].length() >= lpMap.size()) {

				HashMap<Character, Integer> wordMap = new HashMap<Character, Integer>();
				for (int j = 0; j < words[i].length(); j++) {
					char letter = words[i].charAt(j);
					if (letter >= 'a' && letter <= 'z') {

						if (wordMap.containsKey(letter)) {
							wordMap.put(letter, wordMap.get(letter) + 1);
						} else {
							wordMap.put(letter, 1);
						}
					}

				}

				if (wordMap.size() >= lpMap.size()) {

					boolean isComplete = true;
					for (Map.Entry<Character, Integer> entry : lpMap.entrySet()) {

						if (!wordMap.containsKey(entry.getKey()) || wordMap.get(entry.getKey()) < entry.getValue()) {
							isComplete = false;

						}

					}

					if (isComplete && !resultMap.containsKey(words[i].length())) {
						resultMap.put(words[i].length(), words[i]);
					}

				}

				// System.out.println(words[i] + ": " + wordMap.toString());

			}

		}

		// System.out.println(resultMap.toString());
		return resultMap.get(resultMap.firstKey());
	}

	private void loadLicensePlateMap(String licensePlate, HashMap<Character, Integer> lpMap) {

		for (int i = 0; i < licensePlate.length(); i++) {

			char letter = licensePlate.charAt(i);
			if (letter >= 'a' && letter <= 'z') {

				if (lpMap.containsKey(letter)) {
					lpMap.put(letter, lpMap.get(letter) + 1);
				} else {
					lpMap.put(letter, 1);
				}
			}

		}

	}

}
