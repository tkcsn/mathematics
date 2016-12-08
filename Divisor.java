package mathematics;

import java.util.stream.IntStream;

public class Divisor {

	public static void main(String[] args) {
		int target = 12;
		int result = IntStream.range(1, target + 1).filter(v -> target % v == 0).sum();
		System.out.println(result);
	}

}
