import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= test_case; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int velo = 0;
			
			int sum = 0;
			
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					velo += Integer.parseInt(st.nextToken());
				} else if(temp == 2) {
					velo -= Integer.parseInt(st.nextToken());
					if(velo < 0) velo = 0;
				}
				sum += velo;
			}
			System.out.printf("#%d %d\n", i, sum);
		}
		
	}
}
