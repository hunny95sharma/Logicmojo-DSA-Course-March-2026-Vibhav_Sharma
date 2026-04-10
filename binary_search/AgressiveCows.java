package binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AgressiveCows {

	public static int fetchAgressiveCowsBruteForce(int arr[],int cows) {
		Arrays.sort(arr);
		int maxDistance=arr[arr.length-1]-arr[0];
		List<Integer>res=new ArrayList<>();
		List<Integer>prev=new ArrayList<>();
		for(int i=1;i<=maxDistance;i++) {
			prev=res;
			res=isCowsPlaced(arr,i,cows);
			if(res!=null)
				continue;
			else {
				System.out.println(prev);
				return i-1;
			}
		}
		return maxDistance;
	}
	
	public static int fetchAgressiveCowsBinarySearch(int arr[],int cows) {
		Arrays.sort(arr);
		int left=1;
		int right=arr[arr.length-1]-arr[0];
		List<Integer>res=new ArrayList<>();
		List<Integer>ans=new ArrayList<>();
		int maxDistance=0;
		while(left<=right) {
			int mid=left+(right-left)/2;
			res=isCowsPlaced(arr,mid,cows);
			if(res!=null) {
				maxDistance=mid;
				ans=res;
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		if(ans!=null)
			System.out.println(ans);
		return maxDistance;
	}
	
	
	private static List<Integer> isCowsPlaced(int[] arr, int dist, int cows) {
		int cowCount=1; 
		int lastCow=arr[0];
		List<Integer>res=new ArrayList<>();
		res.add(0);
		for(int i=1;i<arr.length;i++) {
			if(arr[i]-lastCow>=dist) {
				lastCow=arr[i];
				cowCount++;
				res.add(i);
			}
			if(cowCount==cows) {
				return res;
			}
		}
		return null;
	}


	public static void main(String[] args) {
		System.out.println(fetchAgressiveCowsBinarySearch(new int[] {2, 12, 11, 3, 26, 7},5));
	}

}
