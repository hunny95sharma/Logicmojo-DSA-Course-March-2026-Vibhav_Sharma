package arrays;

import java.util.List;

public class MaxConsecutiveOne {
	
	public static int fetchMaxConsecutiveOneBruteForce(int arr[]) {
		int maxLength=Integer.MIN_VALUE;
		int startIndex=-1;
		int endIndex=-1;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[j]==0)
					break;
				if((j-i+1)>maxLength) {
					maxLength=j-i+1;
					startIndex=i;
					endIndex=j;
				}
			}
		}
		System.out.println("startIndex===>"+startIndex+",endIndex===>"+endIndex);
		return maxLength==Integer.MIN_VALUE?0:maxLength;
	}
	
	public static int fetchMaxConsecutiveOneSlidingWindow(List<Integer> arr) {
		int maxLength=Integer.MIN_VALUE;
        int startIndex=-1;
        int endIndex=-1;
        int start=0;
        int end=0;
        while(end<arr.size()) {       
            if(arr.get(end)==0)
            start=end+1;
            if((end-start+1)>maxLength) {
                maxLength=end-start+1;
                startIndex=start;
                endIndex=end;
                
            }
            end++;
        }
        System.out.println("startIndex===>"+startIndex+",endIndex===>"+endIndex);
		return maxLength==Integer.MIN_VALUE?0:maxLength;
	}
}
