import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ネットワーク経路ワード検索クラス
 * @author tsano
 */
public class TracerouteSearch {

	/**
	 * Tracerouteコマンドを実行し、検索ワードがHITするまでのルートを表示します.
	 * 
	 * @param args 第一引数：ホスト / 第二引数：検索ワード
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		String host = args[0];
		String word = args[1];
		
		System.out.println("-----------------------------");
		System.out.println("host:" + host);
		System.out.println("word:" + word);
		System.out.println("-----------------------------");

		String os = System.getProperty("os.name").toLowerCase();

		Process process;
		// os check
		if (os.contains("win")) {
			// windows system
			String[] cmd = new String[]{"tracert", host};
			process = Runtime.getRuntime().exec(cmd);
		} else {
			// others system
			String[] cmd = new String[]{"traceroute", host};
			process = Runtime.getRuntime().exec(cmd);
		}

		List<String> resultLines = readLine(process.getInputStream());
		
		// word search
		for (String string : resultLines) {
			System.out.println(string);
			if (string.contains(word)) {
				break;
			} 
		}
	}
	
	/**
	 * InputStreamから文字列を取得します.
	 * 
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static List<String> readLine(InputStream input) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
            return buffer.lines().collect(Collectors.toList());
        }
	}
}
