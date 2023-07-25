import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[] prime = new boolean[1000001];

	public static void Prime() {
		// boolean 기본값 = false
		prime[0] = prime[1] = true;

		for (int i = 2; i * i <= 1000000; i++) {
			if (!prime[i]) {
				for (int j = i * 2; j <= 1000000; j += i) {
					prime[j] = true;
				}
			}
		}
	}

	public static int checkGold(int N) {
		int count = 0;
		
		for (int j = 2; j <= N / 2; j++) {
			if (!prime[j] && !prime[N - j])
				count++;
		}
		
		return count;
	}

	public static void main(String[] args) throws IOException {
		int test_case = Integer.parseInt(br.readLine());
		int N;

		Prime();

		for (int i = 1; i <= test_case; i++) {
			N = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(checkGold(N)) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
