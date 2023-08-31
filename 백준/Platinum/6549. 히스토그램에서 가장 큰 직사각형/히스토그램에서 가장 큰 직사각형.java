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
	static int[] square;

	static void solution() {
		long max = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && square[stack.peek()] >= square[i]) {
				long height = square[stack.pop()];
				long width = 0;
				if (stack.isEmpty())
					width = i;
				else
					width = i - 1 - stack.peek();
				max = Math.max(max, height * width);
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			long height = square[stack.pop()];
			long width = 0;
			if (stack.isEmpty())
				width = N;
			else
				width = N - 1 - stack.peek();
			max = Math.max(max, height * width);
		}
		sb.append(max + "\n");
	}

	static void make() throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			if (st.countTokens() == 1)
				break;
			N = init(st.nextToken());
			square = new int[N];
			for (int i = 0; i < N; i++) {
				square[i] = init(st.nextToken());
			}
			solution();
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		System.out.println(sb);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}