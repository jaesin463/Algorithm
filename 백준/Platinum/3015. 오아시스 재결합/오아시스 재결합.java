import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[] line;

	static void solution() {
		long cnt = 0;
		Stack<person> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			person p = new person(line[i], 1);

			while (!stack.isEmpty() && stack.peek().height <= line[i]) {
				person temp = stack.pop();
				cnt += temp.cnt;
				if (temp.height == line[i]) {
					p.cnt += temp.cnt;
				}
			}
			if(!stack.isEmpty()) {
				cnt++;
			}
			stack.push(p);
		}
		System.out.println(cnt);

	}

	static void make() throws IOException {
		N = init(br.readLine());
		line = new int[N];
		for (int i = 0; i < N; i++) {
			line[i] = init(br.readLine());
			;
		}
		solution();
	}

	public static void main(String[] args) throws IOException {
		make();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

	static class person {
		int height, cnt;

		public person(int height, int cnt) {
			this.height = height;
			this.cnt = cnt;
		}
	}
}