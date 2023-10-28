import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[] A, B;
	static int sum = 0;

	public static void solution() {
		int result = 0;

		for (int j = 0; j < N; j++) {
			int first = 0;
			int end = M - 1;
			int index = 0;

			while (first <= end) {
				int mid = (first + end) / 2;
				if (B[mid] < A[j]) {
					first = mid + 1;
					index = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			result += index;
		}

		sb.append(result).append("\n");
	}

	public static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st);
		M = init(st);

		A = new int[N];
		B = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = init(st);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = init(st);
		}

		Arrays.sort(B);
	}

	public static void main(String[] args) throws IOException {
		int T = init();
		for (int i = 0; i < T; i++) {
			make();
			solution();
		}
		System.out.println(sb);
	}

	public static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	public static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

}