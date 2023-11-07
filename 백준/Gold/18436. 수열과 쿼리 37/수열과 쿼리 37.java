import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int num[], tree[][];
	static int N, M;

	static void create(int s, int e, int node) {
		int leftNode = (node << 1);
		int rightNode = (node << 1) + 1;

		if (s == e) {
			if ((num[s] & 1) == 1) {
				tree[node][0] = 1;
			} else
				tree[node][1] = 1;
		} else {
			int m = s + (e - s) / 2;

			create(s, m, leftNode);
			create(m + 1, e, rightNode);

			tree[node][0] = tree[leftNode][0] + tree[rightNode][0];
			tree[node][1] = tree[leftNode][1] + tree[rightNode][1];
		}
	}

	static void update(int s, int e, int node, int idx, int val) {
		int leftNode = (node << 1);
		int rightNode = (node << 1) + 1;

		if (idx < s || idx > e) {
			return;
		}

		if (s == e) {
			if ((val & 1) == 1) {
				tree[node][1] = 0;
				tree[node][0] = 1;
			} else {
				tree[node][0] = 0;
				tree[node][1] = 1;
			}
		} else {
			int m = s + (e - s) / 2;

			update(s, m, leftNode, idx, val);
			update(m + 1, e, rightNode, idx, val);

			tree[node][0] = tree[leftNode][0] + tree[rightNode][0];
			tree[node][1] = tree[leftNode][1] + tree[rightNode][1];
		}
	}

	static int read(boolean isOdd, int s, int e, int node, int l, int r) {
		if (l > e || r < s)
			return 0;
		if (l <= s && e <= r) {
			if (isOdd)
				return tree[node][0];
			else
				return tree[node][1];
		}

		int mid = s + (e - s) / 2;

		int left = read(isOdd, s, mid, (node << 1), l, r);
		int right = read(isOdd, mid + 1, e, (node << 1) + 1, l, r);

		return left + right;
	}

	static void solution() throws IOException {
		M = init();

		int op, a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			op = init(st);
			a = init(st);
			b = init(st);

			if (op == 1)
				update(1, N, 1, a, b);
			else if (op == 2)
				sb.append(read(false, 1, N, 1, a, b)).append("\n");
			else
				sb.append(read(true, 1, N, 1, a, b)).append("\n");
		}

		System.out.println(sb);
	}

	static void make() throws IOException {
		N = init();

		num = new int[N + 1];
		tree = new int[N << 2][2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			num[i] = init(st);
		}

		create(1, N, 1);
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