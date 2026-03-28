package arrays;

import java.util.Arrays;
import java.util.List;

public class MaximumSubarray {
	
	public static List<Integer> fetchMaximumSubarray(List<Integer> arr) {
		int maxBestTillI=arr.get(0);
		int maxSubSequence=arr.get(0);
		int maxElement=arr.get(0);
		int SubArraySum=arr.get(0)>0?arr.get(0):0;
		for(int i=1;i<arr.size();i++) {
			int v1=arr.get(i);
			int v2=maxBestTillI+arr.get(i);
			 maxBestTillI=v1>v2?v1:v2;
			 maxSubSequence=maxBestTillI>maxSubSequence?maxBestTillI:maxSubSequence;
			 if(arr.get(i)>0) 
				 SubArraySum=SubArraySum+arr.get(i) ;
			 if(arr.get(i)>maxElement)
				 maxElement=arr.get(i);
		}
		if(maxElement<0)
			return Arrays.asList(maxSubSequence,maxElement);
		else
			return Arrays.asList(maxSubSequence,SubArraySum);
	}

	public static void main(String[] args) {
        System.out.println(fetchMaximumSubarray(Arrays.asList(2 ,-1 ,2 ,3 ,4, -5)));
	}

}