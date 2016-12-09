package mathematics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumber {

	public static void main(String[] args) {
		String filePath = args[0];

		List<String> allLine = null;
		try {
			allLine = fileRead(filePath);
			allLine.forEach(v -> {
				PrimeFactorization primeCalc = new PrimeFactorization();
				primeCalc.calc(Integer.parseInt(v));
				output(v, primeCalc.getPrimeList());
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void output(String num, List<String> prime) {
		String xx = prime.stream().collect(Collectors.joining(","));
		System.out.println(num + ":" + xx);
	}
	
	public static List<String> fileRead(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		return Files.readAllLines(path);
	}

}
