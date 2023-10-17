import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static ArrayList<Integer>[] island;
	static int N;
	static long count[];

	static void solution(int child, int parent) {
		// 자식 노드들 방문
		for (int next : island[child]) {
			solution(next, child);
		}

		// 최상위 노드 (1번 섬 제외)
		if (parent != -1) {
			if (count[child] > 0) {
				count[parent] += count[child];
			}
		}
	}

	static void make() throws IOException {
		N = init();

		count = new long[N + 1];

		island = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			island[i] = new ArrayList<>();
		}

		for (int i = 2; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			char ani = st.nextToken().charAt(0);
			int cnt = init(st);
			int next = init(st);

			island[next].add(i);

			count[i] = ani == 'S' ? cnt : -cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution(1, -1);
		System.out.println(count[1]);
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static int init(char c) {
		return c - '0';
	}
}
