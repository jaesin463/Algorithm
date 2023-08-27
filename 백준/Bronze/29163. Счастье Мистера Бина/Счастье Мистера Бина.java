import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = init(br.readLine());
		int odd = 0;
		int even = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			if(init(st.nextToken()) % 2 == 1) odd++;
			else even++;
		}
		System.out.println(even > odd ? "Happy" : "Sad");
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

	static int init(char c) {
		return c - '0';
	}
}