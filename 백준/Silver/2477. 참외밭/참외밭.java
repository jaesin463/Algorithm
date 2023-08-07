import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] melon = new int[6][2];

		int nMelon = Integer.parseInt(br.readLine());

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			melon[i][0] = Integer.parseInt(st.nextToken());
			melon[i][1] = Integer.parseInt(st.nextToken());
		}

		int bWidth = 0;
		int bHeight = 0;

		int wWidth = 0;
		int wHeight = 0;

		for (int i = 0; i < 6; i++) {
			if (melon[i][0] <= 2) {
				wWidth = Math.max(wWidth, melon[i][1]);
				if (wWidth == melon[i][1]) {
					if (i == 0) {
						bWidth = Math.abs(melon[i + 1][1] - melon[5][1]);
					} else if (i == 5) {
						bWidth = Math.abs(melon[i - 1][1] - melon[0][1]);
					} else {
						bWidth = Math.abs(melon[i - 1][1] - melon[i + 1][1]);
					}
				}
			} else {
				wHeight = Math.max(wHeight, melon[i][1]);
				if (wHeight == melon[i][1]) {
					if (i == 0) {
						bHeight = Math.abs(melon[i + 1][1] - melon[5][1]);
					} else if (i == 5) {
						bHeight = Math.abs(melon[i - 1][1] - melon[0][1]);
					} else {
						bHeight = Math.abs(melon[i - 1][1] - melon[i + 1][1]);
					}
				}
			}
		}

		int whole = wWidth * wHeight;
		int blank = bWidth * bHeight;
		System.out.println(nMelon * (whole - blank));

	}
}
