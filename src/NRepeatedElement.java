import java.util.HashSet;

public class NRepeatedElement {

	public int repeatedNTimes(int[] A) {

		HashSet<Integer> resultSet = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (resultSet.contains(A[i])) {
				return A[i];
			}

			resultSet.add(A[i]);

		}

		return 0;
	}
}
