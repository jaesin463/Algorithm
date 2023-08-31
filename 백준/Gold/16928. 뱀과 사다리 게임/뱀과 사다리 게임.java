import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[] dis = new int[101];
	static int[] map = new int[101];

	static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		dis[1] = 0;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 1; i <= 6; i++) {
				int next = now + i;
			
				if (next == 100) {
					dis[next] = dis[now] + 1;
					return;
				}
				
				if (next < 101 && dis[next] == 0) {
					if (map[next] != 0 && dis[map[next]] == 0) {
						dis[map[next]] = dis[now] + 1;
						q.add(map[next]);
					} else if (map[next] == 0) {
						dis[next] = dis[now] + 1;
						q.add(next);
					}
				}
				
			}
		}

	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = init(st.nextToken());
		int M = init(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[init(st.nextToken())] = init(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[init(st.nextToken())] = init(st.nextToken());
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		BFS();
		System.out.println(dis[100]);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}