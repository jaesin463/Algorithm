import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n1 = init(st.nextToken());
		int k1 = init(st.nextToken());
		int n2 = init(st.nextToken());
		int k2 = init(st.nextToken());
		
		System.out.println((n1 * k1) + (n2 * k2));
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
