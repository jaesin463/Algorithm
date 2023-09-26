import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C;
	static int[][] map;
	static int[] sumR, sumC;

	static void eveneven() {
		int mr = 0, mc = 0; // 가장 최소 기쁨을 가진 검은타일 위치
		int min = 1001; // 가장 최소 기쁨을 가진 검은타일의 기쁨
		for (int i = 0; i < R; i++) {
			int j;
			if (i % 2 == 0)
				j = 1;
			else
				j = 0;
			for (; j < C; j += 2) {
				if (map[i][j] < min) {
					min = map[i][j];
					mr = i;
					mc = j;
				}
			}
		}

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int sr = 0, sc = 0;
		int er = R - 1, ec = C - 1;

		while (er - sr > 1) {
			if (sr / 2 < mr / 2) {
				for (int i = 0; i < C - 1; i++)
					sb1.append("R");
				sb1.append("D");

				for (int i = 0; i < C - 1; i++)
					sb1.append("L");
				sb1.append("D");
				sr += 2;
			}
			if (er / 2 > mr / 2) {
				for (int i = 0; i < C - 1; i++)
					sb2.append("R");
				sb2.append("D");

				for (int i = 0; i < C - 1; i++)
					sb2.append("L");
				sb2.append("D");
				er -= 2;
			}
		}

		while (ec - sc > 1) {
			if (sc / 2 < mc / 2) {
				sb1.append("D");
				sb1.append("R");
				sb1.append("U");
				sb1.append("R");
				sc += 2;
			}
			if (ec / 2 > mc / 2) {
				sb2.append("D");
				sb2.append("R");
				sb2.append("U");
				sb2.append("R");
				ec -= 2;
			}
		}
		if (mc == sc) {
			sb1.append("R");
			sb1.append("D");
		} else {
			sb1.append("D");
			sb1.append("R");
		}

		sb.append(sb1);
		sb.append(sb2.reverse());
	}

	static void solution() throws IOException {
		// R이 홀수라면 죄우로 움직이면서 목적지로
		if (R % 2 == 1) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C - 1; j++) {
					if (i % 2 == 1)
						sb.append("L");
					else
						sb.append("R");
				}
				if (i < R - 1)
					sb.append("D");
			}
		}
		// C가 홀수라면 위아래로 움직이면서 목적지로
		else if (C % 2 == 1) {
			for (int i = 0; i < C; i++) {
				for (int j = 0; j < R - 1; j++) {
					if (i % 2 == 1)
						sb.append("U");
					else
						sb.append("D");
				}
				if (i < C - 1)
					sb.append("R");
			}
		}
		// 둘 다 짝수라면 전체에서 행 하나 혹은 열 하나 빼야 함
		else {
			eveneven();
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = init(st);
		C = init(st);

		map = new int[R][C];
		sumR = new int[R];
		sumC = new int[C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = init(st);
				sumR[i] += map[i][j];
				sumC[j] += map[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}