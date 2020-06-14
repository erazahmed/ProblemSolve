import java.util.HashSet;

public class DistributeCandies {

	public int distributeCandies(int[] candies) {
		
		HashSet<Integer> candySet = new HashSet<Integer>();
		int len = candies.length;
		
		for(int i = 0; i < len ; i++) {
			candySet.add(candies[i]);
		}
		
		if(len/2 >= candySet.size() ) {
			return candySet.size();
		}else {
			return len/2;
		}

	}

}
