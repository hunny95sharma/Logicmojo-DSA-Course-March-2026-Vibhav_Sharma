package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualNumberZerosOne {
	
	public static int[]fetchEqualNumberZerosOne(int arr[]){
		int curr_count=0;
		int maxlength=0;
		Map<Integer,Integer>res=new HashMap<>();
		int start=0;
		int end=-1;
		int startIndexResult=0;
		int endIndexResult=-1;
		res.put(0, -1);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0)
				arr[i]=-1;
		}
		for(int i=0;i<arr.length;i++) {
			curr_count=curr_count+arr[i];
			if(res.containsKey(curr_count)) {
				start=res.get(curr_count)+1;
				end=i;
				if((end-start+1)>maxlength) {
					maxlength=end-start+1;
					endIndexResult=end;
					startIndexResult=start;
				}
			}else
			res.put(curr_count, i);
		}
		if(endIndexResult==-1)
			return new int[] {};
		return new int[] {maxlength,startIndexResult,endIndexResult};
				
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(fetchEqualNumberZerosOne(new int[] {0,0,1,1,0})));

	}

}
