import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] arr, tree;
	static int N, M;

	static int create(int s, int e, int node) {
		if (s == e)
			return tree[node] = s;

		int mid = s + (e - s) / 2;
		int left = create(s, mid, node * 2);
		int right = create(mid + 1, e, node * 2 + 1);

		return tree[node] = getIndex(left, right);
	}

	static int update(int s, int e, int node, int idx) {
		if (s > idx || e < idx)
			return tree[node];

		if (s == e)
			return tree[node] = idx;

		int mid = s + (e - s) / 2;
		int left = update(s, mid, node * 2, idx);
		int right = update(mid + 1, e, node * 2 + 1, idx);

		return tree[node] = getIndex(left, right);
	}

	static int read(int s, int e, int node, int l, int r) {
		if (r < s || l > e)
			return 0;

		if (l <= s && e <= r) {
			return tree[node];
		}

		int mid = s + (e - s) / 2;
		int left = read(s, mid, node * 2, l, r);
		int right = read(mid + 1, e, node * 2 + 1, l, r);

		return getIndex(left, right);
	}

	static int getIndex(int left, int right) {
		if (arr[left] == arr[right])
			return getMin(left, right);
		else if (arr[left] < arr[right])
			return left;
		else
			return right;
	}

	static int getMin(int left, int right) {
		if (left < right) {
			return left;
		} else
			return right;
	}

	static void solution() throws IOException {
		M = init();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int op = init(st);
			int a = init(st);
			int b = init(st);

			if (op == 1) {
				arr[a] = b;
				update(1, N, 1, a);
			} else {
				sb.append(read(1, N, 1, a, b)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static void make() throws IOException {
		N = init();

		arr = new int[N + 1];
		arr[0] = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = init(st);
		}

		tree = new int[N * 4];
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