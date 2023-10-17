import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[][] cave;
	static Integer[][] dp;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		dp[0][0] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int row = cur[0];
			int col = cur[1];

			for (int i = 0; i < 4; i++) {
				int r = row + dr[i];
				int c = col + dc[i];

				if (r >= 0 && r < N && c >= 0 && c < N) {
					if (dp[r][c] == null || dp[r][c] > dp[row][col] + cave[row][col]) {
						dp[r][c] = dp[row][col] + cave[row][col];
						q.add(new int[] { r, c });
					}
				}
			}
		}
	}

	static void solution() throws IOException {
		bfs();
		sb.append(dp[N - 1][N - 1] + cave[N - 1][N - 1]);
	}

	static void make() throws IOException {

		cave = new int[N][N];
		dp = new Integer[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cave[i][j] = init(st);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int cnt = 1;
		while (true) {
			N = init();
			if (N == 0)
				break;
			make();
			sb.append("Problem ").append(cnt++).append(": ");
			solution();
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static int init(char c) {
		return c - '0';
	}
}
