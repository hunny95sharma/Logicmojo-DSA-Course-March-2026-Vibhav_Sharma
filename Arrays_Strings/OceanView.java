package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OceanView {

	
	public static List<Integer>fetchOceanViewBruteForce(int arr[]){
		
		List<Integer>res=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			boolean isBigger=false;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]>=arr[i])
					isBigger=true;
			}
			if(!isBigger)
				res.add(i);
		}
		return res;
	}
	
	public static List<Integer>fetchOceanViewSuffix(int arr[]){

		List<Integer>res=new ArrayList<>();
		int maxHeightTillIndex[]=new int[arr.length];
		for(int i=arr.length-2;i>=0;i--) {
			maxHeightTillIndex[i]=arr[i+1]>maxHeightTillIndex[i+1]?arr[i+1]:maxHeightTillIndex[i+1];
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>maxHeightTillIndex[i])
				res.add(i);
		}
		return res;
	}
	
	public static List<Integer>fetchOceanViewOptimized(int arr[]){
   
		int n=arr.length;
		List<Integer>res=new ArrayList<>();
		res.add(n-1);
		int maxi=arr[n-1];
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i]>maxi) {
				maxi=arr[i];
				res.add(i);
			}
		}
		Collections.reverse(res);
		return res;
	}
	
	public static void main(String[] args) {
		
		System.out.println(fetchOceanViewOptimized(new int[] {4,2,3,1}));
		
	}

}
