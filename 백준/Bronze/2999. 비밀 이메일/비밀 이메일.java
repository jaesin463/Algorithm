import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String message = br.readLine();

		int N = message.length();

		int R = 0;
		int C = 0;

		for (int i = 1; i <= Math.sqrt(N); i++) {
			if (N % i == 0) {
				R = i;
				C = N / i;
			}
		}

		char[][] secret = new char[R][C];

		int idx = 0;

		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				secret[j][i] = message.charAt(idx++);
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(secret[i][j]);
			}
		}


	}
}
