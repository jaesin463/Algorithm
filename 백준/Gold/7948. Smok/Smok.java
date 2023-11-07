import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, sheep[];
	static int result = 0;

	static int findMax() {
		int idx = 1;
		for (int i = 2; i < N + 1; i++) {
			if (sheep[i] > sheep[idx]) {
				idx = i;
			}
		}
		return idx;
	}

	static void solution() throws IOException {
		for (int i = 0; i < N; i++) {
			int idx = findMax();
			int max = sheep[idx];
			result += Math.max(max - i, 0);
			sheep[idx] = 0;
		}
		System.out.println(result);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st);
		result = 0;
		sheep = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			sheep[i] = init(st);
		}
	}

	public static void main(String[] args) throws IOException {
		int T = init();
		while (T-- > 0) {
			make();
			solution();
		}
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}