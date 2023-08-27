import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int H = init(st.nextToken());
		int M = init(st.nextToken());
		System.out.println((H - 9) * 60 + M);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}