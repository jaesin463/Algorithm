import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = Integer.parseInt(br.readLine());

		test: for (int tc = 1; tc <= test_case; tc++) {
			int len = Integer.parseInt(br.readLine());

			// 배열 생성 및 가로 확인
			boolean tf = false;
			String[] omok = new String[len];
			for (int i = 0; i < len; i++) {
				omok[i] = br.readLine();
				if (omok[i].contains("ooooo")) {
					tf = true;
				}
			}
			if (tf) {
				System.out.printf("#%d YES\n", tc);
				continue;
			}
			// 세로 확인
			for (int i = 0; i < len; i++) {
				String omoks = "";
				for (int j = 0; j < len; j++) {
					omoks += omok[j].charAt(i);
				}
				if (omoks.contains("ooooo")) {
					System.out.printf("#%d YES\n", tc);
					continue test;
				}
			}
			// 대각선 확인
			int cnt = 0;
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					if (omok[i].charAt(j) == 'o') {
						cnt++;
						// 남동
						if (i + 1 < len && j + 1 < len && omok[i + 1].charAt(j + 1) == 'o') {
							cnt++;
							int idx = 2;
							while (i + idx < len && j + idx < len && omok[i + idx].charAt(j + idx) == 'o') {
								cnt++;
								idx++;
							}
							if (cnt >= 5) {
								System.out.printf("#%d YES\n", tc);
								continue test;
							}
							cnt = 0;
						}
						// 북동
						if (i - 1 > 0 && j + 1 < len && omok[i - 1].charAt(j + 1) == 'o') {
							cnt++;
							int idx = 2;
							while (i - idx >= 0 && j + idx < len && omok[i - idx].charAt(j + idx) == 'o') {
								cnt++;
								idx++;
							}
							if (cnt >= 5) {
								System.out.printf("#%d YES\n", tc);
								continue test;
							}
							cnt = 0;
						}
					}
					cnt = 0;
				}
			}

			System.out.printf("#%d NO\n", tc);
		}

	}
}
