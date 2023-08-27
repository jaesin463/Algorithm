import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int t1 = init(st.nextToken()) * 3;
		int e1 = init(st.nextToken()) * 20;
		int f1 = init(st.nextToken()) * 120;
		int sum1 = t1 + e1 + f1;
		st = new StringTokenizer(br.readLine());
		int t2 = init(st.nextToken()) * 3;
		int e2 = init(st.nextToken()) * 20;
		int f2 = init(st.nextToken()) * 120;
		int sum2 = t2 + e2 + f2;
		
		System.out.print(sum1 > sum2 ? "Max" : sum1 < sum2 ? "Mel" : "Draw");
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}