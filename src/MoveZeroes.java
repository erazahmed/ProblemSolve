
public class MoveZeroes {

	public void moveZeroes(int[] nums) {

		int i = 0;
		while (i <= nums.length - 1 && nums[i] != 0) {
			i++;
		}

		if (i >= nums.length - 1) {
			return;
		}

		int j = i;
		for(;i< nums.length;i++){

			while (j <= nums.length - 1 && nums[j] == 0) {
				j++;
			}

			if (j > nums.length - 1) {
				return;
			}

			nums[i] = nums[j];
			nums[j] = 0;
			j++;
		}

	}

}
