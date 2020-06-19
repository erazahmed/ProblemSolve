
public class SortColors {
	public void sortColors(int[] nums) {

		qSort(nums, 0, nums.length - 1);
		printArray(nums);

	}

	private void qSort(int[] nums, int low, int high) {

		if (low < high) {
			int pivot = partition(nums, low, high);
			qSort(nums, low, pivot - 1);
			qSort(nums, pivot + 1, high);
		}

	}

	private int partition(int[] nums, int low, int high) {

		int pivot = nums[high];

		int i = low - 1;

		for (int j = low; j <= high - 1; j++) {

			if (nums[j] <= pivot) {
				i++;
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
			}
		}

		int temp = nums[high];
		nums[high] = nums[i + 1];
		nums[i + 1] = temp;

		return i + 1;

	}

	public static void printArray(int[] a) {
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("]");
	}

}
