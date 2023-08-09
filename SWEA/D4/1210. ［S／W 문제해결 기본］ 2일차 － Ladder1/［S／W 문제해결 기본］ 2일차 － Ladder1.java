import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, word;

	public static boolean Check(int[][] ladder, int idx) {
		boolean result = false;

		for (int j = 1; j < 100;j++) {
			try {
				if (ladder[j][idx + 1] == 1) {
					idx++;
					while(ladder[j][idx + 1] != 0) {
						idx++;
						if(idx == 99) {
							break;
						}
					}
					continue;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {
				if (ladder[j][idx - 1] == 1) {
					idx--;
					while(ladder[j][idx - 1] != 0) {
						idx--;
						if(idx == 0) {
							break;
						}
					}
					continue;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
		}
		if(ladder[99][idx] == 2) {
			result = true;
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

//		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();

			int[][] ladder = new int[100][100];

			// 배열 생성
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ice = 0;

			for (int i = 0; i < 100; i++) {
				if (ladder[0][i] == 1) {
					if(Check(ladder, i)) {
						ice = i;
						break;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, ice);

		}

	}
}
