import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] pi;
	static int cnt = 0;

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
		int N = init();
		String str = br.readLine();
		makeTable(str);
		System.out.println(N - pi[pi.length - 1]);
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