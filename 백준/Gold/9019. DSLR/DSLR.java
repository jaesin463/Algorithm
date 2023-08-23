import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int A, B;
	static int idx = 0;
	static boolean[] DSLR;
	static String[] oper;

	static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		DSLR = new boolean[10000];
		oper = new String[10000];
		q.add(A);
		DSLR[A] = true;
		oper[A] = "";
		while (!q.isEmpty() && !DSLR[B]) {
			int now = q.poll();
			// D 연산
			int next = (2 * now) % 10000;
			if (!DSLR[next]) {
				DSLR[next] = true;
				oper[next] = oper[now] + 'D';
				q.add(next);
			}
			// S 연산
			next = now - 1;
			if (now == 0) {
				next = 9999;
			}
			if (!DSLR[next]) {
				DSLR[next] = true;
				oper[next] = oper[now] + 'S';
				q.add(next);
			}
			// L 연산
			next = (now % 1000) * 10 + now / 1000;
			if (!DSLR[next]) {
				DSLR[next] = true;
				oper[next] = oper[now] + 'L';
				q.add(next);
			}
			// R 연산
			next = (now % 10) * 1000 + now / 10;
			if (!DSLR[next]) {
				DSLR[next] = true;
				oper[next] = oper[now] + 'R';
				q.add(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int test_case = init(br.readLine());

		for (int tc = 0; tc < test_case; tc++) {
			st = new StringTokenizer(br.readLine());
			A = init(st.nextToken());
			B = init(st.nextToken());
			BFS();
			sb.append(oper[B] + "\n");
		}
		System.out.println(sb.toString());
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
