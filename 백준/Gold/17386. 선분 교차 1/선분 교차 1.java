import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		return x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1 < 0 ? 1 : -1;
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
		if (ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) < 0 && ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) < 0) result = 1;
		System.out.println(result);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
