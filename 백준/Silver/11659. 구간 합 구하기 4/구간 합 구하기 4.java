import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, num[];

	public static void solution() throws IOException {
		for (int i = 1; i < N + 1; i++) {
			num[i] += num[i - 1];
		}

		int i, j;
		for (int index = 0; index < M; index++) {
			st = new StringTokenizer(br.readLine());
			i = init(st);
			j = init(st);

			sb.append(num[j] - num[i - 1]).append("\n");
		}
		
		System.out.println(sb);
	}

	public static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st);
		M = init(st);

		num = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			num[i] = init(st);
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