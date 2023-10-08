import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int direc = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int r = init(st.nextToken());
		int c = init(st.nextToken());

		boolean[][] snail = new boolean[r][c];

		int cnt = 0;

		int x = 0;
		int y = 0;

		for (int i = 0; i < r * c; i++) {
			if (x >= 0 && x < r && y >= 0 && y < c && snail[x][y] == false) {
				snail[x][y] = true;
			} else {
				x = x - dr[direc];
				y = y - dc[direc];
				i--;
				direc = (direc + 1) % 4;
				cnt++;
			}
			x = x + dr[direc];
			y = y + dc[direc];
		}
		
		System.out.println(cnt);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

	static int init(char c) {
		return c - 'A';
	}
}
