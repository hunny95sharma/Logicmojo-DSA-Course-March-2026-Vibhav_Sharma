package arrays;

public class MaxMinSubarraySum {
	
	public static int fetchMaxSubArraySum(int arr[]){
		int bestMaxSumTillNow=arr[0];
		int maxSum=arr[0];
		for(int i=1;i<arr.length;i++) {
			int v1=arr[i];
			int v2=bestMaxSumTillNow+arr[i];
			bestMaxSumTillNow=v1>v2?v1:v2;
			maxSum=bestMaxSumTillNow>maxSum?bestMaxSumTillNow:maxSum;
		}
		return maxSum;
	}
	
	public static int fetchMinSubArraySum(int arr[]){
		int bestMaxSumTillNow=arr[0];
		int maxSum=arr[0];
		for(int i=1;i<arr.length;i++) {
			int v1=arr[i];
			int v2=bestMaxSumTillNow+arr[i];
			bestMaxSumTillNow=v1<v2?v1:v2;
			maxSum=bestMaxSumTillNow<maxSum?bestMaxSumTillNow:maxSum;
		}
		return maxSum;
	}
}