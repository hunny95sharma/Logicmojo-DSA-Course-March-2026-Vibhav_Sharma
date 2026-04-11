package arrays;

public class MaxConsecutiveOnesWithKFlipOfZeros {
	
	public static int fetchMaxConsecutiveOnesWithKFlipOfZerosBruteForce(int arr[],int k) {
		int maximumLength=Integer.MIN_VALUE;
		int startIndex=-1;
		int endIndex=-1;
		for(int i=0;i<arr.length;i++) {
			int zeros=0;
			for(int j=i;j<arr.length;j++) {
				if(arr[j]==0)
					zeros++;
				if(zeros>k)
					break;
					if((j-i+1)>maximumLength) {
						maximumLength=j-i+1;
						startIndex=i;
						endIndex=j;
					}
			}
		}
		System.out.println("start==>"+startIndex+"end===>"+endIndex);
		return maximumLength==Integer.MIN_VALUE?0:maximumLength;
	}
	
	public static int fetchMaxConsecutiveOnesWithKFlipOfZerosSlidingWindowOptimized(int arr[],int k) {
		int maximumLength=Integer.MIN_VALUE;
		int startIndex=-1;
		int endIndex=-1;
		int start=0;
		int end=0;
		int zeros=0;
		while(end<arr.length) {
			if(arr[end]==0)
				zeros++;
			while(zeros>k) {
				if(arr[start]==0)
					zeros--;
				start++;
			}
			if(zeros<=k) {
			if((end-start+1)>maximumLength) {
				maximumLength=end-start+1;
				startIndex=end;
				endIndex=start;
			}	
			}
			end++;
		}
		System.out.println("start==>"+startIndex+"end===>"+endIndex);
		return maximumLength==Integer.MIN_VALUE?0:maximumLength;
	}
	
	public static int fetchMaxConsecutiveOnesWithKFlipOfZerosSlidingWindowBest(int arr[],int k) {
		int maximumLength=Integer.MIN_VALUE;
		int startIndex=-1;
		int endIndex=-1;
		int start=0;
		int end=0;
		int zeros=0;
		while(end<arr.length) {
			if(arr[end]==0)
				zeros++;
			if(zeros>k) {
				if(arr[start]==0)
					zeros--;
				start++;
			}
			if(zeros<=k) {
			if((end-start+1)>maximumLength) {
				maximumLength=end-start+1;
				startIndex=end;
				endIndex=start;
			}	
			}
			end++;
		}
		System.out.println("start==>"+startIndex+"end===>"+endIndex);
		return maximumLength==Integer.MIN_VALUE?0:maximumLength;
	}

}
