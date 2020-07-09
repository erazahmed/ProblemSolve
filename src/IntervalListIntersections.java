import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

	public int[][] intervalIntersection(int[][] A, int[][] B) {

		List<Result> resultList = new ArrayList<IntervalListIntersections.Result>();

		for (int i = 0; i < A.length; i++) {

			for (int j = 0; j < B.length; j++) {

				if (A[i][0] <= B[j][0] && A[i][1] >= B[j][0]) {
					System.out.println(B[j][0] + "," + Math.min(B[j][1], A[i][1]));
					resultList.add(new Result(B[j][0], Math.min(B[j][1], A[i][1])));
				} else if (B[j][0] <= A[i][0] && B[j][1] >= A[i][0]) {
					System.out.println(A[i][0] + "," + Math.min(B[j][1], A[i][1]));
					resultList.add(new Result(A[i][0], Math.min(B[j][1], A[i][1])));
				}

			}

		}

		int[][] result = new int[resultList.size()][2];
		for (int i = 0; i < result.length; i++) {

			result[i][0] = resultList.get(i).x;
			result[i][1] = resultList.get(i).y;
		}

		return result;

	}

	public class Result {

		public int x;
		public int y;

		public Result(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
