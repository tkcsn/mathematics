package mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class PrimeFactorization {
	
	private List<String> primeNumberList;

	public PrimeFactorization() {
		primeNumberList = new ArrayList<String>();
	}

	/**
	 * 
	 * @param t
	 */
	public PrimeFactorization calc(int t) {
		
		if (isPrimeNumber(t)) {
			primeNumberList.add(String.valueOf(t));
			return this;
		}
		
		int[] o = IntStream.range(2, t + 1).toArray();
		
		OptionalInt d = Arrays.stream(o)
				.filter(v -> t % v == 0 && isPrimeNumber(v)) //素数 かつ 割り切れる
				.findFirst();
		
		primeNumberList.add(String.valueOf(d.getAsInt()));
		
		return calc(t/d.getAsInt());
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getPrimeList() {
		return this.primeNumberList;
	}
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPrimeNumber(int num) {
		long c = IntStream.range(2, num)
				.filter(v -> v % 2 != 0) // 偶数排除
				.filter(v -> num % v == 0) // 対象を割り切れる
				.count();
		return c == 0;
	}

}
