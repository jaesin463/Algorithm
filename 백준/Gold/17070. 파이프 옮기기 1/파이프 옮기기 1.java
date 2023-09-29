import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	// 0 : 가로, 1 : 세로, 2 : 대각선 2차원 배열을 3종류로 나누기 위해 3차원 배열 사용
	static int[][][] dp;

	static void solution() {
		dp[1][2][0] = 1;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 3; j < N + 1; j++) {
				// 가로 파이프 추가
				if (map[i][j] == 0) {
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
				}
				// 세로 파이프 추가
				if (i - 1 > 0 && map[i][j] == 0) {
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
				}
				// 대각선 파이프 추가
				if (i - 1 > 0 && map[i][j] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
					dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
			}
		}
		int result = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
		System.out.println(result);
	}

	static void make() throws IOException {
		N = init();
		map = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1][3];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = init(st);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}