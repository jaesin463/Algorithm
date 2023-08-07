import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			
			int result = 0;
			
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int sum = 0;
			
			int Xp = 0;
			int Yp = 0;
			int Xq = 0;
			int Yq = 0;
			
			for(int i = 1; i <= 10000; i++) {
				sum += i;
				if(p <= sum && Xp == 0) {
					Xp = i - (sum - p);
					Yp = i + 1 - Xp;
				}
				if(q <= sum && Xq == 0) {
					Xq = i - (sum - q);
					Yq = i + 1 - Xq;
				}
				if(Xp!=0 && Xq!=0) break;
			}
			
			int[] end = new int[2];
			
			end[0] = Xp + Xq;
			end[1] = Yp + Yq;
			
			sum = 0;
			for(int i = 1; i < end[0] + end[1] - 1; i++) {
				sum += i;
			}
			
			result = sum + end[0];

			System.out.printf("#%d %d\n", tc, result);

		}

	}
}
