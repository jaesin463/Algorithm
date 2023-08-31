import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] board;
	static int N;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		N = init(br.readLine());
		board = new int[N];
		solution(0);
		System.out.println(count);
	}

	static void solution(int depth) {
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			board[depth] = i;
			if (check(depth)) {
				solution(depth + 1);
			}
		}

	}

	static boolean check(int col) {
		for (int i = 0; i < col; i++) {
			if (board[col] == board[i]) {
				return false;
			} else if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
				return false;
			}
		}
		return true;
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}