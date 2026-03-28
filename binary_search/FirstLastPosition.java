package binary_search;

import java.util.Arrays;

public class FirstLastPosition {
	
	public static int fetchFirstPosition(int arr[],int target) {
		int ans=arr.length;
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]>=target) {
				ans=mid;
				end=mid-1;
			}else {
			start=mid+1;
			}
		}
		return ans;
	}
	
	public static int fetchLastPosition(int arr[],int target) {
		int ans=arr.length;
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]>target) {
				ans=mid;
				end=mid-1;
			}else {
			start=mid+1;
			}
		}
		return ans;
	}
	
	
	public static int[] fetchFirstLastPositionCombined(int arr[],int target) {
		int first=-1;
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target) {
				first=mid;
				end=mid-1;
			}else if(arr[mid]>target) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		start=0;
		end=arr.length-1;
		int last=-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target) {
				last=mid;
				start=mid+1;
			}else if(arr[mid]>target) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return new int[] {first,last};
	}
	
	public static int[] searchRange(int[] nums, int target) {
        if(fetchFirstPosition(nums,target)==nums.length || nums[fetchFirstPosition(nums,target)]!=target)
			return new int[] {-1,-1};
		return new int[] {fetchFirstPosition(nums,target),fetchLastPosition(nums,target)-1};
    }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10},6)));
	}

}
