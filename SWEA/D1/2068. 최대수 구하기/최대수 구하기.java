import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		int num[] = new int[10];
		
		for (int i = 0; i < T; i++) {
			int max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				num[j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, num[j]);
			}
			System.out.printf("#%d %d\n", i + 1, max);
		}

	}
}
