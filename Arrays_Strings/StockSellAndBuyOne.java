package arrays;

import java.util.Arrays;

public class StockSellAndBuyOne {

	
	public static int []stockSellAndBuy1(int arr[]){
		int buyPrice=arr[0];
		int buyPriceIndex=0;
		int bestBuyIndex = 0;
		int sellPriceIndex=Integer.MIN_VALUE;
		int maxProfit=Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++) {
			if (arr[i] < buyPrice) {
	            buyPrice = arr[i];
	            buyPriceIndex = i;
	        }
			int profit = arr[i] - buyPrice;
			if (profit > maxProfit) {
	            maxProfit = profit;
	            bestBuyIndex = buyPriceIndex; 
	            sellPriceIndex = i;
	        }
		}
		return new int[] {maxProfit,bestBuyIndex,sellPriceIndex};
	}
	
	
	public static void main(String[] args) {
		
System.out.println(Arrays.toString(stockSellAndBuy1(new int[] {7,1,5,3,6,4})));
		
	}

}