import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] segment, num;
	static int N, M;
	static int min;

	static void create(int[] tree, int start, int end, int node) {
		int leftNode = (node << 1);
		int rightNode = (node << 1) + 1;

		if (start == end)
			tree[node] = num[start];
		else {
			int mid = start + (end - start) / 2;

			create(tree, start, mid, leftNode);
			create(tree, mid + 1, end, rightNode);

			tree[node] = Math.min(tree[leftNode], tree[rightNode]);
		}
	}

	static void read(int start, int end, int node, int left, int right) {
		if (left > end || right < start)
			return;

		if (left <= start && end <= right) {
			min = Math.min(min, segment[node]);
			return;
		}
		
		int mid = start + (end - start) / 2;
		
		read(start, mid, (node << 1), left, right);
		read(mid + 1, end, (node << 1) + 1, left, right);
	}

	static int update(int start, int end, int node, int idx, int val) {
		if (idx < start || idx > end) {
			return segment[node];
		}

		if (start == end) {
			return segment[node] = val;
		}

		int mid = start + (end - start) / 2;
		
		int left = update(start, mid, (node << 1), idx, val);
		int right = update(mid + 1, end, (node << 1) + 1, idx, val);
		
		return segment[node] = Math.min(left, right);
	}

	public static void solution() throws IOException {
		M = init();

		int a, b, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = init(st);
			b = init(st);
			c = init(st);

			if (a == 1) {
				update(1, N, 1, b, c);
			} else {
				min = (int) 1e9;
				read(1, N, 1, b, c);
				sb.append(min).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void make() throws IOException {
		N = init();

		num = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			num[i] = init(st);
		}

		segment = new int[N << 2];
		create(segment, 1, N, 1);
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