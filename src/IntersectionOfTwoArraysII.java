import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII {

	public int[] intersect(int[] nums1, int[] nums2) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			} else {
				map.put(nums1[i], 1);
			}

		}

		HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		int count = 0;

		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				count++;
				map.put(nums2[i], map.get(nums2[i]) - 1);
				if (resultMap.containsKey(nums2[i])) {
					resultMap.put(nums2[i], resultMap.get(nums2[i]) + 1);
				} else {
					resultMap.put(nums2[i], 1);
				}

			}

		}

		int[] result = new int[count];

		count = 0;

		for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {

			for (int i = 0; i < entry.getValue(); i++) {
				result[count] = entry.getKey();
				count++;
			}

		}

		return result;

	}

}
