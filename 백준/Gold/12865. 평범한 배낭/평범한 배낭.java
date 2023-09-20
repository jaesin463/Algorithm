import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class Thing {
	int weight;
	int value;

	public Thing(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, maxWeight;
	static Thing[] bag;
	static int[][] dp;

	static void solution() {
		for (int curw = 1; curw < maxWeight + 1; curw++) {
			for (int w = 1; w < N + 1; w++) {
				if (bag[w].weight > curw)
					dp[w][curw] = dp[w - 1][curw];
				else
					dp[w][curw] = Math.max(dp[w-1][curw - bag[w].weight] + bag[w].value, dp[w-1][curw]);
			}
		}
		System.out.println(dp[N][maxWeight]);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st.nextToken());
		maxWeight = init(st.nextToken());

		bag = new Thing[N + 1];
		dp = new int[N + 1][maxWeight + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			bag[i] = new Thing(init(st.nextToken()), init(st.nextToken()));
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
