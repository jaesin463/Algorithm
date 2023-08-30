import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static boolean[][] hide = new boolean[2][500001];
	static int cnt = 0;

	static int BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		hide[0][N] = true;
		int size, mod, time = 0;
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			size = q.size();
			time++;
			mod = time % 2;

			K += time;
			if (K > 500000) {
				return -1;
			}

			for (int i = 0; i < size; i++) {
				int now = q.poll();
				if (2 * now < 500001 && !hide[mod][2 * now]) {
					q.add(2 * now);
					hide[mod][2 * now] = true;
				}
				if (now > 0 && !hide[mod][now - 1]) {
					q.add(now - 1);
					hide[mod][now - 1] = true;
				}
				if (now < 500000 && !hide[mod][now + 1]) {
					q.add(now + 1);
					hide[mod][now + 1] = true;
				}
			}

			if (hide[mod][K]) {
				return time;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = init(st.nextToken());
		K = init(st.nextToken());

		System.out.println(N == K ? 0 : BFS());
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
