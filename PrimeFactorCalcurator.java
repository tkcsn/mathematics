import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 素因数分解の出力クラス
 * 
 * @author tsano
 *
 */
public class PrimeFactorCalcurator {

	/**
	 * ファイルから読み込んだ整数を素因数分解し結果を画面に表示します.
	 * @param args 第一引数：ファイルパス
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		String filePath = args[0];
		List<String> allLine = fileRead(filePath);

		// 各行の素因数分解を行い画面表示
		allLine.forEach(v -> {
			PrimeFactorization primeCalc = new PrimeFactorization();
			primeCalc.calc(Integer.parseInt(v));
			display(v, primeCalc.getPrimeList());
		});
	}
	
	/**
	 * 結果を画面に表示します.
	 * @param num 整数
	 * @param prime 素因数分解
	 */
	public static void display(String num, List<String> prime) {
		List<String> csvData = new ArrayList<String>();
		csvData.add(num);
		csvData.addAll(prime);
		System.out.println(csvData.stream().collect(Collectors.joining(",")));
	}
	
	/**
	 * ファイルデータ読み込み.
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static List<String> fileRead(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		return Files.readAllLines(path);
	}

}
