import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		if (x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1 < 0)
			return 1;
		else if (x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1 > 0)
			return -1;
		else
			return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		long x1 = init(st.nextToken());
		long y1 = init(st.nextToken());
		long x2 = init(st.nextToken());
		long y2 = init(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long x3 = init(st.nextToken());
		long y3 = init(st.nextToken());
		long x4 = init(st.nextToken());
		long y4 = init(st.nextToken());

		int result = 0;
		int res1 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
		int res2 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);
		// 선분이 직선상에 존재 하는 경우
		if (res1 == 0 && res2 == 0) {
			// 선분이 한점에서 만나는 경우
			if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
					&& Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2)) {
				result = 1;
			}
		}
		// 선분이 교차하는 경우
		else if (res1 <= 0 && res2 <= 0) {
			result = 1;
		}
		System.out.println(result);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
