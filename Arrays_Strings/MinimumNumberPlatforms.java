package arrays;

import java.util.Arrays;

public class MinimumNumberPlatforms {
	
	
	public static int calculateMinimumNumberPlatforms(double[]arrival,double[]departure ) {
		
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int platform=0;
		int maxPlatformTillIndex=0;
		int i=0;
		int j=0;

		while(i<arrival.length) {
			if(arrival[i]<departure[j]) {
				platform++;
				i++;
			}else {
				platform--;
				j++;
			}
			maxPlatformTillIndex=platform>maxPlatformTillIndex?platform:maxPlatformTillIndex;
		}
		return maxPlatformTillIndex;
	}
	
	public static void main(String args[]) {
		System.out.println(calculateMinimumNumberPlatforms(new double[] {2.00, 2.10, 3.00, 3.20, 3.50, 5.00},new double[] {2.30, 3.40, 3.20, 4.30, 4.00, 5.20}));
	}

}