import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		double answer;

		for (int i = 0; i < K - 1; i++) {
			int idx = 0;
			while (Math.pow(2, idx) < N) {
				idx++;
			}
			N -= Math.pow(2, idx - 1);
			
			if(N==0) {
				System.out.println("0");
				return;
			}
		}

		int idx = 0;

		while (Math.pow(2, idx) < N) {
			idx++;
		}
		answer = Math.pow(2, idx) - N;

		System.out.println((int) answer);

	}

}