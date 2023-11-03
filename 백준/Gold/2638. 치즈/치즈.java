import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, cheese[][];
	static boolean visited[][];
	static int cnt = 0;
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static void check() {
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			// (i,0), (i, N - 1)
			if (!visited[i][0])
				BFS(i, 0);
			if (!visited[i][M - 1])
				BFS(i, M - 1);
		}

		for (int i = 0; i < M; i++) {
			// (0, i), (N - 1, i)
			if (!visited[0][i])
				BFS(0, i);
			if (!visited[N - 1][i])
				BFS(N - 1, i);
		}
	}

	static void BFS(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(row, col));
		visited[row][col] = true;

		while (!q.isEmpty()) {
			Point now = q.poll();

			for (int i = 0; i < 4; i++) {
				int dr = now.x + delta[i][0];
				int dc = now.y + delta[i][1];

				if (index(dr, dc) && !visited[dr][dc]) {
					if (cheese[dr][dc] != 0) {
						cheese[dr][dc]++;
						continue;
					}

					q.add(new Point(dr, dc));
					visited[dr][dc] = true;
				}
			}
		}
	}

	static void melt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cheese[i][j] >= 3) {
					cheese[i][j] = 0;
					cnt++;
				} else if (cheese[i][j] == 0)
					continue;
				else
					cheese[i][j] = 1;
			}
		}
	}

	public static void solution() throws IOException {
		int goal = N * M;
		int time = 0;
		while (cnt < goal) {
			time++;
			check();
			melt();
		}
		System.out.println(time);
	}

	public static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st);
		M = init(st);

		cheese = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheese[i][j] = init(st);
				if (cheese[i][j] == 0)
					cnt++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	public static boolean index(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M)
			return false;
		return true;
	}

	public static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	public static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

}