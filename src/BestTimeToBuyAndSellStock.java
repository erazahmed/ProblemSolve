
public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {

//		int profit = 0;
//		if (prices.length < 2) {
//			return 0;
//		}
//
//		int buyIndex = 0;
//		int sellIndex = 1;
//
//		while (sellIndex < prices.length) {
//			if (prices[buyIndex] > prices[sellIndex]) {
//				buyIndex = sellIndex;
//				sellIndex++;
//			} else {
//				profit = Math.max(profit, prices[sellIndex] - prices[buyIndex]);
//				sellIndex++;
//			}
//
//		}
//
//		return profit;

		int maxCur = 0;
		int maxSoFar = 0;

		for (int i = 1; i < prices.length; i++) {

			maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
			maxSoFar = Math.max(maxCur, maxSoFar);

		}

		return maxSoFar;

	}

}
