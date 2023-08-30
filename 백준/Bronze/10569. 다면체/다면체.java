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

		int t = init(br.readLine());
		for(int i = 0 ; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int v = init(st.nextToken());
			int e = init(st.nextToken());
			
			int result = 2 + e - v;
			System.out.println(result);
		}
		
		
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
