import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] chess;
	static int[] dy = { -1, -1, 1, 1 }; // 좌상, 우상, 좌하, 우하
	static int[] dx = { -1, 1, -1, 1 }; // 좌상, 우상, 좌하, 우하
	static int bCnt = 0;
	static int wCnt = 0;

	static void bSearch(boolean[][] visited, int y, int x, int cnt) {
		bCnt = Math.max(cnt, bCnt);

		// 다음 줄
		if (x > N) {
			y += 1;
			x = (y % 2 == 0) ? 2 : 1;
		}

		if (y > N)
			return;

		// 현재자리에 비숍을 놓을 수 있는지 확인
		// 현재자리에 비숍을 놓을 수 있다면 비숍을 놓고 다음 탐색을 진행한다.
		if (isAble(visited, y, x)) {
			visited[y][x] = true;
			bSearch(visited, y, x + 2, cnt + 1);
			visited[y][x] = false;
		}
		bSearch(visited, y, x + 2, cnt);
	}

	static void wSearch(boolean[][] visited, int y, int x, int cnt) {
		wCnt = Math.max(cnt, wCnt);

		if (x > N) {
			y += 1;
			x = (y % 2 == 0) ? 1 : 2;
		}

		if (y > N)
			return;

		if (isAble(visited, y, x)) {
			visited[y][x] = true;
			wSearch(visited, y, x + 2, cnt + 1);
			visited[y][x] = false;
		}
		wSearch(visited, y, x + 2, cnt);
	}

	static boolean isAble(boolean[][] visited, int y, int x) {
		if (chess[y][x] == 0)
			return false; // 0이면 놓을 수 없다.

		for (int i = 0; i < 4; i++) {
			int r = dy[i] + y;
			int c = dx[i] + x;

			for (int j = 1; j <= N; j++) {
				if (r > 0 && c > 0 && r <= N && c <= N) {
					if (visited[r][c])
						return false;

					r += dy[i];
					c += dx[i];
				}
			}
		}
		return true;
	}

	static void solution() {
		// 흑색 자리에 둘 수 있는 비숍의 수를 탐색
		boolean[][] black_visited = new boolean[N + 1][N + 1];
		bSearch(black_visited, 1, 1, 0);

		// 백색 자리에 둘 수 있는 비숍의 수를 탐색
		boolean[][] white_visited = new boolean[N + 1][N + 1];
		wSearch(white_visited, 1, 2, 0);

		System.out.println(bCnt + wCnt);
	}

	static void make() throws IOException {
		N = init(br.readLine());
		chess = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				chess[i][j] = init(st.nextToken());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}