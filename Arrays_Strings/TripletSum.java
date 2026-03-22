package arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {
	
 public static List<List<Integer>> fetchTripletSum(int arr[],int target){
	 Arrays.sort(arr);
	 List<List<Integer>> res=new ArrayList<>();
		for (int i=0;i<arr.length;i++) {
			if(i>0&& arr[i]==arr[i-1])continue;
			int start=i+1;
			int end=arr.length-1;
			while(start<end) {
				if(arr[i]+arr[start]+arr[end]==target) {
					res.add(Arrays.asList(arr[i],arr[start],arr[end]));
					while(start<end && arr[start]==arr[start+1])start++;
					while(start<end && arr[end]==arr[end-1])end--;
					start++;
					end--;
				}else if(arr[i]+arr[start]+arr[end]>target) {
					end--;
				}else {
					start++;
				}
			}
		}	
		
		return res;
 }

	public static void main(String[] args) {
		
System.out.println(fetchTripletSum(new int[] {0, -1, 2, -3, 1},0));
System.out.println(fetchTripletSum(new int[] {1,-2,1,0,5},0));
System.out.println(fetchTripletSum(new int[] {1,1,1,2,2,2,3,3,3,4,4,4},6));

	}

}