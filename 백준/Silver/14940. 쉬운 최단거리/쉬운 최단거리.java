import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int row, col;
	static int[] start = new int[2];
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visited[x][y] = true;
		map[x][y] = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int dx = now[0] + dr[i];
				int dy = now[1] + dc[i];

				if (dx >= 0 && dx < row && dy >= 0 && dy < col) {
					if (!visited[dx][dy] && map[dx][dy] == -1) {
						q.add(new int[] { dx, dy });
						visited[dx][dy] = true;
						map[dx][dy] = map[now[0]][now[1]] + 1;
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

		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				map[j][i] = init(st.nextToken());
				if (map[j][i] == 2) {
					start[0] = j;
					start[1] = i;
				}
				else if(map[j][i] == 1) {
					map[j][i] = -1;
				}
			}
		}

		BFS(start[0], start[1]);

		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				System.out.print(map[j][i] + " ");
			}
			System.out.println();
		}

	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}