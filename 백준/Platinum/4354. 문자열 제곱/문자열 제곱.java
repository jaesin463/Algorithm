import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] pi;
	static int cnt = 0;

	public static void search(String str, String pattern) {
		int sLen = str.length();
		int pLen = pattern.length();
		int index = 0;
		cnt = 0;
		for (int i = 0; i < sLen - 1; i++) {
			while (index > 0 && str.charAt(i) != pattern.charAt(index)) {
				index = pi[index - 1];
			}
			if (str.charAt(i) == pattern.charAt(index)) {
				if (index == pLen - 1) {
					index = pi[index];
					cnt++;
				} else {
					index++;
				}
			}
		}
	}

	public static void makeTable(String pattern) {
		int pLen = pattern.length();
		pi = new int[pLen];

		int prefix = 0;
		for (int suffix = 1; suffix < pLen; suffix++) {
			while (prefix > 0 && pattern.charAt(suffix) != pattern.charAt(prefix)) {
				prefix = pi[prefix - 1];
			}
			if (pattern.charAt(suffix) == pattern.charAt(prefix)) {
				pi[suffix] = ++prefix;
			}
		}
	}

	static void make() throws IOException {
		while (true) {
			String str = br.readLine();
			if (str.equals("."))
				break;
			makeTable(str);
			search(str + str, str);
			sb.append(cnt).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		make();
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}