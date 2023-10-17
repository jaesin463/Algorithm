import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, cnt = 0;
	static char[][] map;
	static boolean[][] check;
	// 우측으로만 이동하기 때문에 column은 항상 1씩 증가할 거임
	static int[] dr = { -1, 0, 1 }; // 출발점 0~r-1이므로, 도착점 0~r-1순대로 도착하게 탐색 방향 설정

	static boolean dfs(int row, int col) {
		for (int i = 0; i < 3; i++) {
			int nr = row + dr[i];
			int nc = col + 1;

			if (!index(nr, nc))
				continue;
			if (map[nr][nc] == '.') {
				if (nc == M - 1) {
					cnt++;
					return true;
				}

				map[nr][nc] = '-';
				if (dfs(nr, nc))
					return true;
			}

		}
		return false;
	}

	static void solution() {
		for (int i = 0; i < N; i++) {
			dfs(i, 0);
		}
		System.out.println(cnt);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st);
		M = init(st);
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static boolean index(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return false;
		}
		return true;
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}