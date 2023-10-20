import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;

	static void solution() {
		int lo = 1;
		int hi = K;

		while (lo < hi) {
			int mid = (lo + hi) / 2;
			int cnt = 0;

			for (int i = 1; i < N + 1; i++) {
				cnt += Math.min(mid / i, N);
			}

			if (K <= cnt)
				hi = mid;
			else
				lo = mid + 1;
		}

		System.out.println(lo);
	}

	static void make() throws IOException {
		N = init();
		K = init();
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}