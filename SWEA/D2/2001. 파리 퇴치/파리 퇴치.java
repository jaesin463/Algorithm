import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;

	public static int kill(int[][] fly, int idx1, int idx2) {
		int sum = 0;

		for (int i = idx1; i < idx1 + M; i++) {
			for (int j = idx2; j < idx2 + M; j++) {
				sum += fly[i][j];
			}
		}

		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int[][] fly = new int[N][N];

			// 배열 생성
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = Integer.MIN_VALUE;

			for (int i = 0; i < N - (M - 1); i++) {
				for (int j = 0; j < N - (M - 1); j++) {
					max = Math.max(max, kill(fly, i, j));
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);

		}

	}
}
