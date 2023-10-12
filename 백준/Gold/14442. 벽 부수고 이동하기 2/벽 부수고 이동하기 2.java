import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, K, map[][];
	static int min = Integer.MAX_VALUE;
	static boolean visited[][][];
	static List<Wall> wall = new ArrayList<>();
	static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void escape() {
		Queue<Wall> q = new LinkedList<>();
		visited = new boolean[N][M][K + 1];

		q.add(new Wall(0, 0, 1, 0));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Wall cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			int dis = cur.dis;
			int crack = cur.crack;

			if (r == N - 1 && c == M - 1) {
				min = Math.min(min, dis);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int dr = r + delta[i][0];
				int dc = c + delta[i][1];

				if (index(dr, dc)) {
					if (map[dr][dc] == 1) {
						if (crack < K && !visited[dr][dc][crack]) {
							visited[dr][dc][crack] = true;
							q.add(new Wall(dr, dc, dis + 1, crack + 1));
						}
					} else {
						if (!visited[dr][dc][crack]) {
							visited[dr][dc][crack] = true;
							q.add(new Wall(dr, dc, dis + 1, crack));
						}
					}
				}
			}
		}

	}

	static void solution() {
		escape();
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st);
		M = init(st);
		K = init(st);

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
	}

	static class Wall {
		int r, c;
		int dis, crack;

		public Wall(int r, int c, int dis, int crack) {
			this.r = r;
			this.c = c;
			this.dis = dis;
			this.crack = crack;
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static boolean index(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M)
			return false;
		return true;
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}
