import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] omok = new int[19][19];
		int[] position = new int[2];

		int winner = 0;

		// 입력
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				omok[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// row 탐색
		for (int i = 0; i < 19; i++) {
			int cnt = 0;
			int now = 0;
			for (int j = 0; j < 19; j++) {
				if (now != 0 && now == omok[i][j]) {
					cnt++;
				} else {
					now = omok[i][j];
					cnt = 1;
					position[0] = i;
					position[1] = j;
				}
				if (cnt == 5 && j == 18) {
					winner = now;
					System.out.println(winner);
					System.out.println((position[0] + 1) + " " + (position[1] + 1));
					return;
				}
				else if (cnt == 5 && omok[i][j + 1] != now) {
					winner = now;
					System.out.println(winner);
					System.out.println((position[0] + 1) + " " + (position[1] + 1));
					return;
				}
			}
		}

		// col 탐색
		for (int i = 0; i < 19; i++) {
			int cnt = 0;
			int now = 0;
			for (int j = 0; j < 19; j++) {
				if (now != 0 && now == omok[j][i]) {
					cnt++;
				} else {
					now = omok[j][i];
					cnt = 1;
					position[0] = i;
					position[1] = j;
				}
				if (cnt == 5 && j == 18) {
					winner = now;
					System.out.println(winner);
					System.out.println((position[1] + 1) + " " + (position[0] + 1));
					return;
				}
				else if (cnt == 5 && omok[j + 1][i] != now) {
					winner = now;
					System.out.println(winner);
					System.out.println((position[1] + 1) + " " + (position[0] + 1));
					return;
				}
			}
		}

		// 우 상단 대각선 탐색
		for (int i = 0; i < 19; i++) {
			int cnt = 0;
			int now = 0;
			for (int j = 0; i + j < 19; j++) {
				if (now != 0 && now == omok[0 + j][i + j]) {
					cnt++;
				} else {
					now = omok[0 + j][i + j];
					cnt = 1;
					position[0] = 0 + j;
					position[1] = i + j;
				}
				if (cnt == 5 && ((0 + j) == 18 || i + j == 18)) {
					winner = now;
					System.out.println(winner);
					System.out.println((position[0] + 1) + " " + (position[1] + 1));
					return;
				}
				else if (cnt == 5 && omok[1 + j][i + j + 1] != now) {
					winner = now;
					System.out.println(winner);
					System.out.println((position[0] + 1) + " " + (position[1] + 1));
					return;
				}
			}
		}

		// 좌 하단 대각선 탐색
		for (int i = 0; i < 19; i++) {
			int cnt = 0;
			int now = 0;
			for (int j = 0; i + j < 19; j++) {
				if (now != 0 && now == omok[i + j][0 + j]) {
					cnt++;
				} else {
					now = omok[i + j][0 + j];
					cnt = 1;
					position[0] = i + j;
					position[1] = 0 + j;
				}
				if (cnt == 5 && ((0 + j) == 18 || i + j == 18)) {
					winner = now;
					System.out.println(winner);
					System.out.println((position[0] + 1) + " " + (position[1] + 1));
					return;
				}
				else if (cnt == 5 && omok[i + j + 1][1 + j] != now) {
					winner = now;
					System.out.println(winner);
					System.out.println((position[0] + 1) + " " + (position[1] + 1));
					return;
				}
			}
		}
		
		// 좌 상단 대각선 탐색
		for (int i = 0; i < 19; i++) {
			int cnt = 0;
			int now = 0;
			for (int j = 0; i + j < 19; j++) {
				if (now != 0 && now == omok[0 + j][18 - i - j]) {
					cnt++;
				} else {
					now = omok[0 + j][18 - i - j];
					cnt = 1;
				}
				if (cnt == 5 && ((0 + j) == 18 || 18 - i - j == 0)) {
					winner = now;
					System.out.println(winner);
					System.out.println((j + 1) + " " + (19 - i - j));
					return;
				} else if (cnt == 5 && omok[1 + j][18 - i - j - 1] != now) {
					winner = now;
					System.out.println(winner);
					System.out.println((j + 1) + " " + (19 - i - j));
					return;
				}
			}
		}
		
		//우 하단 대각선 탐색
		for (int i = 0; i < 19; i++) {
			int cnt = 0;
			int now = 0;
			for (int j = 0; i + j < 19; j++) {
				if (now != 0 && now == omok[18 - i - j][0 + j]) {
					cnt++;
				} else {
					now = omok[18 - i - j][0 + j];
					cnt = 1;
				}
				if (cnt == 5 && ((0 + j) == 18 || 18 - i - j == 0)) {
					winner = now;
					System.out.println(winner);
					System.out.println((19 - j) + " " + (j + 1));
					return;
				} else if (cnt == 5 && omok[18 - i - j - 1][1 + j] != now) {
					winner = now;
					System.out.println(winner);
					System.out.println((19 - i - j) + " " + (j + 1));
					return;
				}
			}
		}
		System.out.println(0);

	}
}
