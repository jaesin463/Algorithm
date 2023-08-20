import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = init(br.readLine());
		
		for(int tc = 1; tc <= test_case; tc++) {
			st = new StringTokenizer(br.readLine());
			int m1 = init(st.nextToken());
			int d1 = init(st.nextToken());
			int m2 = init(st.nextToken());
			int d2 = init(st.nextToken());
			
			int sum1 = 0;
			int sum2 = 0;
			
			for(int i = 0; i < m1 - 1; i++) {
				sum1 += month[i];
			}
			sum1 += d1;
			
			for(int i = 0; i < m2 - 1; i++) {
				sum2 += month[i];
			}
			sum2 += d2;
			
			System.out.printf("#%d %d\n", tc, sum2 - sum1 + 1);
		}
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}