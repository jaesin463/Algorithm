import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, L;

	static void solution() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st.nextToken());
		L = init(st.nextToken());
		Deque<int[]> dq = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = init(st.nextToken());
			while (!dq.isEmpty() && dq.peekLast()[0] > num) {
				dq.pollLast();
			}
			dq.offer(new int[] { num, i });
			if (dq.peekFirst()[1] < i - L + 1) {
				dq.pollFirst();
			}
			bw.write(dq.peekFirst()[0] + " ");
		}
		bw.flush();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		solution();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
