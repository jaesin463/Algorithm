import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();

		int test_case = init(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			int N = init(br.readLine());
			int[] day = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				day[i] = init(st.nextToken());
			}
			long benefit = 0;
			int max = day[N - 1];
			for (int i = N - 2; i >= 0; i--) {
				if (day[i] > max)
					max = day[i];
				else
					benefit += (max - day[i]);
			}
			sb.append(benefit + "\n");
		}
		System.out.println(sb.toString());
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}