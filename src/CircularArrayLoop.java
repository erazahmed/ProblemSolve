
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class CircularArrayLoop {

	public boolean circularArrayLoop(int[] nums) {

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {

			if (!set.contains(i)) {

				int iterator = 0;
				TreeMap<Integer, String> map = new TreeMap<Integer, String>();
//				System.out.println("map key: " + iterator + "   map value: " + i);
				map.put(iterator++, String.valueOf(i));
				set.add(i);
				int currIndex = i;

				inner: for (int j = 0; j < nums.length; j++) {

//					System.out.println("current index: " + currIndex);

					if (nums[i] > 0) {

						if (nums[currIndex] < 0) {
							break inner;
						}

						// check if value matches
//						System.out.println((currIndex + nums[currIndex]) % nums.length);
						if (map.containsValue(String.valueOf((currIndex + nums[currIndex]) % nums.length))) {

							int key = getKeysFromValue(map,
									String.valueOf((currIndex + nums[currIndex]) % nums.length));
							int itemCount = map.size() - key;
//							System.out.println("key: " + key + "   map size: " + map.size());
							if (itemCount < 2) {
//								System.out.println("//////");
								break inner;
							} else {
								return true;
							}

						}

						// check ends

						currIndex = (currIndex + nums[currIndex]) % nums.length;
//						System.out.println("map key: " + iterator + "   map value: " + currIndex);
						map.put(iterator++, String.valueOf(currIndex));
						set.add(currIndex);

					} else {

						if (nums[currIndex] > 0) {
							break inner;
						}

//					check if matches

						int nextIndex;
						if (currIndex + nums[currIndex] < 0)
							nextIndex = nums.length - Math.abs(currIndex + nums[currIndex]) % nums.length;
						else
							nextIndex = currIndex + nums[currIndex];

						if (map.containsValue(String.valueOf(nextIndex))) {

							int key = getKeysFromValue(map, String.valueOf(nextIndex));

							int itemCount = map.size() - key;
//							System.out.println(nextIndex);
//							System.out.println("key: " + key + "   map size: " + map.size());

							if (itemCount < 2) {
								break inner;
							} else {
								return true;
							}

						}

//					check ends

						if (currIndex + nums[currIndex] < 0)
							currIndex = nums.length - Math.abs(currIndex + nums[currIndex]) % nums.length;
						else
							currIndex = currIndex + nums[currIndex];
//						System.out.println("map key: " + iterator + "   map value: " + currIndex);
						map.put(iterator++, String.valueOf(currIndex));
						set.add(currIndex);

					}

				}

			}

		}

		return false;

	}

	public int getKeysFromValue(TreeMap<Integer, String> map, String value) {

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			if (entry.getValue().equals(value)) {
				return entry.getKey();
			}
		}

		return 0;
	}

}
