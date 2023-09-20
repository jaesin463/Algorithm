import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int s, N, K, R1, R2, C1, C2;
	static int start, end;
	static boolean[][] result;
	static int cnt = 0;

	static void partition(int r, int c, int len) {
		// len이 N^s부터 시작하기 때문에 아래 조건에 걸리면 구하고자 하는 영역에 못 들어감 
		if (r > R2 || c > C2 || r + len <= R1 || c + len <= C1) {
			return;
		}
		// 이때까지 검은색이 된 경우가 없기 때문에 흰색(true) 처리
		if (len == 1) {
			result[r - R1][c - C1] = true;
			return;
		}

		int nextLen = len / N;

		for (int i = 0; i < N; i++) {
			for (int k = 0; k < N; k++) {
				if (i >= start && i <= end && k >= start && k <= end)
					continue;
				else {
					partition(r + (i * nextLen), c + (k * nextLen), nextLen);
				}
			}
		}
	}

	static void solution() {
		int len = (int) Math.pow(N, s);
		partition(0, 0, len);

		StringBuilder sb = new StringBuilder();
		for (boolean[] ar : result) {
			for (boolean a : ar) {
				sb.append(a ? 0 : 1);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());

		s = init(st.nextToken());
		N = init(st.nextToken());
		K = init(st.nextToken());

		R1 = init(st.nextToken());
		R2 = init(st.nextToken());
		C1 = init(st.nextToken());
		C2 = init(st.nextToken());
		result = new boolean[R2 - R1 + 1][C2 - C1 + 1];
		
		start = (N - K) / 2;
		end = (N + K) / 2 - 1;
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}
	
	static int init(String str) {
		return Integer.parseInt(str);
	}
}