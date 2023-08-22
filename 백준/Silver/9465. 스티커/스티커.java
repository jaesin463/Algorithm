import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int test_case = init(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {

			int N = init(br.readLine());

			int[][] dp = new int[2][N + 1];
			int[][] sticky = new int[2][N + 1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					sticky[i][j] = init(st.nextToken());
				}
			}

			dp[0][1] = sticky[0][1];
			dp[1][1] = sticky[1][1];

			for (int k = 2; k < N + 1; k++) { // 열 반복만을 통해 0번과 1번행을 동시 처리
				dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + sticky[0][k];
				dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + sticky[1][k];
			}
			
			sb.append(Math.max(dp[0][N], dp[1][N]) + "\n");
		}
		System.out.println(sb.toString());

	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

}
