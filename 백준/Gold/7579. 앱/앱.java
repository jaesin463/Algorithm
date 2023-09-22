import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static long[][] dp;
	static App[] app;
	static int N, M;
	static int result = Integer.MAX_VALUE;

	static void solution() {
		for (int curc = 1; curc < 10000 + 1; curc++) {
			for (int c = 1; c < N + 1; c++) {
				if (app[c].cost > curc)
					// 현재 단계에서 넣을 수 없는 무게
					dp[c][curc] = dp[c - 1][curc];
				else
					// 가방에 넣을지 말지 value max 값을 비교하여 대입
					// 허용 최대 무게를 넘지 않기 위해 curw - bag[w].weight
					dp[c][curc] = Math.max(dp[c - 1][curc - app[c].cost] + app[c].memory, dp[c - 1][curc]);
				if (dp[c][curc] >= M)
					result = Math.min(result, curc);
			}
		}
		System.out.println(result);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st.nextToken());
		M = init(st.nextToken());

		app = new App[N + 1];
		dp = new long[N + 1][10001];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			app[i] = new App();
			app[i].setMemory(init(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			app[i].setCost(init(st.nextToken()));
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

	static class App {
		int memory;
		int cost;

		public App() {
		}

		public int getMemory() {
			return memory;
		}

		public void setMemory(int memory) {
			this.memory = memory;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}
	}
}