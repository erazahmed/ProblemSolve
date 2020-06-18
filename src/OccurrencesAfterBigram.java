import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {

	public String[] findOcurrences(String text, String first, String second) {

		List<String> resultList = new ArrayList<String>();
		String resultStr = "";
		String subString = first + " " + second;

		while (text.contains(subString + " ")) {
			int firstIndex;


			if (text.startsWith(subString + " ")) {
				firstIndex = text.indexOf(subString);
				text = text.substring(firstIndex + subString.length());
			} else {
				firstIndex = text.indexOf(" " + subString + " ");
				text = text.substring(firstIndex + subString.length() + 1);
			}

			resultStr = text.substring(1);
			resultList.add(resultStr.split(" ")[0]);

		}

		String[] result = new String[resultList.size()];

		for (int i = 0; i < result.length; i++) {
			result[i] = resultList.get(i);
		}
		return result;

	}

}
