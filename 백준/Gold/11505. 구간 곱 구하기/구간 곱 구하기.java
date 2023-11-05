import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static final int MOD = 1000000007;
	static long[] num, tree;
	static int N, M, K;

	static void makeSegment(int start, int end, int node) {
		int leftNode = (node << 1);
		int rightNode = (node << 1) + 1;

		if (start == end)
			tree[node] = num[start];
		else {
			int mid = start + (end - start) / 2;
			makeSegment(start, mid, leftNode);
			makeSegment(mid + 1, end, rightNode);

			tree[node] = (tree[leftNode] * tree[rightNode]) % MOD;
		}
	}

	static long findValue(int start, int end, int node, int left, int right) {
		int leftNode = (node << 1);
		int rightNode = (node << 1) + 1;

		if (left > end || right < start)
			return 1;

		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = start + (end - start) / 2;

		long leftValue = findValue(start, mid, leftNode, left, right);
		long rightValue = findValue(mid + 1, end, rightNode, left, right);

		return (leftValue * rightValue) % MOD;
	}

	static long update(int start, int end, int node, int idx, long val) {
		int leftNode = (node << 1);
		int rightNode = (node << 1) + 1;

		if (idx < start || idx > end) {
			return tree[node];
		}

		if (start == end) {
			return tree[node] = val;
		}

		int mid = (start + end) / 2;
		long left = update(start, mid, leftNode, idx, val);
		long right = update(mid + 1, end, rightNode, idx, val);
		return tree[node] = (left * right) % MOD;
	}

	public static void solution() throws IOException {
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = init(st);
			int b = init(st);
			int c = init(st);

			if (a == 1) {
				update(1, N, 1, b, c);
			} else if (a == 2) {
				sb.append(findValue(1, N, 1, b, c)).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

	public static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st);
		M = init(st);
		K = init(st);

		num = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			num[i] = init();
		}

		tree = new long[N * 4];

		makeSegment(1, N, 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
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