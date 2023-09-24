import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, R, Q;
	static int[] parent;
	static int[] size;
	static ArrayList<Integer>[] list, tree;

	static void makeTree(int curNode, int p) {
		for (int node : list[curNode]) {
			if (node != p) {
				tree[curNode].add(node);
				parent[node] = curNode;
				makeTree(node, curNode);
			}
		}
	}

	static void countSubtreeNodes(int curNode) {
		size[curNode] = 1;
		for (int node : tree[curNode]) {
			countSubtreeNodes(node);
			size[curNode] += size[node];
		}
	}

	static void solution() throws IOException {
		makeTree(R, -1);
		countSubtreeNodes(R);
		while (Q-- != 0) {
			int query = init(br.readLine());
			sb.append(size[query]).append("\n");
		}
		System.out.println(sb);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		size = new int[N + 1];
		list = new ArrayList[N + 1];
		tree = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int now = init(st.nextToken());
			int next = init(st.nextToken());

			list[now].add(next);
			list[next].add(now);
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}