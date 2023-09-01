import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, L;
	static int cnt = 0;
	static int[][] slide;

	static boolean checkRow(int row) {
		boolean[] isSlide = new boolean[N];
		for (int col = 0; col < N - 1; col++) {
			int h = slide[row][col] - slide[row][col + 1];
			if (h > 1 || h < -1) {
				return false;
			} else if (h == -1) {
				for (int k = 0; k < L; k++) {
					if (col - k < 0 || isSlide[col - k])
						return false;
					if (slide[row][col] != slide[row][col - k])
						return false;
					isSlide[col - k] = true;
				}

			} else if (h == 1) {
				for (int k = 1; k <= L; k++) {
					if (col + k >= N || isSlide[col + k])
						return false;
					if (slide[row][col] - 1 != slide[row][col + k])
						return false;
					isSlide[col + k] = true;
				}
			}
		}
		return true;
	}

	static boolean checkCol(int col) {
		boolean[] isSlide = new boolean[N];
		for (int row = 0; row < N - 1; row++) {
			int h = slide[row][col] - slide[row + 1][col];
			if (h > 1 || h < -1) {
				return false;
			} else if (h == -1) {
				for (int k = 0; k < L; k++) {
					if (row - k < 0 || isSlide[row - k])
						return false;
					if (slide[row][col] != slide[row - k][col])
						return false;
					isSlide[row - k] = true;
				}
			} else if (h == 1) {
				for (int k = 1; k <= L; k++) {
					if (row + L >= N || isSlide[row + k])
						return false;
					if (slide[row][col] - 1 != slide[row + k][col])
						return false;
					isSlide[row + k] = true;
				}
			}
		}
		return true;
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st.nextToken());
		L = init(st.nextToken());
		slide = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				slide[i][j] = init(st.nextToken());
			}
		}
	}

	static void solution() {
		for (int i = 0; i < N; i++) {
			if (checkRow(i))
				cnt++;
			if (checkCol(i))
				cnt++;
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
		System.out.println(cnt);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}