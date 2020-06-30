
public class MoveZeroes {

	public void moveZeroes(int[] nums) {

		int i = 0;
		while (nums[i] != 0) {
			if (i == nums.length - 1) {
				return;
			}
			i++;
		}
		int j = i;

		while (j < nums.length) {

			while (nums[j] == 0) {
				if (j == nums.length - 1) {
					return;
				}
				j++;
			}

			nums[i] = nums[j];
			nums[j] = 0;
			i++;
			j++;
		}

	}

}
