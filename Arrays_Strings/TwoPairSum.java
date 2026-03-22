package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPairSum {

	
	public static List<List<Integer>>fetchTwoPairSum(int arr[],int target ){
		Arrays.sort(arr);
		int start=0;
		int end=arr.length-1;
		List<List<Integer>>res=new ArrayList<>();
		while(start<end) {
			if(arr[start]+arr[end]==target) {
				res.add(Arrays.asList(arr[start],arr[end]));
				while(start<end && arr[start]==arr[start+1])start++;
				while(start<end && arr[end]==arr[end-1])end--;
				start++;
				end--;
			}else if(arr[start]+arr[end]>target) {
				end--;
			}else {
				start++;
			}
		}
		return res;
	}
	
	public static List<List<Integer>>fetchTwoPairSumTimeOptimizedButNotMemoryOptimized(int arr[],int target ){
		Map<Integer,Integer>map=new HashMap<>();
		List<List<Integer>>res=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			int compliment=target-arr[i];
			if(map.containsKey(compliment)) {
				res.add(Arrays.asList(map.get(compliment),i));
			}
				map.put(arr[i], i);
			
	}
		return res;
	}
	
	public static void main(String args[]) {
		System.out.println(fetchTwoPairSumTimeOptimizedButNotMemoryOptimized(new int[]{10, 20, 35, 50, 75, 80} ,110));
		System.out.println(fetchTwoPairSumTimeOptimizedButNotMemoryOptimized(new int[]{1,1,2,2,3,3,4,4,4,7} ,5));
		System.out.println(fetchTwoPairSumTimeOptimizedButNotMemoryOptimized(new int[]{3,3,3,3} ,6));
	}	
	
}