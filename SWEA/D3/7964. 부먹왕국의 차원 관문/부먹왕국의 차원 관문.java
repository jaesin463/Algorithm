import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			int xPotal = 0;
			int result = 0;
			st = new StringTokenizer(br.readLine());
			int[] city = new int[Integer.parseInt(st.nextToken())];
			int limit = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < city.length; i++) {
				city[i] = Integer.parseInt(st.nextToken());
			}

			if (city[0] == 0) {
				result++;
				city[0] = 1;
			}
			if (city[city.length - 1] == 0) {
				result++;
				city[city.length - 1] = 1;
			}

			for (int i = 1; i < city.length-1; i++) {
				if (city[i] == 1) {
					xPotal = 0;
				} else {
					xPotal++;
					if (xPotal >= limit) {
						result++;
						xPotal = 0;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, result);
		}

	}
}
