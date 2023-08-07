import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

//		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] magnetic = new int[N][N];

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					magnetic[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int result = 0;
			for (int i = 0; i < 100; i++) {
				int NS = 0;
				int cnt = 0;
				for (int j = 0; j < 100; j++) {
					if (magnetic[j][i] == 1) {
						if (NS == 2) {
							cnt++;
							NS = 0;
							continue;
						}
						NS = 1;
					} else if (magnetic[j][i] == 2 && NS != 0) {
						if (NS == 1) {
							cnt++;
							NS = 0;
							continue;
						}
						NS = 2;
					}
				}
				result += cnt;
			}

			System.out.printf("#%d %d\n", tc, result);

		}

	}
}
