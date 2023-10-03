import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int total = 0;
	static int min = Integer.MAX_VALUE;

	static void cntPeople(int x, int y, int d1, int d2) {
		boolean[][] border = new boolean[N][N];

		// 경계선 세팅
		for (int i = 0; i <= d1; i++) {
			border[x + i][y - i] = true;
			border[x + d2 + i][y + d2 - i] = true;
		}

		for (int i = 0; i <= d2; i++) {
			border[x + i][y + i] = true;
			border[x + d1 + i][y - d1 + i] = true;
		}

		int[] peopleSum = new int[5];

		// 1 구역 인구수
		for (int i = 0; i < x + d1; i++) {
			for (int j = 0; j <= y; j++) {
				if (border[i][j])
					break;
				peopleSum[0] += map[i][j];
			}
		}

		// 2 구역 인구수
		for (int i = 0; i <= x + d2; i++) {
			for (int j = N - 1; j > y; j--) {
				if (border[i][j])
					break;
				peopleSum[1] += map[i][j];
			}
		}

		// 3 구역 인구수
		for (int i = x + d1; i < N; i++) {
			for (int j = 0; j < y - d1 + d2; j++) {
				if (border[i][j])
					break;
				peopleSum[2] += map[i][j];
			}
		}

		// 4 구역 인구수
		for (int i = x + d2 + 1; i < N; i++) {
			for (int j = N - 1; j >= y - d1 + d2; j--) {
				if (border[i][j])
					break;
				peopleSum[3] += map[i][j];
			}
		}

		// 5 구역 인구수
		peopleSum[4] = total;

		for (int i = 0; i < 4; i++) {
			peopleSum[4] -= peopleSum[i];
		}

		// 정렬
		Arrays.sort(peopleSum);

		// 최대 - 최소
		min = Math.min(min, peopleSum[4] - peopleSum[0]);
	}

	static void solution() {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if (x + d1 + d2 >= N)
							continue;
						if (y - d1 < 0 || y + d2 >= N)
							continue;
						cntPeople(x, y, d1, d2);
					}
				}
			}
		}
		System.out.println(min);
	}

	static void make() throws IOException {
		N = init();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = init(st);
				total += map[i][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
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