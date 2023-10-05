import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, K;
	static int[][] map;
	static Dice dice = new Dice();
	// 1 = 동, 2 = 서, 3 = 북, 4 = 남
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };
	static int[] oper;

	static void move(int k) {
		int r = dice.r + dr[oper[k]];
		int c = dice.c + dc[oper[k]];
		if (index(r, c)) {
			dice.rollDice(oper[k]);

			if (map[r][c] == 0)
				map[r][c] = dice.down;
			else {
				dice.down = map[r][c];
				map[r][c] = 0;
			}

			dice.r = r;
			dice.c = c;

			sb.append(dice.up).append("\n");
		}
	}

	static void solution() {
		for (int i = 0; i < K; i++) {
			move(i);
		}
		System.out.println(sb);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());

		N = init(st);
		M = init(st);
		dice.r = init(st);
		dice.c = init(st);
		K = init(st);

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = init(st);
			}
		}

		oper = new int[K];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++)
			oper[i] = init(st);

	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static boolean index(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) {
			return true;
		}
		return false;
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static class Dice {
		int r, c;
		int up, down, front, back, left, right;

		public Dice() {
			up = 0;
			down = 0;
			front = 0;
			back = 0;
			left = 0;
			right = 0;
		}

		void rollDice(int direct) {
			if (direct == 1)
				east();
			else if (direct == 2)
				west();
			else if (direct == 3)
				north();
			else
				south();
		}

		void east() {
			int temp = right;
			right = up;
			up = left;
			left = down;
			down = temp;
		}

		void north() {
			int temp = back;
			back = up;
			up = front;
			front = down;
			down = temp;
		}

		void west() {
			int temp = left;
			left = up;
			up = right;
			right = down;
			down = temp;
		}

		void south() {
			int temp = front;
			front = up;
			up = back;
			back = down;
			down = temp;
		}
	}
}