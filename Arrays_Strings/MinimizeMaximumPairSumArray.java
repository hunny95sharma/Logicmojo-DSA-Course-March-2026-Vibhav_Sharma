package arrays;

import java.util.Arrays;

public class MinimizeMaximumPairSumArray {
	
	public int fetchMinimizeMaximumPairSumArray(int arr[]) {
		Arrays.sort(arr);
		int start=0;
		int end=arr.length-1;
		int maxPair=0;
		while(start<end) {
			if((arr[start]+arr[end])>maxPair) {
				maxPair=arr[start]+arr[end];
			}
			start++;
			end--;
		}
		return maxPair;
	}
}