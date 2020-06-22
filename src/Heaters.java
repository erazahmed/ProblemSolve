import java.util.Arrays;

public class Heaters {

	public int findRadius(int[] houses, int[] heaters) {

		int result = 0;

		Arrays.sort(heaters);
		for (int i = 0; i < houses.length; i++) {

			int index = Arrays.binarySearch(heaters, houses[i]);

			if (index < 0) {
				index = -(index + 1);
			}

			if (index == heaters.length) {
				houses[i] = houses[i] - heaters[index - 1];
			} else {
				if (houses[i] == heaters[index]) {
					houses[i] = 0;
				} else {

					if (index == 0) {
						houses[i] = heaters[index] - houses[i];
					} else {
						houses[i] = Math.min(heaters[index] - houses[i], houses[i] - heaters[index - 1]);
					}
				}
			}

			result = Math.max(result, houses[i]);
		}

		return result;

	}

}
