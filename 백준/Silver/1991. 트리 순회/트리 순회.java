import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[][] tree;
	static StringBuilder sb = new StringBuilder();
	static int N;

	static void preOrder(int i) {
		if (i < N) {
			sb.append(tree[i][0]);
			if (tree[i][1] != '.')
				preOrder(tree[i][1] - 'A');
			if (tree[i][2] != '.')
				preOrder(tree[i][2] - 'A');
		}
	}

	static void inOrder(int i) {
		if (i < N) {
			if (tree[i][1] != '.')
				inOrder(tree[i][1] - 'A');
			sb.append(tree[i][0]);
			if (tree[i][2] != '.')
				inOrder(tree[i][2] - 'A');
		}
	}

	static void postOrder(int i) {
		if (i < N) {
			if (tree[i][1] != '.')
				postOrder(tree[i][1] - 'A');
			if (tree[i][2] != '.')
				postOrder(tree[i][2] - 'A');
			sb.append(tree[i][0]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = init(br.readLine());
		tree = new char[N][3];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int now = str.charAt(0) - 'A';
			char left = str.charAt(2);
			char right = str.charAt(4);
			tree[now][0] = str.charAt(0);
			tree[now][1] = left;
			tree[now][2] = right;
		}
		preOrder(0);
		sb.append("\n");
		inOrder(0);
		sb.append("\n");
		postOrder(0);
		System.out.println(sb.toString());
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
