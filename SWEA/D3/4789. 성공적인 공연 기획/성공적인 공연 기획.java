import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			int result = 0;
			int people = 0;
			String str= br.readLine();
			int[] clap = new int[str.length()];
			
			
			for(int i = 0; i < clap.length; i++) {
				clap[i] = str.charAt(i) - '0';
			}
			
			for(int i = 0; i < clap.length; i++) {
				if(people < i) {
					result += i - people;
					people = i;
				}
				people += clap[i];
			}
			
			System.out.printf("#%d %d\n", tc, result);

		}

	}
}
