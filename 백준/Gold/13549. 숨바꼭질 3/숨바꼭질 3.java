import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] hide = new int[100001];
	static int cnt = 0;

	static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		hide[N] = 1;
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == K) {
				min = Math.min(min, now);
			}
			if (2 * now < 100001 && hide[2 * now] == 0) {
				q.add(2 * now);
				hide[2 * now] = hide[now];
			}
			if (now > 0 && hide[now - 1] == 0) {
				q.add(now - 1);
				hide[now - 1] = hide[now] + 1;
			}
			if (now < 100000 && hide[now + 1] == 0) {
				q.add(now + 1);
				hide[now + 1] = hide[now] + 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = init(st.nextToken());
		K = init(st.nextToken());
		BFS();
		System.out.println(hide[K] - 1);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
