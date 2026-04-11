package arrays;

public class MaxSumSubArrayHavingSumK {
	
	public static int fetchMaxSumSubArrayHavingSumKBruteForce(int arr[],int k) {
		int maxSum=Integer.MIN_VALUE;
		int start=-1;
		int end=-1;
		for(int i=0;i<=arr.length-k;i++) {
			int sum=0;
			int j=i;
			for(;j<i+k;j++) {
			   sum=sum+arr[j];	
			}
			if(sum>maxSum) {
				maxSum=sum;
				start=i;
				end=j-1;
			}
		}
		System.out.println("start==>"+start+"end===>"+end);
		return maxSum;
	}
	
	public static int fetchMaxSumSubArrayHavingSumKSlidingWindow(int arr[],int k) {
		int maxSum=Integer.MIN_VALUE;
		int start=-1;
		int end=-1;
		int left=0;
		int right=0;
		int sum=0;
		while(right<arr.length) {
			sum=sum+arr[right];
			if((right-left+1)==k) {
				if(sum>maxSum) {
					maxSum=sum;
					start=left;
					end=right;
				}
				sum=sum-arr[left];
				left++;
			}
			right++;
		}
		System.out.println("start==>"+start+"end===>"+end);
		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println(fetchMaxSumSubArrayHavingSumKBruteForce(new int[] {1,12,-5,-6,50,3},4));
		System.out.println(fetchMaxSumSubArrayHavingSumKSlidingWindow(new int[] {1,12,-5,-6,50,3},4));

	}

}
