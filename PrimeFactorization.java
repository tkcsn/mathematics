import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * 素因数分解クラス
 * 
 * @author tsano
 *
 */
public class PrimeFactorization {
	
	// 素因数分解リスト
	private List<String> primeNumberList;

	public PrimeFactorization() {
		primeNumberList = new ArrayList<String>();
	}

	/**
	 * 素因数分解を行います.
	 * @param num 整数
	 */
	public PrimeFactorization calc(int num) {
		
		if (isPrimeNumber(num)) {
			primeNumberList.add(String.valueOf(num));
			return this;
		}
		
		int[] o = IntStream.range(2, num + 1).toArray();
		
		OptionalInt d = Arrays.stream(o)
				.filter(v -> num % v == 0 && isPrimeNumber(v)) //素数 かつ 割り切れる
				.findFirst();
		
		primeNumberList.add(String.valueOf(d.getAsInt()));
		
		return calc(num/d.getAsInt());
	}
	
	/**
	 * 素因数分解の結果を返却します.
	 * @return
	 */
	public List<String> getPrimeList() {
		return this.primeNumberList;
	}
	
	/**
	 * 素数判定を行います.
	 * @param num 整数
	 * @return true:素数 false:非素数
	 */
	public boolean isPrimeNumber(int num) {
		long c = IntStream.range(2, num)
				.filter(v -> v % 2 != 0) // 偶数排除
				.filter(v -> num % v == 0) // 対象を割り切れる
				.count();
		return c == 0;
	}

}
