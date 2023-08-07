import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		int num[] = new int[10];
		
		for (int i = 0; i < T; i++) {
			double max = Integer.MIN_VALUE;
			double min = Integer.MAX_VALUE;
			double sum = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 10; j++) {
				num[j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, num[j]);
				min = Math.min(min, num[j]);
				sum += num[j];
			}
			
			System.out.printf("#%d %.0f\n", i + 1, ((sum - max - min) / 8));
		}

	}
}
