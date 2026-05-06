package recursion;

public class FactorialTrailingZeros {

	public int trailingZeroes(int n) {

		return trailingZeroesHelper(n);

	}

	private int trailingZeroesHelper(int n) {

		int count=n/5;

		if(count==0)
			return 0;

		return count+trailingZeroesHelper(n/5);


	}

}