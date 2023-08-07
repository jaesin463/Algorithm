import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		boolean[] isPrime = new boolean[1000001];
		isPrime[0] = true;
		isPrime[1] = true;

		for (int i = 2; i * i <= 1000000; i++) {
			if (!isPrime[i]) {
				for (int j = i * i; j <= 1000000; j += i)
					isPrime[j] = true;
			}
		}

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			st = new StringTokenizer(br.readLine());
			String D = st.nextToken();
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int result = 0;

			for(int i = A; i <= B; i++) {
				if(!isPrime[i] && String.valueOf(i).contains(D)) {
					result++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, result);

		}

	}
}
