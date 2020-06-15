import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {

	public List<String> subdomainVisits(String[] cpdomains) {

		HashMap<String, Integer> domainMap = new HashMap<String, Integer>();
		List<String> resultList = new ArrayList<String>();

		for (int i = 0; i < cpdomains.length; i++) {

			String[] domainData = cpdomains[i].split(" ");

			int count = Integer.parseInt(domainData[0]);

			String domain = "";
			String[] domainArr = domainData[1].split("\\.");

			for (int j = domainArr.length - 1; j >= 0; j--) {

				if (j == domainArr.length - 1) {
					domain = domainArr[j];
				} else {
					domain = domainArr[j] + "." + domain;
				}

				if (domainMap.containsKey(domain)) {
					int oldCount = domainMap.get(domain);
					domainMap.put(domain, oldCount + count);
				} else {
					domainMap.put(domain, count);
				}

			}

		}

		for (Map.Entry mapElement : domainMap.entrySet()) {

			String key = (String) mapElement.getKey();
			int value = ((int) mapElement.getValue());

			resultList.add(value + " " + key);

		}

		return resultList;

	}

}
