import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, K;
	static int[] parent;
	static int[] blue;
	static int[] magic;

	static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y) {
			parent[x] = y;
		} else {
			parent[y] = x;
		}
	}

	static int upper_bound(int target) {
		int start = 0;
		int end = M;
		while (start < end) {
			int mid = (start + end) / 2;
			if (blue[mid] < target) {
				start = mid + 1;
			} else if (blue[mid] > target) {
				end = mid;
			} else {
				return mid + 1;
			}
		}
		return end;
	}

	static void solution() throws IOException {
		for (int i = 0; i < K; i++) {
			int idx = upper_bound(magic[i]);
			idx = find(idx);

			System.out.println(blue[idx]);

			if (idx != M - 1)
				union(idx, idx + 1);
		}
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st.nextToken());
		M = init(st.nextToken());
		K = init(st.nextToken());

		blue = new int[M];
		parent = new int[M];
		magic = new int[K];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			parent[i] = i;
			blue[i] = init(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			magic[i] = init(st.nextToken());
		}

		Arrays.sort(blue);
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}