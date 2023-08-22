import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = init(br.readLine());
		int[][] dp = new int[N][3];
		int[][] paint = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			paint[i][0] = init(st.nextToken());
			paint[i][1] = init(st.nextToken());
			paint[i][2] = init(st.nextToken());
		}
		
		dp[0][0] = paint[0][0];
		dp[0][1] = paint[0][1];
		dp[0][2] = paint[0][2];
		
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + paint[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + paint[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + paint[i][2];
		}
		
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

}
