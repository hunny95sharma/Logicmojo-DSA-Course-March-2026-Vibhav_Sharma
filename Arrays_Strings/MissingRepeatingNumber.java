package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRepeatingNumber {
	
	public static List<Integer>findMissingRepeatingNumber(List<Integer>arr){
		
		List<Integer>res=new ArrayList<Integer>();
		for(int i=0;i<arr.size();i++) {
			int idx=Math.abs(arr.get(i))-1;
			if(arr.get(idx)<0)
				res.add(Math.abs(arr.get(i)));
			else
				arr.set(idx, arr.get(idx)*-1);
		}
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)>0)
				res.add(i+1);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(findMissingRepeatingNumber(Arrays.asList(3,1,3)));

	}

}
