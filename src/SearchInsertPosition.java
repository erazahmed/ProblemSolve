
public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {

		if (nums.length == 0 || target < nums[0]) {
			return 0;
		}

		if (target > nums[nums.length - 1]) {
			return nums.length;
		}

		System.out.println();
		return binarySearch(nums, target, 0, nums.length - 1);

	}

	private int binarySearch(int[] nums, int target, int startIndex, int endIndex) {

		if (startIndex < endIndex) {

			int midIndex = (startIndex + endIndex) / 2;
			System.out.println("midIndex: " + midIndex);
			if (target < nums[midIndex]) {

				return binarySearch(nums, target, startIndex, midIndex - 1);

			} else if (target > nums[midIndex]) {

				return binarySearch(nums, target, midIndex + 1, endIndex);

			} else {
				return midIndex;
			}
		} else if (startIndex > endIndex) {
			return startIndex;
		} else {
			if (target < nums[startIndex]) {
				return startIndex;
			} else if (target > nums[startIndex]) {
				return startIndex + 1;
			} else {
				return startIndex;
			}

		}

	}

}
