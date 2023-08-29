import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int r;

	public Point(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int test_case = init(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			st = new StringTokenizer(br.readLine());
			Point p1 = new Point(init(st.nextToken()), init(st.nextToken()), init(st.nextToken()));
			Point p2 = new Point(init(st.nextToken()), init(st.nextToken()), init(st.nextToken()));

			double len = Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));

			if (p1.x == p2.x && p1.y == p2.y) {
				if (p1.r == p2.r) {
					System.out.println(-1);
				} else {
					System.out.println(0);
				}
			} else {
				if (len == p1.r + p2.r) {
					System.out.println(1);
				} else if (Math.abs(p1.r - p2.r) == len) {
					System.out.println(1);
				} else if (len > p1.r + p2.r) {
					System.out.println(0);
				} else if (len < Math.abs(p1.r - p2.r)) {
					System.out.println(0);
				} else {
					System.out.println(2);
				}
			}

		}

	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}