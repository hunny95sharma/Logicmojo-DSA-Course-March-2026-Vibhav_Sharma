package arrays;

public class MaxMinSubArrayProduct {

	public static int fetchMaxProductSubarray(int arr[]) {
		int maxBestEnding=arr[0];
		int minBestEnding=arr[0];
		int maxProduct=0;
		for(int i=1;i<arr.length;i++) {
			int v1=arr[i];
			int v2=minBestEnding*arr[i];
			int v3=maxBestEnding*arr[i];
			minBestEnding=v1<v2?(v1<v3?v1:v3):(v2<v3?v2:v3);
			maxBestEnding=v1>v2?(v1>v3?v1:v3):(v2>v3?v2:v3);
			maxProduct=maxProduct>minBestEnding?(maxProduct>maxBestEnding?maxProduct:maxBestEnding):(minBestEnding>maxBestEnding?minBestEnding:maxBestEnding);
		}
		return maxProduct;
	}
	
	public static int fetchMinProductSubarray(int arr[]) {
		int maxBestEnding=arr[0];
		int minBestEnding=arr[0];
		int maxProduct=0;
		for(int i=1;i<arr.length;i++) {
			int v1=arr[i];
			int v2=minBestEnding*arr[i];
			int v3=maxBestEnding*arr[i];
			minBestEnding=v1<v2?(v1<v3?v1:v3):(v2<v3?v2:v3);
			maxBestEnding=v1>v2?(v1>v3?v1:v3):(v2>v3?v2:v3);
			maxProduct=maxProduct<minBestEnding?(maxProduct<maxBestEnding?maxProduct:maxBestEnding):(minBestEnding<maxBestEnding?minBestEnding:maxBestEnding);
		}
		return maxProduct;
	}
}
