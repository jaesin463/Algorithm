import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp = new int[1000001];
	static int[] route = new int[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = init(br.readLine());

		dp[1] = 0;
		for (int i = 2; i <= N;i++) {
			dp[i] = dp[i - 1] + 1;
			route[i] = i - 1;
			if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
				dp[i] = dp[i / 2] + 1;
				route[i] = i / 2;
			}
			if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
				dp[i] = dp[i / 3] + 1;
				route[i] = i / 3;
			}
		}
		sb.append(dp[N] + "\n");
		int find = N;
		while(true) {
			sb.append(find + " ");
			if(find == 1) break;
			find = route[find];
		}
		System.out.println(sb.toString());

	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

}
