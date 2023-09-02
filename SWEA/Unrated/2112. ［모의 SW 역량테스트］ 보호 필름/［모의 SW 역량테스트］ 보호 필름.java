import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int D, W, K;
	static int min;
	static int[][] board;

	static void solution(int depth, int cnt) {
		if (check()) {
			min = Math.min(min, cnt);
			return;
		}
		if (cnt >= min || depth == D) {
			return;
		}

		int[] tempR = board[depth].clone();

		solution(depth + 1, cnt);

		for (int i = 0; i < W; i++)
			board[depth][i] = 0;
		solution(depth + 1, cnt + 1);

		for (int i = 0; i < W; i++)
			board[depth][i] = 1;
		solution(depth + 1, cnt + 1);

		board[depth] = tempR.clone();
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		D = init(st.nextToken());
		W = init(st.nextToken());
		K = init(st.nextToken());
		min = Integer.MAX_VALUE;

		board = new int[D][W];

		for (int i = 0; i < D; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = init(st.nextToken());
			}
		}

		solution(0, 0);
	}

	static boolean check() {
		for (int j = 0; j < W; j++) {
			int cnt = 1;
			boolean flag = false;
			for (int i = 1; i < D; i++) {
				if (board[i][j] == board[i - 1][j])
					cnt++;
				else
					cnt = 1;

				if (cnt == K) {
					flag = true;
					break;
				}
			}
			if(!flag) return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		int T = init(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			make();
			System.out.printf("#%d %d\n", tc, min);
		}

	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}