import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String N = br.readLine();
		for(int i = N.length() - 1; i >= 0 ; i--) {
			sb.append(N.charAt(i));
		}
		
		System.out.println(sb.toString());
		
		
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
