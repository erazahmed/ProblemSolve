
public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {

		if (nums.length == 0) {
			return -1;
		}

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {

			int mid = (start + end) / 2;
			System.out.println("mid: " + mid + "   value: " + nums[mid]);

			if (nums[mid] == target) {
				return mid;
			}

			if (nums[start] < nums[mid] && nums[mid] < nums[end]) {

				if (target > nums[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}

			} else if (nums[start] > nums[mid] && nums[mid] < nums[end]) {

				if (nums[mid] > target) {
					end = mid - 1;
				} else {
					if (target <= nums[end]) {
						start = mid + 1;
					} else {
						end = mid - 1;
					}
				}

			} else {

				System.out.println("mid: " + mid);

				if (nums[mid] < target) {
					start = mid + 1;
				} else {
					if (target >= nums[start]) {
						end = mid - 1;
					} else {
						start = mid + 1;
					}
				}

			}

		}

		return -1;

	}

}
