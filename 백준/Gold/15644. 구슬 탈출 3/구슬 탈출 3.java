import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static hole hole;
	static ball blue, red;
	static int N, M;
	static char[][] map;
	static boolean[][][][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[] op = {'U', 'R', 'D', 'L'};
	static char[] oper = new char[10];

	public static void BFS() {
		Queue<ball[]> queue = new LinkedList<>();
		queue.add(new ball[] { new ball(red.r, red.c, 1, ""), new ball(blue.r, blue.c, 1, null) });
		visited[red.r][red.c][blue.r][blue.c] = true;
		while (!queue.isEmpty()) {
			ball[] marble = queue.poll();

			int rR = marble[0].r;
			int rC = marble[0].c;
			int bR = marble[1].r;
			int bC = marble[1].c;
			int cnt = marble[0].cnt;

			if (cnt > 10) {
				System.out.println(-1);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int drR = rR;
				int drC = rC;
				int dbR = bR;
				int dbC = bC;

				boolean isRedHole = false;
				boolean isBlueHole = false;

				while (map[drR + dr[i]][drC + dc[i]] != '#') {
					drR += dr[i];
					drC += dc[i];

					if (drR == hole.r && drC == hole.c) {
						isRedHole = true;
						break;
					}
				}

				while (map[dbR + dr[i]][dbC + dc[i]] != '#') {
					dbR += dr[i];
					dbC += dc[i];

					if (dbR == hole.r && dbC == hole.c) {
						isBlueHole = true;
						break;
					}
				}

				if (isBlueHole) {
					continue;
				}

				if (isRedHole && !isBlueHole) {
					System.out.println(cnt);
					System.out.println(marble[0].oper + op[i]);
					return;
				}

				if (drR == dbR && drC == dbC) {
					// 위쪽으로 기울이기
					if (i == 0) {
						if (rR > bR)
							drR++;
						else
							dbR++;
					}
					// 오른쪽으로 기울이기
					else if (i == 1) {
						if (rC < bC)
							drC--;
						else
							dbC--;
					}
					// 아래쪽으로 기울이기
					else if (i == 2) {
						if (rR < bR)
							drR--;
						else
							dbR--;
					}
					// 왼쪽으로 기울이기
					else {
						if (rC > bC)
							drC++;
						else
							dbC++;
					}
				}

				if (!visited[drR][drC][dbR][dbC]) {
					visited[drR][drC][dbR][dbC] = true;
					queue.add(new ball[] { new ball(drR, drC, cnt + 1, marble[0].oper + op[i]), new ball(dbR, dbC, cnt + 1, null) });
				}
			}
		}
		System.out.println(-1);
		return;
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st.nextToken());
		M = init(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][N][M];

		// 구슬 map 구성
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'O') {
					hole = new hole(i, j);
				} else if (map[i][j] == 'B') {
					blue = new ball(i, j, 0, null);
				} else if (map[i][j] == 'R') {
					red = new ball(i, j, 0, null);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		BFS();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}

class ball {
	int r;
	int c;
	int cnt;
	String oper;

	ball(int r, int c, int cnt, String oper) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.oper = oper;
	}
}

class hole{
	int r;
	int c;
	public hole(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
}