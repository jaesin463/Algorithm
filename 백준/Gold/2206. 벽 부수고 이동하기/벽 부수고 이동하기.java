import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static int[][] dis;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static boolean[][][] visited;
	static int min = Integer.MAX_VALUE;
	static List<int[]> wall = new ArrayList<>();

	static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[2][N + 1][M + 1];
		dis = new int[N + 1][M + 1];
		dis[1][1] = 1;
		
		q.add(new int[] { 1, 1, 0 });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int v = now[2];

			if (x == N && y == M) {
				min = Math.min(min, dis[x][y]);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int r = x + dr[i];
				int c = y + dc[i];

				if (r > 0 && r <= N && c > 0 && c <= M) {
					if (map[r][c] == 1) {
						if (v == 0 && !visited[1][r][c]) {
							visited[v][r][c] = true;
							dis[r][c] = dis[x][y] + 1;
							q.add(new int[] { r, c, 1 });
						}
					} else {
						if (!visited[v][r][c]) {
							visited[v][r][c] = true;
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
		N = init(st.nextToken());
		M = init(st.nextToken());
		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		BFS();
		System.out.println(min != Integer.MAX_VALUE ? min : -1);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
