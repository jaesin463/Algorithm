import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = (int) 1e9;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, dist[][], before[][];
	static boolean check[][];

	public static void solution() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// i == k 와 k == j인 경우를 거르지 않으면
					// 거쳐가지 않는 간선도 모조리 없애게 될 수 있음.
					// 예를 들어 i = 1, k = 1, j = 2일 경우
					// 1에서 2로 가기 위해 거쳐가는 정점이 없는데
					// 1 -> 2 간선을 없애게 될 수 있음.
					if (i == j || i == k || k == j) {
						continue;
					}

					// dist는 플로이드 와샬 알고리즘을 이미 수행한 상태인데
					// 또 최단거리를 초기화할 부분이 생기면 모순.
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						System.out.println(-1);
						return;
					}

					// 거쳐가는 지점을 통해서 최단거리가 초기화된 부분이 있다면
					// i -> j 간선을 없앰.
					if (dist[i][j] == dist[i][k] + dist[k][j]) {
						before[i][j] = INF;
					}
				}
			}
		}

		int result = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (before[i][j] != INF && i != j && !check[i][j]) {
					result += before[i][j];
					check[i][j] = check[j][i] = true;
				}
			}
		}

		System.out.println(result);
	}

	public static void make() throws IOException {
		N = init();
		dist = new int[N + 1][N + 1];
		before = new int[N + 1][N + 1];
		check = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				before[i][j] = dist[i][j] = init(st);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) throws IOException {
		return Integer.parseInt(st.nextToken());
	}
}
