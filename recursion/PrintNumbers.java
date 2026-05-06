package recursion;

public class PrintNumbers {

	public static void printAsc(int n){

		if(n<=0)
			return;
		printAsc(n-1);
		System.out.print(n+" ");
	}
	
	public static void printDsc(int n){

		if(n<=0)
			return;
		System.out.print(n+" ");
		printAsc(n-1);
	}


}