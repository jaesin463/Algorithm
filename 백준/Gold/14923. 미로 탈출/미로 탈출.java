import java.awt.Point;
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
	static int N, M;
	static Point start;
	static Point escape;
	static int[][] map;
	static int[][] dis;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static boolean[][][] visited;
	static int min = Integer.MAX_VALUE;
	static List<int[]> wall = new ArrayList<>();

	static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[N + 1][M + 1][2];
		dis = new int[N + 1][M + 1];
		dis[start.x][start.y] = 0;

		q.add(new int[] { start.x, start.y, 0 });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int v = now[2];

			if (x == escape.x && y == escape.y) {
				min = Math.min(min, dis[x][y]);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int r = x + dr[i];
				int c = y + dc[i];

				if (r > 0 && r <= N && c > 0 && c <= M) {
					if (map[r][c] == 1) {
						if (v == 0 && !visited[r][c][1]) {
							visited[r][c][v] = true;
							dis[r][c] = dis[x][y] + 1;
							q.add(new int[] { r, c, 1 });
						}
					} else {
						if (!visited[r][c][v]) {
							visited[r][c][v] = true;
							dis[r][c] = dis[x][y] + 1;
							q.add(new int[] { r, c, v });
						}
					}
				}
			}
		}
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st);
		M = init(st);

		st = new StringTokenizer(br.readLine());
		start = new Point(init(st), init(st));

		st = new StringTokenizer(br.readLine());
		escape = new Point(init(st), init(st));

		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = init(st);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		BFS();
		System.out.println(min != Integer.MAX_VALUE ? min : -1);
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}