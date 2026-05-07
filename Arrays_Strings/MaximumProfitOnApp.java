package matrix;

import java.util.Arrays;

public class MaximumProfitOnApp {

	public static int maximumProfit(int budget[]) {

		Arrays.sort(budget);

		int result=0;

		for(int i=0;i<budget.length;i++) {

			int temp=budget[i]*(budget.length-i);
			if(temp>result)
				result=temp;
		}
		return result;

	}

}