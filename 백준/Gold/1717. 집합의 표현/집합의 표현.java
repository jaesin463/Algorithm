import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[] arr;

	static void make_set() {
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
	}

	static int find_set(int a) {
		if (arr[a] == a)
			return a;

		return arr[a] = find_set(arr[a]);
	}

	static void union(int a, int b) {
		arr[find_set(b)] = find_set(a);
	}

	static void solution() throws IOException {
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int oper = init(st.nextToken());
			int a = init(st.nextToken());
			int b = init(st.nextToken());

			if (oper == 1)
				sb.append(find_set(a) == find_set(b) ? "YES\n" : "NO\n");
			else
				union(a, b);
		}
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st.nextToken());
		M = init(st.nextToken());
		arr = new int[N + 1];
		make_set();
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
		System.out.println(sb);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
