package arrays;

public class MinimumSizeSubArraySum {

	public static int fetchMinLengthSubarrayWhoseSumEqualGreaterTarget(int arr[],int k) {

		int minimumLength=Integer.MAX_VALUE;
		int start=0;
		int end=0;
		int startIndex=-1;
		int endIndex=-1;
		int sum=0;
		while(end<arr.length) {
			sum=sum+arr[end];
			while(sum>=k) {
				if((end-start+1)<minimumLength) {
					minimumLength=end-start+1;
					startIndex=start;
					endIndex=end;
				}
				sum=sum-arr[start];
				start++;
			}
			end++;
		}
		return minimumLength==Integer.MAX_VALUE?0:(endIndex-startIndex+1);

	}
}