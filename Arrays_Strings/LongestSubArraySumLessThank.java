package arrays;

public class LongestSubArraySumLessThank {
	
	public static int fetchLongestSubArraySumLessThankBruteForce(int arr[],int k) {
		int maximumLength=Integer.MIN_VALUE;
		int startIndex=-1;
		int endIndex=-1;
		for(int i=0;i<arr.length;i++) {
			int sum=0;
			for(int j=i;j<arr.length;j++) {
				sum=sum+arr[j];
				if(sum>k)
					break;
				else {
					if((j-i+1)>maximumLength) {
						maximumLength=j-i+1;
						startIndex=i;
						endIndex=j;
					}
				}
				
			}
		}
		System.out.println("startIndex===>"+startIndex+",endIndex===>"+endIndex);
		return maximumLength==Integer.MIN_VALUE?0:maximumLength;
	}
	
	public static int fetchLongestSubArraySumLessThankSlidingWindowOptimal(int arr[],int k) {
		int maximumLength=Integer.MIN_VALUE;
		int startIndex=-1;
		int endIndex=-1;
		int start=0;
		int end=0;
		int sum=0;
		while(end<arr.length) {
			sum=sum+arr[end];
			while(sum>k) {
				sum=sum-arr[start];
				start++;
			}
			if(sum<=k) {
				if((end-start+1)>maximumLength) {
					maximumLength=end-start+1;
					startIndex=start;
					endIndex=end;
				}
			}
			end++;
		}
		System.out.println("startIndex===>"+startIndex+",endIndex===>"+endIndex);
		return maximumLength==Integer.MIN_VALUE?0:maximumLength;
	}
	
	public static int fetchLongestSubArraySumLessThankSlidingWindowBest(int arr[],int k) {
		int maximumLength=Integer.MIN_VALUE;
		int startIndex=-1;
		int endIndex=-1;
		int start=0;
		int end=0;
		int sum=0;
		while(end<arr.length) {
			sum=sum+arr[end];
			if(sum>k) {
				sum=sum-arr[start];
				start++;
			}
			if(sum<=k) {
				if((end-start+1)>maximumLength) {
					maximumLength=end-start+1;
					startIndex=start;
					endIndex=end;
				}
			}
			end++;
		}
		System.out.println("startIndex===>"+startIndex+",endIndex===>"+endIndex);
		return maximumLength==Integer.MIN_VALUE?0:maximumLength;
	}

	public static void main(String[] args) {
		System.out.println(fetchLongestSubArraySumLessThankSlidingWindowBest(new int[] {2,5,0,0,7,10},14));
	}

}
