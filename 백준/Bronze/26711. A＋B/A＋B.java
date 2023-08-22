import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		BigInteger n1 = new BigInteger(br.readLine());
		BigInteger n2 = new BigInteger(br.readLine());
		
		System.out.println(n1.add(n2));
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
