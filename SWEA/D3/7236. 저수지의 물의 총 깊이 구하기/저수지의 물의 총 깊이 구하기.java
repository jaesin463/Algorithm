import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int x[] = { -1, -1, -1, 0, 1, 1,  1,  0 };
	static int y[] = { -1,  0,  1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			int result = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = st.nextToken().charAt(0);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int depth = 0;
					if (map[i][j] == 'W') {
						for (int k = 0; k < 9; k++) {
							try {
								if (map[i + x[k]][j + y[k]] == 'W') {
									depth++;
								}
							} catch (ArrayIndexOutOfBoundsException e) {
								continue;
							}
						}
						if (depth == 0) {
							depth = 1;
						}
						result = Math.max(depth, result);

					}
				}
			}

			System.out.printf("#%d %d\n", tc, result);

		}

	}
}
