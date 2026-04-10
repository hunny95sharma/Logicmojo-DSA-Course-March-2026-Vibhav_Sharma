package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualOddEven {

	
	public static int[]fetchEqualOddEven(int arr[]){
		int curr_count=0;
		int maxlength=0;
	    int start=0;
	    int end=-1;
	    Map<Integer,Integer>res=new HashMap<>();
	    res.put(0, -1);
	    for(int i=0;i<arr.length;i++) {
	    	if(arr[i]%2==0)
	    		curr_count=curr_count+1;
	    	else
	    		curr_count=curr_count-1;
	    	if(res.containsKey(curr_count)) {
	    		start=res.get(curr_count)+1;
	    		end=i;
	    		if((end-start+1)>maxlength) {
	    			maxlength=end-start+1;
	    			start=res.get(curr_count)+1;
		    		end=i;
	    		}
	    	}else
    			res.put(curr_count,i);
	    }
		
		return new int[] {maxlength,start,end};
	}	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(fetchEqualOddEven(new int[] {1,2,1,2})));

	}
	
}
