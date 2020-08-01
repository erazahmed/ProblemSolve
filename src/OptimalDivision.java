
public class OptimalDivision {

	public String optimalDivision(int[] nums) {

		StringBuilder stringBuilder = new StringBuilder();

		if (nums.length == 0) {
			return stringBuilder.toString();
		}

		stringBuilder.append(nums[0]);
		if (nums.length == 1) {
			return stringBuilder.toString();
		}

		if (nums.length == 2) {
			stringBuilder.append("/");
			stringBuilder.append(nums[1]);
			return stringBuilder.toString();
		}

		stringBuilder.append("/(");
		stringBuilder.append(nums[1]);

		for (int i = 2; i < nums.length; i++) {
			stringBuilder.append("/");
			stringBuilder.append(nums[i]);
		}
		stringBuilder.append(")");
		return stringBuilder.toString();

	}

}
