
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UncommonWordsfromTwoSentences {

	public String[] uncommonFromSentences(String A, String B) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		String[] wordsA = A.split(" ");
		String[] wordsB = B.split(" ");

		for (int i = 0; i < wordsA.length; i++) {
			if (map.containsKey(wordsA[i])) {
				map.put(wordsA[i], map.get(wordsA[i]) + 1);
			} else {
				map.put(wordsA[i], 1);
			}

		}

		for (int i = 0; i < wordsB.length; i++) {
			if (map.containsKey(wordsB[i])) {
				map.put(wordsB[i], map.get(wordsB[i]) + 1);
			} else {
				map.put(wordsB[i], 1);
			}
		}

		HashSet<String> resultSet = new HashSet<String>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				resultSet.add(entry.getKey());
			}
		}

		String[] result = new String[resultSet.size()];
		int count = 0;

		for (String entry : resultSet) {
			result[count++] = entry;
		}

		return result;

	}

}
