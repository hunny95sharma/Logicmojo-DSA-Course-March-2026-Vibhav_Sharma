package arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {

	
	public static List<Integer>fetchAllDuplicates(int arr[]){
		
		List<Integer>result=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			int index=Math.abs(arr[i])-1;
			if(arr[index]<0)
			{
				result.add(Math.abs(index+1));
			}else {
				arr[index]=arr[index]*-1;
			}
		}
	    for (int i = 0; i < arr.length; i++) {
	    	arr[i] = Math.abs(arr[i]);
	    }
		return result;
	}
	
public static void main(String[] args) {
		
	    System.out.println(fetchAllDuplicates(new int[] {4,3,2,7,8,2,3,1}));	
		}
	
}