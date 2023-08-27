import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, T;
	static int[][] dust;
	static int[][] temp;
	static int[] Airconditioner;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static void refresh() {
		clockWise();
		counterClockWise();
	}

	static void clockWise() {
		int air = Airconditioner[1];
		int tempLD = dust[N - 1][0];
		int tempRU = dust[air][M - 1];
		int tempRD = dust[N - 1][M - 1];

		for (int i = air + 1; i < N - 2; i++) {
			dust[i][0] = dust[i + 1][0];
		}
		dust[N - 2][0] = tempLD;
		for (int i = 0; i < M - 2; i++) {
			dust[N - 1][i] = dust[N - 1][i + 1];
		}
		dust[N - 1][M - 2] = tempRD;
		for (int i = N - 1; i > air + 1; i--) {
			dust[i][M - 1] = dust[i - 1][M - 1];
		}
		dust[air + 1][M - 1] = tempRU;
		for (int i = M - 1; i > 0; i--) {
			dust[air][i] = dust[air][i - 1];
		}
	}

	static void counterClockWise() {
		int air = Airconditioner[0];
		int tempLU = dust[0][0];
		int tempRU = dust[0][M - 1];
		int tempRD = dust[air][M - 1];

		for (int i = air - 1; i > 1; i--) {
			dust[i][0] = dust[i - 1][0];
		}
		dust[1][0] = tempLU;
		for (int i = 0; i < M - 1; i++) {
			dust[0][i] = dust[0][i + 1];
		}
		dust[0][M - 1] = tempRU;
		for (int i = M - 1; i > 0; i--) {
			dust[air][i] = dust[air][i - 1];
		}
		for (int i = 0; i < air - 1; i++) {
			dust[i][M - 1] = dust[i + 1][M - 1];
		}
		dust[air - 1][M - 1] = tempRD;
	}

	static void spread(int x, int y) {
		int spDust = dust[x][y] / 5;
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int r = x + dr[i];
			int c = y + dc[i];
			if (r >= 0 && r < N && c >= 0 && c < M) {
				if ((r == Airconditioner[0] || r == Airconditioner[1]) && c == 0)
					continue;
				temp[r][c] += spDust;
				cnt++;
			}
		}
		temp[x][y] += (dust[x][y] - (cnt * spDust));
	}

	static void findAir() {
		int idx = 2;
		while (true) {
			if (dust[idx][0] == -1) {
				Airconditioner = new int[] { idx, idx + 1 };
				dust[idx][0] = 0;
				dust[idx + 1][0] = 0;
				break;
			}
			idx++;
		}
	}

	static void cycle() {
		temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dust[i][j] != 0) {
					spread(i, j);
				}
			}
		}
		dust = temp.clone();
		refresh();
	}

	static void makeBoard() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st.nextToken());
		M = init(st.nextToken());
		T = init(st.nextToken());
		dust = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				dust[i][j] = init(st.nextToken());
			}
		}
		findAir();
	}

	static int result() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum += dust[i][j];
			}
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		makeBoard();
		for (int i = 0; i < T; i++) {
			cycle();
		}
		System.out.println(result());
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

	static int init(char c) {
		return c - '0';
	}

	static void check(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}