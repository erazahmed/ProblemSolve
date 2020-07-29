
public class RemoveDuplicatesFromSortedArrayII {

	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int i = 2;
		for (int j = 2; j < nums.length; j++) {

			if (nums[i - 2] != nums[j]) {
				nums[i++] = nums[j];
			}

		}

		return i;

	}

}
