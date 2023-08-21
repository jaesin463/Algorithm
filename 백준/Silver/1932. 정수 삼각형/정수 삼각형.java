import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = init(br.readLine());

		int[][] num = new int[N][N];
		int[][] DP = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				num[i][j] = init(st.nextToken());
			}
		}

		DP[0][0] = num[0][0];

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < i + 1; j++) {
				DP[i + 1][j] = Math.max(DP[i + 1][j], DP[i][j] + num[i + 1][j]);
				DP[i + 1][j + 1] = DP[i][j] + num[i + 1][j + 1];
			}
		}
		Arrays.sort(DP[N - 1]);
		System.out.println(DP[N - 1][N - 1]);

	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
