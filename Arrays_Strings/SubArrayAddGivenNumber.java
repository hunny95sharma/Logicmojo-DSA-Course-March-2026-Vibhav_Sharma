package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArrayAddGivenNumber {
	
	public static int[]fetchSubArrayAddGivenNumber(int arr[],int target){
		int curr_count=0;
		int start=0;
		int end=-1;
		Map<Integer,Integer>res=new HashMap<>();
		res.put(0, -1);
		for(int i=0;i<arr.length;i++) {
			curr_count=curr_count+arr[i];
			if(res.containsKey(curr_count-target)) {
				start=res.get(curr_count-target)+1;
				end=i;
				break;
			}
			res.put(curr_count, i);
		}
		if(end!=-1)
			return new int[] {start,end};
				else
					return new int[] {};	
			
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(fetchSubArrayAddGivenNumber(new int[] {1, 4, 20, 3, 10, 5},33)));
	}

}
