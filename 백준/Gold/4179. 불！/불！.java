import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C;
	static char maze[][];
	static Point J;
	static Queue<Point> fire = new LinkedList<>();
	static int[][] dis;
	static int[][] fireDis;
	/** 우 좌 하 상 */
	static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void fireSpread() {
		// 불 번짐
		while (!fire.isEmpty()) {
			Point f = fire.poll();
			for (int i = 0; i < 4; i++) {
				int dr = f.r + delta[i][0];
				int dc = f.c + delta[i][1];

				if (index(dr, dc) && maze[dr][dc] != '#') {
					if (fireDis[dr][dc] > fireDis[f.r][f.c] + 1) {
						fire.add(new Point(dr, dc));
						fireDis[dr][dc] = fireDis[f.r][f.c] + 1;
					}
				}
			}
		}
	}

	static void escape() {
		Queue<Point> q = new LinkedList<>();
		q.add(J);

		while (!q.isEmpty()) {
			Point cur = q.poll();
			int nr = cur.r;
			int nc = cur.c;

			for (int i = 0; i < 4; i++) {
				int dr = nr + delta[i][0];
				int dc = nc + delta[i][1];

				// 사람의 탈출 조건 : 배열의 인덱스 벗어나기
				if (!index(dr, dc)) {
					System.out.println(dis[nr][nc] + 1);
					return;
				}

				// 불에 닿으면 죽습니다.
				if (fireDis[dr][dc] <= dis[nr][nc] + 1)
					continue;

				// 벽이 아니면 움직입니다.
				if (maze[dr][dc] != '#' && dis[dr][dc] > dis[nr][nc] + 1) {
					q.add(new Point(dr, dc));
					dis[dr][dc] = dis[nr][nc] + 1;
				}

			}

		}

		System.out.println("IMPOSSIBLE");
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = init(st);
		C = init(st);

		maze = new char[R][C];

		dis = new int[R][C];
		for (int i = 0; i < R; i++)
			Arrays.fill(dis[i], Integer.MAX_VALUE);

		fireDis = new int[R][C];
		for (int i = 0; i < R; i++)
			Arrays.fill(fireDis[i], Integer.MAX_VALUE);

		String str;
		for (int i = 0; i < R; i++) {
			str = br.readLine();
			for (int j = 0; j < C; j++) {
				maze[i][j] = str.charAt(j);
				if (maze[i][j] == 'J') {
					J = new Point(i, j);
					dis[i][j] = 0;
				} else if (maze[i][j] == 'F') {
					fire.add(new Point(i, j));
					fireDis[i][j] = 0;
				}
			}
		}

	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		make();
		fireSpread();
		escape();
	}

	static boolean index(int r, int c) {
		if (r < 0 || r > R - 1 || c < 0 || c > C - 1)
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