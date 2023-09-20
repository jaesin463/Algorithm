import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	// 변수
	static int s, N, K, R1, R2, C1, C2;
	static int start, end;
	static boolean[][] result;

	// 분할정복
	static void partition(int r, int c, int len) {
//		System.out.println("cnt : " + cnt + " r : " + r + " c : " + c + " len : " + len + " bw : " + bw);
//		System.out.println("r + len : " + (r + len) + " c + len : " + (c + len));
//		System.out.println("R1 : " + R1 + " C1 : " + C1 + " R2 : " + R2 + " C2 : " + C2);
		// r시작점이 R2보다 작거나, r끝점이 R1보다 클 때
		// c시작점이 C2보다 작거나, c끝점이 C1보다 클 때
		if (r > R2 || c > C2 || r + len <= R1 || c + len <= C1) {
			return;
		}
//		System.out.println("No Return");
		// s만큼 재귀하면 num을 넣고 리턴
		if (len == 1) {
			result[r - R1][c - C1] = false;
			return;
		}

		int nextLen = len / N;

		// 재귀
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
		// 계산
		int len = (int) Math.pow(N, s);
		partition(0, 0, len);

		// 출력
		StringBuilder sb = new StringBuilder();
		for (boolean[] ar : result) {
			for (boolean a : ar) {
				sb.append(a ? 1 : 0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());

		s = Integer.parseInt(st.nextToken()); // 시간 -> 0 ~ 10
		N = Integer.parseInt(st.nextToken()); // 나누어지는 단위 -> 3 ~ 8
		K = Integer.parseInt(st.nextToken()); // 검정색으로 채울 부분

		// 전체 배열을 만들면?
		// len(N^s)의 최대 크기 : 8^10 = 약 10억
		// 배열의 최대 크기 = 10억*10억 = 100억
		// 따라서 -> 정답 배열만 만들기
		R1 = Integer.parseInt(st.nextToken());
		R2 = Integer.parseInt(st.nextToken());
		C1 = Integer.parseInt(st.nextToken());
		C2 = Integer.parseInt(st.nextToken());
		result = new boolean[R2 - R1 + 1][C2 - C1 + 1]; // 정답을 저장할 배열
		for(int i = 0; i < R2 - R1 + 1; i++) {
			Arrays.fill(result[i], true);
		}
		start = (N - K) / 2; // 검정색 : 시작하는 지점
		end = (N + K) / 2 - 1; // 검정색 : 끝나는 지점
	}

// main
	public static void main(String[] args) throws IOException {
		make();
		solution();
	}
}