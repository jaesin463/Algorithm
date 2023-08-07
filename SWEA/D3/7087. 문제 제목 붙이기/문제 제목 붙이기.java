import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int x[] = { -1, -1, -1, 0, 1, 1,  1,  0 };
	static int y[] = { -1,  0,  1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] alpha = new int[26];
			
			for(int i = 0; i < N; i++) {
				alpha[br.readLine().charAt(0)-'A']++;
			}
			
			int result = 0;
			
			for(int i = 0; i < 26; i++) {
				if(alpha[i] != 0) {
					result++;
				} else {
					break;
				}
			}

			System.out.printf("#%d %d\n", tc, result);

		}

	}
}
