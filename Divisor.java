import java.util.stream.IntStream;

/**
 * 約数の合計計算クラス
 * 
 * @author tsano
 *
 */
public class Divisor {

	/**
	 * 引数（整数）の約数を全て足し算した合計を表示します.
	 * @param args 第一引数：整数
	 */
	public static void main(String[] args) {
		int target = Integer.parseInt(args[0]);
		int result = IntStream.range(1, target + 1) 
				.filter(v -> target % v == 0)
				.sum();
		System.out.println(result);
	}

}
