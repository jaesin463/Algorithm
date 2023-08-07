import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			boolean error = false;
			int[] S = new int[14];
			int[] D = new int[14];
			int[] H = new int[14];
			int[] C = new int[14];

			int nS = 13;
			int nD = 13;
			int nH = 13;
			int nC = 13;

			String deck = br.readLine();

			for (int i = 0; i < deck.length(); i += 3) {
				char c = deck.charAt(i);
				int card = Integer.parseInt(deck.substring(i + 1, i + 3));
				if (c == 'S') {
					S[card]++;
					nS--;
					if (S[card] != 1) {
						error = true;
						break;
					}
				}
				if (c == 'D') {
					D[card]++;
					nD--;
					if (D[card] != 1) {
						error = true;
						break;
					}
				}
				if (c == 'H') {
					H[card]++;
					nH--;
					if (H[card] != 1) {
						error = true;
						break;
					}
				}
				if (c == 'C') {
					C[card]++;
					nC--;
					if (C[card] != 1) {
						error = true;
						break;
					}
				}
			}

			if (error)
				System.out.println("#" + tc + " ERROR");
			else
				System.out.printf("#%d %d %d %d %d\n", tc, nS, nD, nH, nC);

		}

	}
}
