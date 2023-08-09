import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, word;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			word = Integer.parseInt(st.nextToken());

			int[][] puzzle = new int[N][N];

			// 배열 생성
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			
			//row
			for (int i = 0; i < N; i++) {
				int length = 0;
				for (int j = 0; j < N; j++) {
					if(puzzle[i][j] == 1) {
						length++;
					} else {
						if(length == word) {
							cnt++;
						}
						length = 0;
					}
					if(j == N - 1 && length == word) {
						cnt++;
					}
				}
			}
			//col
			for (int i = 0; i < N; i++) {
				int length = 0;
				for (int j = 0; j < N; j++) {
					if(puzzle[j][i] == 1) {
						length++;
					} else {
						if(length == word) {
							cnt++;
						}
						length = 0;
					}
					if(j == N - 1 && length == word) {
						cnt++;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt);

		}

	}
}
