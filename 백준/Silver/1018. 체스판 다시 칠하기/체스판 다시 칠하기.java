import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int paint = 0;

		int Min = 64;

		char[][] board = new char[a][b];

		for (int i = 0; i < a; i++) {
			String str = br.readLine();
			for (int j = 0; j < b; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i <= a - 8; i++) {
			for (int j = 0; j <= b - 8; j++) {
				paint = 0;
				for (int k = 0; k < 8; k++) {
					if (board[i + k][j + k] != 'B')
						paint++;
					for (int l = 2; l < 8 - k; l += 2) {
						if (board[i + k + l][j + k] != 'B')
							paint++;
						if (board[i + k][j + k + l] != 'B')
							paint++;
					}
					for (int l = 1; l < 8 - k; l += 2) {
						if (board[i + k + l][j + k] != 'W')
							paint++;
						if (board[i + k][j + k + l] != 'W')
							paint++;
					}
				}

				if (paint > 32)
					paint = 64 - paint;
				Min = Math.min(Min, paint);
			}
		}

		System.out.print(Min);

	}
}