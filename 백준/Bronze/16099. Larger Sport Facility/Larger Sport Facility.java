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
		int test_case = init(br.readLine());
		for(int tc = 0; tc < test_case; tc++) {
			st = new StringTokenizer(br.readLine());
			BigInteger T = new BigInteger(st.nextToken()).multiply(new BigInteger(st.nextToken()));
			BigInteger E = new BigInteger(st.nextToken()).multiply(new BigInteger(st.nextToken()));
			int result = T.compareTo(E);
			System.out.println( result == 1 ? "TelecomParisTech" : result != 0 ? "Eurecom" : "Tie");
		}
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

	static int init(char c) {
		return c - '0';
	}
}