import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, arr[];

	public static void solution() {
		int start = 0, end = 0, sum = 0, cnt = 0;

		while (true) {
			if (sum >= M) {
				sum -= arr[start++];
			} else if (end == N)
				break;
			else {
				sum += arr[end++];
			}
			if (sum == M) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	public static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st);
		M = init(st);

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = init(st);
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	public static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	public static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

}