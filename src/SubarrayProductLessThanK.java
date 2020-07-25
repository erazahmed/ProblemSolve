
public class SubarrayProductLessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {

		if (k < 1) {
			return 0;
		}

		int i = 0;
		int j = 0;
		int product = 1;
		int result = 0;

		for (j = 0; j < nums.length; j++) {

			product *= nums[j];

			while (product >= k && i <= j) {
				product /= nums[i];
				i++;
			}

			result += j - i + 1;

		}

		return result;

	}

}
