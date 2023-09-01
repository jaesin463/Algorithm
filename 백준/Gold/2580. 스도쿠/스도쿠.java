import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] sudoku = new int[9][9];
	static ArrayList<int[]> list = new ArrayList<>();

	static void solution(int depth) {
		if (list.size() == depth) {
			result();
			System.out.println(sb);
			System.exit(0);
		}

		int x = list.get(depth)[0];
		int y = list.get(depth)[1];

		boolean[] check = new boolean[10];

		for (int i = 0; i < 9; i++) {
			if (sudoku[x][i] != 0) {
				check[sudoku[x][i]] = true;
			}
			if (sudoku[i][y] != 0) {
				check[sudoku[i][y]] = true;
			}
		}

		int sqX = (x / 3) * 3;
		int sqY = (y / 3) * 3;
		for (int i = sqX; i < sqX + 3; i++) {
			for (int j = sqY; j < sqY + 3; j++) {
				if (sudoku[i][j] != 0) {
					check[sudoku[i][j]] = true;
				}
			}
		}

		for (int i = 1; i <= 9; i++) {
			if (!check[i]) {
				sudoku[x][y] = i;
				solution(depth + 1);
				sudoku[x][y] = 0;
			}
		}

	}

	static void result() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j] + " ");
			}
			sb.append("\n");
		}
	}

	static void make() throws IOException {
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = init(st.nextToken());
				if (sudoku[i][j] == 0)
					list.add(new int[] { i, j });
			}
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution(0);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}