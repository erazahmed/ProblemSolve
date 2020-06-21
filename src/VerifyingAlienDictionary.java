
public class VerifyingAlienDictionary {

	public boolean isAlienSorted(String[] words, String order) {

		for (int i = 0; i < words.length - 1; i++) {

			inner: for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {

				if (order.indexOf(words[i].charAt(j)) < order.indexOf(words[i + 1].charAt(j))) {
					break inner;
				}

				if (order.indexOf(words[i].charAt(j)) > order.indexOf(words[i + 1].charAt(j))) {
					return false;
				}

				if (j == Math.min(words[i].length(), words[i + 1].length() - 1)
						&& words[i].length() > words[i + 1].length()) {

					return false;
				}

			}

		}

		return true;

	}

}
