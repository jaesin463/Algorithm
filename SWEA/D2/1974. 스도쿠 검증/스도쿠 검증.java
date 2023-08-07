import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			boolean tf = true;
			int[] check;
			int[][] sudoku = new int[9][9];

			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				check = new int[10];
				for (int j = 0; j < 9; j++) {
					int temp = Integer.parseInt(st.nextToken());
					check[temp]++;
					if (check[temp] != 1) {
						tf = false;
					}
					sudoku[i][j] = temp;
				}
			}

			if (tf == false) {
				System.out.printf("#%d %d\n", tc, 0);
				continue;
			}

			col: for (int i = 0; i < 9; i++) {
				check = new int[10];
				for (int j = 0; j < 9; j++) {
					check[sudoku[j][i]]++;
					if (check[sudoku[j][i]] != 1) {
						tf = false;
						break col;
					}
				}
			}

			if (tf == false) {
				System.out.printf("#%d %d\n", tc, 0);
				continue;
			}

			square: for (int i = 1; i < 9; i += 3) {
				for (int j = 1; j < 9; j += 3) {
					check = new int[10];
					check[sudoku[j][i]]++;
					check[sudoku[j - 1][i]]++;
					check[sudoku[j + 1][i]]++;
					check[sudoku[j][i - 1]]++;
					check[sudoku[j][i + 1]]++;
					check[sudoku[j - 1][i - 1]]++;
					check[sudoku[j + 1][i + 1]]++;
					check[sudoku[j - 1][i + 1]]++;
					check[sudoku[j + 1][i - 1]]++;

					for (int k = 1; k < 10; k++) {
						if (check[k] != 1) {
							tf = false;
							break square;
						}
					}
				}
			}

			if (tf == false) {
				System.out.printf("#%d %d\n", tc, 0);
				continue;
			}

			System.out.printf("#%d %d\n", tc, 1);

		}

	}
}
