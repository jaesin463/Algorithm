import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] tetris = new int[N][100];

			// 회전 배열
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int k = Integer.parseInt(st.nextToken());
				for (int l = 0; l < k; l++) {
					tetris[j][l] = 1;
					if (l == 0) {
						tetris[j][l] = k;
					}
				}
			}

			int[] result = new int[N];

			for (int j = 0; j < N; j++) {
				if (tetris[j][0] != 0) {
					for (int k = j + 1; k < N - j; k++) {
						if (tetris[k][tetris[j][0] - 1] == 0) {
							result[j]++;
						}
					}
				} else {
					result[j] = 0;
				}
			}

			Arrays.sort(result);

			System.out.printf("#%d %d\n", i + 1, result[N - 1]);
		}

	}
}
