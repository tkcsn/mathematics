package mathematics;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class PrimeFactorization {

	public static void main(String[] args) {
		factorio(27);
	}
	
	public static void factorio(int t) {
		
		if (isPrimeNumber(t)) {
			System.out.println(t);
			return;
		}
		
		int[] o = IntStream.range(2, t + 1).toArray();
		
		OptionalInt d = Arrays.stream(o)
				.filter(v -> t % v == 0 && isPrimeNumber(v)) //素数 かつ 割り切れる
				.findFirst();
		
		System.out.println(d.getAsInt());
		
		factorio(t/d.getAsInt());
	}
	
	public static boolean isPrimeNumber(int num) {
		long c = IntStream.range(2, num)
				.filter(v -> v % 2 != 0) // 偶数排除
				.filter(v -> num % v == 0) // 対象を割り切れる
				.count();
		return c == 0;
	}

}
