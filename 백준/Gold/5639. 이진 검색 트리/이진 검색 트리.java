import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringTokenizer st;
	static Vertex vertex;

	static void dfs(Vertex v) {
		if (v.left != null)
			dfs(v.left);
		if (v.right != null)
			dfs(v.right);
		System.out.println(v.num);
	}

	static class Vertex {
		int num;
		Vertex left, right;

		public Vertex(int num) {
			this.num = num;
		}
	}

	static void insert(Vertex v, int num) {
		if (num < v.num) {
			if (v.left != null) {
				insert(v.left, num);
			} else {
				v.left = new Vertex(num);
			}
		} else {
			if (v.right != null) {
				insert(v.right, num);
			} else {
				v.right = new Vertex(num);
			}
		}
	}

	static void make() throws IOException {
		String start = br.readLine();
		vertex = new Vertex(Integer.parseInt(start));
		start = br.readLine();
		while (start != null) {
			try {
				insert(vertex, Integer.parseInt(start));
				start = br.readLine();
			} catch (NumberFormatException e) {
				return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		dfs(vertex);
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}