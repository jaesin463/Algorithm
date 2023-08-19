import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int row, col;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<int[]> q = new LinkedList<>();
	static int max = 0;

	static void BFS() {

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int dx = now[0] + dr[i];
				int dy = now[1] + dc[i];

				if (dx >= 0 && dx < row && dy >= 0 && dy < col) {
					if (!visited[dx][dy] && map[dx][dy] == -2) {
						q.add(new int[] { dx, dy });
						visited[dx][dy] = true;
						map[dx][dy] = map[now[0]][now[1]] + 1;
						max = Math.max(max, map[dx][dy]);
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		col = init(st.nextToken());
		row = init(st.nextToken());
		map = new int[row][col];
		visited = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = init(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new int[] { i, j });
					visited[i][j] = true;
					map[i][j] = 0;
				} else if(map[i][j] == 0) {
					map[i][j] = -2;
				}
			}
		}

		BFS();
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(map[i][j] == -2) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(max);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}