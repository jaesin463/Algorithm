import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int result[];
	static boolean visited[];

	static void recur(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			result[depth] = i + 1;
			recur(depth + 1);
		}
	}

	static void solution() throws IOException {
		recur(0);
		System.out.println(sb);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[M];
		visited = new boolean[N + 1];
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}