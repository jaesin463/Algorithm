import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int row, col, height;
	static int[][][] map;
	static boolean[][][] visited;
	static int[] dr = { 1, -1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, 1, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static Queue<int[]> q = new LinkedList<>();
	static int max = 0;

	static void BFS() {

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 6; i++) {
				int dx = now[0] + dr[i];
				int dy = now[1] + dc[i];
				int dz = now[2] + dh[i];

				if (dx >= 0 && dx < row && dy >= 0 && dy < col && dz >= 0 && dz < height) {
					if (!visited[dx][dy][dz] && map[dx][dy][dz] == -2) {
						q.add(new int[] { dx, dy, dz });
						visited[dx][dy][dz] = true;
						map[dx][dy][dz] = map[now[0]][now[1]][now[2]] + 1;
						max = Math.max(max, map[dx][dy][dz]);
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
		height = init(st.nextToken());
		map = new int[row][col][height];
		visited = new boolean[row][col][height];
		
		for(int k = 0; k < height; k++) {
			for (int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < col; j++) {
					map[i][j][k] = init(st.nextToken());
					if (map[i][j][k] == 1) {
						q.add(new int[] { i, j, k });
						visited[i][j][k] = true;
						map[i][j][k] = 0;
					} else if (map[i][j][k] == 0) {
						map[i][j][k] = -2;
					}
				}
			}
		}
		

		BFS();
		for(int k = 0; k < height; k++) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (map[i][j][k] == -2) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		System.out.println(max);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}